package com.academy.shopping.model.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.AdminException;
import com.academy.shopping.model.domain.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	@Qualifier("mybatisAdminDAO")
	private AdminDAO adminDAO;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin select(int admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin selectByIdAndPass(Admin admin)throws AdminException{
		return adminDAO.selectByIdAndPass(admin);
	}

	@Override
	public void insert(Admin admin)throws AdminException {
		adminDAO.insert(admin);
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	
}
