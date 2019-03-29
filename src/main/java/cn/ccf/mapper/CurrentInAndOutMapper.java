package cn.ccf.mapper;

import cn.ccf.pojo.CurrentInAndOut;
import cn.ccf.pojo.CurrentInAndOutExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentInAndOutMapper {
    int countByExample(CurrentInAndOutExample example);

    int deleteByExample(CurrentInAndOutExample example);

    int deleteByPrimaryKey(String id);

    int insert(CurrentInAndOut record);

    int insertSelective(CurrentInAndOut record);

    List<CurrentInAndOut> selectByExample(CurrentInAndOutExample example);

    CurrentInAndOut selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CurrentInAndOut record, @Param("example") CurrentInAndOutExample example);

    int updateByExample(@Param("record") CurrentInAndOut record, @Param("example") CurrentInAndOutExample example);

    int updateByPrimaryKeySelective(CurrentInAndOut record);

    int updateByPrimaryKey(CurrentInAndOut record);
}