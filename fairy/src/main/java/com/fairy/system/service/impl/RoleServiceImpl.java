package com.fairy.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.fairy.common.utils.BeanUtil;
import com.fairy.system.dao.RoleDao;
import com.fairy.system.dao.RoleMenuDao;
import com.fairy.system.vo.RoleVO;
import com.fairy.system.model.Role;
import com.fairy.system.model.RoleMenu;
import com.fairy.system.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author deyong_tong
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private RoleMenuDao roleMenuDao;

    @Override
    public Role findById(Integer id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findByCondition(RoleVO roleVO) {
        PageHelper.startPage(roleVO.getPageNum(), roleVO.getPageSize());
        Role role = BeanUtil.copyProperties(roleVO, Role.class);
        return roleDao.findByCondition(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<RoleMenu> getRoleMenu(RoleMenu roleMenu) {
        return roleMenuDao.findByCondition(roleMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMenuPermission(RoleVO roleVO) {
        List<Integer> menuIdList = roleVO.getMenuIdList();
        if (roleVO.getRoleId() == null || menuIdList == null) {
            throw new RuntimeException("参数有误");
        }
        //删除已有的权限值
        roleMenuDao.deleteByRoleId(roleVO.getRoleId());
        //持久化记录
        menuIdList.forEach(item->{
            RoleMenu model = new RoleMenu();
            model.setRoleId(roleVO.getRoleId());
            model.setMenuId(item);
            roleMenuDao.save(model);
        });
    }

}
