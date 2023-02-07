import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class People{
	int status;
	int at;
	public People(int status, int at) {
		super();
		this.status = status;
		this.at = at;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		//input
		String[] imm = br.readLine().split(" ");
		int[] map = new int[imm.length+1];
		
		for(int i = 0; i < imm.length; i++) map[i+1] = Integer.parseInt(imm[i]);
		

		int BN = Integer.parseInt(br.readLine());
		List <People> peoples = new ArrayList<>();
		
		for(int i = 0; i < BN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sta = Integer.parseInt(st.nextToken());
			int at = Integer.parseInt(st.nextToken());
			peoples.add(new People(sta,at));
		}
		
		for(int at = 0; at < peoples.size(); at++) {
			int zender = peoples.get(at).status;
			int button = peoples.get(at).at;
			
			//남자
			if(zender == 1) {
				for(int click = button; click < map.length; click += button) {
					map[click] = (map[click] + 1) % 2;
				}
			}
			
			//여자
			else if(zender == 2) {
				int arrange = 1;
				int saveArrange = 0;
				//range 구하기
				while(button - arrange > 0 && button + arrange < map.length) {
					if(map[button - arrange] == map[button + arrange]) {
						saveArrange = arrange;
						arrange++;
					}
					else break;
				}
				//스위치 켜기
				for(int click = button - saveArrange; click <= button + saveArrange; click++) {
					map[click] = (map[click] + 1) % 2;
				}
			}
			
		}
		//출력
		for(int i = 1; i < map.length; i++) {
			System.out.print(map[i] + " ");
			if(i%20 == 0) System.out.println();
		}

	}
	
		
}
