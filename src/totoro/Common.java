package totoro;

/*
 * ���������� 
 */
public interface Common {
	
	public final static int STATUS_INIT = 0;			//��ʼ
	public final static int STATUS_MAIN_MENU = 1;		//��Ϸ���˵� 
	public final static int STATUS_SELECT_TOTORO = 2;	//ѡ����è
	public final static int STATUS_GAME_PLAYING = 3;	//��Ϸ��    
	
	public final static int GAME_PLAY = 2;
	public final static int GAME_FAIL = 3;
	public final static int GAME_SUCCESS = 4;
	public final static int GAME_PAUSE = 5;

	public final static TotoroGameEngine engine = TotoroGameEngine.instance;
	public final static int ScrW = TotoroGameEngine.ScrW;
	public final static int ScrH = TotoroGameEngine.ScrH;
	public final static int gameH = 457;
	public final static int startP = 73;
	public final static int endP = 530;

	public final static int spirit_id = 100;
	public final static int boss_id = 200;
	
	/*�����ʼλ��*/
	public static final int OBJECT_POSITION_UP = 1;			//��	
	public static final int OBJECT_POSITION_DOWN = 2;		//��
	public static final int OBJECT_POSITION_LEFT = 3;		//��
	public static final int OBJECT_POSITION_RIGHT = 4;		//��
	
	/*�����ƶ�����*/
	public static final int OBJECT_DIRECTION_UP = 0;			//��
	public static final int OBJECT_DIRECTION_DOWN = 1;			//��
	public static final int OBJECT_DIRECTION_LEFT = 2;			//��
	public static final int OBJECT_DIRECTION_RIGHT = 3;			//��
	public static final int OBJECT_DIRECTION_LEFT_UP = 4;			//����
	public static final int OBJECT_DIRECTION_RIGHT_UP = 5;			//����
	public static final int OBJECT_DIRECTION_LEFT_DOWN = 6;			//����
	public static final int OBJECT_DIRECTION_RIGHT_DOWN = 7;		//����
	
	/*���鹥��״̬*/
	public static final int ATTACK_PERMISSION_YES = 1;	//�ܹ���
	public static final int ATTACK_PERMISSION_NO = 0;	//���ܹ���
	
	/*���������Ƿ����佱Ʒ*/
	public static final int SPIRITI_PRIZE_YES = 1;		//��
	public static final int SPIRITI_PRIZE_NO = 0;		//����
	
	/*��ɫ״̬1*/
	public static final int ROLE_STATUS_ALIVE = 1;		//����״̬
	public static final int ROLE_STATUS_DEAD = -1;		//����ת̨	
	public static final int ROLE_STATUS_PROTECTED = 2;	//�޵�״̬
	public static final int ROLE_STATUS_PASS = 3;		//ͨ��״̬
	
	/*��ɫ״̬2*/
	public static final int ROLE_STATUS2_MOVE = 1;			//�ƶ�״̬
	public static final int ROLE_STATUS2_ATTACK = 2;		//��ͨ����״̬
	public static final int ROLE_STATUS2_SKILL_ATTACK = 3;	//����һ״̬
	public static final int ROLE_STATUS2_SKILL2_ATTACK = 4;	//���ܶ�״̬
	
	/*��è�ȼ�*/
	public static final int TOTORO_GRADE_ONE = 1;
	public static final int TOTORO_GRADE_TWO = 2;
	public static final int TOTORO_GRADE_THREE = 3;
	public static final int TOTORO_GRADE_FOUR = 4;
	
	/*����ӵ��ȼ�*/
	public static final int TOTORO_BOMB_GRADE_ONE = 1;
	public static final int TOTORO_BOMB_GRADE_TWO = 2;
	public static final int TOTORO_BOMB_GRADE_THREE = 3;
	public static final int TOTORO_BOMB_GRADE_FOUR = 4;
	
	/*���ͼƬid*/
	public static final int pinkTotoroPicId = Resource.id_pink_totoro;
	public static final int yellowTotoroPicId = Resource.id_yellow_totoro;
	public static final int blueTotoroPicId = Resource.id_blue_totoro;
	public static final int blackTotoroPicId = Resource.id_black_totoro;
	
	/*�Ż�ͼƬ*/
	public static final int pinkWingplane = Resource.id_pink_totoro_wingplane;
	public static final int yellowWingplane = Resource.id_yellow_totoro_wingplane;
	public static final int blueWingplane = Resource.id_blue_totoro_wingplane;
	public static final int blackWingplane = Resource.id_black_totoro_wingplane;
	
	/*�ӵ�ͼƬid*/
	public static final int pinkBombPicId = Resource.id_pink_totoro_bomb;
	public static final int yellowBomb1PicId = Resource.id_yellow_totoro_bomb1;
	public static final int yellowBomb2PicId = Resource.id_yellow_totoro_bomb2;
	public static final int yellowBomb3PicId = Resource.id_yellow_totoro_bomb3;
	public static final int blueBomb1PicId = Resource.id_blue_totoro_bomb1;
	public static final int blueBomb2PicId = Resource.id_blue_totoro_bomb2;
	public static final int blueBomb3PicId = Resource.id_blue_totoro_bomb3;
	public static final int blueBomb4PicId = Resource.id_blue_totoro_bomb4;
	public static final int blackBomb1PicId = Resource.id_black_totoro_bomb1;
	public static final int blackBomb2PicId = Resource.id_black_totoro_bomb2;
	public static final int blackBomb3PicId = Resource.id_black_totoro_bomb3;

	/*propPic*/
	public static final int laserPic = Resource.id_prop_laser;
	public static final int missilePic = Resource.id_prop_missile;
	
	public static final int yellowVentose = Resource.id_yellow_totoro_ventose;
	public static final int pinkVentose = Resource.id_pink_totoro_ventose;
	
	/*�����ӵ�ͼƬ*/
	public static final int spiritBomb1PicId = Resource.id_sky_spirit_bomb_1;
	public static final int spiritBomb2PicId = Resource.id_burrow_spirit_bomb_2;
	public static final int spiritBomb3PicId = Resource.id_ice_spirit_bomb_1;
	public static final int spiritBomb4PicId = Resource.id_ice_spirit_bomb_2;
	public static final int spiritBomb5PicId = Resource.id_lava_spirit_bomb;
	public static final int spiritBomb6PicId = Resource.id_ice_boss_1_fire_attack;
	
	public static final int boss1SkillPicId = Resource.id_sky_boss_1_skill;
	public static final int boss2SkillPicId = Resource.id_sky_boss_2_skill;
	public static final int boss3SkillPicId = Resource.id_burrow_boss_1_skill;
	public static final int boss4SkillPicId = Resource.id_burrow_boss_2_skill;
	public static final int boss5SkillPicId = Resource.id_ice_boss_1_fire_attack;
	public static final int boss6SkillPicId_1 = Resource.id_ice_boss_2_skill_1;
	public static final int boss6SkillPicId_2 = Resource.id_ice_boss_2_skill_2;
	public static final int boss6SkillPicId_3 = Resource.id_ice_boss_2_skill_3;
	public static final int boss6SkillPicId_4 = Resource.id_ice_boss_2_skill_4;
	public static final int boss7SkillPicId_1 = Resource.id_lava_boss_1_bomb1;
	public static final int boss7SkillPicId_2 = Resource.id_lava_boss_1_bomb2;
	public static final int boss7SkillPicId_3 = Resource.id_lava_boss_1_bomb3;
	public static final int boss7SkillPicId_4 = Resource.id_lava_boss_1_bomb4;
	public static final int boss7SkillPicId_5 = Resource.id_lava_boss_1_bomb5;
	public static final int boss7SkillPicId_6 = Resource.id_lava_boss_1_bomb6;
	public static final int boss7SkillPicId_7 = Resource.id_lava_boss_1_bomb7;
	public static final int boss7SkillPicId_8 = Resource.id_lava_boss_1_bomb8;
	public static final int boss8Skill2_1_PicId = Resource.id_lava_boss_2_skill_1;
	public static final int boss8Skill2_2_PicId = Resource.id_lava_boss_2_skill_2;
	public static final int boss8Skill2_3_PicId = Resource.id_lava_boss_2_skill_3;
	
	public static final int batteryBomb2PicId = Resource.id_ice_battery_bomb;
	public static final int batteryBomb3PicId = Resource.id_lava_battery_bomb;
	
	/*����ͼƬid*/
	public static final int spirits_1 = Resource.id_sky_spirits_1;
	public static final int spirits_2 = Resource.id_sky_spirits_2;
	public static final int spirits_3 = Resource.id_sky_spirits_3;
	
	public static final int spirits_4 = Resource.id_burrow_spirit_1;
	public static final int spirits_5 = Resource.id_burrow_spirit_2;
	public static final int spirits_6 = Resource.id_burrow_spirit_3;
	public static final int spirits_7 = Resource.id_burrow_spirit_4;
	
	public static final int spirits_8 = Resource.id_ice_spirit_1;
	public static final int spirits_9 = Resource.id_ice_spirit_2;
	
	public static final int spirits_10 = Resource.id_lava_spirit_1;
	public static final int spirits_11 = Resource.id_lava_spirit_2;
	
	public static final int spirits_12 = Resource.id_ice_boss_1_fire_object;
	
	/*��̨ͼƬid*/
	public static final int battery_1 = Resource.id_sky_battery;
	public static final int battery_2 = Resource.id_ice_battery;
	public static final int battery_3 = Resource.id_lava_battery;
	
	/*bossͼƬid*/
	public static final int boss_1 = Resource.id_sky_boss_1;
	public static final int boss_2 = Resource.id_sky_boss_2;
	public static final int boss_3 = Resource.id_burrow_boss_1;
	public static final int boss_4 = Resource.id_burrow_boss_2;
	public static final int boss_5 = Resource.id_ice_boss_1;
	public static final int boss_6 = Resource.id_ice_boss_2;
	public static final int boss_7 = Resource.id_lava_boss_1;
	public static final int boss_8 = Resource.id_lava_boss_2;
	
	/*propPicId*/
	public static final int prop_blood_icon = Resource.id_prop_blood_icon;
	public static final int prop_laser_icon = Resource.id_prop_laser_icon;
	public static final int prop_missile_icon = Resource.id_prop_missile_icon;
	public static final int prop_upgrade_icon = Resource.id_prop_upgrade_icon;
	public static final int prop_ventose_icon = Resource.id_prop_ventose_icon;
	public static final int prop_wingplane_icon = Resource.id_prop_wingplane_icon;
	
	public static final int id_blood = 1;		//Ѫƿ
	public static final int id_laser = 2;		//����
	public static final int id_missile = 3;		//����
	public static final int id_upgrade = 4;		//��������
	public static final int id_ventose = 5;		//����
	public static final int id_wingplane = 6;	//�Ż�
	
	/*�ؿ��ȼ���Ϣ*/
	public static final long levelInfo[][] = {
		/*0-�ؿ�, 1-�ؿ�ʱ��(��), 2-����ʱ����, 3-battery interval*/
		{1, 120, 5000, 10000},
		{2, 120, 5000, 10000},
		{3, 120, 5000, 10000},
		{4, 120, 5000, 10000},
		{5, 120, 5000, 10000},
		{6, 120, 5000, 10000},
		{7, 120, 5000, 60000},
		{8, 120, 5000, 60000},
	};
	
	/*�������*/
	public int playerParam[][] = {
			/*0-id, 1-x����, 2-y����, 3-���, 4-�߶�, 5-������, 6-Ѫ��, 7-�˺�, 8-�ȼ�, 9-x�ٶ�, 10-y�ٶ�
			 * ,11-����ӵ��ȼ�, 12-���ͼƬid, 13-����, 14-����, 15-Ч��*/
			{0, 20, 250, 48, 100, 3, 100, 15, TOTORO_GRADE_ONE, 12, 10, TOTORO_BOMB_GRADE_ONE, yellowTotoroPicId, 6, 4, 6},
			{1, 20, 250, 35, 53, 3, 100, 10, TOTORO_GRADE_TWO, 10, 12, TOTORO_BOMB_GRADE_ONE, pinkTotoroPicId, 4, 3, 6},
			{2, 20, 250, 63, 97, 3, 200, 5, TOTORO_GRADE_THREE, 15, 15, TOTORO_BOMB_GRADE_ONE, blueTotoroPicId, 8, 6, 7},
			{3, 20, 250, 53, 97, 3, 150, 7, TOTORO_GRADE_FOUR, 15, 15, TOTORO_BOMB_GRADE_ONE, blackTotoroPicId, 6, 8, 8},
	};
	
	/*�Ż�����*/
	public int wingplaneParam[][] = {
			/*0-id, 1-picId, 2-w, 3-h, 4-blood,5-damage*/
			{0,yellowWingplane, 23,47,50,15},
			{1,pinkWingplane, 16,25,75,10},
			{2,blueWingplane, 30,45,100,15},
			{3,blackWingplane, 24,45,75,15},
	};
	
	public int wingplaneBombParam[][] = {
			/*0-id, 1-w, 2-h, 3-damage, 4-picId*/
			{0, 32, 18, 30, yellowBomb1PicId, 15},
			{1, 27, 21, 30, pinkBombPicId, 10},
			{2, 34, 14, 30, blueBomb1PicId,20},
			{3, 22, 23, 30, blackBomb1PicId,20},
	};
	
	/*�����ͨ��������, 	�����е���ֵΪ0��ʾ��ʹ�ø�ֵ*/
	public int bombParam[][][] = {
			/*��ҵȼ�*/
			{
				/*�ӵ��ȼ�*/
				/*0-id, 1-���, 2-�߶�, 3-�˺�, 4-x�ٶ�, 5-Y�ٶ�, 6-�ӵ�ͼƬid*/
				{14, 32, 18, 20, 30, 6, yellowBomb1PicId},
				{15, 46, 25, 25, 30, 6, yellowBomb2PicId},
				{16, 100, 50, 30, 30, 6, yellowBomb3PicId},
			},
			{
				/*�ӵ��ȼ�*/
				/*0-id, 1-���, 2-�߶�, 3-�˺�, 4-x�ٶ�, 5-Y�ٶ�, 6-�ӵ�ͼƬid*/
				{10, 27, 21, 20, 20, 6, pinkBombPicId},
				{11, 27, 21, 20, 20, 6, pinkBombPicId},
				{12, 27, 21, 20, 20, 6, pinkBombPicId},
				{13, 27, 21, 20, 20, 6, pinkBombPicId},
			},
			{
				/*�ӵ��ȼ�*/
				/*0-id, 1-���, 2-�߶�, 3-�˺�, 4-x�ٶ�, 5-Y�ٶ�, 6-�ӵ�ͼƬid*/
				{17, 34, 14, 20, 20, 6, blueBomb1PicId},
				{18, 67, 14, 12, 20, 6, blueBomb2PicId},
				{19, 93, 33, 8, 20, 6, blueBomb3PicId},
				{20, 114, 51, 8, 20, 6, blueBomb4PicId},
			},
			{
				/*�ӵ��ȼ�*/
				/*0-id, 1-���, 2-�߶�, 3-�˺�, 4-x�ٶ�, 5-Y�ٶ�, 6-�ӵ�ͼƬid*/
				{21, 22, 23, 20, 30, 6, blackBomb1PicId},
				{22, 86, 29, 12, 20, 6, blackBomb2PicId},
				{23, 65, 65, 30, 30, 6, blackBomb3PicId},
			},
	};
	
	public int playerSkillParam[][] = {
			/*0-id, 1-w,2-h,3-damage,4-speedx,5-speedy, 6-frameNum,7-picId*/
			{0, 600, 11, 5, 5, 5, 4, laserPic},
			{1, 42, 21, 70, 20, 20, 1, missilePic},
			
			{2, 164, 159, 40, 60, 60, 8, yellowVentose},
			{3, 164, 159, 40, 60, 60, 8, yellowVentose},
			{4, 180, 454, 70, 60, 60, 5, pinkVentose},
			{5, 180, 454, 70, 60, 60, 5, pinkVentose},
	};
	
	/*��������*/
	public int propsParam[][] = {
			/*0-Id, 1-propPicId, 2-picW, 3-picH, 4-speedX, 5-speedY, 6-*/
			{id_blood, prop_blood_icon, 42,41,5,5},
			{id_laser, prop_laser_icon, 44,44,5,5},
			{id_missile, prop_missile_icon, 44,44,5,5},
			{id_upgrade, prop_upgrade_icon, 49,57,5,5},
			{id_ventose, prop_ventose_icon, 40,40,5,5},
			{id_wingplane, prop_wingplane_icon, 47,46,5,5},
	};
	
	/*ÿ���ؿ�������Ľ�Ʒ*/
	public int levelProps[][] = {
			{id_blood,id_blood,id_laser, id_upgrade,id_wingplane},
			{id_blood,id_missile, id_upgrade,id_wingplane,id_wingplane},
			{id_blood,id_missile, id_upgrade,id_wingplane,id_wingplane},
			{id_blood,id_laser,id_missile, id_upgrade,/*id_ventose,*/id_wingplane,id_wingplane},
			{id_blood,id_missile, id_upgrade,id_wingplane,id_wingplane},
			{id_blood,id_laser,id_missile, id_upgrade,id_wingplane,id_wingplane},
			{id_blood,id_missile, id_upgrade,id_wingplane,id_wingplane},
			{id_blood,id_laser,id_missile, id_upgrade,id_wingplane,id_wingplane},
	};
	
	/*boss����*/
	public int bossParam[][] = {  
			/*0-id, 1-���, 2-�߶�, 3-Ѫ��, 4-����, 5-x�ٶ�, 6-y�ٶ�, 7-x����, 8-y����
			 * 9-ͼƬid, 10-֡�����, 11-ͼƬ��֡��, 12-�˺�, 13-����һʱ����, 14-���ܶ�ʱ����, 15-����, 16-��ʼλ��,17-����1�˺�, 18-����2�˺�*/
			{200, 186, 266, 12000, 100, 10, 10, 0, 0, boss_1, 300, 5, 50, 7, 3, OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
			{201, 162, 210, 12000, 100, 5, 5, 0, 0, boss_2, 300, 3, 50, 7, 3,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,50},
			{202, 192, 204, 24000, 100, 5, 5, 0, 0, boss_3, 300, 1, 50, 7, 3,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
			{203, 196, 213, 24000, 100, 5, 5, 0, 0, boss_4, 300, 5, 50, 7, 3,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
			{204, 102, 160, 36000, 100, 5, 5, 0, 0, boss_5, 300, 3, 50, 3, 7,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
			{205, 103, 148, 36000, 100, 5, 5, 0, 0, boss_6, 300, 3, 50, 7, 3,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
			{206, 275, 353, 48000, 100, 5, 5, 0, 0, boss_7, 300, 5, 50, 3, 7,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
			{207, 260, 299, 48000, 100, 5, 5, 0, 0, boss_8, 150, 5, 50, 3, 7,OBJECT_DIRECTION_LEFT, OBJECT_POSITION_RIGHT,50,30},
	};
	
	/*boss��������*/
	public int bossSkillParam[][] = {
			/*0-bossId, 1-picW, 2-picH, 3-damage,4-mapx, 5-mapy, 6-picId, 7-speedX, 8-speedY, 9-frameNum, 10-skillNum*/
			{200, 110, 130, 10, 10, 0, boss1SkillPicId, 15, 15, 3, 1},
			{201, 85, 50, 10, 10, 0, boss2SkillPicId, 25, 25, 1, 1},
			{202, 76, 150, 30, 10, 0, boss3SkillPicId, 80, 80, 1, 4},
			{203, 135, 145, 10, 10, 0, boss4SkillPicId, 80, 25, 4, 4},
			{204, 50, 23, 10, 10, 0, boss5SkillPicId, 25, 25, 3, 3},
			{205, 49, 52, 30, 10, 0, batteryBomb2PicId, 30, 80, 1, 4},
			{206, 24, 22, 10, 10, 0, boss7SkillPicId_1, 15, 15, 1, 8},
			{207, 38, 37, 30, 10, 0, boss7SkillPicId_4, 60, 60, 1, 12},
			
			{0, 50, 140, 100, 10, 0, boss8Skill2_1_PicId, 60, 60, 3, 1},
	};
	
	/*��6,7��boss����һͼƬ����*/
	public int bossSkillPic[][][] = {
			/*��6��*/
			{
				/*0-bossId, 1-picW, 2-picH, 3-picId, 4-speedX, 5-speedY, 6-frameNum, 7-damage*/
				{205, 68, 131, boss6SkillPicId_4, 80, 25, 1, 10},
				{205, 48, 94, boss6SkillPicId_3, 80, 25, 1, 15},
				{205, 34, 66, boss6SkillPicId_2, 80, 25, 1, 20},
				{205, 23, 43, boss6SkillPicId_1, 80, 25, 1, 20},
			},
			/*��7��*/
			{
				/*0-bossId, 1-picW, 2-picH, 3-picId, 4-speedX, 5-speedY, 6-frameNum, 7-damage*/
				{206, 68, 66, boss7SkillPicId_8, 64, 25, 1, 10},
				{206, 62, 59, boss7SkillPicId_7, 64, 25, 1, 10},
				{206, 54, 51, boss7SkillPicId_6, 64, 25, 1, 10},
				{206, 46, 44, boss7SkillPicId_5, 64, 25, 1, 10},
				{206, 38, 37, boss7SkillPicId_4, 64, 25, 1, 10},
				{206, 30, 29, boss7SkillPicId_3, 64, 25, 1, 10},
				{206, 28, 26, boss7SkillPicId_2, 64, 25, 1, 10},
				{206, 24, 22, boss7SkillPicId_1, 64, 25, 1, 10},
			}
	};

	/*��̨����*/
	public int batteryParam[][] = {
			/*0-id, 1-width, 2-height, 3-blood, 4-scores, 5-speedX, 6-speedY, 7-coorX, 8-coorY
			 * 9-position, 10-attackpermission, 11-picId, 12-frameNum, 13-damage, 14-bombInterval, 15-picInterval, 16-prize*/
			
			{300, 70, 69, 300, 30, 3, 0, ScrW, 415, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_1, 3, 10, 1, 500,SPIRITI_PRIZE_NO},
			{300, 70, 69, 300, 30, 3, 0, ScrW, 415, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_1, 3, 10, 1, 500,SPIRITI_PRIZE_NO},
			{300, 70, 69, 300, 30, 3, 0, ScrW, 415, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_1, 3, 10, 1, 500,SPIRITI_PRIZE_NO},
			{300, 70, 69, 300, 30, 3, 0, ScrW, 415, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_1, 3, 10, 1, 500,SPIRITI_PRIZE_NO},
			{301, 131, 146, 350, 30, 3, 0, ScrW, 355, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_2, 4, 10, 1, 500,SPIRITI_PRIZE_YES},
			{301, 131, 146, 350, 30, 3, 0, ScrW, 355, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_2, 4, 10, 1, 500,SPIRITI_PRIZE_YES},
			{302, 92, 97, 200, 30, 3, 0, ScrW, 378, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_3, 1, 10, 1, 500,SPIRITI_PRIZE_YES},
			{302, 92, 97, 200, 30, 3, 0, ScrW, 378, OBJECT_POSITION_LEFT, ATTACK_PERMISSION_YES, battery_3, 1, 10, 1, 500,SPIRITI_PRIZE_YES},
	};
	
	/*������ͨ��������*/
	public int spiritBombParam[][] = {
			/*0-����id, 1-id, 2-���, 3-�߶�, 4-�˺�, 5-x�ٶ�, 6-Y�ٶ�, 7-�ӵ�ͼƬid,8-�����ӵ����� */
			{100, 15, 15, 14, 10, 20, 20, spiritBomb1PicId, 1},
			{101, 15, 15, 14, 10, 20, 5, spiritBomb1PicId, 3},
			{102, 15, 15, 14, 10, 20, 5, spiritBomb1PicId, 1},
			{103, 16, 21, 24, 10, 20, 5, spiritBomb2PicId, 3},
			{104, 16, 21, 24, 10, 20, 20, spiritBomb2PicId, 1},
			{105, 16, 21, 24, 10, 20, 20, spiritBomb2PicId, 1},
			{106, 16, 21, 24, 10, 20, 20, spiritBomb2PicId, 1},
			{107, 17, 14, 15, 15, 20, 20, spiritBomb3PicId, 1},
			{108, 18, 15, 15, 15, 20, 5, spiritBomb4PicId, 3},
			{109, 19, 24, 15, 15, 20, 20, spiritBomb5PicId, 1},
			{110, 14, 24, 15, 15, 20, 5, spiritBomb5PicId, 3},
			{111, 13, 50, 23, 15, 20, 20, spiritBomb6PicId, 1},
			//{200, 20, 85, 50, 25, 20, 20, bossBomb1PicId},
			{201, 15, 15, 14, 15, 20, 5, spiritBomb1PicId, 3},
			{202, 16, 21, 24, 15, 20, 5, spiritBomb2PicId, 3},
			{203, 16, 21, 24, 15, 20, 5, spiritBomb2PicId, 3},
			{204, 17, 14, 15, 15, 20, 5, spiritBomb3PicId, 3},
			{205, 18, 15, 15, 15, 20, 5, spiritBomb4PicId, 3},
			{206, 14, 24, 15, 15, 20, 5, spiritBomb5PicId, 3},
			{207, 14, 24, 15, 15, 20, 5, spiritBomb5PicId, 3},
			{300, 30, 15, 14, 15, 20, 15, spiritBomb1PicId, 1},
			{301, 31, 49, 52, 15, 20, 20, batteryBomb2PicId, 1},
			{302, 32, 31, 31, 15, 20, 30, batteryBomb3PicId, 3},
	};
	
	/*��������*/
	public int spiritParam[][] = {
	/*0-id, 1-���, 2-�߶�, 3-Ѫ��, 4-����, 5-x�ٶ�, 6-y�ٶ�, 7-x����, 8-y����, 9-��ʼλ��, 
	 * 10-�Ƿ�ṥ��, 11-ͼƬid, 12-�Ƿ����佱Ʒ, 13-֡�����, 14-ͼƬ��֡�� , 15-�����˺�
	 * 16-�����ӵ����*/
		{100, 47, 62, 10, 15, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_1, SPIRITI_PRIZE_YES, 500, 5, 10, 3},
		{101, 84, 76, 30, 10, 8, 8, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_2, SPIRITI_PRIZE_YES, 500, 3, 10, 3},
		{102, 80, 62, 45, 10, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_3, SPIRITI_PRIZE_NO, 500, 3, 10, 2},
		
		{103, 50, 69, 45, 10, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_4, SPIRITI_PRIZE_NO, 500, 3, 10, 2},
		{104, 63, 89, 100, 20, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_5, SPIRITI_PRIZE_YES, 500, 3, 10, 2},
		{105, 93, 114, 20, 10, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_6, SPIRITI_PRIZE_NO, 500, 6, 10, 2},
		{106, 79, 104, 100, 10, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_7, SPIRITI_PRIZE_YES, 500, 2, 10, 2},
		
		{107, 60, 75, 100, 20, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_8, SPIRITI_PRIZE_YES, 500, 3, 10, 2},
		{108, 75, 66, 50, 20, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_9, SPIRITI_PRIZE_YES, 500, 3, 10, 2},
		
		{109, 105, 79, 150, 25, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_10, SPIRITI_PRIZE_YES, 500, 5, 10, 2},
		{110, 45, 97, 200, 25, 6, 6, 640, 200, 0, ATTACK_PERMISSION_YES, spirits_11, SPIRITI_PRIZE_YES, 500, 4, 10, 2},
		
		//����boss����С��
		{111, 22, 32, 200, 25, 6, 6, 640, 200, 0, ATTACK_PERMISSION_NO, spirits_12, SPIRITI_PRIZE_NO, 500, 3, 5, 2},
		
		/*��ħboss����С��*/
		{112, 68, 66, 100, 25, 20, 6, 640, 200, 0, ATTACK_PERMISSION_NO, boss7SkillPicId_8, SPIRITI_PRIZE_NO, 500, 1, 10, 2},
	};
	
	/*����������Ϣ*/
	public int batchInfo[][][] = {
			/*0-id, 1-����, 2-��ʼλ��, 3-�ƶ�����*/
		/*��һ�ع����б�*/	
		{
			{100, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{101, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{104, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{102, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{104, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{104, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			//{102, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{102, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*�ڶ��ع����б�*/	
		{
			{102, 4, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{101, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{101, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{102, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{102, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{104, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{100, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{104, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{104, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			//{102, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{102, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*�����ع����б�*/	
		{
			{103, 4, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{105, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{106, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{105, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{105, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{103, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{103, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{106, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{106, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{105, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{103, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{106, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			//{105, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*���Ĺع����б�*/	
		{
			{103, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{105, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{106, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{105, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{105, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{103, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{103, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{106, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{106, 2, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{105, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{103, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{106, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			//{105, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			//{100, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
		
		/*����ع����б�*/	
		{
			{107, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{108, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{108, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 2, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{107, 3, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 4, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{108, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
		},
		
		/*�����ع����б�*/	
		{
			{107, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{108, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{108, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{107, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{107, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 2, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{108, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{107, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{108, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
		},
		
		/*���߹ع����б�*/	
		{
			{109, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{109, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{110, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{110, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{109, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{110, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{109, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{109, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{110, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{109, 2, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{110, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{109, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{109, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{110, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
		},
		
		/*�ڰ˹ع����б�*/	
		{
			{109, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{110, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{109, 2, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{110, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{109, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{109, 4, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{110, 10, OBJECT_POSITION_LEFT, OBJECT_DIRECTION_RIGHT},
			{109, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{109, 3, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{110, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{110, 4, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
			{109, 2, OBJECT_POSITION_UP, OBJECT_DIRECTION_RIGHT_DOWN},
			{110, 3, OBJECT_POSITION_DOWN, OBJECT_DIRECTION_RIGHT_UP},
			{109, 10, OBJECT_POSITION_RIGHT, OBJECT_DIRECTION_LEFT},
		},
	};
	
	/*������Ϣ*/
	public String descInfo[] = {
			"�ػ����飺����һ��,�ػ���������һ",
			"��ɱ����ȫ������,�޵�״̬,����5��",
	};
	
	public String helpInfo = "��è��ʿ��һ���洳�������Ϸ����è���Զ������ӵ���ʹ�÷����������è�ƶ�����������м��ʵ��丽������������������Ѫƿ�����ػ����顣���⣬��һ����Ի�����Ϸ�ҽ�����è��������è��������è�������ɱ��#r#r";
	
	public String helpInfo2 = 
			"���������������������Ը���è�������.��Ϸ��һ����2�ָ������������ٵ����ͼ��⡣#r"+
			"����������������������������è�������������ÿ����è�����������Ч������һ����#r"+
			"Ѫƿ��Ѫƿ���Իָ���èһ����Ѫ����#r"+
			"�ػ����飺�ػ�������԰�����һ����ս����ʼ��èֻ��Я��1���ػ����飬ÿ��һ������һֻ��������ӵ�4ֻ�����ÿ��һ�����ػ�����Ҳ����ʧ1����#r#r"
	;
	
	public String helpInfo3 = 
			"������è�������ʼ��Ϸ������èѡ����棬����2ֻ��è��δ�����ģ���Ҫ���ʹ����Ϸ�ҽ�����δ��������èӵ�и�ǿ�������͹�����.ÿֻ��è�Ľ�������Ϊ500"+TotoroGameEngine.expenseUnit+"��#r"+
			"������è����ս�������е�����ּ�9�����̳ǿ���������è.�������������Я���ػ����������.�����ķ�������Ϊ��20��40��80"+TotoroGameEngine.expenseUnit+"��#r"+
			"������è�������ʧȥ���е���������ѡ�񸴻���è��ÿ�ظ���Ļ��Ѳ�ͬ���ֱ�Ϊ100��200��300��300��300��300��300��300"+TotoroGameEngine.expenseUnit+"��#r"+
			"�����ɱ����ս�������е�����ּ�9�����̳ǿ��Թ����ɱ����ɱ������ҳ���һ��ʱ����޵в��Ե�����ɺܴ���˺�.ÿ����ɱ��Ҫ200"+TotoroGameEngine.expenseUnit+"��#r"
	;
}
