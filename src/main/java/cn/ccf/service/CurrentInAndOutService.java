package cn.ccf.service;

import cn.ccf.mapper.CurrentInAndOutMapper;
import cn.ccf.pojo.CurrentInAndOut;
import cn.ccf.pojo.CurrentInAndOutExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CurrentInAndOutService {

    @Resource
    private CurrentInAndOutMapper currentInAndOutMapper;

    public CurrentInAndOut queryByWorkId(String workId) {
        CurrentInAndOutExample example = new CurrentInAndOutExample();
        example.createCriteria().andWorkIdEqualTo(workId);
        List<CurrentInAndOut> currentInAndOuts = currentInAndOutMapper.selectByExample(example);
        if (currentInAndOuts != null && currentInAndOuts.size() != 0) {
            return currentInAndOuts.get(0);
        }

        return null;

    }

}
