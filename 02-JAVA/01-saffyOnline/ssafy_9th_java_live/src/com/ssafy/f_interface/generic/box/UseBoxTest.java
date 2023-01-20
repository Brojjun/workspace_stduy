package com.ssafy.f_interface.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
        // END:
    	NumberBox<Number> box2 = new NumberBox<>();
    	box2.addSomes(1,10,11,12.3);
    	NumberBox<Integer> box3 = new NumberBox<>();
    	box3.addSomes(1,2,10);
    	//NumberBox<String> box4 = new NumberBox<>(); -->number와 관련 없는 string은 사용 불가
    }

}
