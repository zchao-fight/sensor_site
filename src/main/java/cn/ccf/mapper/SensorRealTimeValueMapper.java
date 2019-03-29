package cn.ccf.mapper;

import cn.ccf.pojo.SensorRealTimeValue;
import cn.ccf.pojo.SensorRealTimeValueExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRealTimeValueMapper {
    int countByExample(SensorRealTimeValueExample example);

    int deleteByExample(SensorRealTimeValueExample example);

    int deleteByPrimaryKey(String id);

    int insert(SensorRealTimeValue record);

    int insertSelective(SensorRealTimeValue record);

    List<SensorRealTimeValue> selectByExample(SensorRealTimeValueExample example);

    SensorRealTimeValue selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SensorRealTimeValue record, @Param("example") SensorRealTimeValueExample example);

    int updateByExample(@Param("record") SensorRealTimeValue record, @Param("example") SensorRealTimeValueExample example);

    int updateByPrimaryKeySelective(SensorRealTimeValue record);

    int updateByPrimaryKey(SensorRealTimeValue record);
}