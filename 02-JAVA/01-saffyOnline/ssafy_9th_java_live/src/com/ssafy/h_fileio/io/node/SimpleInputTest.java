package com.ssafy.h_fileio.io.node;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class SimpleInputTest {

    private String data1 = "hi java world";
    private String data2 = "자바는 객체지향 언어입니다.";

    //1글자씩 읽어보자
    private void read1() {
        // TODO: data2를 읽어보자.
    	try(InputStream input = new ByteArrayInputStream(data1.getBytes())){
    		int read = -1;
    		while((read = input.read()) != -1) {
    			System.out.printf("읽은 값 : %d, %c\n",read,read);
    		}
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
        // END:
    }
    //10글자씩 읽어보자
    //한글은 글자당 3byte이기 때문에 10byte를 읽으면 깨짐 -> 유니코드는 byte로 처리하기는 좋지 않다.
    private void read2() {
    	byte[] buffer = new byte[10];
    	
    	try(InputStream input = new ByteArrayInputStream(data2.getBytes())){
    		int read = -1;
    		while((read = input.read(buffer)) != -1) {
    			System.out.printf("읽은 개수 : %d, %s\n",read,new String(buffer, 0, read));
    		}
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void read3() {
    	char[] buffer = new char[10];
    	
    	try(Reader input = new CharArrayReader(data2.toCharArray())){
    		int read = -1;
    		while((read = input.read(buffer)) > 0) {
    			System.out.printf("읽은 개수 : %d, %s\n",read,new String(buffer, 0, read));
    		}
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public static void main(String[] args) {
        SimpleInputTest ns = new SimpleInputTest();
        //ns.read1();
        //ns.read2();
         ns.read3();
    }
}
