package cn.ccf.mapper;

import cn.ccf.pojo.HumidityHistory;
import cn.ccf.pojo.ProximityHistory;
import cn.ccf.pojo.ProximityHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProximityHistoryMapper {
    int countByExample(ProximityHistoryExample example);

    int deleteByExample(ProximityHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProximityHistory record);

    int insertSelective(ProximityHistory record);

    List<ProximityHistory> selectByExample(ProximityHistoryExample example);

    ProximityHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProximityHistory record, @Param("example") ProximityHistoryExample example);

    int updateByExample(@Param("record") ProximityHistory record, @Param("example") ProximityHistoryExample example);

    int updateByPrimaryKeySelective(ProximityHistory record);

    int updateByPrimaryKey(ProximityHistory record);

    void batchInsert(List<ProximityHistory> list);
}