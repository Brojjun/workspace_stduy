import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
     
    static int map[][];
    static int bn;
    static boolean[] visit;
    static boolean[] visited;
    static int[] data;
    static int min_data = Integer.MAX_VALUE;
     
 
    public static void main(String[] args) throws IOException {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int T = 1; T <= test; T++) {
            min_data = Integer.MAX_VALUE;
            bn = Integer.parseInt(br.readLine());
            map = new int[bn][bn];
            visit = new boolean[bn];
             
            for(int i = 0; i < bn; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < bn; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                     
                }
            }
             
            makeNum(0,0);
            System.out.println("#"+T+" "+min_data);
        }
         
    }
     
     
    static int score1 = 0;
    private static void makeNum(int cnt, int start) {
        if(cnt == bn/2) {
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
             
            for(int i = 0 ; i < bn; i++) {
                if(visit[i])arr.add(i);
                else arr2.add(i);
            }
             
            visited = new boolean[bn];
            score1 = 0;
            data = new int[bn];
            calScore(arr, 0);
            int aa = score1;
            visited = new boolean[bn];
            score1 = 0;
            data = new int[bn];
            calScore(arr2, 0);
            min_data = Math.min(min_data, Math.abs(aa - score1));
            return;
        }
         
        for(int i = start; i < bn; i++) {
            if(visit[i])continue;
            visit[i] = true;
            makeNum(cnt+1,i+1);
            visit[i] = false;
        }
    }
 
 
 
    private static void calScore(ArrayList<Integer> arr,int cnt) {
        if(cnt == 2) {
            score1 += map[arr.get(data[0])][arr.get(data[1])];
            return;
        }
        for(int i = 0; i < arr.size(); i++) {
            if(visited[i])continue;
            visited[i] = true;
            data[cnt] = i;
            calScore(arr,cnt+1);
            data[cnt] = 0;
            visited[i] = false;
        }
         
    }
}