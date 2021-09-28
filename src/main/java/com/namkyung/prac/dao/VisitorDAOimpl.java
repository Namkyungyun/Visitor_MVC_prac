package com.namkyung.prac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.namkyung.prac.db.DBConnection;
import com.namkyung.prac.vo.VisitorVO;

import oracle.jdbc.proxy.annotation.Pre;

@Repository
public class VisitorDAOimpl implements VisitorDAO{

	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null && rs.isClosed()) {
				rs.close();
				
			}
			if(pstmt != null && pstmt.isClosed()) {
				pstmt.close();
			}
			if(conn != null && conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<VisitorVO> selectVisitors() {
		//conn
		Connection conn = DBConnection.getInstance();
		//sql
		String sql = "SELECT * FROM VISITOR ORDER BY VNO DESC";
		//pstmt
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VisitorVO> vlist= new ArrayList<VisitorVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VisitorVO vvo = new VisitorVO();
				vvo.setVno(rs.getInt(1));
				vvo.setNickname(rs.getString(2));
				vvo.setContent(rs.getString(3));
				vvo.setRegdate(rs.getDate(4));
				vlist.add(vvo);
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return vlist;
	}

	@Override
	public int insertVisitor(VisitorVO vvo) {
		Connection conn = DBConnection.getInstance();
		String sql = "INSERT INTO VISITOR( VNO,NICKNAME,CONTENT) "
				+ "VALUES(VISITOR_VNO_SEQ.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vvo.getNickname());
			pstmt.setString(2,vvo.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		
		return result;
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {
		Connection conn = DBConnection.getInstance();
		String sql = "UPDATE VISITOR "
				+ "SET CONTENT =? "
				+ "WHERE VNO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vvo.getContent());
			pstmt.setInt(2, vvo.getVno());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return result;
				
	}

	@Override
	public int deleteVisitor(int vno) {
		Connection conn = DBConnection.getInstance();
		String sql = "DELETE FROM VISITOR "
				+ "WHERE VNO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		
		return result;
	}

}
