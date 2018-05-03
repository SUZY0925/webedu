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
import com.edu.MemDTO;
import com.edu.bbs.dto.BbsDTO;

public class old_BbsDAO {
	private static old_BbsDAO bdao = new old_BbsDAO();
	
	CallableStatement cst;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private old_BbsDAO() {
		
	}
	
	public static old_BbsDAO getInstance() {
		return bdao;
	}
	
	// 글쓰기
	public void write(BbsDTO bbsdto) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent) ")
		.append("values(bbsnum_seq.nextval,?,?,?,?,bbsnum_seq.currval, 0,0)");
		
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
		sql.append("select bnum, btitle, bname, bhit, bcontent, bcdate, bgroup, bstep, bindent from bbs ")
			.append("order by bgroup desc, bstep asc, bNum desc, bcdate desc");
		
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
					bbsdto.setbGroup(rs.getInt("bGroup"));
					bbsdto.setbStep(rs.getInt("bStep"));
					bbsdto.setbIndent(rs.getInt("bIndent"));
					alist.add(bbsdto);
			}
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> list()");
		} finally {
			DataBaseUtil.close(conn, pstmt,rs);
		}
		return alist;
	}

	public ArrayList<BbsDTO> getList(int startRow, int endRow) {
		ArrayList<BbsDTO> alist = new ArrayList<>();
		BbsDTO bbsdto;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM (SELECT ROWNUM RN, bNum,bTitle,bName,bCdate,bHit FROM ")
			.append("(SELECT * FROM bbs order by bgroup desc, bstep asc, bNum desc, bcdate desc)) WHERE RN BETWEEN ? AND ?");
		
/*		select t2.*
		from (select row_number() over (ORDER BY bgroup desc, bstep asc) as num, t1.*
		                FROM bbs t1) t2
		where num between ? and ?*/

		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
				while(rs.next()) {
					bbsdto = new BbsDTO();
					bbsdto.setbNum(rs.getInt("bNum"));
					bbsdto.setbTitle(rs.getString("bTitle"));
					bbsdto.setbName(rs.getString("bName"));
					bbsdto.setbCdate(rs.getDate("bCdate"));
					bbsdto.setbHit(rs.getInt("bHit"));
					alist.add(bbsdto);
				}
				
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"ArrayList<BbsDTO> getList()");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return alist;
	}
	
	public int getListCount() {
		int count = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from bbs");
		
		try {
         conn = DataBaseUtil.getConnection(); // 커넥션을 얻어옴
         pstmt = conn.prepareStatement(sql.toString());
         
         rs = pstmt.executeQuery();
         if(rs.next()){
            count = rs.getInt(1);
         }
      } catch (SQLException e) {
         DataBaseUtil.printSQLException(e, this.getClass().getName() + " : int getListCount()");
      } finally {
         DataBaseUtil.close(conn, pstmt, rs);
      }
      return count; // 총 레코드 수 리턴
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
	

	// 글수정하기
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
	
	//글삭제하기
	public void delete(int bNum) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from bbs where bNum=?");

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, bNum);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "void delete(int bNum)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	
	// 다음글 이전글 이동
	public BbsDTO pageNav(int bNum, int np) {
		int pageNum = 0;
		BbsDTO bbsdto = new BbsDTO();
		String sql = "";

		if (np == 1) {
			// 이전글
			sql = "select bNum from bbs where bNum=(select max(bNum) from bbs where bNum < ?)";
			try {
				conn = DataBaseUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bNum);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					pageNum = rs.getInt("bNum");
					
					conn.close();
					bbsdto = view(pageNum);
				} else {
					pageNum = bNum;
					
					conn.close();
					bbsdto = view(pageNum);
				}
				
			} catch (SQLException e) {
				DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO pageNav(int bNum, int np) 이전글");
			} finally {
				DataBaseUtil.close(pstmt, rs);
			}
			
		} else {
			// 다음글
			sql = "select bNum from bbs where bNum=(select min(bNum) from bbs where bNum > ?)";
			try {
				conn = DataBaseUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bNum);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					pageNum = rs.getInt("bNum");
					
					conn.close();
					bbsdto = view(pageNum);
				} else {
					pageNum = bNum;
					
					conn.close();
					bbsdto = view(pageNum);
				}
			} catch (SQLException e) {
				DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO pageNav(int bNum, int np) 다음글");
			} finally {
				DataBaseUtil.close(conn, pstmt, rs);
			}
		}
		
		return bbsdto;
	}

	//원글 가져오기
	public BbsDTO replyView(int bNum) {
		BbsDTO bbsdto=null;
		String sql = "select bnum, btitle, bname, bhit,bUdate, bcontent, bgroup, bstep, bindent from bbs where bnum = ?";

		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bbsdto = new BbsDTO();
				bbsdto.setbNum(rs.getInt("bNum"));
				bbsdto.setbTitle(rs.getString("bTitle"));
				bbsdto.setbName(rs.getString("bName"));
				bbsdto.setbHit(rs.getInt("bHit"));
				bbsdto.setbUdate(rs.getDate("bUdate"));
				bbsdto.setbContent(rs.getString("bContent"));
				bbsdto.setbGroup(rs.getInt("bGroup"));
				bbsdto.setbStep(rs.getInt("bStep"));
				bbsdto.setbIndent(rs.getInt("bindent"));
			}
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName() + "BbsDTO replyView(int bNum)");
		} finally {
			DataBaseUtil.close(conn, pstmt, rs);
		}
		return bbsdto;
	}

	// 답글 등록하기
	public void reply(BbsDTO bbsdto) {
		// 이전 답글 step 업데이트
		updateStep(bbsdto.getbGroup(), bbsdto.getbStep());
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bbs (bnum, btitle, bname, bhit, bcontent, bgroup, bstep, bindent) ")
		.append("values(bbsnum_seq.nextval,?,?,?,?,?,?,?)");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, bbsdto.getbTitle());
			pstmt.setString(2, bbsdto.getbName());
			pstmt.setInt(3, bbsdto.getbHit());
			pstmt.setString(4, bbsdto.getbContent());
			pstmt.setInt(5, bbsdto.getbGroup());
			pstmt.setInt(6, bbsdto.getbStep()+1);
			pstmt.setInt(7, bbsdto.getbIndent()+1);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"void reply(BbsDTO bbsdto)");
		} finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}
	
	public void updateStep(int bgroup, int bstep) {
		StringBuffer sql = new StringBuffer();
		sql.append("update bbs set bstep = bstep+1 where bgroup=? and bstep > ?");
		
		try {
			conn = DataBaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, bgroup);
			pstmt.setInt(2, bstep);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			DataBaseUtil.printSQLException(e, this.getClass().getName()+"updateStep(int bgroup, int bstep)");
		}  finally {
			DataBaseUtil.close(conn, pstmt);
		}
	}

}
