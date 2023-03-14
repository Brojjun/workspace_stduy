package com.ssafy.live17SMT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class test {
	
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet();
		//HashMap<Integer, String> map = new HashMap<>();
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1, "일");
		map.put(100, "백");
		map.put(1000, "천");
		map.put(10000, "만");
		map.put(10, "십");

		

		for(Map.Entry<Integer, String> num : map.entrySet()) {
			System.out.println(num.getValue());
		}
	}
}