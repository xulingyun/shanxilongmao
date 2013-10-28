package totoro;

import cn.ohyeah.itvgame.shanxi.Define;
import cn.ohyeah.itvgame.shanxi.Iptv_Link;
import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.DrawPopupText;
import cn.ohyeah.stb.ui.DrawUtil;
import cn.ohyeah.stb.ui.PopupPrompt;
import cn.ohyeah.stb.ui.PopupText;

public class PropManager implements Common {

	private TotoroGameEngine engine;
	public PlayerProp[] props;
	public boolean disConnected;

	private String[] names = { "寒悯", "冥月", "守护精灵二", "守护精灵三", "守护精灵四", "必杀技" };
	private int[] ids = { 61, 62, 63, 64, 65, 66 };
	private int[] price = { 500, 500, 200, 300, 500, 200 };
	private String[] desc = { "龙猫寒悯，攻击高", "龙猫冥月，攻击高，防御高",
			"守护精灵二，守护精灵可以帮助你一起作战", "守护精灵三，守护精灵可以帮助你一起作战",
			"守护精灵四，守护精灵可以帮助你一起作战", "必杀技：全屏攻击，无敌状态，持续5秒" };

	public PropManager(TotoroGameEngine engine) {
		this.engine = engine;
		props = engine.props;
	}

	/* 查询玩家道具 */
	public void queryProps() {
		initProps();
		try {
			if (GameCanvasEngine.isConnected) {
				engine.iptv_link.GetItem();
			} else {
				PopupPrompt pp = UIResource.getInstance()
						.buildDefaultPopupPrompt();
				pp.setText("网络连接超时，请稍后重试！");
				pp.popup();
				disConnected = true;
				return;
			}
		} catch (Exception e) {
			System.out.println("查询道具信息出错：" + e.getMessage());
		}
		int[][] pps = engine.iptv_link.props;
		if (pps == null) {
			/**
			 * 多线程模式下，如果接口数据还没返回，让主线程 睡眠3秒，等待数据返回
			 */
			try {
				Thread.sleep(3000);
				pps = engine.iptv_link.props;
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
		}
		if (pps == null) {
			return;
		}
		for (int i = 0; i < props.length; i++) {
			for (int j = 0; j < pps.length; j++) {
				if (pps[j][0] == props[i].getPropId()) {
					props[i].setNums(pps[j][1]);
				}
			}
		}

		for (int i = 0; i < props.length; i++) {
			System.out.println("道具ID==" + props[i].getPropId());
			System.out.println("道具名称==" + props[i].getName());
			System.out.println("道具数量==" + props[i].getNums());
			System.out.println("道具价格==" + props[i].getPrice());
		}
	}

	private void initProps() {
		props = new PlayerProp[6];
		for (int j = 0; j < props.length; j++) {
			PlayerProp prop = new PlayerProp();
			prop.setPropId(ids[j]);
			prop.setName(names[j]);
			prop.setPrice(price[j]);
			prop.setId(j);
			prop.setNums(0);
			prop.setDesc(desc[j]);
			prop.setFeeCode(0);
			props[j] = prop;
		}
	}

	/* 根据道具ID查询该道具数量 */
	public PlayerProp getPropById(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				return props[i];
			}
		}
		return null;
	}

	public int getPropNumsById(int id) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == id) {
				return props[i].getNums();
			}
		}
		return 0;
	}

	public void addPropNumsById(int id) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == id) {
				props[i].setNums(props[i].getNums() + 1);
			}
		}
	}

	public void reducePropNumsById(int id) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == id) {
				if (props[i].getNums() > 0) {
					props[i].setNums(props[i].getNums() - 1);
				}
			}
		}
	}

	public int getPriceById(int propId) {
		int len = props.length;
		for (int i = len - 1; i >= 0; i--) {
			if (props[i].getPropId() == propId) {
				return props[i].getPrice();
			}
		}
		return 0;
	}

	public boolean buyProp(int propId, int propCount, SGraphics g) {
		if (GameCanvasEngine.isConnected) {
			PlayerProp pp = getPropById(propId);
			engine.iptv_link.returnInfo = "";
			engine.iptv_link.result = -1;
			engine.iptv_link.UseMoney(pp.getPrice(), "1", 0);
			DrawPopupText dpt = UIResource.getInstance()
					.buildDefaultDrawPopupText();
//			long time = System.currentTimeMillis();
//			while (engine.iptv_link.result == -1&&System.currentTimeMillis()-time<10000) {
//				
//			}
			engine.waitTime();
			if (engine.iptv_link.result == 0) {
				dpt.setText("购买" + pp.getName() + "成功");
			} else {
				dpt.setText(Define.getErrorInfo(Integer
						.parseInt(engine.iptv_link.returnInfo)));
			}
			dpt.popup();
			return (engine.iptv_link.result == 0);
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
			disConnected = true;
			return false;
		}
	}

	/* 同步道具 */
	public void sysProps() {
		if (GameCanvasEngine.isConnected) {
			int[][] item = new int[6][2];
			for (int i = 0; i < ids.length; i++) {
				if (ids[i] == props[i].getPropId()) {
					item[i][0] = ids[i];
					item[i][1] = props[i].getNums();
				}
			}
			engine.iptv_link.SaveItem(item);
			for (int j = 0; j < item.length; j++) {
				System.out.println("道具ID==" + item[j][0]);
				System.out.println("道具数量==" + item[j][1]);
			}
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
			disConnected = true;
		}
	}
}
