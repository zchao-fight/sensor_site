package cn.ccf.mapper;

import cn.ccf.pojo.HumidityHistory;
import cn.ccf.pojo.HumidityHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumidityHistoryMapper {
    int countByExample(HumidityHistoryExample example);

    int deleteByExample(HumidityHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(HumidityHistory record);

    int insertSelective(HumidityHistory record);

    List<HumidityHistory> selectByExample(HumidityHistoryExample example);

    HumidityHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HumidityHistory record, @Param("example") HumidityHistoryExample example);

    int updateByExample(@Param("record") HumidityHistory record, @Param("example") HumidityHistoryExample example);

    int updateByPrimaryKeySelective(HumidityHistory record);

    int updateByPrimaryKey(HumidityHistory record);

    void batchInsert(List<HumidityHistory> list);
}