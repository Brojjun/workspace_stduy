
public class Number2 {
	public static void main(String[] args) {
		//1.
		int[] arr = new int[];
		
		//2.
		int arr2[] = new int[];
		
		//3.
		int arr3[] = new int[] {'a',2,'-',4};
		
		//4.
		int arr4[] = {'a',"b",1};
	}
}


/*
 * 문제 2. 다음 중 정상적으로 Array를 생성한 것은 몇번인가요?
 */

/* 
 * 1번과 2번은 right value에서 얼만큼 동적할당할 건지에 대한 명령이 없다. new int[2];가 필요
 * 4번 "b"는 String이기 때문에 int Array에 넣을 수 없다.
 * 
 * 정답 : 3번
 */