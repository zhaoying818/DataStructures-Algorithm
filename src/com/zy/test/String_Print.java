package com.zy.test;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ��Ҫ���ӡ������������
 * ��������ͼ
 */
public class String_Print {
	
	
	private int[] numbers = new int[]{1,2,2,3,4,5};
	private int n = numbers.length;
	//�������ͼ�еĵ��Ƿ������
	private boolean[] visited = new boolean[n];
	//ͼ�Ķ�ά�����ʾ
	private int[][] graph = new int[n][n];
	//���ֵ����
	private String combination ="";
	public Set<String> getAllCombinations(){
		//����ͼ
		buildGraph();
		//����������е����
		Set<String> set = new HashSet<String>();
	 	//�Ӳ�ͬ�Ľ�����������ȱ���
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
		//ȷ���ڱ���ʱ3��5���ɴ�
		graph[3][5]=0;
		graph[5][3]=0;		
	}
	
	//�����Խ��startλ�ÿ�ʼ����DFS��depth first search��������ȱ���
	private void DFS(int start,Set<String> set){
		visited[start] = true;
		combination = combination + numbers[start];
		if(combination.length()==n){
			//4���ܳ����ڵ���λ��
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
