
public class Number3 {
	public static void main(String[] args) {
		
	
	int first = Integer.MAX_VALUE;
	int second = 1;
	System.out.println(first + second);
	}
}

//문제3. Integer.MAX_VALUE의 값은 2147483647입니다. 그렇다면 해당 코드의 출력을 적으세요.

/*
 * Int.MAX_VALUE는 이진코드로 01111111111111111...입니다.
 * 여기서 1을 더하면 10000000000000000... 이 됩니다.
 * 
 * int의 이진코드에서 가장 왼쪽에 있는 숫자는 양수인지 음수인지를 결정하고,
 * 첫번째 수가 0일 경우 (2번째 숫자부터의 값)을 0에 더한 값이고,
 * 첫번째 수가 1일 경우 (2번째 숫자부터의 값)을 -1에 뺀 값입니다.
 * 
 * 그렇기 때문에 01111111...인 상태에서 1을 더하면 100000...이 되고 이는 -1 - (Integer.MAX_VALUE) 입니다.
 * 답 : -2147483648
*/
