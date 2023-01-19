package com.ssafy.e_polymorphism;

import com.ssafy.c_inheritance.person.Person;
import com.ssafy.c_inheritance.person.SpiderMan;

public class PolymorphismUsage {
    public void useObjectArray() {
        // TODO:Object []을 선언하고 다양한 객체를 저장하고 저장된 클래스 타입을 출력하세요.
        // END:
    	Object [] objs = new Object[4];
    	objs[0] = "Hello";
    	objs[1] = new Person();
    	objs[2] = new Venom();
    	objs[3] = 3;//autoboxing
    	
    	
    	for(int i=0; i<objs.length; i++) {
    		System.out.println(objs[i].getClass().getName());
    	}
    	//autoboxing
    	int a = 10;
    	Integer oabj = a;
    	int sum = a + oabj;
    	
    	
    	
    	/////
    	Object obj = objs[1];
    	if(obj instanceof Person) {
    		Person p = (Person)obj;
    		p.eat();
    	}
    	else {
    		System.out.println(obj.getClass().getName());
    	}
    	SpiderMan sam2 = new SpiderMan();
    	System.out.prinln(sam2);
    }
    

    public void useObjectParam() {
        System.out.println(1);
        System.out.println("Hello");
        System.out.println(new Person());
        System.out.println(new SpiderMan());
    }

    public static void main(String[] args) {
        PolymorphismUsage usage = new PolymorphismUsage();
        usage.useObjectArray();
        usage.useObjectParam();
    }
}
