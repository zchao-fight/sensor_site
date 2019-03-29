package cn.ccf.mapper;

import cn.ccf.pojo.InAndOutHistory;
import cn.ccf.pojo.InAndOutHistoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InAndOutHistoryMapper {
    int countByExample(InAndOutHistoryExample example);

    int deleteByExample(InAndOutHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(InAndOutHistory record);

    int insertSelective(InAndOutHistory record);

    List<InAndOutHistory> selectByExample(InAndOutHistoryExample example);

    InAndOutHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InAndOutHistory record, @Param("example") InAndOutHistoryExample example);

    int updateByExample(@Param("record") InAndOutHistory record, @Param("example") InAndOutHistoryExample example);

    int updateByPrimaryKeySelective(InAndOutHistory record);

    int updateByPrimaryKey(InAndOutHistory record);
}