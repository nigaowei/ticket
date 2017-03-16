package com.biglog.ticket.core.ticket;

import com.biglog.ticket.core.docSim.Doc2Vec;
import com.biglog.ticket.core.tree.Tree;
import com.biglog.ticket.core.tree.TreeNode;
import com.biglog.ticket.web.model.ReasonAndMeasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngw on 2017/3/7.
 * 告警原因与处理措施逻辑匹配
 *
 */

public class ReasonMeasure {



    private static TreeNode root = null;

    private static Tree tree = null;

    private static final int LEN = 4;

    /**
     * 初始化
     * @param reasonAndMeasures
     */

    public static void init(List<ReasonAndMeasure> reasonAndMeasures){

        tree = new Tree();

        List<String[]> templates = new ArrayList<String[]>();

        for(ReasonAndMeasure reasonAndMeasure:reasonAndMeasures){
            String []template  = new String[LEN];

            template[0] = reasonAndMeasure.getReasonClassification();
            template[1] = reasonAndMeasure.getReasonSubdivision();
            template[2] = reasonAndMeasure.getFailureReason();
            template[3] = reasonAndMeasure.getProcessingMeasures();
            templates.add(template);
        }

        root = new TreeNode("").getRoot(tree,templates);

    }
    /**
     * @param ticket
     * @param dt
     * @param index1 原因分类
     * @param index2 原因细分
     * @param index3 故障原因
     * @param index4 处理措施
     * @return
     * -1:不在模板库
     * 0 不合格
     * 1 合格
     */
    private static Doc2Vec doc2Vec = new Doc2Vec();

    public static int check(ArrayList<String> ticket,int index1,int index2,int index3,int index4){

        ArrayList<String> data = new ArrayList<String>();

        data.add(ticket.get(index1));

        data.add(ticket.get(index2));

        data.add(ticket.get(index3));

        String measure = ticket.get(index4);

        ArrayList<TreeNode> treeNodes = tree.classify(root, data);

        if(treeNodes==null)
            return -1;


        double min = Double.MAX_VALUE;

        for(TreeNode treeNode:treeNodes){
            double dis = doc2Vec.getDistance(measure,treeNode.getNodeName());
            if(dis<min)
                min = dis;
        }

        if(min>1.5){
            return 0;
        }

        return 1;





    }

}
