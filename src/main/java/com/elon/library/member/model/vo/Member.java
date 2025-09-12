package com.elon.library.member.model.vo;

/* 회원테이블 MEMBER_TBL */
public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String gender;
	private int age;
	private String admin_YN;
	private String member_Active;
	
	public Member() {};
	
	
	
	public Member(String memberId, String memberName, String memberPhone, int age) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.age = age;
	}



	public Member(String memberId, String memberPw, String memberName, String memberPhone, String gender, int age) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.gender = gender;
		this.age = age;
	}



	public Member(String memberId, String memberPw, String memberName, String memberPhone, int age,
			String member_Active) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.age = age;
		this.member_Active = member_Active;
	}

	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public Member(String memberId, String memberPw, String memberName, String memberPhone, String gender, int age,
			String admin_YN, String member_Active) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.gender = gender;
		this.age = age;
		this.admin_YN = admin_YN;
		this.member_Active = member_Active;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPw() {
		return memberPw;
	}



	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberPhone() {
		return memberPhone;
	}



	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getAdmin_YN() {
		return admin_YN;
	}



	public void setAdmin_YN(String admin_YN) {
		this.admin_YN = admin_YN;
	}



	public String getMember_Active() {
		return member_Active;
	}



	public void setMember_Active(String member_Active) {
		this.member_Active = member_Active;
	}



	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + ", gender=" + gender + ", age=" + age + ", admin_YN=" + admin_YN
				+ ", member_Active=" + member_Active + "]";
	}


	
}