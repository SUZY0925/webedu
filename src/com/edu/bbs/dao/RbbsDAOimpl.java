package com.edu.bbs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.DataBaseUtil;
import com.edu.bbs.dto.BbsDTO;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsDAOimpl implements RbbsDAO {
	private static RbbsDAO rbdao = new RbbsDAOimpl();

	CallableStatement cst;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	private RbbsDAOimpl () {
		
	}
	
	public static RbbsDAO getInstance() {
		return rbdao;
	}
	
	// 댓글등록
	@Override
	public void write(RbbsDTO rbbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into replybbs (rnum, bnum, rname, rcontent, rgroup, rstep, rindent) ")
				.append("values(rbbsnum_seq.nextval,?,?,?,rbbsnum_seq.nextval,0,0)");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, rbbsdto.getBnum());
			pstmt.setString(2, rbbsdto.getRname());
			pstmt.setString(3, rbbsdto.getRcontent());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void write(RbbsDTO rbbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}

	@Override
	public ArrayList<RbbsDTO> list(int startRow, int endRow) {
		ArrayList<RbbsDTO> alist = new ArrayList<>();
		RbbsDTO rbbsdto;
		StringBuffer sql = new StringBuffer();
		sql.append("select t2.* from (select row_number() over ")
			.append("(ORDER BY rgroup desc, rstep asc) as num, t1.* FROM replybbs t1) t2 where num between ? and ?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					rbbsdto = new RbbsDTO();
					rbbsdto.setBnum(rs.getInt("Bnum"));
					rbbsdto.setRnum(rs.getInt("Rnum"));
					rbbsdto.setRname(rs.getString("Rname"));
					rbbsdto.setRcontent(rs.getString("Rcontent"));
					rbbsdto.setRcdate(rs.getDate("Rcdate"));
					rbbsdto.setRgroup(rs.getInt("Rgroup"));
					rbbsdto.setRstep(rs.getInt("Rstep"));
					rbbsdto.setRindent(rs.getInt("Rindent"));
					alist.add(rbbsdto);
				}
				
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<RbbsDTO> list(int startRow, int endRow)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return alist;
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BbsDTO view(int bNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO modify(RbbsDTO rbbsdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int bNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public BbsDTO pageNav(int bNum, int np) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO replyView(int bNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reply(RbbsDTO rbbsdto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStep(int bgroup, int bstep) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<RbbsDTO> searchList(String option, String search, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSearchListCount(String option, String search) {
		// TODO Auto-generated method stub
		return 0;
	}

}
