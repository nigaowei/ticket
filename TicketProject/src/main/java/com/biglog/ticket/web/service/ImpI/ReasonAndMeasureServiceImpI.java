package com.biglog.ticket.web.service.ImpI;

import com.biglog.ticket.web.dao.ReasonAndMeasureMapper;
import com.biglog.ticket.web.model.ReasonAndMeasure;
import com.biglog.ticket.web.service.ReasonAndMeasureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */

@Service
public class ReasonAndMeasureServiceImpI implements ReasonAndMeasureService {

    @Resource
    private ReasonAndMeasureMapper reasonAndMeasureMapper;
    /**
     * 获取所有
     *
     * @return
     */
    @Override
    public List<ReasonAndMeasure> get() {
        return reasonAndMeasureMapper.get();
    }

    /**
     * 插入
     *
     * @param reasonAndMeasure
     * @return
     */
    @Override
    public int insert(ReasonAndMeasure reasonAndMeasure) {
        return reasonAndMeasureMapper.insert(reasonAndMeasure);
    }
}
