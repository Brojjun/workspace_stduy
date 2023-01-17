package com.saffy.startcamp;

public class test02_Switch {
	public static void main(String[] args) {
		/*
		 * 1.4버전까진  : int로 형변환이 가능한 것들(byte, short, char, int)
		 * 1.5버전 이후 : enum 추가
		 * 1.7버전 이후 : String
		 * 
		 * switch(수식) {
		 * 	case 값 :
		 * 	처리할일;
		 * 	break;
		 * 
		 * 	case 값 :
		 * 	처리할일;
		 * 	break;
		 * 
		 * 	default:
		 *  처리할일;
		 *}
		 */
	{
		System.out.println("1.4 확인");
		int num = 4;
		int result = 0;
		switch (num) {
		case 1:
			result +=1;
			System.out.print(result);
			break;
		case 2:
			result +=10;
			System.out.print(result);
			break;
		case 3:
			result +=100;
			System.out.print(result);
			
		default:
			result += 10000;
			System.out.print(result);
			
		case 4:
			result += 1000;
			
			break;
			
		}
		System.out.println(result);
	}
		
	{	
		String result = "";
		System.out.println("1.7 string 확인");
		final String season = "summer";
		switch (season) {
		case "spring":
			result ="봄";
			System.out.print(result);
			break;
		case "summer":
			result ="여름";
			System.out.print(result);
			break;
		case "fall":
			result = "가을";
			System.out.print(result);
			

		case "winter":
			result = "겨울";
			break;
			
		default:
			System.out.print("디포트");
		}		
	System.out.println(result);
	}
	
	
	{	
		String result = "";
		System.out.println("1.8 enum 확인");
		Season season = Season.SUMMER;
		
		switch (season) {
		case SPRING:
			result ="봄";
			System.out.print(result);
			break;
		case SUMMER:
			result ="여름";
			System.out.print(result);
			break;
		case FALL:
			result = "가을";
			System.out.print(result);
			

		case WINTER:
			result = "겨울";
			break;
			
		default:
			System.out.print("디포트");
		}	
		

	System.out.println(result);
	}
	
	}
	
	enum Season{
		SPRING, SUMMER, FALL, WINTER
	}	
	
	
}
