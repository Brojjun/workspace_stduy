import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class boj_2961 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int BN = Integer.parseInt(br.readLine());
		int[] dal = new int[BN];
		int[] sin = new int[BN];
		
		for(int i = 0; i < BN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			dal[i] = Integer.parseInt(st.nextToken());
		}
		
		int greatCook = Integer.MAX_VALUE;
		for(int i = 0; i < (1 << BN) - 1; i++) {
			int sinSum = 1;
			int dalSum = 0;
			for(int j = 0; j < BN; j++) {
				if((i & (1 << j)) != 0) continue;
				sinSum *= sin[j];
				dalSum += dal[j];
			}
			//System.out.println(Math.abs(sinSum - dalSum));
			greatCook = Math.min(greatCook, Math.abs(sinSum - dalSum));
		}
		System.out.println(greatCook);
	}
}
