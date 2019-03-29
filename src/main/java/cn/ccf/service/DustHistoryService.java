package cn.ccf.service;

import cn.ccf.mapper.DustHistoryMapper;
import cn.ccf.pojo.DustHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DustHistoryService {

    @Resource
    private DustHistoryMapper dustHistoryMapper;

    public void saveDust(List<DustHistory> list) {
        dustHistoryMapper.batchInsert(list);
    }
}
