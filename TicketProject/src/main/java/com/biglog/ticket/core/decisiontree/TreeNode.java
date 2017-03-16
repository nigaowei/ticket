package com.biglog.ticket.core.decisiontree;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private static String ENCODE = "UTF-8";
    private static String SPLIT = "\t";//文本拆分
    private String nodeName; // 决策树节点名称
    private List<String> splitAttributes; // 分裂属性名
    private ArrayList<TreeNode> childrenNodes; //决策树的子节点
    private ArrayList<ArrayList<String>> dataSet; //划分到该节点的数据集
    private ArrayList<String> attributeSet; //数据集所有属性


    public TreeNode() {
        childrenNodes = new ArrayList<TreeNode>();
    }

    public static TreeNode getRoot(DecisionTree dt, ArrayList<String> attributeList, String filePath) {
        File f = new File(filePath);
        //InputStreamReader isr=null;



        InputStream is = null;

        BufferedReader reader = null;
        TreeNode root = null;
        try {
            //isr = new InputStreamReader(new FileInputStream(f), ENCODE);
            is = TreeNode.class.getClass().getResourceAsStream(filePath);
            reader = new BufferedReader(new InputStreamReader(is, Charset.forName(ENCODE)));
            String str = null;
            ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();
            while ((str = reader.readLine()) != null) {
                ArrayList<String> tmpList = new ArrayList<String>();
                String[] s = str.split(SPLIT);
                for (int i = 0; i < s.length; i++) {
                    tmpList.add(s[i]);
                }
                dataSet.add(tmpList);
            }
            root = dt.buildTree(dataSet, attributeList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return root;


    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<String> getSplitAttributes() {
        return splitAttributes;
    }

    public void setSplitAttributes(List<String> splitAttributes) {
        this.splitAttributes = splitAttributes;
    }

    public ArrayList<TreeNode> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(ArrayList<TreeNode> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    public ArrayList<ArrayList<String>> getDataSet() {
        return dataSet;
    }

    public void setDataSet(ArrayList<ArrayList<String>> dataSet) {
        this.dataSet = dataSet;
    }

    public ArrayList<String> getAttributeSet() {
        return attributeSet;
    }

    public void setAttributeSet(ArrayList<String> attributeSet) {
        this.attributeSet = attributeSet;
    }
}
