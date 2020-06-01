import java.util.Random;

public class TwoDimension {

	public static void main(String[] args) {
		Random r = new Random();
		int array[][]= new int [4][4];
		
		for(int i = 0; i<array.length;i++) {
			for(int j = 0; j<array[i].length;j++) {
				array[i][j]=r.nextInt(10);
				System.out.print((array[i][j]+1) +" ");
			}
			System.out.println();
		}
	}
}