


public class Number4 {
	
	public static void main(String[] args) {
		String a = "무선사업부";
		String b = "무선사업부";
		String c = new String("무선사업부");
		
		int cnt = 0;
		
		if(a == b)
			cnt++;
		
		if(a.equals(b)) 
			cnt++;
		
		if(a == c)
			cnt++;
		
		cnt += a.compareTo(b);
		
		System.out.println(cnt);
			
	}
}

/*
 * 문제 4. 해당 코드의 출력값을 예측해보세요.
 *	1. 1
 *  2. 2
 *  3. 3
 *  4. 4
*/

/*
 * 1. a == b의 경우 주소를 비교하는 연산이다.
 * 자바에서는 문자열을 변수에 저장한 뒤 해당 문자열의 주소를 저장하고, 나중에 똑같은 문자열을 대입받으면 해당 문자열의 주소를 저장한다.
 * 그래서 a와 b의 주소는 같다. true이다.
 * 2. String객체 내의 문자열을 비교하는 연산이다. a와 b의 문자열은 같기 때문에 true이다.
 * 3. 번과 비슷한 주소 비교 문제이다.
 * 그러나 다른 점은 new키워드를 사용해 새롭게 동적할당했기 때문에 서로 다른 주소값을 가진다. 그래서 false이다.
 * 4. compareTo는 두 문자열의 값의 차를 나타내는 함수이다. 두 문자열의 내용이 같기 때문에 0이 출력된다.
 *  
 *  2번 2
*/

