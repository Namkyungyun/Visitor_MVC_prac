package com.namkyung.prac.service;

import java.util.List;

import com.namkyung.prac.vo.VisitorVO;

public interface VisitorService {
	public List<VisitorVO> searchVisitor();
	public int insertVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int deleteVisitor(int vno);
}
