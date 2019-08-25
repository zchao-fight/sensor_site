package cn.ccf.service;

import cn.ccf.mapper.CurrentInAndOutMapper;
import cn.ccf.mapper.InAndOutHistoryMapper;
import cn.ccf.pojo.CurrentInAndOut;
import cn.ccf.pojo.CurrentInAndOutExample;
import cn.ccf.pojo.InAndOutHistory;
import cn.ccf.pojo.InAndOutHistoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author charles
 * @date 2019/5/9 16:37
 */
@Service
public class InAndOutService {

    @Resource
    private InAndOutHistoryMapper inAndOutHistoryMapper;

    @Resource
    private CurrentInAndOutMapper currentInAndOutMapper;

    public List<CurrentInAndOut> selectAllCurrentInAndOut() {
        CurrentInAndOutExample example = new CurrentInAndOutExample();
        return currentInAndOutMapper.selectByExample(example);
    }

    public List<InAndOutHistory> selectAllInAndOutHistory() {
        InAndOutHistoryExample example = new InAndOutHistoryExample();
        return inAndOutHistoryMapper.selectByExample(example);
    }
}
