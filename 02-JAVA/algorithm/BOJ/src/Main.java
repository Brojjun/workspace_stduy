import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			for(int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
	}

}
}
