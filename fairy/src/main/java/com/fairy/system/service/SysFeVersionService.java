package com.fairy.system.service;

import com.fairy.system.vo.SysFeVersionVO;
import com.fairy.system.model.SysFeVersion;

import java.util.List;

/**
 * @author deyong_tong
 */
public interface SysFeVersionService {

    /**
     * 查询
     * @param id id
     * @return SysFeVersion
     */
    SysFeVersion findById(Integer id);

    /**
     * 条件查询
     * @param sysFeVersionVO sysFeVersionVO
     * @return list
     */
    List<SysFeVersion> findByCondition(SysFeVersionVO sysFeVersionVO);

    /**
     * 保存
     * @param user user
     */
    void save(SysFeVersion user);

    /**
     * 更新
     * @param user user
     */
    void update(SysFeVersion user);

    /**
     * 删除
     * @param id id
     */
    void deleteById(Integer id);

    /**
     * 查询所有
     * @param sysFeVersionVO sysFeVersionVO
     * @return list
     */
    List<SysFeVersion> findAll(SysFeVersionVO sysFeVersionVO);

}