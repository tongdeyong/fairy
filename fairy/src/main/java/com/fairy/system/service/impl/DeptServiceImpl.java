package com.fairy.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.fairy.system.dao.DeptDao;
import com.fairy.system.vo.DeptVO;
import com.fairy.system.model.Dept;
import com.fairy.system.service.DeptService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Stack;

/**
 * @author deyong_tong
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;

	@Override
	public Dept findById(Integer id) {
		return deptDao.findById(id);
	}

	@Override
	public List<DeptVO> findByCondition(DeptVO deptVO) {
		PageHelper.startPage(deptVO.getPageNum(), deptVO.getPageSize());
		List<DeptVO> deptList = deptDao.findByCondition(deptVO);
		buildTreeData(deptList);
		return deptList;
	}

	private void buildTreeData(List<DeptVO> deptVOList){
		Stack<DeptVO> stack = new Stack<>();
		stack.addAll(deptVOList);
		while (!stack.empty()) {
			DeptVO pop = stack.pop();
			DeptVO temp = new DeptVO();
			temp.setParentId(pop.getId());
			List<DeptVO> children = deptDao.findByCondition(temp);
			if (CollectionUtils.isNotEmpty(children)) {
				pop.setChildren(children);
				children.forEach(stack::push);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(Dept dept) {
		deptDao.save(dept);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(Dept dept) {
		deptDao.update(dept);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteById(Integer id) {
		deptDao.deleteById(id);
		//递归删除子节点
		DeptVO deptVO = new DeptVO();
		deptVO.setParentId(id);
		List<DeptVO> deptVOList = deptDao.findByCondition(deptVO);
		Stack<DeptVO> stack = new Stack<>();
		stack.addAll(deptVOList);
		while (!stack.empty()) {
			DeptVO pop = stack.pop();
			deptDao.deleteById(pop.getId());
			deptVO.setParentId(pop.getId());
			List<DeptVO> temp = deptDao.findByCondition(deptVO);
			if (CollectionUtils.isNotEmpty(temp)) {
				temp.forEach(stack::push);
			}
		}
	}

	@Override
	public List<DeptVO> findAll(DeptVO deptVO) {
		List<DeptVO> deptList = deptDao.findByCondition(deptVO);
		buildTreeData(deptList);
		return deptList;
	}

}
