package cn.ccf.mapper;

import cn.ccf.pojo.GasHistory;
import cn.ccf.pojo.GasHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GasHistoryMapper {
    int countByExample(GasHistoryExample example);

    int deleteByExample(GasHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(GasHistory record);

    int insertSelective(GasHistory record);

    List<GasHistory> selectByExample(GasHistoryExample example);

    GasHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GasHistory record, @Param("example") GasHistoryExample example);

    int updateByExample(@Param("record") GasHistory record, @Param("example") GasHistoryExample example);

    int updateByPrimaryKeySelective(GasHistory record);

    int updateByPrimaryKey(GasHistory record);

    void batchInsert(List<GasHistory> list);
}