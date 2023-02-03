
public class Number5 {
	public static void main(String[] args) {
		// 1.
		Grendizer a = new Car();
		
		// 2.
		Car b = new Grendizer();
		
		// 3.
		Grendizer c = new OpenGrendizer();
		
		// 4.
		Grendizer d = new Grendizer();
	}
}
class Car {
	Car(){
		System.out.println("뿌뿌뿌");
	}
}
class Grendizer extends Car{
	Grendizer(){
		System.out.println("나의 드림카 그랜다이져");
	}
}
class OpenGrendizer extends Grendizer{
	OpenGrendizer(){
		System.out.println("나의 드림카 그랜다이져가 뚜껑도 열림");
	}
}

/*
 * 문제5. main에서 잘못된 객체생성은 몇번인가?
 */


// 1번은 잘못된 형변환이다.
// 자식 인스턴스는 부모클래스의 인서턴스를 가지고 있기 때문에 부모 변수에 들어갈 수 있다.
// 그러나 부모 인스턴스는 자식클래스의 인스턴스를 가지고 있지 않기 때문에 자식 변수에 들어갈 수 없다.