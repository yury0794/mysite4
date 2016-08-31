package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void delete(GuestBookVo vo) {
		sqlSession.delete("guestbook.delete", vo);
	}

	public void insert(GuestBookVo vo) {
		sqlSession.insert("guestbook.insert", vo);
	}

	public List<GuestBookVo> getList() {
		List<GuestBookVo> list = sqlSession.selectList("guestbook.list");
		return list;
	}
}