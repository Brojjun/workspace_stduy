package com.ssafy.live07QTree;

public class Test {

	public static void main(String[] args) {
		int size = 9;
		
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
		
		for(int i = 0; i < size ; i++) {
			tree.add((char)(65+i));
		}
		
		//tree.bfs();
//		tree.dfsByPostorder();
//		tree.dfsByInorder();
		tree.dfsByPreorder();
		tree.dfs();
	}
}
