package sdfdf;
public class main {
	public static void main(String[] args) {
		try {
			int a = 1/0;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("캐치");
		}
		finally {
			System.out.println("파이널");
		}
	}
}
