package com.biglog.ticket.web.service.ImpI;

import com.biglog.ticket.web.dao.AlarmAndReasonMapper;
import com.biglog.ticket.web.model.AlarmAndReason;
import com.biglog.ticket.web.service.AlarmAndReasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ngw on 2017/3/13.
 */
@Service
public class AlarmAndReasonServiceImpI implements AlarmAndReasonService{

    @Resource
    private AlarmAndReasonMapper alarmAndReasonMapper;
    /**
     * 获取所有
     *
     * @return
     */
    @Override
    public List<AlarmAndReason> get() {
        return alarmAndReasonMapper.get();
    }

    /**
     * 插入
     *
     * @param alarmAndReason
     * @return
     */
    @Override
    public int insert(AlarmAndReason alarmAndReason) {
        return alarmAndReasonMapper.insert(alarmAndReason);
    }
}
