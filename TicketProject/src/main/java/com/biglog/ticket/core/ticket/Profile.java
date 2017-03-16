package com.biglog.ticket.core.ticket;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 工单字段配置文件
 * Created by ngw on 2017/1/16.
 */
public class Profile{

    private static Properties pro = null;

    private static final String configPath = "/field.properties";//配置文件路径

    /**
     * 配置文件信息初始化
     * @return
     */
    public static Properties init(){

        pro = new Properties();

        try {

            pro.load(new InputStreamReader(Profile.class.getResourceAsStream(configPath), "UTF-8"));

        }catch (Exception e){

            e.printStackTrace();
        }

        return pro;
    }


}
