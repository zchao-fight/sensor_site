package cn.ccf.mapper;

import cn.ccf.pojo.LoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoginLogMapper {
    void insert(Map<String, Object> logForm);

    List<LoginLog> selectLoginLogsByUsername(@Param("username") String username, @Param("start") Integer start, @Param("rows") Integer rows);

    Integer getTotalCount(@Param("username") String username);
}
