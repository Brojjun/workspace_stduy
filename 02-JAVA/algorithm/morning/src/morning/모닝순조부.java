package morning;

import java.util.Arrays;
import java.util.Scanner;

public class 아침순조부 {
    static int N, R;
    static int[] numbers, input;
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        
        input = new int[N];
        numbers = new int[R];
        visited = new boolean[N];
        int[] selected = new int[N];
        
        for (int i = 0; i < N; i++) input[i] = sc.nextInt();
        
        Arrays.fill(selected, 1);
        for (int i = 0; i < N - R; i++) selected[i] = 0;
        
        System.out.println("-----순열-----");
        perm(0);
        System.out.println("-----순열-비트----");
        perm(0, 0);
        System.out.println("-----조합----");
        comb(0, 0);
        System.out.println("-----부분집합 비트----");
        subSet();
        System.out.println("-----부분집합 재귀----");
        subSet(0);
        
        System.out.println("------------");
        Arrays.sort(input);
        do {
            System.out.println(Arrays.toString(input));
        }while (np(input));
        
        System.out.println("------------");
        Arrays.sort(input);
        do {
            for (int i = 0; i < N; i++) {
                if (selected[i] == 0) continue;
                System.out.print(input[i] + " ");
            }
            System.out.println();
        }while (np(selected));
        
        
    }

    private static boolean np(int[] input) {
        int n = input.length;
        
        int i = n - 1;
        while (i > 0 && input[i - 1] >= input[i]) i--;
        if (i == 0) return false;
        
        int j = n - 1;
        while(input[i - 1] >= input[j]) j--;
        
        swap(input, i - 1, j);
        
        int k = n - 1;
        while(i < k) {
            swap(input, i++, k--);
        }
        
        return true;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private static void subSet(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) continue;
                System.out.print(input[i] + " ");
            }
            System.out.println();
            return;
        }
        visited[cnt] = true;
        subSet(cnt + 1);
        visited[cnt] = false;
        subSet(cnt + 1);

    }

    private static void subSet() {
        for (int i = 0; i < (1<<N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == 0) continue;
                System.out.print(input[j] + " ");
            }
            System.out.println();
        }
    }

    private static void comb(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = start; i < N; i++) {
            numbers[cnt] = input[i];
            comb(cnt + 1, i + 1);
        }
        
    }

    private static void perm(int cnt, int flag) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) != 0) continue;
            numbers[cnt] = input[i];
            perm(cnt + 1, flag | (1 << i));
        }        
    }

    private static void perm(int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = input[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}