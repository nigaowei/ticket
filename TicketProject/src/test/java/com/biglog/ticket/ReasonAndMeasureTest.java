package com.biglog.ticket;

import com.biglog.ticket.web.model.ReasonAndMeasure;
import com.biglog.ticket.web.service.ReasonAndMeasureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class ReasonAndMeasureTest {

    @Resource
    private ReasonAndMeasureService reasonAndMeasureService;

    @Test
    public void insertTest(){

        InputStream is = null;

        BufferedReader br = null;

        try{

            is = this.getClass().getResourceAsStream("/reason_measure");

            br = new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));

            String s = null;

            while((s = br.readLine())!=null){
                String ss[] = s.split("\t");

                if(ss.length!=4)
                    continue;
                ReasonAndMeasure reasonAndMeasure = new ReasonAndMeasure(ss[0],ss[1],ss[2],ss[3]);

                reasonAndMeasureService.insert(reasonAndMeasure);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    @Test

    public void getTest(){
        List<ReasonAndMeasure> reasonAndMeasures = reasonAndMeasureService.get();

        System.out.println(reasonAndMeasures.size());
    }
}
