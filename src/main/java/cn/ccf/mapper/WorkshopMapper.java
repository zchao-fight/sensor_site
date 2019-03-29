package cn.ccf.mapper;

import cn.ccf.pojo.Workshop;
import cn.ccf.pojo.WorkshopExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopMapper {
    int countByExample(WorkshopExample example);

    int deleteByExample(WorkshopExample example);

    int deleteByPrimaryKey(String id);

    int insert(Workshop record);

    int insertSelective(Workshop record);

    List<Workshop> selectByExample(WorkshopExample example);

    Workshop selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Workshop record, @Param("example") WorkshopExample example);

    int updateByExample(@Param("record") Workshop record, @Param("example") WorkshopExample example);

    int updateByPrimaryKeySelective(Workshop record);

    int updateByPrimaryKey(Workshop record);
}