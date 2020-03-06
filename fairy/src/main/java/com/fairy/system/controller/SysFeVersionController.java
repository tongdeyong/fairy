package com.fairy.system.controller;

import com.fairy.common.vo.Result;
import com.fairy.system.vo.SysFeVersionVO;
import com.fairy.system.model.SysFeVersion;
import com.fairy.system.service.SysFeVersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author deyong_tong
 */
@RestController
@Slf4j
@RequestMapping("/system/sysFeVersion")
public class SysFeVersionController extends BaseController {

    @Resource
    private SysFeVersionService sysFeVersionService;

    @GetMapping("/list")
    public Result getPageList(SysFeVersionVO sysFeVersionVO) {
        List<SysFeVersion> sysFeVersionList = sysFeVersionService.findByCondition(sysFeVersionVO);
        return commonReturnResult(sysFeVersionList);
    }

    @GetMapping("/all-list")
    public Result getAllList(SysFeVersionVO sysFeVersionVO) {
        try {
            return Result.ok(sysFeVersionService.findAll(sysFeVersionVO));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/save")
    public Result save(@RequestBody SysFeVersion sysFeVersion) {
        try {
            sysFeVersionService.save(sysFeVersion);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody SysFeVersion sysFeVersion) {
        try {
            sysFeVersionService.update(sysFeVersion);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public Result remove(@PathVariable Integer id) {
        try {
            sysFeVersionService.deleteById(id);
            return Result.ok();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
}
