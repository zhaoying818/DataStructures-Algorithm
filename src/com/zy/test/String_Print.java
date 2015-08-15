package com.zy.test;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 按要求打印数组的排列情况
 * 利用无向图
 */
public class String_Print {
	
	
	private int[] numbers = new int[]{1,2,2,3,4,5};
	private int n = numbers.length;
	//用来标记图中的点是否遍历过
	private boolean[] visited = new boolean[n];
	//图的二维数组表示
	private int[][] graph = new int[n][n];
	//数字的组合
	private String combination ="";
	public Set<String> getAllCombinations(){
		//构造图
		buildGraph();
		//用来存放所有的组合
		Set<String> set = new HashSet<String>();
	 	//从不同的结点出发深度优先遍历
		for(int i=0;i<n;i++)
			this.DFS(i, set);
		return set;
		
	}
	
	private void buildGraph(){
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				if(i==j)
					graph[i][j]=0;
				else
					graph[i][j]=1;
			}
		//确保在遍历时3与5不可达
		graph[3][5]=0;
		graph[5][3]=0;		
	}
	
	//对树丛结点start位置开始进行DFS（depth first search）深度优先遍历
	private void DFS(int start,Set<String> set){
		visited[start] = true;
		combination = combination + numbers[start];
		if(combination.length()==n){
			//4不能出现在第三位置
			if(combination.indexOf("4")!=2)
				set.add(combination);
		}
		for(int j=0;j<n;j++){
			if(graph[start][j]==1 && visited[j]==false)
				DFS(j,set);
		}
		combination = combination.substring(0, combination.length()-1);
		visited[start] = false;
	}
	
	
	public static void main(String[] args){
		String_Print st = new String_Print();
		Set<String> set = st.getAllCombinations();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
	}

}
