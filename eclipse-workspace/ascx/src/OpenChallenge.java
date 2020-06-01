import java.util.Scanner;
import java.util.Random;

public class OpenChallenge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Random r = new Random();
		int ran = r.nextInt(100);
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		int fir = 0,cnt = 1, fin = 99;
		
		while(true) {
			System.out.println(fir + "-" + fin);
			System.out.print(cnt+">>");
			int ans = sc.nextInt();	
			cnt++;		
			if(ans == ran) {
				System.out.print("맞았습니다.\n다시하시겠습니까(y/n)>>");
				String con = sc.next();
				if(con.equals("y")) {
					fir = 0; cnt = 1; fin = 99; 
					ran = r.nextInt(100);
				}
				else return;
			}
			else if (ans < ran) { System.out.println("더 높게"); fir = ans;}
			else if (ans > ran) { System.out.println("더 낮게"); fin = ans;}
		}
	}
}