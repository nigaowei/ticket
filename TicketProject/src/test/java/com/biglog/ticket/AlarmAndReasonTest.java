package com.biglog.ticket;

import com.biglog.ticket.web.model.AlarmAndReason;
import com.biglog.ticket.web.model.ReasonAndMeasure;
import com.biglog.ticket.web.service.AlarmAndReasonService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class AlarmAndReasonTest {

    @Resource
    private AlarmAndReasonService alarmAndReasonService;

    @Test
    public void insertTest() {

        InputStream is = null;

        BufferedReader br = null;

        try{

            is = this.getClass().getResourceAsStream("/alarm_reason");

            br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            String s = null;

            while((s = br.readLine())!=null){
                String ss[] = s.split("\t");

                if(ss.length!=4)
                    continue;
               AlarmAndReason alarmAndReason = new AlarmAndReason(ss[3],ss[0],ss[1],ss[2]);

                alarmAndReasonService.insert(alarmAndReason);
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
        List<AlarmAndReason> alarmAndReasons = alarmAndReasonService.get();

        System.out.println(alarmAndReasons.size());
    }
}
