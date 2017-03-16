package com.biglog.ticket.core.ticket;


import com.biglog.ticket.core.tree.Tree;
import com.biglog.ticket.core.tree.TreeNode;
import com.biglog.ticket.web.model.AlarmAndReason;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ngw on 2017/3/7.
 * 告警与故障原因逻辑匹配
 */
public class AlarmReason {



    private static Tree tree = new Tree();
    private static TreeNode root = null;

    private static final int LEN = 4;

    public static void init(List<AlarmAndReason> alarmAndReasons){

        List<String[]> templates = new ArrayList<String[]>();

        for(AlarmAndReason alarmAndReason : alarmAndReasons){

            String [] template  = new String[LEN];

            template[3] = alarmAndReason.getAlarmTitle();
            template[0] = alarmAndReason.getReasonClassification();
            template[1] = alarmAndReason.getReasonSubdivision();
            template[2] = alarmAndReason.getFailureReason();

            templates.add(template);
        }

        root = new TreeNode("").getRoot(tree,templates);

    }

    /**
     *
     * @param ticket 工单数据
     * @param index1 原因分类
     * @param index2 原因细分
     * @param index3 故障原因
     * @param index4 告警标题
     * @return
     * -1: 不存在该模板
     * 0：不合格
     * 1：合格
     */
    public static int check(ArrayList<String> ticket,int index1,int index2,int index3,int index4){

        ArrayList<String> data = new ArrayList<String>();

        data.add(ticket.get(index1));

        data.add(ticket.get(index2));

        data.add(ticket.get(index3));

        String alarm = ticket.get(index4);

        ArrayList<TreeNode> treeNodes = tree.classify(root, data);




        if(treeNodes == null){
            return -1;
        }


        for(TreeNode node:treeNodes){
            if(node.getNodeName().equals(alarm))
                return 1;
        }


        return 0;




    }
}
