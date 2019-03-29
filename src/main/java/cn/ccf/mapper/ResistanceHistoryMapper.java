package cn.ccf.mapper;

import cn.ccf.pojo.ResistanceHistory;
import cn.ccf.pojo.ResistanceHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResistanceHistoryMapper {
    int countByExample(ResistanceHistoryExample example);

    int deleteByExample(ResistanceHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResistanceHistory record);

    int insertSelective(ResistanceHistory record);

    List<ResistanceHistory> selectByExample(ResistanceHistoryExample example);

    ResistanceHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResistanceHistory record, @Param("example") ResistanceHistoryExample example);

    int updateByExample(@Param("record") ResistanceHistory record, @Param("example") ResistanceHistoryExample example);

    int updateByPrimaryKeySelective(ResistanceHistory record);

    int updateByPrimaryKey(ResistanceHistory record);

    void batchInsert(List<ResistanceHistory> list);
}