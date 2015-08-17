package com.zy.test;

import java.util.Arrays;
import java.util.Vector;

public class TireTree {
	
	class TireNode{
		Vector<String> bwords = new Vector<String>();
		TireNode next[] = new TireNode[26];
		TireNode(){
			for(int i=0;i<26;i++)
				next[i] = null;
		}
	}
	int cmpChar(char c1,char c2){
		return (c1-c2);
	}
	void insertNode(TireNode root,String wd){
		if(wd.length()==0){
			return;
		}
		if(root==null){
			root=new TireNode();
		}
		int i=0;
		char swd[] = wd.toCharArray();
		Arrays.sort(swd);
		TireNode next = root;
		while(i<wd.length()){
			if(next.next[swd[i]-'a']==null){
				TireNode nn = new TireNode();
				next.next[swd[i]-'a'] = nn;
			}
			next = next.next[swd[i]-'a'];
			i++;
		}
		next.bwords.add(wd);
	}
	boolean searchNode(TireNode root,String wd){
		int i=0;
		char swd[] = wd.toCharArray();
		Arrays.sort(swd);
		while(i<wd.length()){
			if(root.next[swd[i]-'a']!=null){
				root = root.next[swd[i]-'a'];
				i++;
			}
			else{
				break;
			}
		}
		if(i==wd.length()){
			for(int j=0;j<root.bwords.size();j++){
				System.out.print(root.bwords.get(j) +" ");
			}
			System.out.println();
			return true;
		}
		return false;
	}
	
	public void findBrother(){
		TireNode root = new TireNode();
		insertNode(root, "hehao");
		insertNode(root, "ehaoh");
		insertNode(root, "haohe");
		insertNode(root, "aoheh");
		insertNode(root, "facri");
		insertNode(root, "et");
		insertNode(root, "oheha");
		insertNode(root, "hehe");
		insertNode(root, "eheh");
		searchNode(root, "oheha");
//		System.out.println();
		searchNode(root, "hehe");
	}
	
	public static void main(String[] args) {

		new TireTree().findBrother();
	}

}
