class tv{
	int a;
	public void settv(int a) {
		this.a = a;
	}
	public int gettv() {
		return a;
	}
}

public class asc {
	public static void main(String [] args) {
		tv [] mytv = new tv [5]; //객체 배열 생성
		for(int i = 0; i < 5; i++) {
			mytv[i] = new tv(); //객체 배열에 대한 레퍼런스 변수 지정
			mytv[i].settv(i);
			System.out.println(mytv[i].gettv());
		}
	}
}