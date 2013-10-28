package totoro;
import javax.microedition.lcdui.Image;

import cn.ohyeah.itvgame.model.GameRanking;
import cn.ohyeah.stb.game.GameCanvasEngine;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.PopupConfirm;
import cn.ohyeah.stb.ui.PopupText;
import cn.ohyeah.stb.ui.TextView;

public class StateMain implements Common{
	
	public boolean exit;
	//private StateGame stateGame;
	private TotoroGameEngine engine;
	public StateMain(TotoroGameEngine engine){
		this.engine = engine;
		//this.stateGame = engine.stateGame;
	}
	
	public int menuAxis[][] = {/*{20, 20},*/ {220, 92+65}, {220, 164+65}, {220, 236+65}, {220, 308+65}};
	public int menuAxis2[][] = {{517, 342}, {517, 428}};
	
	public static int mainIndex;
	//private boolean isRight;
	
	public void handleKey(KeyState keyState){
		if (keyState.containsAndRemove(KeyCode.BACK)) {
			exit = true;
			Resource.clearMain();
		}else if (keyState.containsAndRemove(KeyCode.UP)) {
			mainIndex = (mainIndex + 4 - 1) % 4;
		} else if (keyState.containsAndRemove(KeyCode.DOWN)) {
			mainIndex = (mainIndex + 1) % 4;
		} else if (keyState.containsAndRemove(KeyCode.OK)) {
			processSubMenu();
		}
	}

	public void show(SGraphics g) {
		Image bg = Resource.loadImage(Resource.id_main_bg);
		Image button = Resource.loadImage(Resource.id_main_button);
		Image text = Resource.loadImage(Resource.id_main_text);
		
		g.drawImage(bg, 0, 0, 20);
		int buttonW = button.getWidth(), buttonH = button.getHeight()/2;
		int textW = text.getWidth(), textH = text.getHeight()/4;
		for(int i=0;i<4;i++){
			if (mainIndex == i){
				g.drawRegion(button, 0, 0, buttonW, buttonH, 0, menuAxis[i][0], menuAxis[i][1], 20);
				g.drawRegion(text, 0, textH*i, textW, textH, 0, menuAxis[i][0]+36, menuAxis[i][1]+15, 20);
			} else {
				g.drawRegion(button, 0, buttonH, buttonW, buttonH, 0, menuAxis[i][0], menuAxis[i][1], 20);
				g.drawRegion(text, 0, textH*i, textW, textH, 0, menuAxis[i][0]+36, menuAxis[i][1]+15, 20);
			}
		}
		
		/*排行数据*/
		g.setColor(0xffffff);
		if(engine.rankList!=null){
			int x = 340, y = 65, w = 160, h = 26, w1 = 125;
			int myRanking = 0;
			for(int i=0;i<engine.rankList.length;i++){
				GameRanking rank = engine.rankList[i];
				String userId = rank.getUserId();
				String scores = String.valueOf(rank.getScores());
				TextView.showSingleLineText(g, userId, x, y, w, h, 1);
				TextView.showSingleLineText(g, scores, x+w, y, w1, h, 1);
				y += h+13;
				if(userId.equals(engine.getEngineService().getUserId())){
					myRanking = rank.getRanking();
				}
			}
			drawNum(g, myRanking, 450, 490);
		}
		g.setColor(0);
		
		//drawNum(g, StateGame.ventoseNum, 450, 448);
	}
	
	public static void drawNum(SGraphics g, int n, int x, int y) {
		Image num = Resource.loadImage(Resource.id_main_num);
		String number = String.valueOf(n);
		int numW = num.getWidth()/10, numH = num.getHeight();
		for (byte i = 0; i < number.length(); i++) {
			g.drawRegion(num, (number.charAt(i) - '0') * numW, 0, numW, numH, 0, x, y, 0);
			x += numW+1;
		}
	}
		
	public void execute(){}
	
	private void processSubMenu() {
		if (mainIndex == 0) { 			//新游戏
			if(TotoroGameEngine.result){
				PopupConfirm pc = UIResource.getInstance().buildDefaultPopupConfirm();
				pc.setText("你有存档是否覆盖重新开始?");
				if(pc.popup()==0){
					engine.state = STATUS_SELECT_TOTORO;
//					engine.stateGame.quitGameDeleteDate();
					Resource.clearMain();
				}else{
					mainIndex = 1;
				}
			}else{
				engine.state = STATUS_SELECT_TOTORO;
				Resource.clearMain();
			}
		} else if(mainIndex == 1){		//继续游戏
			TotoroGameEngine.result = engine.readRecord();
			if(!TotoroGameEngine.result){
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("没有游戏记录,请重新开始游戏");
				pt.popup();
				mainIndex = 0;
			}else{
				engine.state = STATUS_SELECT_TOTORO;
				Resource.clearMain();
			}
		} /*else if (mainIndex == 2) {	//充值
			if(GameCanvasEngine.isConnected){
				StateSubscribe ss = new StateSubscribe(engine);
				ss.processSubscribe();
			}else{
				PopupText pt = UIResource.getInstance().buildDefaultPopupText();
				pt.setText("网络连接中断，无法充值，请稍候!");
				pt.popup();
			}
		} */else if (mainIndex == 2){ 	//游戏帮助
			StateHelp sh = new StateHelp(engine);
			sh.processHelp();
		} else if (mainIndex == 3) {	//退出游戏
			PopupConfirm pc = UIResource.getInstance().buildDefaultPopupConfirm();
			pc.setText("确定退出游戏?");
			if(pc.popup() == 0){
				Resource.clearMain();
				//engine.saveRecord();
				engine.pm.sysProps();
				exit = true;
			}
		}
	}
}
