package com.elon.library.lend.model.vo;

import java.sql.Date;

public class Rent {
	private String memberId;
	private String bookNo;
	private Date lendDate;
	private Date returnDate;
	private String bookName;
	private String author;
	private String publisher;
	private String lendYn;
	private String returnYn;
	
	public Rent() {}

	
	
	public Rent(String memberId, String bookNo, Date lendDate, Date returnDate, String bookName, String author,String publisher,String lendYn,String returnYn) {
		this.memberId = memberId;
		this.bookNo = bookNo;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.lendYn = lendYn;
		this.returnYn = returnYn;
	}



	public Rent(String memberId, String bookNo, Date lendDate, Date returnDate, String bookName) {
		this.memberId = memberId;
		this.bookNo = bookNo;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.bookName = bookName;
	}
	
	
	
	public String getReturnYn() {
		return returnYn;
	}
	public void setReturnYn(String returnYn) {
		this.returnYn = returnYn;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLendYn() {
		return lendYn;
	}
	public void setLendYn(String lendYn) {
		this.lendYn = lendYn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
