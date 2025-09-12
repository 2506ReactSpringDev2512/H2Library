package com.elon.library.book.model.vo;

/* 책 테이블 BOOK_TBL */
public class Book {
	private String book_No;
	private String book_Name;
	private String member_Id;
	private String book_Author;
	private String book_Publisher;
	private String lend_YN;
	private String modify_Book;
	
	public Book() {}

	/* admin */
	
	public Book(String book_No, String book_Name, String book_Author, String book_Publisher) {
		super();
		this.book_No = book_No;
		this.book_Name = book_Name;
		this.book_Author = book_Author;
		this.book_Publisher = book_Publisher;
	}
	
	public Book(String book_No, String book_Name, String member_Id, String book_Author, String book_Publisher,
			String lend_YN, String modify_Book) {
		super();
		this.book_No = book_No;
		this.book_Name = book_Name;
		this.member_Id = member_Id;
		this.book_Author = book_Author;
		this.book_Publisher = book_Publisher;
		this.lend_YN = lend_YN;
		this.modify_Book = modify_Book;
	}

	public Book(String book_Name, String book_Author, String book_Publisher) {
		super();
		this.book_Name = book_Name;
		this.book_Author = book_Author;
		this.book_Publisher = book_Publisher;
	}

	/* user*/
	public Book(String book_No, String book_Name, String book_Author, String book_Publisher, String lend_YN) {
		super();
		this.book_No = book_No;
		this.book_Name = book_Name;
		this.book_Author = book_Author;
		this.book_Publisher = book_Publisher;
		this.lend_YN = lend_YN;
	}
	
	/* admin */
	public Book(String book_No, String book_Name, String member_Id, String book_Author, String book_Publisher,
			String lend_YN) {
		super();
		this.book_No = book_No;
		this.book_Name = book_Name;
		this.member_Id = member_Id;
		this.book_Author = book_Author;
		this.book_Publisher = book_Publisher;
		this.lend_YN = lend_YN;
	}

	public String getBook_No() {
		return book_No;
	}

	public void setBook_No(String book_No) {
		this.book_No = book_No;
	}

	public String getBook_Name() {
		return book_Name;
	}

	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public String getBook_Author() {
		return book_Author;
	}

	public void setBook_Author(String book_Author) {
		this.book_Author = book_Author;
	}

	public String getBook_Publisher() {
		return book_Publisher;
	}

	public void setBook_Publisher(String book_Publisher) {
		this.book_Publisher = book_Publisher;
	}

	public String getLend_YN() {
		return lend_YN;
	}

	public void setLend_YN(String lend_YN) {
		this.lend_YN = lend_YN;
	}
	
	public String getModify_Book() {
		return modify_Book;
	}
	
	public void setModify_Book(String modify_Book) {
		this.modify_Book = modify_Book;
	}

	@Override
	public String toString() {
		return "Book [book_No=" + book_No + ", book_Name=" + book_Name + ", member_Id=" + member_Id + ", book_Author="
				+ book_Author + ", book_Publisher=" + book_Publisher + ", lend_YN=" + lend_YN + ", modify_Book="
				+ modify_Book + "]";
	}

}
