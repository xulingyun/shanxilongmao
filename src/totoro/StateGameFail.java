package totoro;

import javax.microedition.lcdui.Image;

import cn.ohyeah.itvgame.shanxi.Iptv_Link;
import cn.ohyeah.stb.game.SGraphics;
import cn.ohyeah.stb.key.KeyCode;
import cn.ohyeah.stb.key.KeyState;
import cn.ohyeah.stb.res.UIResource;
import cn.ohyeah.stb.ui.DrawUtil;
import cn.ohyeah.stb.ui.PopupConfirm;
import cn.ohyeah.stb.ui.TextView;

public class StateGameFail implements Common{

	
	private TotoroGameEngine engine;
	private boolean running;
	private int failIndex=1;
	private long startTime, endTime;
	private int interval;
	
	public StateGameFail(TotoroGameEngine e){
		engine = e;
		startTime = System.currentTimeMillis()/1000;
	}
	
	public int processGameFail(int level){
		running = true;
		try {
			KeyState keyState = engine.getKeyState();
			SGraphics g = engine.getSGraphics();
			while (running) {
				
				endTime = System.currentTimeMillis()/1000;
				interval = (int) (10-(endTime-startTime));
				
				handleGameFail(keyState);
				if (running) {
					long t1 = System.currentTimeMillis();
					showGameFail(g, level);
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
			Resource.clearGameFail();
		}
		return failIndex;
	}

	private void showGameFail(SGraphics g, int count) {
		int sw = 370;
		int sh = 270;
		int sx = engine.getScreenWidth() / 2 - sw / 2;
		int sy = engine.getScreenHeight() / 2 - sh / 2;
		int offx = sx;
		int offy = sy;
		DrawUtil.drawRect(0xf1db44, g, offx, offy, sw, sh);
		offx += 10;
		offy += 10;
		DrawUtil.drawRect(0x734115, g, offx, offy, sw - 20, sh - 20);


		offx += 90;
		g.setColor(0xffffff);
		engine.setFont(25, true);
		TextView.showSingleLineText(g, "游戏失败", sx + 10, sy + 10, 350, 60,
				TextView.STYLE_ALIGN_CENTER);

		g.setColor(0xffff00);
		engine.setFont(15, true);
		String s1 = "是否购买复活";
		String s2 = "价格：" + count + TotoroGameEngine.expenseUnit;
		String s3 = "现有tv豆：" + Iptv_Link.money;
		String s4 = "tv豆不足，尚需充值" + (count - Iptv_Link.money)
				+ TotoroGameEngine.expenseUnit;
		int strx = sx;
		int stry = offy + 70;
		TextView.showSingleLineText(g, s1, strx, stry, sw, 30,
				TextView.STYLE_ALIGN_CENTER);
		stry += 25;
		TextView.showSingleLineText(g, s2, strx, stry, sw, 30,
				TextView.STYLE_ALIGN_CENTER);
		stry += 25;
		TextView.showSingleLineText(g, s3, strx, stry, sw, 30,
				TextView.STYLE_ALIGN_CENTER);
		boolean hasEnoughMoney = Iptv_Link.money < count ? false : true;
		if (!hasEnoughMoney) {
			stry += 25;
			TextView.showSingleLineText(g, s4, strx, stry, sw, 30,
					TextView.STYLE_ALIGN_CENTER);
		}
		engine.setDefaultFont();

		Image btn1 = null;
		Image btn2 = Resource.loadImage(Resource.id_prompt_close);
		if (hasEnoughMoney) {
			btn1 = Resource.loadImage(Resource.id_prompt_ok);
		} else {
			btn1 = Resource.loadImage(Resource.id_prompt_cz);
		}
		int btx = sx + sw / 3 - btn1.getWidth() / 2;
		int bty = sy + 200;
		g.drawImage(btn1, btx, bty, 0);

		btx += sw / 3;
		g.drawImage(btn2, btx, bty, 0);

		if (failIndex == 0) {
			DrawUtil.drawRect(g, btx - sw / 3, bty, btn1.getWidth(),
					btn1.getHeight(), 2, 0x5ad0c0);
		} else {
			DrawUtil.drawRect(g, btx, bty, btn1.getWidth(), btn1.getHeight(),
					2, 0x5ad0c0);
		}
		drawNum(g, interval, sx+30, sy + 50);

		// int w = bgW+30;
		// int h = bgH+50;
		// int x = ScrW/2-w/2;
		// int y = ScrH/2-h/2;
		// g.setColor(0X000000);
		// DrawUtil.drawRect(g, x, y, w, h);
		// g.setColor(0xffffff);

		// int bgX = ScrW/2-bgW/2;
		// int bgY = ScrH/2-bgH/2 - 15;
		// g.drawImage(bg, bgX, bgY, 20);
		// int buttonX = x + 90;
		// int buttonY = y + h-buttonH;
		// int textX = buttonX + buttonW/2-textW/2;
		// int textY = buttonY + buttonH/2-textH/2;
		// for(int i=0;i<2;i++){
		// if(i == failIndex){
		// g.drawRegion(button, 0, 0, buttonW, buttonH, 0, buttonX, buttonY,
		// 20);
		// }else{
		// g.drawRegion(button, 0, buttonH, buttonW, buttonH, 0, buttonX,
		// buttonY, 20);
		// }
		// g.drawRegion(text, 0, i*textH, textW, textH, 0, textX, textY, 20);
		// buttonX += buttonW+15;
		// textX = buttonX + buttonW/2-textW/2;
		// }
		//
		// StateMain.drawNum(g, count, x+210, y+113);
		// engine.setFont(20, true);
		// g.drawString(engine.expenseUnit, x+245, y+116, 20);
		// engine.setDefaultFont();
		// drawNum(g, interval, ScrW/2-bgW/2+25, bgY+50);
	}
	
	public static void drawNum(SGraphics g, int n, int x, int y) {
		Image num = Resource.loadImage(Resource.id_fail_num);
		String number = String.valueOf(n);
		int numW = num.getWidth()/10, numH = num.getHeight();
		for (byte i = 0; i < number.length(); i++) {
			g.drawRegion(num, (number.charAt(i) - '0') * numW, 0, numW, numH, 0, x, y, 0);
			x += numW+1;
		}
	}
	
	private void handleGameFail(KeyState keyState) {
		if (keyState.containsAndRemove(KeyCode.NUM0 | KeyCode.BACK)) {
			running = false;
			failIndex = 1;
		}else if(keyState.containsAndRemove(KeyCode.LEFT)){
			failIndex = 0;
		}else if(keyState.containsAndRemove(KeyCode.RIGHT)){
			failIndex = 1;
		}else if(keyState.containsAndRemove(KeyCode.OK)){
			running = false;
		}
		if(interval <= 0){
			failIndex = 1;
			running = false;
		}
	}

}
