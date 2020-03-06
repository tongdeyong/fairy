package com.fairy.system.dao;

import com.fairy.system.vo.DeptVO;
import com.fairy.system.model.Dept;

import java.util.List;

/**
 * 部门dao
 *
 * @author deyong_tong
 */
public interface DeptDao {

	/**
	 * 通过id查找部门
	 *
	 * @param id  id
	 * @return Dept
	 */
	Dept findById(Integer id);

	/**
	 * 条件查找部门
	 *
	 * @param deptVO deptVO
	 * @return list
	 */
	List<DeptVO> findByCondition(DeptVO deptVO);

	/**
	 * 保存部门
	 *
	 * @param dept dept
	 */
	void save(Dept dept);

	/**
	 * 更新部门
	 *
	 * @param dept dept
	 * @return int
	 */
	int update(Dept dept);

	/**
	 * 通过id删除部门
	 *
	 * @param id id
	 * @return int
	 */
	int deleteById(Integer id);
}
