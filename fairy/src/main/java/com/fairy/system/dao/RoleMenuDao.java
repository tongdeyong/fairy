package com.fairy.system.dao;

import com.fairy.system.model.RoleMenu;

import java.util.List;

/**
 * @author deyong_tong
 */
public interface RoleMenuDao {

	/**
	 * id查找角色
	 * @param id id
	 * @return RoleMenu
	 */
	RoleMenu findById(Integer id);

	/**
	 * 条件查找角色
	 * @param roleMenu RoleMenu
	 * @return list
	 */
	List<RoleMenu> findByCondition(RoleMenu roleMenu);

	/**
	 * 保存
	 * @param roleMenu RoleMenu
	 */
	void save(RoleMenu roleMenu);

	/**
	 * 更新
	 * @param roleMenu RoleMenu
	 * @return int
	 */
	int update(RoleMenu roleMenu);

	/**
	 * 通过id删除
	 * @param id id
	 * @return int
	 */
	int deleteById(Integer id);

	/**
	 * 通过觉得id删除
	 * @param roleId roleId
	 */
	void deleteByRoleId(Integer roleId);
}
