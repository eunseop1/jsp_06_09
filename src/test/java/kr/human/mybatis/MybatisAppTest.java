package kr.human.mybatis;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.human.member.dao.MemberDAOImpl;

public class MybatisAppTest {
	static SqlSessionFactory sqlSessionFactory;
	
	//이 클래스 실행전에 먼저 실행하라
	@Before
	public void beforeClass() {
		sqlSessionFactory = MybatisApp.getSqlSessionFactory();
	}
	
	@Test
	public void getSession() {
		assertNotNull(MybatisApp.getSqlSessionFactory());//null이 아니면 뭔가를 얻어온다
		//JUnit테스트로 돌렸을때 초록색 바가 뜨면 연결이 성공적이라는 것이다
	}
	
	@Test
	public void selectByIdx() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			assertEquals(MemberDAOImpl.getInstance().selectByIdx(sqlSession, 1).getUserid(), "root");
			assertEquals(MemberDAOImpl.getInstance().selectByIdx(sqlSession, 2).getName(), "최고관리자");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void selectByUserid() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			assertEquals(MemberDAOImpl.getInstance().selectByUserid(sqlSession, "root").getName(), "최고관리자");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	
}
