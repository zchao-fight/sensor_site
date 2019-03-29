package cn.ccf.mapper;

import cn.ccf.pojo.TemperatureHistory;
import cn.ccf.pojo.TemperatureHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TemperatureHistoryMapper {
    int countByExample(TemperatureHistoryExample example);

    int deleteByExample(TemperatureHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(TemperatureHistory record);

    int insertSelective(TemperatureHistory record);

    List<TemperatureHistory> selectByExample(TemperatureHistoryExample example);

    TemperatureHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TemperatureHistory record, @Param("example") TemperatureHistoryExample example);

    int updateByExample(@Param("record") TemperatureHistory record, @Param("example") TemperatureHistoryExample example);

    int updateByPrimaryKeySelective(TemperatureHistory record);

    int updateByPrimaryKey(TemperatureHistory record);

    void batchInsert(List<TemperatureHistory> list);
}