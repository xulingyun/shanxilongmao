package totoro;

/**
 * �����ƶ��������Ե��������
 * @author jackey
 *
 */
public class MoveObject {
	
	int status;				//״̬1:���ţ������� �޵�
	int status2;			//״̬2���ƶ� ������
	int id;					//����id
	int objectId;			//��������id
	int mapx;				//x������
	int mapy;				//y������
	int width;				//����ͼƬ���
	int height;				//����ͼƬ�߶�
	int lifeNum;			//��������
	int blood;				//Ѫ��
	int damage;				//��ɵ��˺�ֵ
	int speedX;				//x�᷽���ٶ�
	int speedY; 			//y�᷽���ٶ�
	int scores;				//����
	int grade;				//�ȼ�
	int bombGrade;			//����ӵ��ȼ�
	int frame;				//����ͼƬ֡��
	int picId;				//ͼƬid
	int position;			//��ʼλ��(0-��, 1-��, 2-��)
	int attackPermission;	//�ܲ��ܹ���(0-no, 1-yes)
	int pirze;				//�Ƿ��н�Ʒ(0-no, 1-yes)
	int direction;			//�ƶ�����(0-��, 1-��, 2-��, 3-��, 4-����, 5-����, 6-����, 7-����)
	long startTime;			//����֡����ת����
	long endTime;			//
	int timeInterval;		//����֡����ת���
	int frameNum;			//ͼƬ��֡��
	int frameIndex;			//��ǰ���ڵ�֡
	int directionValue;		//����ֵ
	long bombSTime;			//�����ӵ���ʱ�����
	long bombETime;
	int bombInterval;		//�����ӵ��ļ��
	long skill1STime;
	long skill1ETime;
	int skill1Interval;
	int skill1Damage;
	long skill2STime;
	long skill2ETime;
	int skill2Interval;
	int skill2Damage;
	long runTime1;		//boss run time1
	long runTime2;		//boss run time2
	int stopInterval;
	int skillStatue;	//1-����1, 2-����2
	
	int bombNum;
	int wingplaneNums;
	int wingplaneMaxNums;
	int missileGrade;  //1,2 �ȼ�
	int skillNums;		//������
	
	MoveObject mo;			//���ٵ������ٶ���
}
