package com.biglog.ticket.core.ticket;

import com.biglog.ticket.core.util.JSONOperator;
import com.biglog.ticket.web.model.AlarmAndReason;
import com.biglog.ticket.web.model.ReasonAndMeasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 工单质检主函数
 * Created by ngw on 2017/1/16.
 */
public class TicketCheck {

    private static final String field0 = "工单流水号";

    private static final String field1 = "告警标题";

    private static final String field2 = "操作时间（T2处理：处理完成）";

    private static final String field3 = "处理时限（移交T2处理）";

    private static final String field4 = "故障处理结果";

    private static final String field5 = "处理措施";

    private static final String field6 = "原因分类";

    private static final String field7 = "原因细分";

    private static final String field8 = "故障原因";

    private static final String field9 = "告警清除时间";

    private static final String field10 = "告警发生时间";

    private static final String field11 = "质检人员";

    private static final String field12 = "质检结果";

    private static final String field13 = "质检内容";

    private static final String field14 = "是否延期申请";

    private static final String field15 = "故障消除时间";

    private static final String field16 = "是否有告警清除时间回单";





    public static ArrayList<ArrayList<ArrayList<String>>> check(String filePath,Long t1,Long t2,List<AlarmAndReason> alarmAndReasons,List<ReasonAndMeasure> reasonAndMeasures){

        FileReader.init(filePath);

        ArrayList<ArrayList<String>> tickets = FileReader.xlsReader();//读取工单文件

        Properties pro = Profile.init();//读取配置文件

        AlarmReason.init(alarmAndReasons);//初始化告警与故障原因质检

        ReasonMeasure.init(reasonAndMeasures);//初始化故障原因与处理措施质检

        int index0 = Integer.parseInt(pro.getProperty(field0));

        int index1 = Integer.parseInt(pro.getProperty(field1));

        int index2 = Integer.parseInt(pro.getProperty(field2));

        int index3 = Integer.parseInt(pro.getProperty(field3));

        int index4 = Integer.parseInt(pro.getProperty(field4));

        int index5 = Integer.parseInt(pro.getProperty(field5));

        int index6 = Integer.parseInt(pro.getProperty(field6));

        int index7 = Integer.parseInt(pro.getProperty(field7));

        int index8 = Integer.parseInt(pro.getProperty(field8));

        int index9 = Integer.parseInt(pro.getProperty(field9));

        int index10 = Integer.parseInt(pro.getProperty(field10));

        int index11 = Integer.parseInt(pro.getProperty(field11));

        int index12 = Integer.parseInt(pro.getProperty(field12));

        int index13 = Integer.parseInt(pro.getProperty(field13));

        int index14 = Integer.parseInt(pro.getProperty(field14));

        int index15 = Integer.parseInt(pro.getProperty(field15));

        int index16 = Integer.parseInt(pro.getProperty(field16));

        ArrayList<ArrayList<ArrayList<String>>> al = new ArrayList<ArrayList<ArrayList<String>>>();//质检结果

        ArrayList<ArrayList<String>> al0 = new ArrayList<ArrayList<String>>();//统计

        ArrayList<ArrayList<String>> al1 = new ArrayList<ArrayList<String>>();//模板不存在

        ArrayList<ArrayList<String>> al2 = new ArrayList<ArrayList<String>>();//模板不存在

        ArrayList<ArrayList<String>> al3 = new ArrayList<ArrayList<String>>();//告警与故障原因不匹配

        ArrayList<ArrayList<String>> al4= new ArrayList<ArrayList<String>>();//故障原因与处理措施不匹配

        int sum0 = tickets.size();
        int sum1 = 0;//数据异常
        int sum2 = 0;//不合格工单
        int sum3 = 0;//合格工单
        int sum4 = 0;//高风险工单





        



        for(ArrayList<String> ticket:tickets){

            if(ticket.get(index16).equals("其他")){

                sum1++;
                continue;

            }

            int res = AlarmReason.check(ticket,index6,index7,index8,index1);//质检告警与故障原因是否逻辑匹配

            if(res == -1){

                ArrayList<String> r = new ArrayList<String>();

                r.add(ticket.get(index0));
                r.add(ticket.get(index1));
                r.add(ticket.get(index6));
                r.add(ticket.get(index7));
                r.add(ticket.get(index8));
                al1.add(r);
                sum4++;
                continue;
            }else if(res == 0){
                ArrayList<String> r = new ArrayList<String>();
                r.add(ticket.get(index0));
                r.add(ticket.get(index1));
                r.add(ticket.get(index6));
                r.add(ticket.get(index7));
                r.add(ticket.get(index8));
                al3.add(r);
                sum2++;

                continue;
            }
            res = ReasonMeasure.check(ticket,index6,index7,index8,index5);//质检故障原因与处理措施是否逻辑匹配

            if(res == -1){

                ArrayList<String> r = new ArrayList<String>();
                r.add(ticket.get(index0));
                r.add(ticket.get(index6));
                r.add(ticket.get(index7));
                r.add(ticket.get(index8));
                r.add(ticket.get(index5));
                al2.add(r);
                al2.add(ticket);
                sum4++;
                continue;
            }else if(res == 0){
                ArrayList<String> r = new ArrayList<String>();
                r.add(ticket.get(index0));
                r.add(ticket.get(index6));
                r.add(ticket.get(index7));
                r.add(ticket.get(index8));
                r.add(ticket.get(index5));
                al4.add(r);
                sum2++;
                continue;
            }

            sum3++;




//            /**
//             * 回单时小于故障清除时间
//             */
//            if(!TimeLogic.time1(ticket,Integer.parseInt(pro.getProperty(field2)),Integer.parseInt(pro.getProperty(field15)))){
//
//                result += "回单时间小于故障消除时间；";
//
//                flog = false;
//            }
//
//            /**
//             *判断是否满足原因不明
//             */
//            if(!TimeLogic.time2(ticket,Integer.parseInt(pro.getProperty(field9)),Integer.parseInt(pro.getProperty(field10)),Integer.parseInt(pro.getProperty(field8)),t1)){
//
//                result += "告警历时太长，重新查询告警原因；";
//
//                flog = false;
//            }
//            /**
//             *判断是否满足闪断告警
//             */
//
//            if(!TimeLogic.time3(ticket, Integer.parseInt(pro.getProperty(field9)), Integer.parseInt(pro.getProperty(field10)), Integer.parseInt(pro.getProperty(field8)), t2)){
//
//                result += "告警历时太长，不符合闪断告警；";
//
//                flog = false;
//            }
//            /**
//             * 判断告警清除时间和故障消除时间是否一致
//             */
//            if(!TimeLogic.time4(ticket,Integer.parseInt(pro.getProperty(field9)),Integer.parseInt(pro.getProperty(field15)),t3)){
//
//                result += "告警清除时间和故障消除时间前后不一致；";
//
//                flog = false;
//            }
//
//            /**
//             * 判断T2完成时间是否超过处理时限并未延期申请
//             */


//            if(!TimeLogic.time5(ticket,Integer.parseInt(pro.getProperty(field2)),Integer.getInteger(pro.getProperty(field3)),Integer.parseInt(pro.getProperty(field14)))){
//
//                result += "T2超出处理时限";
//
//                flog = false;
//            }

//            System.out.println(result);
//            ticket.add(Integer.parseInt(pro.getProperty(field11)),"系统");
//
//            if(flog){
//
//                ticket.add(Integer.parseInt(pro.getProperty(field12)),"合格");
//
//                ticket.add(Integer.parseInt(pro.getProperty(field13)),"质检合格");
//
//            } else{
//
//                ticket.add(Integer.parseInt(pro.getProperty(field12)),"不合格");
//
//                ticket.add(Integer.parseInt(pro.getProperty(field13)),result);
//            }






        }
        ArrayList<String> r = new ArrayList<String>();

        r.add(sum0+"");
        r.add(sum1+"");
        r.add(sum2+"");
        r.add(sum3+"");
        r.add(sum4+"");

        al0.add(r);

        al.add(al0);

        al.add(al1);
        al.add(al2);
        al.add(al3);
        al.add(al4);

        return al;





    }

    public static String test(String filePath,Long t1,long t2,List<AlarmAndReason> alarmAndReasons,List<ReasonAndMeasure> reasonAndMeasures){

        ArrayList<ArrayList<ArrayList<String>>> res = check(filePath,t1,t2,alarmAndReasons,reasonAndMeasures);

       return new JSONOperator().getJSONString(res);


    }






}
