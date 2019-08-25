package cn.ccf.service;

import cn.ccf.mapper.UserInfoMapper;
import cn.ccf.pojo.UserInfo;
import cn.ccf.pojo.UserInfoExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo queryUserInfoByWorkId(String hexWorkId) {
        UserInfoExample example = new UserInfoExample();

        example.createCriteria().andWorkIdEqualTo(hexWorkId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (userInfos != null && userInfos.size() != 0) {
            return userInfos.get(0);
        }
        return null;
    }

    public int deleteUser(int id) {
        return userInfoMapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
    }

    public Integer inserUser(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    public List<UserInfo> findAllUsers() {
        UserInfoExample example = new UserInfoExample();
        return userInfoMapper.selectByExample(example);
    }

    public boolean queryUserInfoByUsernameAndEchoWorkId(String username, String echoWorkId) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andEchoWorkIdEqualTo(echoWorkId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);


        UserInfoExample example1 = new UserInfoExample();
        example1.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> userInfos1 = userInfoMapper.selectByExample(example1);

        return CollectionUtils.isEmpty(userInfos) && CollectionUtils.isEmpty(userInfos1);
    }

    public UserInfo queryUserById(String id) {
        return userInfoMapper.selectByPrimaryKey(BigDecimal.valueOf(Integer.parseInt(id)));
    }

    public void updateSelective(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    public UserInfo queryUserInfoByUsername(String username) {

        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(userInfos)) {
            return null;
        }
        return userInfos.get(0);
    }
}
