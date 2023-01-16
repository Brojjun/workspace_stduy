// ##DELETE_FILE:
package com.ssafy.c_inheritance.person;

public class SpiderMan extends Person {
    boolean isSpider;

    public void fireWeb() {
        if (isSpider) {
            System.out.println("거미줄 발사.. 어떻게 하지?");
        } else {
            System.out.println("사람은 발사 못하지.");
        }
    }

    @Deprecated
    public void love() {
        System.out.println("메리제인과의 사랑!");
    }

}