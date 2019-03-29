package cn.ccf.service;

import cn.ccf.mapper.ResistanceHistoryMapper;
import cn.ccf.pojo.ResistanceHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResistanceHistoryService {
    @Resource
    private ResistanceHistoryMapper resistanceHistoryMapper;


    public void saveResistance(List<ResistanceHistory> list) {
        resistanceHistoryMapper.batchInsert(list);
    }
}
