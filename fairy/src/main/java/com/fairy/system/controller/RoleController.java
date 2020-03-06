package com.fairy.system.controller;

import com.fairy.common.vo.Result;
import com.fairy.system.vo.RoleVO;
import com.fairy.system.model.Role;
import com.fairy.system.model.RoleMenu;
import com.fairy.system.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author deyong_tong
 */
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController{

    @Resource
    private RoleService roleService;

    @GetMapping("/list")
    public Result getRolePageList(RoleVO roleVO) {
        List<Role> roleList = roleService.findByCondition(roleVO);
        return commonReturnResult(roleList);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody Role role) {
        roleService.save(role);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Role role) {
        roleService.update(role);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{roleId}")
    public Result remove(@PathVariable Integer roleId) {
        roleService.deleteById(roleId);
        return Result.ok();
    }

    /**
     * 获取已有的菜单权限
     * @param roleMenu
     * @return
     */
    @GetMapping("/role-menu")
    public Result getRoleMenu(RoleMenu roleMenu) {
        List<RoleMenu> roleMenuList = roleService.getRoleMenu(roleMenu);
        List<Integer> result = new ArrayList<>();
        roleMenuList.forEach(item -> result.add(item.getMenuId()));
        return Result.ok(result);
    }

    /**
     * 增加
     * @param roleVO
     * @return
     */
    @PostMapping("/add-menu-permission")
    public Result addMenuPermission(@RequestBody RoleVO roleVO) {
        roleService.addMenuPermission(roleVO);
        return Result.ok();
    }


}
