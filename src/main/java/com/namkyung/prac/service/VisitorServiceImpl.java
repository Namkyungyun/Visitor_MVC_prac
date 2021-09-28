package com.namkyung.prac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namkyung.prac.dao.VisitorDAO;
import com.namkyung.prac.vo.VisitorVO;

@Service
public class VisitorServiceImpl implements VisitorService{
	
	
	@Autowired
	private VisitorDAO vdao;
	
	@Override
	public List<VisitorVO> searchVisitor() {

		return vdao.selectVisitors();
	}

	@Override
	public int insertVisitor(VisitorVO vvo) {

		return vdao.insertVisitor(vvo);
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {

		return vdao.updateVisitor(vvo);
	}

	@Override
	public int deleteVisitor(int vno) {

		return vdao.deleteVisitor(vno);
	}

}
