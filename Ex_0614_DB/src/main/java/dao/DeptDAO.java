package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

public class DeptDAO {
	
	//mybatis 사용을 위한 mapper 접근용 객체
	SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//전체 부서목록
	public List<DeptVO> select(){
		
		List<DeptVO> list = sqlSession.selectList("dept.dept_list");
		return list;
	}
	
}
