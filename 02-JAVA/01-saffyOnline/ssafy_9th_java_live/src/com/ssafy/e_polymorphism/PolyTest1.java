// ##DELETE_FILE:
package com.ssafy.e_polymorphism;

import com.ssafy.c_inheritance.person.Person;
import com.ssafy.c_inheritance.person.SpiderMan;

public class PolyTest1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SpiderMan onlyOne = new SpiderMan();

        SpiderMan sman = onlyOne;

        Person person = onlyOne;

        Object obj = onlyOne;

        // Venom venom = onlyOne;
    }
}

class Venom extends SpiderMan {}