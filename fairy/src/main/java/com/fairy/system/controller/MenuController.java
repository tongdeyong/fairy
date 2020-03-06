package com.fairy.system.controller;

import com.fairy.common.vo.Result;
import com.fairy.system.vo.MenuVO;
import com.fairy.system.model.Menu;
import com.fairy.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author deyong_tong
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController extends BaseController{

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    public Result getMenuPageList(MenuVO menuVO) {
        List<MenuVO> menuList = menuService.findByCondition(menuVO);
        return commonReturnResult(menuList);
    }

    @GetMapping("/all-list")
    public Result getMenuAllList(MenuVO menuVO) {
        List<MenuVO> menuList = menuService.findAll(menuVO);
        return Result.ok(menuList);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Menu menu) {
        menuService.update(menu);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{menuId}")
    public Result remove(@PathVariable Integer menuId) {
        menuService.deleteById(menuId);
        return Result.ok();
    }
}
