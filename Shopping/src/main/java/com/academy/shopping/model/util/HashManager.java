package com.academy.shopping.model.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

//회원 정보 중 비밀번호를 평문으로 넣지 말자
//암호화 시킬 건데 16진수 값으로 HASH 값으로 변환하자
@Component
public class HashManager {
	public static String getConvertedPassword(String password){
		
		StringBuffer sb=null;
		try {
			//위의 문자열을 hash 값으로 변환
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));//쪼개기
			
			//쪼개진 데이터 크기 만큼 반복문 돌리면서 하나씩 16진수 hash값으로 변환한 후, 
			//하나의 문자열에 모아놓는다.
			 sb = new StringBuffer();
			for(int i=0; i<hash.length; i++) {
				String hex = Integer.toHexString(0xff&hash[i]);
				
				System.out.println(hex);
				if(hex.length()==1) {//길이가 하나일때 EX) b ->0b
					sb.append("0");
				}
				sb.append(hex);
			}
			System.out.println(sb.toString());
			System.out.println(sb.toString().length());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
