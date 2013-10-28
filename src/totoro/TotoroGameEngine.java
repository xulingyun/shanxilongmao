package totoro;

import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;

import com.sun.kvem.jsr082.obex.QueuedHeader;

import cn.ohyeah.itvgame.model.GameRanking;
import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.PopupPrompt;
import cn.ohyeah.stb.util.ConvertUtil;

/**
 * 游戏引擎
 * 
 * @author Administrator
 */
public class TotoroGameEngine extends GameCanvasEngine implements Common {
	public static boolean isSupportFavor = false;
	public static int ScrW = 0;
	public static int ScrH = 0;
	public static String debugString = "";
	public static String queueString = "";

	public static String expenseUnit = "tv豆";

	public static TotoroGameEngine instance = buildGameEngine();

	private static TotoroGameEngine buildGameEngine() {
		if (instance == null) {
			return new TotoroGameEngine(TotoroMIDlet.getInstance());
		} else {
			return instance;
		}
	}

	public StateMain stateMain;
	public StateGame stateGame;
	public StateSelectInterface stateSelect;
	public PropManager pm;
	public static boolean result;
	// public int money;
	public String data = "";

	private TotoroGameEngine(MIDlet midlet) {
		super(midlet);
		setRelease(true);
		ScrW = screenWidth;
		ScrH = screenHeight;
		stateGame = new StateGame(this);
		stateMain = new StateMain(this);
		stateSelect = new StateSelectInterface(this);
		pm = new PropManager(this);
	}

	public int state;
	// public int playingIndex;
	private int cursorFrame;
	public PlayerProp[] props;
	public GameRanking[] rankList;

	protected void loop() {

		/* 显示界面 */
		switch (state) {
		case STATUS_INIT:
			showInit(g);
			break;
		case STATUS_MAIN_MENU:
			stateMain.show(g);
			break;
		case STATUS_SELECT_TOTORO:
			stateSelect.show(g);
			break;
		case STATUS_GAME_PLAYING:
			stateGame.show(g);
			break;
		}

		/* 执行逻辑 */
		switch (state) {
		case STATUS_INIT:
			cursorFrame = (cursorFrame + 1) % 12;
			break;
		case STATUS_MAIN_MENU:
			stateMain.execute();
			break;
		case STATUS_SELECT_TOTORO:
			stateSelect.execute();
			break;
		case STATUS_GAME_PLAYING:
			stateGame.execute();
			break;
		}

		/* 处理键值 */
		switch (state) {
		case STATUS_INIT:
			handleInit(keyState);
			break;
		case STATUS_MAIN_MENU:
			stateMain.handleKey(keyState);
			break;
		case STATUS_SELECT_TOTORO:
			stateSelect.handle(keyState, StateMain.mainIndex);
			break;
		case STATUS_GAME_PLAYING:
			stateGame.handleKey(keyState);
			break;
		}
		if (isDebugMode()) {
			addDebugUserMessage(debugString);
		}

		/* 退出游戏 */
		exit();
	}

	private void init() {
		/* 查询道具 */
		pm.queryProps();

		/* 查询排行 */
		queryList();

		if (pm.getPropNumsById(65) > 0) {
			StateGame.wingplaneMaxNums = 4;
		} else if (pm.getPropNumsById(64) > 0) {
			StateGame.wingplaneMaxNums = 3;
		} else if (pm.getPropNumsById(63) > 0) {
			StateGame.wingplaneMaxNums = 2;
		} else {
			StateGame.wingplaneMaxNums = 1;
		}
		StateGame.ventoseNum = pm.getPropNumsById(66);
		StateGame.hasTotoro3 = pm.getPropNumsById(61) > 0 ? true : false;
		StateGame.hasTotoro4 = pm.getPropNumsById(62) > 0 ? true : false;

		/* 读取游戏记录 */
		result = readRecord();

		/* 获取用户余额 */
		getMoney();
	}

	public void queryList() {
		rankList = null;
	}

	private void handleInit(KeyState key) {
		if (key.containsAndRemove(KeyCode.OK)) {
			state = STATUS_MAIN_MENU;
			Resource.clearInit();
		}
	}

	/**
	 * return true: 表示数据加载完成（不论加载成功或失败）
	 */
	public boolean loadData() {
		init();
		return true;
	}

	private void showInit(SGraphics g) {
		Image bg = Resource.loadImage(Resource.id_bg);
		Image text = Resource.loadImage(Resource.id_text);
		g.drawImage(bg, 0, 0, 20);
		if (cursorFrame > 4) {
			int x = screenWidth / 2 - text.getWidth() / 2;
			g.drawImage(text, x, 495, 20);
		}
	}

	private void getMoney() {
		if (GameCanvasEngine.isConnected) {
			iptv_link.GetMoney();
			try {
				String str = iptv_link.returnInfo;
				if (str.equals("") || str == null) {
					/**
					 * 多线程模式下，如果接口数据还没返回，让主线程 睡眠3秒，等待数据返回
					 */
					Thread.sleep(3000);
				}
				// money = Integer.parseInt(iptv_link.returnInfo);
			} catch (Exception e) {
				System.out.println("获取余额时解析出错：" + e.getMessage());
			}
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
		}
	}

	private void exit() {
		if (stateMain.exit
		/* || !GameCanvasEngine.isConnected */
		|| pm.disConnected) {
			exit = true;
		}
	}

	private long recordTime;

	public boolean timePass(int millisSeconds) {
		long curTime = System.currentTimeMillis();
		if (recordTime <= 0) {
			recordTime = curTime;
		} else {
			if (curTime - recordTime >= millisSeconds) {
				recordTime = 0;
				return true;
			}
		}
		return false;
	}

	// 同步道具
	public void sysProps() {
		pm.sysProps();
	}

	public void saveRecord() {
		if (GameCanvasEngine.isConnected) {
			if (StateGame.lifeNum < 1 || StateGame.scores <= 0) {
				return;
			}
			setRecordData();
			iptv_link.SaveParam("1", data);
			data = "";
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
		}
	}

	public void saveScores() {
		if (GameCanvasEngine.isConnected) {
			iptv_link.GetScore();
			if (iptv_link.scores == 0) {
				engine.waitTime();
			}
			if (iptv_link.scores < StateGame.scores) {
				iptv_link.UpdateScore(StateGame.scores);
			}
		} else {
			PopupPrompt pp = UIResource.getInstance().buildDefaultPopupPrompt();
			pp.setText("网络连接超时，请稍后重试！");
			pp.popup();
		}
	}

	private void setRecordData() {
		data += "" + StateGame.lifeNum + "," + StateGame.currLevel + ","
				+ StateGame.blood + "," + StateGame.grade + ","
				+ StateGame.bombGrade + "," + StateGame.wingplaneNums + ","
				+ StateGame.missileGrade + "," + StateGame.laserNums + ","
				+ StateGame.batchIndex + "," + StateGame.levelInterval + ","
				+ StateGame.bossBlood + "," + StateGame.level_over + ","
				+ StateGame.startGameVentoseNums + "," + StateGame.scores;
		 printInfo();
	}

	/**
	 * 读取游戏记录
	 * 
	 * @return
	 */
	public boolean readRecord() {
		try {
			if (GameCanvasEngine.isConnected) {
				iptv_link.GetParamEx("1");
				String str = iptv_link.returnInfo;

				if (str.equals("") || str == null) {
					/**
					 * 多线程模式下，如果接口数据还没返回，让主线程 睡眠3秒，等待数据返回
					 */
					Thread.sleep(3000);
				}
				str = iptv_link.returnInfo;
				String[] ss = ConvertUtil.split(str, ",");
				if (ss.length < 1) {
					return false;
				} else {
					initRecordInfo(ss);
					return true;
				}
			} else {
				PopupPrompt pp = UIResource.getInstance()
						.buildDefaultPopupPrompt();
				pp.setText("网络连接超时，请稍后重试！");
				pp.popup();
				/**
				 * 连接中断，退出游戏
				 */
				engine.setExit();
				return false;
			}
		} catch (Exception e) {
			System.out.println("读取游戏记录异常：" + e.getMessage());
			return false;
		}
	}

	public void waitTime() {
		long time = System.currentTimeMillis();
		while (engine.iptv_link.result == -1
				&& System.currentTimeMillis() - time < 5000) {

		}
	}

	private void initRecordInfo(String[] str) {

		StateGame.lifeNum = Integer.parseInt(str[0]);
		StateGame.currLevel = Integer.parseInt(str[1]);
		StateGame.blood = Integer.parseInt(str[2]);
		StateGame.grade = Integer.parseInt(str[3]);
		StateGame.bombGrade = Integer.parseInt(str[4]);
		StateGame.wingplaneNums = Integer.parseInt(str[5]);
		StateGame.missileGrade = Integer.parseInt(str[6]);
		StateGame.laserNums = Integer.parseInt(str[7]);
		StateGame.batchIndex = Integer.parseInt(str[8]);
		StateGame.levelInterval = Integer.parseInt(str[9]);
		StateGame.bossBlood = Integer.parseInt(str[10]);
		StateGame.level_over = str[11].equals("true") ? true : false;
		StateGame.startGameVentoseNums = Integer.parseInt(str[12]);
		StateGame.scores = Integer.parseInt(str[13]);

		printInfo();
	}

	private void printInfo() {
		System.out.println("StateGame.lifeNum:" + StateGame.lifeNum);
		System.out.println("StateGame.currLevel:" + StateGame.currLevel);
		System.out.println("StateGame.blood:" + StateGame.blood);
		System.out.println("StateGame.grade:" + StateGame.grade);
		System.out.println("StateGame.bombGrade:" + StateGame.bombGrade);
		System.out.println("StateGame.wingplaneMaxNums:"
				+ StateGame.wingplaneMaxNums);
		System.out
				.println("StateGame.wingplaneNums:" + StateGame.wingplaneNums);
		System.out.println("StateGame.missileGrade:" + StateGame.missileGrade);
		System.out.println("StateGame.laserNums:" + StateGame.laserNums);
		System.out.println("StateGame.batchIndex:" + StateGame.batchIndex);
		System.out.println("StateGame.ventoseNum:" + StateGame.ventoseNum);
		System.out.println("StateGame.hasTotoro3:" + StateGame.hasTotoro3);
		System.out.println("StateGame.hasTotoro4:" + StateGame.hasTotoro4);
		System.out.println("StateGame.scores:" + StateGame.scores);
		System.out.println("StateGame.levelInterval:"
				+ (StateGame.levelInterval));
		System.out.println("StateGame.bossBlood:" + (StateGame.bossBlood));
		System.out.println("StateGame.level_over:" + (StateGame.level_over));
		System.out.println("StateGame.startGameVentoseNums:"
				+ (StateGame.startGameVentoseNums));
	}
}
