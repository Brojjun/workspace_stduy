package com.ssafy.off16;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
     
    public class SWEA서로소집합3289 {
        static int[] number;
        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringBuffer sb = new StringBuffer();
             
            int T = Integer.parseInt(br.readLine());
            for(int t = 1; t <= T; t++) {
                int ht[] = new int[2];
                sb.append("#" + t + " ");
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                make(N);
                for(int i = 0 ; i < M; i++) {
                    st = new StringTokenizer(br.readLine());
                    ht[0] = Integer.parseInt(st.nextToken());
                    ht[1] = Integer.parseInt(st.nextToken());
                    union(ht[0],ht[1]);
 
                }
                 
                HashSet<Integer> set = new HashSet<>(); 
                for(int i = 1 ; i <= N; i++) {
                    set.add(find(number[i]));
                }
                sb.append(set.size() + "\n");
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
             
        }
        private static void union(int head, int tail) {
            int rootHead = find(head);
            int rootTail = find(tail);
            if(rootHead == rootTail)return;
             
            number[rootTail] = rootHead;
        }
        private static int find(int data) {
            if(data == number[data])return data;
            return number[data] = find(number[data]);
     
        }
        private static void make(int n) {
            number = new int[n+1];
            for(int i = 0 ; i <= n ; i++)number[i] = i;
        }
     
         
    }