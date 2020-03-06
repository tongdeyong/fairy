package com.fairy.system.service;

import com.fairy.system.vo.MenuVO;
import com.fairy.system.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deyong_tong
 */
@Service
public interface MenuService {

	/**
	 * 查询
	 * @param id id
	 * @return id
	 */
	Menu findById(Integer id);

	/**
	 * 条件查询
	 * @param menuVO menuVO
	 * @return list
	 */
	List<MenuVO> findByCondition(MenuVO menuVO);

	/**
	 * 保存
	 * @param menu menu
	 */
	void save(Menu menu);

	/**
	 * 更新
	 * @param menu menu
	 */
	void update(Menu menu);

	/**
	 * 删除
	 * @param id id
	 */
	void deleteById(Integer id);

	/**
	 * 查询所有
	 * @param menuVO menuVO
	 * @return list
	 */
    List<MenuVO> findAll(MenuVO menuVO);
}
