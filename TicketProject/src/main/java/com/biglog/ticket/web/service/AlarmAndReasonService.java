package com.biglog.ticket.web.service;

import com.biglog.ticket.web.model.AlarmAndReason;


import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */
public interface AlarmAndReasonService {


    /**
     * 插入
     * @param alarmAndReason
     * @return
     */
    int insert(AlarmAndReason alarmAndReason);

    /**
     * 获取所有
     * @return
     */
    List<AlarmAndReason> get();
}
