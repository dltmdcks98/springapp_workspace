package com.academy.ormsqlmapapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//이 객체는 Mybatis의 쿼리수행 객체인 SqlSession을 얻기 위한 SqlSessionFactory를 설정하기 위함
//이 객체는 싱글턴으로 정의하여 중복 인스턴스를 방지할 것임
public class ConfigManager {
	private static ConfigManager instance;
	SqlSessionFactory sqlSessionFactory;
	
	private ConfigManager() {
		try {
			String resource = "com/academy/ormsqlmapapp/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// 	이 메서드를 통해 DAO 등이 SqlSession 객체를 반환  받을 수 있도록 제공해주자	
	public SqlSession getSqlSession() {

		return sqlSessionFactory.openSession();
		
	}
	public void closeSqlSession(SqlSession sqlSession) {
		sqlSession.close();
	}
	
	public static ConfigManager getInstance() {
		if(instance==null) {
			instance = new ConfigManager();
		}
		return instance;
	}
}
