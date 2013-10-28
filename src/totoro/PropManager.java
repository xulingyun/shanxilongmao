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

	private String[] names = { "����", "ڤ��", "�ػ������", "�ػ�������", "�ػ�������", "��ɱ��" };
	private int[] ids = { 61, 62, 63, 64, 65, 66 };
	private int[] price = { 500, 500, 200, 300, 500, 200 };
	private String[] desc = { "��è������������", "��èڤ�£������ߣ�������",
			"�ػ���������ػ�������԰�����һ����ս", "�ػ����������ػ�������԰�����һ����ս",
			"�ػ������ģ��ػ�������԰�����һ����ս", "��ɱ����ȫ���������޵�״̬������5��" };

	public PropManager(TotoroGameEngine engine) {
		this.engine = engine;
		props = engine.props;
	}

	/* ��ѯ��ҵ��� */
	public void queryProps() {
		initProps();
		try {
			if (GameCanvasEngine.isConnected) {
				engine.iptv_link.GetItem();
			} else {
				PopupPrompt pp = UIResource.getInstance()
						.buildDefaultPopupPrompt();
				pp.setText("�������ӳ�ʱ�����Ժ����ԣ�");
				pp.popup();
				disConnected = true;
				return;
			}
		} catch (Exception e) {
			System.out.println("��ѯ������Ϣ����" + e.getMessage());
		}
		int[][] pps = engine.iptv_link.props;
		if (pps == null) {
			/**
			 * ���߳�ģʽ�£�����ӿ����ݻ�û���أ������߳� ˯��3�룬�ȴ����ݷ���
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
			System.out.println("����ID==" + props[i].getPropId());
			System.out.println("��������==" + props[i].getName());
			System.out.println("��������==" + props[i].getNums());
			System.out.println("���߼۸�==" + props[i].getPrice());
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

	/* ���ݵ���ID��ѯ�õ������� */
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
				dpt.setText("����" + pp.getName() + "�ɹ�");
			} else {
				dpt.setText(Define.getErrorInfo(Integer
						.parseInt(engine.iptv_link.returnInfo)));
			}
			dpt.popup();
			return (engine.iptv_link.result == 0);
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("�������ӳ�ʱ�����Ժ����ԣ�");
			pp.popup();
			disConnected = true;
			return false;
		}
	}

	/* ͬ������ */
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
				System.out.println("����ID==" + item[j][0]);
				System.out.println("��������==" + item[j][1]);
			}
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("�������ӳ�ʱ�����Ժ����ԣ�");
			pp.popup();
			disConnected = true;
		}
	}
}
