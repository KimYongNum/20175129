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
		tv [] mytv = new tv [5]; //��ü �迭 ����
		for(int i = 0; i < 5; i++) {
			mytv[i] = new tv(); //��ü �迭�� ���� ���۷��� ���� ����
			mytv[i].settv(i);
			System.out.println(mytv[i].gettv());
		}
	}
}