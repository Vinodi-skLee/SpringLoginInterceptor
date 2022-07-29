package com.walab.camp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walab.camp.vo.UserVO;

import org.apache.ibatis.session.SqlSession;

@Repository("UserDAO")
public class UserDAO {
	
	@Autowired
	SqlSession sqlSession;

	public UserVO getUser(UserVO vo) {
		return sqlSession.selectOne("User.getUser", vo);
	}
	
	public UserVO getDuplicatedUser(UserVO vo) {
		return sqlSession.selectOne("User.getDuplicatedUser", vo);
	}
	
	public int insertUser(UserVO vo) {
		return sqlSession.insert("User.insertUser", vo);
	}
}