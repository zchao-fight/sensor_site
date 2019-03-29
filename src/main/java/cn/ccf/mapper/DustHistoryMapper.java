package cn.ccf.mapper;

import cn.ccf.pojo.DustHistory;
import cn.ccf.pojo.DustHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DustHistoryMapper {
    int countByExample(DustHistoryExample example);

    int deleteByExample(DustHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(DustHistory record);

    int insertSelective(DustHistory record);

    List<DustHistory> selectByExample(DustHistoryExample example);

    DustHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DustHistory record, @Param("example") DustHistoryExample example);

    int updateByExample(@Param("record") DustHistory record, @Param("example") DustHistoryExample example);

    int updateByPrimaryKeySelective(DustHistory record);

    int updateByPrimaryKey(DustHistory record);

    void batchInsert(List<DustHistory> list);
}