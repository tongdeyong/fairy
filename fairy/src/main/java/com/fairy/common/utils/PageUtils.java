package com.fairy.common.utils;

import java.util.List;

/**
 * @author deyong_tong
 */
public class PageUtils {
    /**
     * 分页
     *
     * @param list
     * @param pageNum
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> List<T> page(List<T> list, int pageNum, int pageSize) {
        int total = list.size();
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, total);
        return list.subList(start, end);
    }

}