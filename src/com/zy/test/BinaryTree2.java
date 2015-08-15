package com.zy.test;

public class BinaryTree2 {
	
	private int maxLen = 0;
	private int max(int a,int b){
		return a>b?a:b;
	}
	public void findMaxDistance(Nodess root){
		if(root==null)
			return;
		if(root.left==null)
			root.leftMaxDistance=0;
		if(root.right==null)
			root.rightMaxDistance=0;
		if(root.left!=null)
			findMaxDistance(root.left);
		if(root.right!=null)
			findMaxDistance(root.right);
		//计算左子树距离根结点的最大距离
		if(root.left!=null)
			root.leftMaxDistance=max(root.left.leftMaxDistance,
					root.left.rightMaxDistance);
		//计算右子树距离根结点的最大距离
		if(root.right!=null)
			root.rightMaxDistance = max(root.right.leftMaxDistance,
					root.right.rightMaxDistance);
		//获取二叉树所有结点的最大距离
		if(root.leftMaxDistance+root.rightMaxDistance>maxLen){
			maxLen=root.leftMaxDistance+root.rightMaxDistance;
		}
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Nodess{
	public int data;
	public Nodess left;
	public Nodess right;
	public int leftMaxDistance;  //左子树距离根结点的最大距离
	public int rightMaxDistance; //右子树距离根结点的最大距离
	public Nodess(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
