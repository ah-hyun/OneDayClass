package onedayclass;

import java.util.List;
import java.util.Scanner;

import onedaymember.Member;
import onedaymember.MemberManage;
import onedaymember.MemberService;


public class OnedayService {
	Scanner sc = new Scanner(System.in);
	
	// 클래스 추가
	public void insertClass() {
		OnedayClass oc = new OnedayClass();
		System.out.println(" (っ•ɞ•)っ 추가할 클래스의 이름을 입력해주세요!    =͟͟͞͞➳❥");
		String cname = sc.nextLine();
		
		System.out.println(" (っ•ɞ•)っ 강사님의 이름을 입력해주세요!    =͟͟͞͞➳❥");
		String tname = sc.nextLine();
		
		oc.setClassName(cname);
		oc.setTeacherName(tname);
		
		int result = OnedayManage.getInstance().getInsertClass(oc);
		
		if (result == 1) {
			System.out.println(" ଘ(๑• ө•)۶ෆ 입력하신 클래스가 추가 되었습니다! ");
		}else {
			System.out.println(" •᷄ ɞ•᷅  입력하신 클래스가 추가되지 않았습니다! ");
		}
	}
	
	
	// 클래스 삭제
	public void deleteClass() {
		System.out.println(" (っ•ɞ•)っ 삭제할 클래스의 이름을 입력해주세요!    =͟͟͞͞➳❥");
		String cname = sc.nextLine();
		
		int result = OnedayManage.getInstance().getDeleteClass(cname);
	
		if (result == 1) {
			System.out.println(" ଘ(๑• ө•)۶ෆ 입력하신 클래스가 삭제 되었습니다! ");
		}else {
			System.out.println(" •᷄ ɞ•᷅  입력하신 클래스가 삭제되지 않았습니다! ");
		}
	}
	
	// 클래스 변경
	public void updateClass() {
		Member member = new Member();
	try {
	System.out.println(" (っ•ɞ•)っ 클래스를 변경할 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
	String memberid = sc.nextLine();
	
	System.out.println(" (っ•ɞ•)っ 변경하실 클래스의 이름을 입력해주세요!    =͟͟͞͞➳❥");
	System.out.println(" 1. 비누공예  |  2. 유화아트  |  3. 도자기  |  4. 마카롱  |  5. 터프팅");
	String cname = sc.nextLine();
	
	if(cname.equals("비누공예")) {
		member.setClassName("비누공예");
		member.setMemberId(memberid);
		member.setClassName(cname);
		member.setTeacherName("최지현");
		
	}else if (cname.equals("유화아트")){
		member.setClassName("유화아트");
		member.setMemberId(memberid);
		member.setClassName(cname);
		member.setTeacherName("최진영");
		
		
	}else if (cname.equals("도자기")){
		member.setClassName("도자기");
		member.setMemberId(memberid);
		member.setClassName(cname);
		member.setTeacherName("이효진");
		
	}else if (cname.equals("마카롱")){
		member.setClassName("마카롱");
		member.setMemberId(memberid);
		member.setClassName(cname);
		member.setTeacherName("박수영");
		
	}else if (cname.equals("터프팅")){
		member.setClassName("터프팅");
		member.setMemberId(memberid);
		member.setClassName(cname);
		member.setTeacherName("이나영");
	}
		
	int result = OnedayManage.getInstance().getupdateClass(member);
	
	if (result == 1) {
		System.out.println(" ଘ(๑• ө•)۶ෆ 입력하신 정보가 정상적으로 변경 되었습니다! ");
	}else {
		System.out.println(" •᷄ ɞ•᷅  입력하신 정보가 수정되지 않았습니다! ");
	}
	} catch(Exception e) {
		System.out.println(" •᷄ ɞ•᷅  존재하지 않는 클래스입니다. 새로 작성해주세요! ");
	}
	}
	
	// 클래스 회원등록
	public void insertMemberClass() {
		Member member = new Member();
		OnedayClass oc = new OnedayClass();
		
		member.setMemberId(MemberService.memberInfo.getMemberId());
		try {
		System.out.println(" (っ•ɞ•)っ 등록하실 클래스의 번호를 입력해주세요!    =͟͟͞͞➳❥");
		System.out.println(" 1. 비누공예  |  2. 유화아트  |  3. 도자기  |  4. 마카롱  |  5. 터프팅");
		int cNum = Integer.parseInt(sc.nextLine());
		String cname ="";
		
		System.out.println(" (っ•ɞ•)っ 회원님의 이름을 입력해주세요!    =͟͟͞͞➳❥");
		String name = sc.nextLine();
		System.out.println(" (っ•ɞ•)っ 클래스를 수강할 예약일을 입력해주세요!    =͟͟͞͞➳❥");
		String cdate = sc.nextLine();
		
		if(cNum == 1) {
			member.setClassName("비누공예");
			cname = "비누공예";
			member.setMemberName(name);
			member.setClassDate(cdate);
			member.setTeacherName("최지현");
			
		}else if (cNum == 2){
			member.setClassName("유화아트");
			cname = "유화아트";
			member.setMemberName(name);
			member.setClassDate(cdate);
			member.setTeacherName("최진영");
			
		}else if (cNum == 3){
			member.setClassName("도자기");
			cname = "도자기";
			member.setMemberName(name);
			member.setClassDate(cdate);
			member.setTeacherName("이효진");
			
		}else if (cNum == 4){
			member.setClassName("마카롱");
			cname = "마카롱";
			member.setMemberName(name);
			member.setClassDate(cdate);
			member.setTeacherName("박수영");
			
		}else if (cNum == 5){
			member.setClassName("터프팅");
			cname = "터프팅";
			member.setMemberName(name);
			member.setClassDate(cdate);
			member.setTeacherName("이나영");
		}
		
		int result = OnedayManage.getInstance().getClassTableUp(cname);
				
		if(member.getClassDate().equals(cdate) && result >= 6) {
			System.out.println(" •᷄ ɞ•᷅  수강 인원이 다 찼습니다. 다른 클래스를 선택해주세요!");
		}else {
		
		int result2 = OnedayManage.getInstance().getInsertMemberClass(member);
		
		if(result2 == 1) {
			System.out.println(" (๑•̀ ਊ•́) 회원님의 예약이 정상적으로 등록 되었습니다! ");
	
		}else {
			System.out.println(" •᷄ ɞ•᷅  회원님의 예약이 등록되지 않았습니다! ");
		}
		}
		} catch(Exception e) {
			System.out.println(" •᷄ ɞ•᷅  존재하지 않는 클래스입니다. 새로 작성해주세요! ");
		}

	
	}
		
	
	// 클래스 예약일 변경
	public void updateClassDate() {
		Member member = new Member();
		
		System.out.println(" (っ•ɞ•)っ 예약일을 변경할 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
		String memberid = sc.nextLine();
		
		System.out.println(" (っ•ɞ•)っ 변경하실 예약일을 입력해주세요!    =͟͟͞͞➳❥");
		String cdate = sc.nextLine();
		
		member.setMemberId(memberid);
		member.setClassDate(cdate);
		
		int result = OnedayManage.getInstance().getupdateClassDate(member);
		
		if (result == 1) {
			System.out.println(" (๑•̀ ਊ•́) 입력하신 정보가 정상적으로 수정 되었습니다! ");
		}else {
			System.out.println(" •᷄ ɞ•᷅  입력하신 정보가 수정되지 않았습니다! ");
		}
	}
	
	// 클래스 시간표
	public void ClassTimetable() {
		List<OnedayClass> list = OnedayManage.getInstance().getClassTimetable();
		System.out.println("╔═════════════════════════════━━━─── • ───━━━══════════════════════════════╗");
		System.out.println("       월      |       화      |       수      |      목    　|       금       ");
		for(OnedayClass oc : list) {
			System.out.printf("%5s %-6s", oc.getClassName()," 클래스");
			
				
		}
		System.out.println();
		for(OnedayClass oc : list) {
			System.out.printf("%5s %-6s",oc.getTeacherName(), " 강사님");
			
		}
		
		System.out.println();
		System.out.println("╚═════════════════════════════━━━─── • ───━━━══════════════════════════════╝");
		
			
	}
	}
	
	
