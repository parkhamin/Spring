package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {
	SqlSession sqlSession;
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//전체 회원목록 조회
	public List<MemberVO> selectAll(){
		List<MemberVO> list = sqlSession.selectList("m.member_list");
		return list;
	}
	
	//회원추가
	public int insertUser(MemberVO vo) {
		
		int res = sqlSession.insert("m.insert_user", vo);
		return res;
		
	}
	
	//아이디 중복체크
	public MemberVO checkId( String id ) {
		MemberVO vo = sqlSession.selectOne("m.checkid", id);
		return vo;
	}
	
	//회원삭제
	public int deleteMember(int idx) {
		
		int res = sqlSession.delete("m.delMember", idx);
		return res;
	}
}


















