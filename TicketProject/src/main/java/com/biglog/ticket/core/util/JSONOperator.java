package com.biglog.ticket.core.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * 将质检结果转化成JSON格式String
 * Created by ngw on 2016/9/10.
 */
public class JSONOperator {
    /**
     * 将质检结果转化为JSON格式返回
     * @param result
     * @return
     */
    public String  getJSONString(ArrayList<ArrayList<ArrayList<String>>> result){
        JSONArray jsonArray=new JSONArray();

        jsonArray.add(getJSON1(result.get(0).get(0)));
        jsonArray.add(getJOSN2(result.get(1)));

        jsonArray.add(getJOSN3(result.get(2)));

        jsonArray.add(getJOSN2(result.get(3)));

        jsonArray.add(getJOSN3(result.get(4)));



        return jsonArray.toJSONString();
    }

    /**工单总数，异常数据（未处理的工单），不合格工单数，合格工单数，高风险工单数
     *
     @param count
     * @return
     */
    private JSONArray getJSON1(ArrayList<String> count){
        int num0=Integer.parseInt(count.get(0));
        int num1=Integer.parseInt(count.get(1));
        int num2=Integer.parseInt(count.get(2));
        int num3=Integer.parseInt(count.get(3));
        int num4=Integer.parseInt(count.get(4));

        JSONArray jsonArray=new JSONArray();
        JSONObject obj1=new JSONObject();
        obj1.put("table","总数");
        obj1.put("num",num0);
        JSONObject obj2=new JSONObject();
        obj2.put("table","异常数据");
        obj2.put("num",num1);
        JSONObject obj3=new JSONObject();
        obj3.put("table","不合格");
        obj3.put("num",num2);
        JSONObject obj4=new JSONObject();
        obj4.put("table","合格");
        obj4.put("num",num3);
        JSONObject obj5=new JSONObject();
        obj5.put("table","高风险");
        obj5.put("num", num4);
        jsonArray.add(obj1);
        jsonArray.add(obj2);
        jsonArray.add(obj3);
        jsonArray.add(obj4);
        jsonArray.add(obj5);
        return jsonArray;
    }

    /**
     * 告警与故障原因不匹配工单
     * @param tickets
     * @return
     */

    private JSONArray getJOSN2(ArrayList<ArrayList<String>> tickets){
        JSONArray jsonArray=new JSONArray();
        for(ArrayList<String> ticket:tickets){
            JSONObject obj=new JSONObject();

            obj.put("ticketNum",ticket.get(0));

            obj.put("alarmTitle",ticket.get(1));

            obj.put("reasonClassification",ticket.get(2));

            obj.put("reasonSubdivision",ticket.get(3));

            obj.put("failureReason",ticket.get(4));

            jsonArray.add(obj);
        }
        return jsonArray;
    }

    /**
     * 故障原因与处理措施不匹配工单
     * @param tickets
     * @return
     */
    private JSONArray getJOSN3(ArrayList<ArrayList<String>> tickets){
        JSONArray jsonArray=new JSONArray();
        for(ArrayList<String> ticket:tickets){
            JSONObject obj=new JSONObject();

            obj.put("ticketNum",ticket.get(0));

            obj.put("reasonClassification",ticket.get(1));

            obj.put("reasonSubdivision",ticket.get(2));

            obj.put("failureReason",ticket.get(3));

            obj.put("processingMeasures",ticket.get(4));

            jsonArray.add(obj);
        }
        return jsonArray;
    }
}
