package com.biglog.ticket.core.ticket;

import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * 文件读取
 * Created by ngw on 2017/1/16.
 */
public class FileReader {


    private static InputStream is = null;

    private static Workbook wk = null;

    private static Sheet sheet = null;


    /**
     * 初始化
     */
    public static void init(String filePath){


        try{

            is=new FileInputStream(filePath);

            wk=Workbook.getWorkbook(is);

            sheet=wk.getSheet(0);


        }catch (Exception e){

            e.printStackTrace();

        }


    }

    /**
     * 读取excel中的工单信息
     */
    public static ArrayList<ArrayList<String>> xlsReader(){



        int rows = sheet.getRows();

        int columns = sheet.getColumns();

        ArrayList<ArrayList<String>> tickets = new ArrayList<ArrayList<String>>();

        int num = 0;

        while(num<rows){

            ArrayList<String> ticket = new ArrayList<String>();

            for(int i=0;i<columns;i++)

                ticket.add(sheet.getCell(i,num).getContents());

            tickets.add(ticket);

            num++;
        }


        return tickets;


    }






}
