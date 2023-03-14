package com.ssafy.off19;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정형준_BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+|-", true);
		int num = 0;
		boolean flag = false;
		List <Integer> arr = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			String nx = st.nextToken();
			
			if(nx.equals("+")) continue;
			else if(nx.equals("-")) {
				flag = true;
				arr.add(0);
			}
			//앞에 마이너스가 o
			else if(flag) {
				int data = arr.get(arr.size()-1);
				arr.set(arr.size()-1, data + Integer.parseInt(nx));
			}
			//앞에 마이너스가 x
			else if(!flag) {
				num += Integer.parseInt(nx);
			}
			
		}
		for(int i = 0; i < arr.size(); i++)
			num -= arr.get(i);
		System.out.println(num);
	}
}