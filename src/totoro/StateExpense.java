package totoro;
import javax.microedition.lcdui.Image;

import cn.ohyeah.itvgame.shanxi.Iptv_Link;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.ui.DrawUtil;
import cn.ohyeah.stb.ui.TextView;

/**
 * 陕西电信购买道具确认界面
 * @author Administrator
 *
 */
public class StateExpense implements Common{
	private TotoroGameEngine engine;
	private boolean running;
	private int menuIndex;
	private int propId;
	private int propIndex;
	private boolean hasEnoughMoney;
	private String message;
	
	public StateExpense(TotoroGameEngine e, int propId){
		engine = e;
		this.propId = propId;
		message = engine.pm.props[propId-61].getDesc();
	}
	
	public int processPrompt(){
		running = true;
		KeyState keyState = engine.getKeyState();
		SGraphics g = engine.getSGraphics();
		try {
			init();
			while (running) {
				handlePrompt(keyState, g);
				if (running) {
					long t1 = System.currentTimeMillis();
					showPrompt(g);
					engine.flushGraphics();
					System.gc();
					int sleepTime = (int)(125-(System.currentTimeMillis()-t1));
					if (sleepTime <= 0) {
						Thread.sleep(0);
					}
					else {
						Thread.sleep(sleepTime);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Resource.clearPrompt();
			
			/**
			 * 购买龙猫返回界面时不需要刷新游戏界面
			 */
			if(propId != 61 && propId != 62){
				engine.stateGame.show(g);
			}
		}
		return menuIndex;
	}

	private void init() {
		if(propId == 61){
			/**
			 * 龙猫寒悯
			 */
			propIndex = 2;
		}else if(propId == 62){
			/**
			 * 龙猫冥月
			 */
			propIndex = 3;
		}else if(propId == 63 || propId == 64 || propId == 65){
			/**
			 * 守护精
			 */
			propIndex = 1;
		}else if(propId == 66){
			/**
			 * 必杀技
			 */
			propIndex = 0;
		}
		
		if(Iptv_Link.money < engine.pm.getPriceById(propId)){
			hasEnoughMoney = false;
		}else{
			hasEnoughMoney = true;
		}
		
	}

	private void showPrompt(SGraphics g) {
		int sw = 370;
		int sh = 270;
		int sx = engine.getScreenWidth()/2 - sw/2;
		int sy = engine.getScreenHeight()/2 - sh/2;
		int offx = sx;
		int offy = sy;
		DrawUtil.drawRect(0xf1db44, g, offx, offy, sw, sh);
		offx += 10;
		offy += 10;
		DrawUtil.drawRect(0x734115, g, offx, offy, sw-20, sh-20);
		
		Image propIcon = Resource.loadImage(Resource.id_prompt_propIcon);
		int pw = propIcon.getWidth()/4;
		int ph = propIcon.getHeight();
		offx += 20;
		offy += 10;
		DrawUtil.drawRect(g, offx, offy, pw, ph, 2, 0xc68a51);
		g.drawRegion(propIcon, pw*propIndex, 0, pw, ph, 0, offx, offy, 0);
		
		offx += 90;
		DrawUtil.drawRect(g, offx, offy, 220, ph, 2, 0xc68a51);
		g.setColor(0xffffff);
		TextView.showMultiLineText(g, message, 2, offx, offy, 220, ph);
		
		g.setColor(0xffff00);
		engine.setFont(15, true);
		String s1 = "是否购买"+engine.pm.getPropById(propId).getName();
		String s2 = "价格："+engine.pm.getPropById(propId).getPrice()+TotoroGameEngine.expenseUnit;
		String s3 = "现有tv豆："+Iptv_Link.money;
		String s4 = "tv豆不足，尚需充值"+(engine.pm.getPropById(propId).getPrice()-Iptv_Link.money)+TotoroGameEngine.expenseUnit;
		int strx = sx;
		int stry = offy + 70;
		TextView.showSingleLineText(g, s1, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		stry += 25;
		TextView.showSingleLineText(g, s2, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		stry += 25;
		TextView.showSingleLineText(g, s3, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		if(!hasEnoughMoney){
			stry += 25;
			TextView.showSingleLineText(g, s4, strx, stry, sw, 30, TextView.STYLE_ALIGN_CENTER);
		}
		engine.setDefaultFont();
		
		Image btn1 = null;
		Image btn2 = Resource.loadImage(Resource.id_prompt_close);
		if(hasEnoughMoney){
			btn1 = Resource.loadImage(Resource.id_prompt_ok);
		}else{
			btn1 = Resource.loadImage(Resource.id_prompt_cz);
		}
		int btx = sx + sw/3 - btn1.getWidth()/2;
		int bty = sy + 200;
		g.drawImage(btn1, btx, bty, 0);
		
		btx += sw/3;
		g.drawImage(btn2, btx, bty, 0);
		
		if(menuIndex == 0){
			DrawUtil.drawRect(g, btx-sw/3, bty, btn1.getWidth(), btn1.getHeight(), 2, 0x5ad0c0);
		}else{
			DrawUtil.drawRect(g, btx, bty, btn1.getWidth(), btn1.getHeight(), 2, 0x5ad0c0);
		}
	}
	
	private void handlePrompt(KeyState keyState, SGraphics g) {
		if (keyState.containsAndRemove(KeyCode.NUM0 | KeyCode.BACK)) {
			running = false;
			menuIndex = 0;
		}else if(keyState.containsAndRemove(KeyCode.LEFT)){
			menuIndex = 0;
		}else if(keyState.containsAndRemove(KeyCode.RIGHT)){
			menuIndex = 1;
		}else if(keyState.containsAndRemove(KeyCode.OK)){
			if(menuIndex == 0){
				if(!hasEnoughMoney){
					/*Recharge sr = new Recharge(engine);
					sr.recharge();*/
					StateSubscribe ss = new StateSubscribe(engine);
					ss.processSubscribe();
					init();
				}else{
					if(engine.pm.buyProp(propId, 1, g)){
						addPropNums(propId);
					}
					running = false;
				}
			}else{
				running = false;
			}
		}
	}

	private void addPropNums(int propId) {
		switch (propId){
		case 61:
			StateGame.hasTotoro3 = true;
			break;
		case 62:
			StateGame.hasTotoro4 = true;
			break;
		case 63:
			StateGame.wingplaneMaxNums ++;
			break;
		case 64:
			StateGame.wingplaneMaxNums ++;
			break;
		case 65:
			StateGame.wingplaneMaxNums ++;
			break;
		case 66:
			StateGame.ventoseNum ++;
			break;
		}
		
		/**
		 * 往道具数组中加道具
		 */
		engine.pm.addPropNumsById(propId);
	}
}
