package com.biglog.ticket.core.tree;

import java.util.ArrayList;


public class Tree {

	/**
	 * 构建树
	 * @param root
	 * @param nodeNames
	 * @return
	 */
	public TreeNode buildTree(TreeNode root,String[] nodeNames){
		
		TreeNode tn = root;
		
		for(String nodeName:nodeNames){
			
			TreeNode node = new TreeNode(nodeName);
			
			ArrayList<TreeNode> childrenNodes = tn.getChildrenNodes();
			
			if(childrenNodes.contains(node)){
				tn = TreeNode.getNode(childrenNodes, nodeName);
				continue;
				
			}
			else{
				childrenNodes.add(node);
			}
			tn = TreeNode.getNode(childrenNodes, nodeName);
		}
		return root;
	}

	/**
	 * 给出故障原因 可以得到告警列表或处理措施列表
	 * @param root
	 * @param nodeNames
	 * @return
	 */
	public ArrayList<TreeNode> classify(TreeNode root,ArrayList<String> nodeNames){
		for(String nodeName:nodeNames){
			TreeNode node = TreeNode.getNode(root.getChildrenNodes(), nodeName);
			if(node==null){
				return null;
			}
			root = node;
		}
		ArrayList<TreeNode> childrenNodes = root.getChildrenNodes();
		
		return  childrenNodes;
	}


}
