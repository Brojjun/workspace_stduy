package com.ssafy.g_collection.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    // 문자열을 저장할 List, 구현체는 ArrayList
    List<String> friends = new ArrayList<>();

    public static void main(String[] args) {

        ListTest alt = new ListTest();
        alt.createTest();
        alt.retrieveTest();
        alt.updateTest();
        alt.deleteTest();
    }

    public void createTest() {
        // TODO: friends에 여러명의 친구를 등록해보자.
    	friends.add("1번");
    	friends.add("2번");
    	friends.add("3번");
    	friends.add("4번");
    	friends.add("4번");
    	friends.add(0,"새치기");
        // END:
        System.out.println("추가 후 내용 출력: " + friends);
    }

    public void retrieveTest() {
        // TODO: 다양한 조회 기능을 사용해보자.
    	System.out.println("list의 크기 : " + friends.size());
    	for(int i=0; i<friends.size(); i++) {
    		System.out.println(friends.get(0));
    	}
    	for(String friend : friends) System.out.println("foreach : " +friend);
    	
    	System.out.println(friends.contains("1번"));
    	System.out.println(friends.indexOf("1"));
        // END:
    }

    public void updateTest() {
        // TODO: 홍길동이 있다면 값을 율도국 왕으로 변경해보자.
    	int idx = friends.indexOf("3번");
    	if(idx >= 0) {
    		friends.set(idx, "33번");
    	}
    	System.out.println("수정 후 : " + friends);
        // END:
    }

    public void deleteTest() {
        // TODO: 0번째 친구와 율도국 왕을 삭제하시오.
        // END:
        friends.remove(0);
        System.out.println("삭제 후 : " + friends);
        
        friends.clear();// 리스트 초기화
        System.out.println("초기화 후 : " + friends);
        
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        
        l.remove(1);
        l.remove(Integer.valueOf(1));
    }
}
