package com.fairy.system.dao;

import com.fairy.system.vo.SysFeVersionVO;
import com.fairy.system.model.SysFeVersion;

import java.util.List;

/**
 * 版本控制
 * @author deyong_tong
 */
public interface SysFeVersionDao {

    /**
     * id查找
     * @param id id
     * @return 版本信息
     */
    SysFeVersion findById(Integer id);

    /**
     * 条件查找
     * @param sysFeVersionVO sysFeVersionVO
     * @return list
     */
    List<SysFeVersion> findByCondition(SysFeVersionVO sysFeVersionVO);

    /**
     * 保存
     * @param sysFeVersion sysFeVersion
     */
    void save(SysFeVersion sysFeVersion);

    /**
     * 更新
     * @param sysFeVersion sysFeVersion
     * @return int
     */
    int update(SysFeVersion sysFeVersion);

    /**
     * 删除
     * @param id id
     * @return int
     */
    int deleteById(Integer id);

}