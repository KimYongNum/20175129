import java.util.Scanner;
import java.util.Random;

public class OpenChallenge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Random r = new Random();
		int ran = r.nextInt(100);
		System.out.println("���� �����Ͽ����ϴ�. ���߾� ������");
		int fir = 0,cnt = 1, fin = 99;
		
		while(true) {
			System.out.println(fir + "-" + fin);
			System.out.print(cnt+">>");
			int ans = sc.nextInt();	
			cnt++;		
			if(ans == ran) {
				System.out.print("�¾ҽ��ϴ�.\n�ٽ��Ͻðڽ��ϱ�(y/n)>>");
				String con = sc.next();
				if(con.equals("y")) {
					fir = 0; cnt = 1; fin = 99; 
					ran = r.nextInt(100);
				}
				else return;
			}
			else if (ans < ran) { System.out.println("�� ����"); fir = ans;}
			else if (ans > ran) { System.out.println("�� ����"); fin = ans;}
		}
	}
}