package com.fairy.common.vo;

import lombok.Data;

/**
 * @author deyong_tong
 */
@Data
public class Result {

    private Integer status;
    private String msg;
    private Object data;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;

    public static Result build(Integer code, String msg, Object data, Integer pageNum, Integer pageSize, Integer total) {
        Result r = new Result();
        r.setStatus(code);
        r.setMsg(msg);
        r.setData(data);
        r.setPageNum(pageNum);
        r.setPageSize(pageSize);
        r.setTotal(total);
        return r;
    }

    public static Result error(String msg) {
        return build(400, msg, null, null, null, null);

    }

    public static Result error() {
        return error("失败");
    }

    public static Result ok(String msg, Object data) {
        return build(200, msg, data, null, null, null);
    }

    public static Result ok(Object data) {
        return ok("成功", data);
    }

    public static Result ok(Object data, Integer pageNum, Integer pageSize, Integer total) {
        return build(200, "成功", data, pageNum, pageSize, total);
    }

    public static Result ok() {
        return ok(null);
    }

}
