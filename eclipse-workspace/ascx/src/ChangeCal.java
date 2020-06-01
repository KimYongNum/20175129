import java.util.Scanner;

public class ChangeCal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		System.out.print("금액을 입력하시오>>");
		int money = sc.nextInt();
		
		for(int i = 0; i < unit.length; i++) {		
			int res = money / unit[i];
			if(res == 0 ) continue;
			System.out.println(unit[i]+"원 짜리 : " + res + "개");
			money %= unit[i];
		}
	}
}