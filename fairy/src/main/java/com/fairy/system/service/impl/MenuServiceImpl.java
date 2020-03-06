package com.fairy.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.fairy.system.dao.MenuDao;
import com.fairy.system.vo.MenuVO;
import com.fairy.system.model.Menu;
import com.fairy.system.service.MenuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author deyong_tong
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public Menu findById(Integer id) {
        return menuDao.findById(id);
    }

    @Override
    public List<MenuVO> findByCondition(MenuVO menuVO) {
        PageHelper.startPage(menuVO.getPageNum(), menuVO.getPageSize());
        List<MenuVO> menuList = menuDao.findByCondition(menuVO);
        //查询子节点
        buildTreeData(menuList);
        return menuList;
    }

    private void buildTreeData(List<MenuVO> menuList){
        Stack<MenuVO> stack = new Stack<>();
        stack.addAll(menuList);
        while (!stack.empty()) {
            MenuVO pop = stack.pop();
            MenuVO temp = new MenuVO();
            temp.setParentId(pop.getId());
            List<MenuVO> children = menuDao.findByCondition(temp);
            if (CollectionUtils.isNotEmpty(children)) {
                pop.setChildren(children);
                children.forEach(stack::push);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Menu menu) {
        menu.setUpdateTime(new Date());
        menuDao.update(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        menuDao.deleteById(id);
        //递归删除子节点
        MenuVO menuVO = new MenuVO();
        menuVO.setParentId(id);
        List<MenuVO> menuVOList = menuDao.findByCondition(menuVO);
        Stack<MenuVO> stack = new Stack<>();
        stack.addAll(menuVOList);
        while (!stack.empty()) {
            MenuVO pop = stack.pop();
            menuDao.deleteById(pop.getId());
            menuVO.setParentId(pop.getId());
            List<MenuVO> temp = menuDao.findByCondition(menuVO);
            if (CollectionUtils.isNotEmpty(temp)) {
                temp.forEach(stack::push);
            }
        }
    }

    @Override
    public List<MenuVO> findAll(MenuVO menuVO) {
        List<MenuVO> menuList = menuDao.findByCondition(menuVO);
        //查询子节点
        buildTreeData(menuList);
        return menuList;
    }

}
