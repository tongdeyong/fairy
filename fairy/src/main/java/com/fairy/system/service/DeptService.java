package com.fairy.system.service;


import com.fairy.system.vo.DeptVO;
import com.fairy.system.model.Dept;

import java.util.List;


/**
 * @author deyong_tong
 */
public interface DeptService {

	/**
	 * 查询
	 * @param id id
	 * @return dept
	 */
	Dept findById(Integer id);

	/**
	 * 条件查找
	 * @param deptVO deptVO
	 * @return list
	 */
	List<DeptVO> findByCondition(DeptVO deptVO);

	/**
	 * 保存
	 * @param dept dept
	 */
	void save(Dept dept);

	/**
	 * 更新
	 * @param dept dept
	 */
	void update(Dept dept);

	/**
	 * 删除
	 * @param id id
	 */
	void deleteById(Integer id);

	/**
	 * 查询所有
	 * @param deptVO deptVO
	 * @return list
	 */
    List<DeptVO> findAll(DeptVO deptVO);
}
