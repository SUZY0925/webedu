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
		int cnt = 0;
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
			
			System.out.println("title:"+bbsdto.getbTitle() + " name:"+bbsdto.getbName() +
					" hit:"+bbsdto.getbHit() +" content:"+bbsdto.getbContent());
			
			cnt = pstmt.executeUpdate();
			
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
	
	
	// 글내용 가져오기
	public BbsDTO view(int bNum) {
		BbsDTO bbsdto = new BbsDTO();;
		String sql = "{call Clist_callbbs(?,?,?,?,?,?,?)}";
		
		try {
			conn = DataBaseUtil.getConnection();
			cst = conn.prepareCall(sql);
			
			cst.setInt(1, bNum);
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setDate(4, null);
			cst.setDate(5, null);
			cst.setInt(6, 0);
			cst.setString(7, "");
			
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
         cst.registerOutParameter(3, java.sql.Types.VARCHAR);
         cst.registerOutParameter(4, java.sql.Types.DATE);
         cst.registerOutParameter(5, java.sql.Types.DATE);
         cst.registerOutParameter(6,  java.sql.Types.INTEGER);
         cst.registerOutParameter(7, java.sql.Types.VARCHAR);
         
			cst.executeQuery();
			
			//out BNUM, BTITE, BNAME, BCDATE, BUDATE, BHIT, BCONTent
			bbsdto.setbNum(bNum);
			bbsdto.setbTitle(cst.getString(2));
			bbsdto.setbName(cst.getString(3));
			bbsdto.setbCdate(cst.getDate(4));
			bbsdto.setbUdate(cst.getDate(5));
			bbsdto.setbHit(cst.getInt(6));
			bbsdto.setbContent(cst.getString(7));
			
			System.out.println("BTITE:"+cst.getString(2));
			System.out.println("BNAME:"+cst.getString(3));
			System.out.println("BCDATE:"+cst.getDate(4));
			System.out.println("BUDATE:"+cst.getDate(5));
			System.out.println("BHIT:"+cst.getInt(6));
			System.out.println("BCONTent:"+cst.getString(7));

		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"BbsDTO view(int bNum)");
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
}
