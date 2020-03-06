package com.fairy.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.fairy.system.dao.SysFeVersionDao;
import com.fairy.system.handler.UserHandler;
import com.fairy.system.vo.SysFeVersionVO;
import com.fairy.system.model.SysFeVersion;
import com.fairy.system.service.SysFeVersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author deyong_tong
 */
@Service
public class SysFeVersionServiceImpl implements SysFeVersionService {

    @Resource
    private SysFeVersionDao sysFeVersionDao;

    @Override
    public SysFeVersion findById(Integer id) {
        return sysFeVersionDao.findById(id);
    }

    @Override
    public List<SysFeVersion> findByCondition(SysFeVersionVO sysFeVersionVO) {
        PageHelper.startPage(sysFeVersionVO.getPageNum(), sysFeVersionVO.getPageSize());
        return sysFeVersionDao.findByCondition(sysFeVersionVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysFeVersion sysFeVersion) {
        sysFeVersion.setCreateTime(new Date());
        sysFeVersion.setCreateUser(UserHandler.getCurrentUser().getUsername());
        sysFeVersion.setUpdateTime(new Date());
        sysFeVersionDao.save(sysFeVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysFeVersion sysFeVersion) {
        sysFeVersion.setUpdateTime(new Date());
        sysFeVersionDao.update(sysFeVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        sysFeVersionDao.deleteById(id);
    }

    @Override
    public List<SysFeVersion> findAll(SysFeVersionVO sysFeVersionVO) {
        return sysFeVersionDao.findByCondition(sysFeVersionVO);
    }

}
