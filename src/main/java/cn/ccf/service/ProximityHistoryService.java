package cn.ccf.service;

import cn.ccf.mapper.ProximityHistoryMapper;
import cn.ccf.pojo.ProximityHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author charles
 * @date 2019/8/13 15:52
 */
@Service
public class ProximityHistoryService {
    @Resource
    private ProximityHistoryMapper proximityHistoryMapper;


    public void saveProximity(List<ProximityHistory> list) {
        proximityHistoryMapper.batchInsert(list);
    }
}
