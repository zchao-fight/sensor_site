package cn.ccf.mapper;

import cn.ccf.pojo.Sensor;
import cn.ccf.pojo.SensorExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorMapper {
    int countByExample(SensorExample example);

    int deleteByExample(SensorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    List<Sensor> selectByExample(SensorExample example);

    Sensor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByExample(@Param("record") Sensor record, @Param("example") SensorExample example);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);
}