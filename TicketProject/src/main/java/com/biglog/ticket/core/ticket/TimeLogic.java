package com.biglog.ticket.core.ticket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 时间逻辑一致性判断
 * Created by ngw on 2017/1/16.
 */
public class TimeLogic {


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    /**
     * 回单时间小于告警清除时间,返回false；时间格式不正确，返回false
     * @param ticket 工单数据
     * @param field1 回单时间
     * @param field2 告警清除时间
     * @return
     */
    public static boolean time1(ArrayList<String> ticket, int field1,int field2){

        boolean flog = true;

        try{

            Date date1 = sdf.parse(ticket.get(field1));

            Date date2 = sdf.parse(ticket.get(field2));

            if(date1.getTime()<date2.getTime())

                flog = false;

        }catch (Exception e){

            /**
             * 时间解析异常
             */
            flog = false;
        }

        return flog;
    }

    /**
     * 判断是否满足原因不明
     * @param ticket 工单数据
     * @param field1 告警清除时间
     * @param field2 告警发生时间
     * @param field3 告警原因
     * @param t      告警原因为‘原因不明’时间间隔
     */

    public static boolean time2(ArrayList<String> ticket,int field1,int field2,int field3,Long t){

        boolean flog = true;

        try{

            Date date1 = sdf.parse(ticket.get(field1));

            Date date2 = sdf.parse(ticket.get(field2));

            Long diff = date1.getTime()-date2.getTime();

            Long tmp = diff/(1000*3600*24);

            if( tmp > t && ticket.get(field3).equals("原因不明") )

                flog = false;



        }catch (Exception e){

            flog = false;
        }

        return flog;


    }
    /**
     * 判断是否满足闪断告警
     * @param ticket 工单数据
     * @param field1 告警清除时间
     * @param field2 告警发生时间
     * @param field3 告警原因
     * @param t      告警原因为‘闪断告警’时间间隔
     */
    public static boolean time3(ArrayList<String> ticket,int field1,int field2,int field3,Long t){

        boolean flog = true;

        try{

            Date date1 = sdf.parse(ticket.get(field1));

            Date date2 = sdf.parse(ticket.get(field2));

            Long diff = date1.getTime()-date2.getTime();

            Long tmp = diff/(1000*60);

            if( tmp > t && ticket.get(field3).equals("闪断告警") )

                flog = false;



        }catch (Exception e){

            flog = false;
        }

        return flog;


    }

    /**
     *判断告警清除时间和故障消除时间是否一致
     * @param ticket 工单数据
     * @param field1 告警清除时间
     * @param field2 故障消除事件
     * @param t  时间间隔
     * @return
     */
    public static boolean time4(ArrayList<String> ticket,int field1,int field2,Long t){

        boolean flog = true;

        try{

            Date date1 = sdf.parse(ticket.get(field1));

            Date date2 = sdf.parse(ticket.get(field2));

            Long diff = date1.getTime()-date2.getTime();

            Long tmp = diff/(1000*60);

            if(Math.abs(tmp)>t)

                flog = false;

        }catch (Exception e){

           flog = false;
        }

        return flog;

    }

    /**
     * 判断T2完成时间是否超过处理时限并未延期申请
     * @param ticket 工单数据
     * @param field1 操作时间（T2处理：处理完成）
     * @param field2 处理时限(移交T2处理)
     * @param field3 是否延期申请
     * @return
     */
    public static boolean time5(ArrayList<String> ticket,int field1,int field2,int field3){

        boolean flog = true;

        try{

            Date date1 = sdf.parse(ticket.get(field1));

            Date date2 = sdf.parse(ticket.get(field2));

            Long diff = date1.getTime()-date2.getTime();

            if(diff > 0 && ticket.get(field3).equals("否"))

                flog = false;

        }catch (Exception e){

            flog = false;
        }

        return flog;

    }

}
