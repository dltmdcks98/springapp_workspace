package com.academy.shopping.model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.util.HashManager;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private HashManager hashManager;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Member selectCustomerId(String customer_id) throws MemberException {
		return memberDAO.selectCustomerId(customer_id);
	}
	@Override
	public Member selectByIdAndPass(Member member) {
		String hash = hashManager.getConvertedPassword(member.getCustomer_pass());
		member.setCustomer_pass(hash);//암호화된 결과를 다시 넣는다.
		return memberDAO.selectByIdAndPass(member);
	}
	@Override
	public void insert(Member member) throws MemberException {
		String hash = hashManager.getConvertedPassword(member.getCustomer_pass());
		member.setCustomer_pass(hash);//암호화된 결과를 다시 넣는다.
		memberDAO.insert(member);
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Member member) {
		// TODO Auto-generated method stub
		
	}
	
}
