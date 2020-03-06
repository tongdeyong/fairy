package com.fairy.system.dao;

import com.fairy.system.vo.MenuVO;
import com.fairy.system.model.Menu;

import java.util.List;

/**
 * 菜单dao
 *
 * @author deyong_tong
 */
public interface MenuDao {

	/**
	 * 通过id查找menu
	 * @param id id
	 * @return menu信息
	 */
	Menu findById(Integer id);

	/**
	 * 查找下级
	 *
	 * @param menuVO  menu
	 * @return list
	 */
	List<MenuVO> findByCondition(MenuVO menuVO);

	/**
	 * 保存菜单
	 *
	 * @param menu menu
	 */
	void save(Menu menu);

	/**
	 * 更新菜单
	 *
	 * @param menu menu
	 * @return int
	 */
	int update(Menu menu);


	/**
	 * 删除菜单
	 *
	 * @param id id
	 * @return int
	 */
	int deleteById(Integer id);
}
