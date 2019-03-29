package cn.ccf.mapper;

import cn.ccf.pojo.NumInWorkshop;
import cn.ccf.pojo.NumInWorkshopExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumInWorkshopMapper {
    int countByExample(NumInWorkshopExample example);

    int deleteByExample(NumInWorkshopExample example);

    int deleteByPrimaryKey(String id);

    int insert(NumInWorkshop record);

    int insertSelective(NumInWorkshop record);

    List<NumInWorkshop> selectByExample(NumInWorkshopExample example);

    NumInWorkshop selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NumInWorkshop record, @Param("example") NumInWorkshopExample example);

    int updateByExample(@Param("record") NumInWorkshop record, @Param("example") NumInWorkshopExample example);

    int updateByPrimaryKeySelective(NumInWorkshop record);

    int updateByPrimaryKey(NumInWorkshop record);
}