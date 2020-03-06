package com.fairy.system.service;

import com.fairy.system.vo.RoleVO;
import com.fairy.system.model.Role;
import com.fairy.system.model.RoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deyong_tong
 */
@Service
public interface RoleService {

	/**
	 * 查询
	 * @param id id
	 * @return Role
	 */
	Role findById(Integer id);

	/**
	 * 条件查询
	 * @param roleVO roleVO
	 * @return list
	 */
	List<Role> findByCondition(RoleVO roleVO);

	/**
	 * 保存
	 * @param user user
	 */
	void save(Role user);

	/**
	 * 更新
	 * @param user user
	 */
	void update(Role user);

	/**
	 * 删除
	 * @param id id
	 */
	void deleteById(Integer id);

	/**
	 * 获取
	 * @param roleMenu roleMenu
	 * @return list
	 */
    List<RoleMenu> getRoleMenu(RoleMenu roleMenu);

	/**
	 * 添加菜单权限
	 * @param roleVO roleVO
	 */
	void addMenuPermission(RoleVO roleVO);
}
