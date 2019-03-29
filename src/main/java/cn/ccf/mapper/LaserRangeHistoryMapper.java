package cn.ccf.mapper;

import cn.ccf.pojo.LaserRangeHistory;
import cn.ccf.pojo.LaserRangeHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaserRangeHistoryMapper {
    int countByExample(LaserRangeHistoryExample example);

    int deleteByExample(LaserRangeHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(LaserRangeHistory record);

    int insertSelective(LaserRangeHistory record);

    List<LaserRangeHistory> selectByExample(LaserRangeHistoryExample example);

    LaserRangeHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LaserRangeHistory record, @Param("example") LaserRangeHistoryExample example);

    int updateByExample(@Param("record") LaserRangeHistory record, @Param("example") LaserRangeHistoryExample example);

    int updateByPrimaryKeySelective(LaserRangeHistory record);

    int updateByPrimaryKey(LaserRangeHistory record);

    void batchInsert(List<LaserRangeHistory> list);
}