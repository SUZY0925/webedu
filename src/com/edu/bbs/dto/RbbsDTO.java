package com.edu.bbs.dto;

import java.util.Date;

public class RbbsDTO {
	private int rnum, bnum, rgood, rbad, rgroup, rstep, rindent;
	private String rid, rname, rcontent;
	private Date rcdate, rudate;
	
	public RbbsDTO() {
		
	}
	
	public RbbsDTO(int rnum, int bnum, int rgood, int rbad, int rgroup, int rstep, int rindent, String rid, String rname,
			String rcontent, Date rcdate, Date rudate) {
		super();
		this.rnum = rnum;
		this.bnum = bnum;
		this.rgood = rgood;
		this.rbad = rbad;
		this.rgroup = rgroup;
		this.rstep = rstep;
		this.rindent = rindent;
		this.rid = rid;
		this.rname = rname;
		this.rcontent = rcontent;
		this.rcdate = rcdate;
		this.rudate = rudate;
	}



	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getRgood() {
		return rgood;
	}
	public void setRgood(int rgood) {
		this.rgood = rgood;
	}
	public int getRbad() {
		return rbad;
	}
	public void setRbad(int rbad) {
		this.rbad = rbad;
	}
	public int getRgroup() {
		return rgroup;
	}
	public void setRgroup(int group) {
		this.rgroup = group;
	}
	public int getRstep() {
		return rstep;
	}
	public void setRstep(int rstep) {
		this.rstep = rstep;
	}
	public int getRindent() {
		return rindent;
	}
	public void setRindent(int rindent) {
		this.rindent = rindent;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public Date getRcdate() {
		return rcdate;
	}
	public void setRcdate(Date rcdate) {
		this.rcdate = rcdate;
	}
	public Date getRudate() {
		return rudate;
	}
	public void setRudate(Date rudate) {
		this.rudate = rudate;
	}
	@Override
	public String toString() {
		return "RbbsDTO [rnum=" + rnum + ", bnum=" + bnum + ", rgood=" + rgood + ", rbad=" + rbad + ", rgroup=" + rgroup
				+ ", rstep=" + rstep + ", rindent=" + rindent + ", rid=" + rid + ", rname=" + rname + ", rcontent="
				+ rcontent + ", rcdate=" + rcdate + ", rudate=" + rudate + "]";
	}
	
	
}
