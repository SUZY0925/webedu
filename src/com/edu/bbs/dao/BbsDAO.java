package com.edu.bbs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edu.DataBaseUtil;
import com.edu.bbs.dto.BbsDTO;

public class BbsDAO {
	private static BbsDAO bdao = new BbsDAO();
	
	CallableStatement cst;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private BbsDAO() {
		
	}
	
	public static BbsDAO getInstance() {
		return bdao;
	}
	
	// 글목록
	public void write(BbsDTO bbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent) ")
		.append("values(bbsnum_seq.nextval,?,?,?,?)");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setInt(3, bbsdto.getbHit());
			pstmt.setString(4, bbsdto.getbContent());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void write(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	
	//글목록 가져오기
	public ArrayList<BbsDTO> list() {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto = new BbsDTO();
		StringBuffer sql = new StringBuffer();
		sql.append("select bnum, btitle, bname, bhit, bcontent, bcdate from bbs ")
			.append("order by bnum desc");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
					bbsdto = new BbsDTO();
					bbsdto.setbNum(rs.getInt("bnum"));
					bbsdto.setbTitle(rs.getString("btitle"));
					bbsdto.setbName(rs.getString("bname"));
					bbsdto.setbHit(rs.getInt("bhit"));
					bbsdto.setbContent(rs.getString("bcontent"));
					bbsdto.setbCdate(rs.getDate("bcdate"));
					alist.add(bbsdto);
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		
		return alist;
	}
	
	
	/*
	create or replace procedure  Clist_callbbs (
	    PNUM IN NUMBER,
	    OTITLE out bbs.btitle%TYPE,
	    ONAME out bbs.bname%TYPE,
	    OUDATE out bbs.budate%TYPE,
	    OHIT out bbs.bhit%TYPE,
	    OCONTENT out bbs.bcontent%TYPE)
	AS
	    r_errcode NUMBER;
	    r_errmsg VARCHAR(2);
	BEGIN
	        update BBS 
	        SET BHIT=(BHIT+1) where BNUM = PNUM;
	        select BTITLE, BNAME, BUDATE, BHIT, BCONTENT
	        INTO  OTITLE, ONAME, OUDATE, OHIT, OCONTENT
	        FROM bbs
	        where bnum = pnum;
	Exception 
	    WHEN OTHERS THEN
	    ROLLBACK;
	    r_errcode := SQLCODE;
	    r_errmsg := SQLERRM;
	    DBMS_OUTPUT.PUT_LINE('ERRCODE : ' || to_char(r_errcode));
	    DBMS_OUTPUT.PUT_LINE('ERRMSG : ' || r_errmsg);
	END;
	/
*/
	// 글내용 가져오기
	public BbsDTO view(int bNum) {
		BbsDTO bbsdto = new BbsDTO();
		String sql = "{call Clist_callbbs(?,?,?,?,?,?)}";

		try {
			conn = DataBaseUtil.getConnection();
			cst = conn.prepareCall(sql);

			cst.setInt(1, bNum);
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setDate(4, null);
			cst.setInt(5, 0);
			cst.setString(6, "");

			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.registerOutParameter(4, java.sql.Types.DATE);
			cst.registerOutParameter(5, java.sql.Types.INTEGER);
			cst.registerOutParameter(6, java.sql.Types.VARCHAR);

			cst.executeQuery();

			bbsdto.setbNum(bNum);
			bbsdto.setbTitle(cst.getString(2));
			bbsdto.setbName(cst.getString(3));
			bbsdto.setbUdate(cst.getDate(4));
			bbsdto.setbHit(cst.getInt(5));
			bbsdto.setbContent(cst.getString(6));

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO view(int bNum)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bbsdto;
	}
	

	public BbsDTO modify(BbsDTO bbsdto) {
		String sql ="update bbs set bTitle=?, bName=?, bContent=?, bUdate=sysdate where bNum=?";
		String sql2="select bTitle, bName, bUdate, bHit, bContent from bbs where bNum=?";
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setString(3, bbsdto.getbContent());
			pstmt.setInt(4, bbsdto.getbNum());
			
			pstmt.executeUpdate();
			
			try {
				pstmt = conn.prepareStatement(sql2.toString());
				
				pstmt.setInt(1, bbsdto.getbNum());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					bbsdto.setbNum(bbsdto.getbNum());
					bbsdto.setbTitle(rs.getString(1));
					bbsdto.setbName(rs.getString(2));
					bbsdto.setbUdate(rs.getDate(3));
					bbsdto.setbHit(rs.getInt(4));
					bbsdto.setbContent(rs.getString(5));
				}
			} catch (SQLException e) {
				DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO modify(BbsDTO bbsdto) Select");
				DataBaseUtil.close(conn, pstmt,rs);
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO modify(BbsDTO bbsdto) Update");
		}  finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}

		return bbsdto;
	}
}
