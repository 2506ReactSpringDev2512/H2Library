/* 로그인.jsp */
function checkInput_Login() {
	let id = document.getElementById("memberId").value;
	let pw = document.getElementById("memberPw").value;
	if (!id) {
		alert("아이디를 입력해주세요.");
		return false;
	}

	if (!pw) {
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	return true;
}

		