package com.fairy.system.handler;

import com.fairy.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author deyong_tong
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 该注解声明异常处理方法
     * @param e e
     * @return result
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }
}
