package com.fairy.system.controller;

import com.fairy.common.vo.Result;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * .提出公共方法
 *
 * @author deyong_tong 童德勇 2020/3/6 23:32
 * @version V1.0
 */
@Slf4j
public class BaseController {

    public Result commonReturnResult(List tableList) {
        try {
            if (tableList instanceof Page) {
                Page page = (Page) tableList;
                return Result.ok(tableList, page.getPageNum(), page.getPageSize(), (int) page.getTotal());
            }
            return Result.ok(tableList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.error(e.getMessage());
        }
    }
}
