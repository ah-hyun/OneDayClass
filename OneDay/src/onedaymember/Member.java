package onedaymember;

import lombok.Getter;
import lombok.Setter;
import onedayclass.OnedayClass;

@Getter
@Setter

public class Member {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberage;
	private String membertel;
	private String role;
	private String className;
	private String teacherName;
	private String classDate;

	@Override
	public String toString() {
		return " ╔═══════════════════════ °• ♥ •° ═════════════════════╗" 
				+ "\n   로그인 ID: " + memberId + "      회원 이름: " + memberName + "\n   회원 나이: "
				+ memberage + "살" + "       회원 전화번호: " + membertel + "\n   속한 클래스: " + className + " 클래스"
				+ "\n   클래스 예약일: " + classDate + 
				"﻿\n ╚══════════════════════ °• ♥ •° ══════════════════════╝";
	}
	
	

}
