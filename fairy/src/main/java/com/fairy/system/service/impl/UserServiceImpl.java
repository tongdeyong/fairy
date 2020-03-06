package com.fairy.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.fairy.common.utils.BeanUtil;
import com.fairy.system.dao.UserDao;
import com.fairy.system.dao.UserDeptDao;
import com.fairy.system.vo.UserVO;
import com.fairy.system.model.User;
import com.fairy.system.model.UserDept;
import com.fairy.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author deyong_tong
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserDeptDao userDeptDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByCondition(UserVO userVO) {
        PageHelper.startPage(userVO.getPageNum(), userVO.getPageSize());
        if (userVO.getDeptId().equals(0)) {
            userVO.setDeptId(null);
        }
        return userDao.findByCondition(userVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserVO userVO) {
        User user = BeanUtil.copyProperties(userVO, User.class);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userDao.save(user);

        UserDept userDept = new UserDept();
        userDept.setDeptId(userDept.getDeptId());
        userDept.setUserId(userDept.getUserId());
        userDeptDao.save(userDept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(UserVO userVO) {
        User user = BeanUtil.copyProperties(userVO, User.class);
        user.setUpdateTime(new Date());
        userDao.update(user);

        UserDept userDept = userDeptDao.findByUserId(user.getId());
        userDept.setDeptId(userVO.getDeptId());
        userDeptDao.update(userDept);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        userDao.deleteById(id);
        userDeptDao.deleteByUserId(id);
    }

    @Override
    public User findByUsername(String username) {
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        List<User> userList = userDao.findByCondition(userVO);
        if (CollectionUtils.isEmpty(userList)) {
            log.error("{}-用户不存在", username);
            throw new RuntimeException("用户不存在");
        }
        if (userList.size() > 1) {
            log.error("{}-查询到多个用户", username);
            throw new RuntimeException("查询到多个用户");
        }
        return userList.get(0);
    }


}
