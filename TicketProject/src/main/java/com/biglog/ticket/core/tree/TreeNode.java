package com.biglog.ticket.core.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树类
 */
public class TreeNode {
	
	private String nodeName;//节点名称
	
	private ArrayList<TreeNode> childrenNodes;//孩子节点
	
	public TreeNode(String nodeName){
		
		this.nodeName = nodeName;
		
		this.childrenNodes = new ArrayList<TreeNode>();
	}
	public static TreeNode getNode(ArrayList<TreeNode> childrenNodes,String nodeName){
		
		for(TreeNode node:childrenNodes){
			if(node.getNodeName().equals(nodeName))
				return node;
		}
		return null;
	}
	public static TreeNode getRoot(Tree tree,List<String[]> templates){
		TreeNode root = new TreeNode("");

		for(String[] template:templates){
			root = tree.buildTree(root,template);
		}
		return root;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public ArrayList<TreeNode> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(ArrayList<TreeNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode node = (TreeNode) o; 
        return nodeName.equals(node.nodeName);
	}
	
	
}
