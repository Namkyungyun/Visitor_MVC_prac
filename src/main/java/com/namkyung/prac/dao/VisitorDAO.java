package com.namkyung.prac.dao;

import java.util.List;

import com.namkyung.prac.vo.VisitorVO;

public interface VisitorDAO {

	public List<VisitorVO> selectVisitors();
	public int insertVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int deleteVisitor(int vno);
}
