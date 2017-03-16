package com.biglog.ticket.web.dao;

import com.biglog.ticket.web.model.AlarmAndReason;
import com.biglog.ticket.web.model.ReasonAndMeasure;


import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */
public interface AlarmAndReasonMapper {

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
