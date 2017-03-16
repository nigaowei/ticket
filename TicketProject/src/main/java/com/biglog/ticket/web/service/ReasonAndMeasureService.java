package com.biglog.ticket.web.service;

import com.biglog.ticket.web.model.ReasonAndMeasure;

import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */
public interface ReasonAndMeasureService {

    /**
     * 插入
     * @param reasonAndMeasure
     * @return
     */
    int insert(ReasonAndMeasure reasonAndMeasure);

    /**
     * 获取所有
     * @return
     */
    List<ReasonAndMeasure> get();
}
