// @@DELETE_FILE:
package com.ssafy.g_collection.exception.custom;

@SuppressWarnings("serial")
public class FruitNotFoundException extends Exception {
    public FruitNotFoundException(String name) {
        super(name + "에 해당하는 과일은 없습니다.");
    }
}
