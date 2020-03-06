package com.fairy.system.controller;

import com.fairy.common.vo.Result;
import com.fairy.system.handler.UserHandler;
import com.fairy.common.utils.MD5Utils;
import com.fairy.system.vo.UserVO;
import com.fairy.system.model.User;
import com.fairy.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author deyong_tong
 */
@RequestMapping("/system/user")
@RestController
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result getUserPageList(UserVO userVO) {
        // 查询列表数据
        List<User> userList = userService.findByCondition(userVO);
        return commonReturnResult(userList);
    }

    @GetMapping("/info")
    public Result getUserInfo() {
        return Result.ok(UserHandler.getCurrentUser());
    }

    @PostMapping("/save")
    public Result save(@RequestBody UserVO userVO) {
        userVO.setPassword(MD5Utils.encrypt(userVO.getUsername(), userVO.getPassword()));
        userService.save(userVO);
        return Result.ok();
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody UserVO userVO) {
        userService.update(userVO);
        return Result.ok();
    }


    @PostMapping("/delete/{userId}")
    @ResponseBody
    public Result remove(@PathVariable Integer userId) {
        userService.deleteById(userId);
        return Result.ok();
    }

    @PostMapping("/resetPassword")
    @ResponseBody
    public Result resetPassword(@RequestBody UserVO userVO) {
        userService.update(userVO);
        return Result.ok();
    }

}
