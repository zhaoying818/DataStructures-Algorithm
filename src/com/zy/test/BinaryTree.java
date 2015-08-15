package com.zy.test;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	private Node2 root;
	public BinaryTree(){
		root = null;
	}
	
	/**
	 * ��data���뵽�����������
	 * @param data
	 */
	public void insert(int data){
		Node2 newNode = new Node2(data);
		if(root == null){
			root = newNode;
		}
		else{
			Node2 current = root;
			Node2 parent;
			while(true){//Ѱ�Ҳ���λ��
				parent = current;
				if(data<current.data){
					current = current.left;
					if(current==null){
						parent.left = newNode;
						return;
					}
				}else{
					current = current.right;
					if(current==null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * ����ֵ���빹��������
	 */
	public void buildTree(int[] data){
		for(int i=0;i<data.length;i++){
			insert(data[i]);
		}
	}
	
	/**
	 * ������������ݹ�ʵ��
	 */
	public void inOrder(Node2 localRoot){
		if(localRoot!=null){
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}
	public void inOrder(){
		this.inOrder(this.root);
	}
	/**
	 *  ������������ݹ�ʵ��
	 */
	public void preOrder(Node2 localRoot){
		if(localRoot!=null){
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	public void preOrder(){
		this.preOrder(this.root);
	}
	
	/**
	 * ������������ݹ�ʵ��
	 */
	public void postOrder(Node2 localRoot){
		if(localRoot!=null){
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}
	public void postOrder(){
		this.postOrder(this.root);
	}
	
	/**
	 * �������
	 */
	public void layerTranverse(){
		if(this.root==null){
			return;
		}
		Queue<Node2> q = new LinkedList<Node2>();
		q.add(this.root);
		while(!q.isEmpty()){
			Node2 n = q.poll();
			System.out.print(n.data);
			System.out.print(" ");
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
	}
	
	
	
	 /**
	  * ��֪�����������������������
	  */
	public void initTree(int[] preOrder,int[] inOrder){
		this.root = this.initTree(preOrder, 0, preOrder.length-1, 
				inOrder, 0, inOrder.length-1);
	}
	public Node2 initTree(int[] preOrder,int start1,int end1,
			int[] inOrder,int start2,int end2){
		if(start1>end1 || start2>end2){
			return null;
		}
		int rootData = preOrder[start1];
		Node2 head = new Node2(rootData);
		//�ҵ���������ڵ�λ��
		int rootIndex = findIndexInArray(inOrder, rootData, start2, end2);
		int offset = rootIndex -start2 - 1;
		//����������
		Node2 left = initTree(preOrder, start1+1, start1+1+offset, 
				inOrder, start2, start2 + offset);
		//����������
		Node2 right = initTree(preOrder, start1+offset+2, end1, 
				inOrder, rootIndex+1, end2);
		head.left = left;
		head.right = right;
		return head;
	}
	
	public int findIndexInArray(int[] a,int x,int begin,int end){
		for(int i=begin;i<=end;i++){
			if(a[i]==x)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};
		bt.buildTree(data);
		System.out.print("�������������:");
		bt.inOrder();
		System.out.println();
		System.out.print("�������������:");
		bt.preOrder();
		System.out.println();
		System.out.print("�������������:");
		bt.postOrder();
		System.out.println();
		System.out.print("�������������:");
		bt.layerTranverse();
		System.out.println();
		
//		int[] preOrder = {1,2,4,8,9,5,10,3,6,7};
//		int[] inOrder = {8,4,9,2,10,5,1,6,3,7};
//		bt.initTree(preOrder, inOrder);
//		System.out.print("�������������:");
//		bt.postOrder();

	}

}

class Node2{
	public int data;
	public Node2 left;
	public Node2 right;
	public Node2(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}