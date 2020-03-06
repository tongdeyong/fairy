package com.fairy.system.controller;

import com.fairy.common.vo.Result;
import com.fairy.system.vo.DeptVO;
import com.fairy.system.model.Dept;
import com.fairy.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author deyong_tong
 */
@RestController
@RequestMapping("/system/dept")
public class DeptController extends BaseController{

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    public Result getDeptPageList(DeptVO deptVO) {
        List<DeptVO> deptList = deptService.findByCondition(deptVO);
        return commonReturnResult(deptList);
    }
    @GetMapping("/all-list")
    public Result getDeptAllList(DeptVO deptVO) {
        List<DeptVO> deptList = deptService.findAll(deptVO);
        return Result.ok(deptList);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public Result save(@RequestBody Dept dept) {
        deptService.save(dept);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{deptId}")
    public Result remove(@PathVariable Integer deptId) {
        deptService.deleteById(deptId);
        return Result.ok();
    }
}
