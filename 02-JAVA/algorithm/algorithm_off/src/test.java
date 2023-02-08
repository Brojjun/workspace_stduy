
public class test {
	public static void main(String[] args) {
		int i = 1;
		int n = 3;
		int r = 4;
		while(true) {
			System.out.println(i + " : " + n + " % " + r + " = " + n%r);
			n = n * n;
			i++;
			if(i==500)break;
		}
	}
}
