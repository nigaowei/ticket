package com.biglog.ticket.web.controller;

import com.biglog.ticket.core.ticket.TicketCheck;
import com.biglog.ticket.web.model.AlarmAndReason;
import com.biglog.ticket.web.model.ReasonAndMeasure;
import com.biglog.ticket.web.service.AlarmAndReasonService;
import com.biglog.ticket.web.service.ReasonAndMeasureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ngw on 2016/9/10.
 */
@RestController
@RequestMapping("/test")
public class TicketController {
    private static final String uploadFolderName = "uploadFiles";

    @Resource
    private ReasonAndMeasureService reasonAndMeasureService;
    @Resource

    private AlarmAndReasonService alarmAndReasonService;

    /**
     * 获取上传的Excel工单文件，完成质检，返回质检结果
     * @param file
     * @param session
     * @param request
     * @param response
     * @throws Exception
     */

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public @ResponseBody void fileUpload(@RequestParam("file") CommonsMultipartFile file,
                                         HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
        String curProjectPath = session.getServletContext().getRealPath("/");
        String saveDirectoryPath = curProjectPath + "/" + uploadFolderName+"/"+new Date().getTime()+file.getOriginalFilename();
        //System.out.println(saveDirectoryPath);
        File saveDirectory = new File(saveDirectoryPath);
        if (!file.isEmpty()) {
            file.transferTo(saveDirectory);
        }
        Long t1 = Long.parseLong(request.getParameter("num1"));
        Long t2 = Long.parseLong(request.getParameter("num2"));
        response.setContentType("application/json");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=null;

        List<ReasonAndMeasure> reasonAndMeasures = reasonAndMeasureService.get();

        List<AlarmAndReason> alarmAndReasons = alarmAndReasonService.get();

        String result = TicketCheck.test(saveDirectoryPath,t1,t2,alarmAndReasons,reasonAndMeasures);

        System.out.println(result);

        try {
            out=response.getWriter();
            out.write(result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // return result;

    }

    /**
     * 添加告警与故障原因模板
     * @param alarmAndReason
     * @param request
     * @return
     */

    @RequestMapping(value = "/add_alarmAndReason",method = RequestMethod.POST)

    public ResponseEntity<?> add_alarmAndReason(AlarmAndReason alarmAndReason,HttpServletRequest request){

        System.out.println(alarmAndReason.getAlarmTitle());

        int flog = alarmAndReasonService.insert(alarmAndReason);
        String result = "Add success!";
        if(flog==0)
            result = "Add Failure";
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    /**
     * 添加故障原因与处理措施模板
     * @param reasonAndMeasure
     * @param request
     * @return
     */

    @RequestMapping(value = "/add_reasonAndMeasure",method = RequestMethod.POST)

    public ResponseEntity<?> add_reasonAndMeasure(ReasonAndMeasure reasonAndMeasure,HttpServletRequest request){

        int flog = reasonAndMeasureService.insert(reasonAndMeasure);
        String result = "Add success!";
        if(flog==0)
            result = "Add Failure";
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }



}
