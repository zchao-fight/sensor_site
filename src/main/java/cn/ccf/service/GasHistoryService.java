package cn.ccf.service;

import cn.ccf.mapper.GasHistoryMapper;
import cn.ccf.pojo.GasHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GasHistoryService {
    @Resource
    private GasHistoryMapper gasHistoryMapper;


    public void saveGas(List<GasHistory> list) {
        gasHistoryMapper.batchInsert(list);
    }
}
