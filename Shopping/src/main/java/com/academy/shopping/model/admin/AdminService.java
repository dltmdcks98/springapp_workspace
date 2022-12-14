package com.academy.shopping.model.admin;

import java.util.List;

import com.academy.shopping.model.domain.Admin;

public interface AdminService {
	public List selectAll();
	public Admin select(int admin_id);
	public Admin selectByIdAndPass(Admin admin);//로그인시 필요
	public void insert(Admin admin);
	public void update(Admin admin);
	public void delete(Admin admin);//int형 안쓴 이유 혹시 모를 hibernate 때문
	
	
}
