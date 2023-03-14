package com.ssafy.off18Dijxstra;
import java.io.*;
import java.util.*;

public class BJG1낚시왕17143 {
	static class Shark{
		int spd,dir,size;
		public Shark(int spd, int dir, int size) {
			super();

			this.spd = spd;
			this.dir = dir;
			this.size = size;
		}
		@Override
		public String toString() {
			return Integer.toString(size);
		}		
	}
	
	static int by,bx,m,eat=0;
	static Shark[][] map;
	static Shark[][] vmap;
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		by = Integer.parseInt(st.nextToken());
		bx = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[by][bx];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int yy = Integer.parseInt(st.nextToken()) - 1;
			int xx = Integer.parseInt(st.nextToken()) - 1;
			int spd = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[yy][xx] = new Shark(spd,dir-1,size);
		}
		int man = 0;
		//시뮬레이션 시작
		for(int i = 0 ; i < bx; i++) {
			//print();
			fishing(man);//낚시 ㄱㄱ
			//vmap에서 상어들이 이동한 뒤 다시 map에 넣어줌 ( 상어 잘못된 겹침 방지 )
			vmap = new Shark[by][bx];
			moveShark();//상어 이동
			for(int j = 0 ; j < by; j++)map[j] = vmap[j].clone();
			man++;//이동
			
		}
		System.out.println(eat);
	}
	//콘솔에 찍어보기
	private static void print() {
		for(int i = 0 ; i < by; i++) {
			for(int j = 0 ; j < bx; j++) {
				System.out.print(map[i][j] == null ?"0 " : map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//map=>vmap으로 이동
	static private void moveShark() {
		for(int x = 0; x < bx; x++) {
			for(int y = 0 ; y < by; y++) {
				if(map[y][x] == null) continue;
				int ny = y;
				int nx = x;
				int dir = map[y][x].dir;
				int spd = map[y][x].spd;
				int size = map[y][x].size;
				
				if(dir == 1 || dir == 0) {
					//한칸씩 이동해서 1에 도달하면 % size 해주자.
					while(spd > 0 && ny != 0) {
						if(ny == 0 || spd == 0)break;
						spd--;
						ny += dy[dir];
						if(ny < 0 || ny >= by) {
							dir = (dir + 1) % 2;
							ny += (dy[dir]) * 2;
						}
					}
					
					spd = spd % ((by-1)*2);
					while(spd > 0) {
						spd--;
						ny += dy[dir];
						if(ny < 0 || ny >= by) {
							dir = (dir + 1) % 2;
							ny += (dy[dir]) * 2;
						}
					}
					
				}
				
				else if(dir == 3 || dir == 2) {
					//한칸씩 이동해서 1에 도달하면 % size 해주자.
					while(spd > 0 && nx != 0) {
						spd--;
						nx += dx[dir];
						if(nx < 0 || nx >= bx) {
							dir = (dir == 3) ? 2 : 3;
							nx += (dx[dir]) * 2;
						}
					}
					
					spd = spd % ((bx-1)*2);
					while(spd > 0) {
						if(spd == 0)break;
						spd--;
						nx += dx[dir];
						if(nx < 0 || nx >= bx) {
							dir = (dir == 3) ? 2 : 3;
							nx += (dx[dir]) * 2;
						}
					}
				}
				if(vmap[ny][nx] == null)
					vmap[ny][nx] = new Shark(map[y][x].spd, dir, size);
				else {
					if(vmap[ny][nx].size < size) {
						vmap[ny][nx] = null;
						vmap[ny][nx] = new Shark(map[y][x].spd, dir, size);
					}
				}
				map[y][x] = null;
				
			}
		}
	}

	static private void fishing(int man) {
		int ny = 0;
		int x = man;
		for(int i = 0 ; i < by; i++) {
			if(ny >= by)break;
			if(map[ny][x] != null) {
				eat += map[ny][x].size;
				map[ny][x] = null;
				return;
			}
			ny++;
		}
		
	}

}
