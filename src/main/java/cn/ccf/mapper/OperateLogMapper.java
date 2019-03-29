package cn.ccf.mapper;

import cn.ccf.pojo.OperateLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OperateLogMapper {

    List<OperateLog> selectOperateLogsByUsername(@Param("username") String username, @Param("start") Integer start, @Param("rows") Integer rows);
    Integer getTotalCount(@Param("username") String username);

    void insert(Map<String, Object> logForm);
}