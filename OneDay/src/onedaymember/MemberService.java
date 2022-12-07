package onedaymember;

import java.util.List;
import java.util.Scanner;

import onedayclass.OnedayClass;

public class MemberService {

	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);

	// 회원가입
	public void signIn() {
		Member member = new Member();
		
		System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
		String id = sc.nextLine();
	
		System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 PW를 입력해주세요!    =͟͟͞͞➳❥");
		String pw = sc.nextLine();
		
		System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 이름을 입력해주세요!    =͟͟͞͞➳❥");
		String name = sc.nextLine();
		
		System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 나이를 입력해주세요!    =͟͟͞͞➳❥");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 전화번호를 입력해주세요!    =͟͟͞͞➳❥");
		String tel = sc.nextLine();
		
		member.setMemberId(id);
		member.setMemberPw(pw);
		member.setMemberName(name);
		member.setMemberage(age);
		member.setMembertel(tel);
		member.setRole("0");
		
		int result = MemberManage.getInstance().getsignIn(member);
		
		if (result == 1) {
			System.out.println(" ଘ(๑• ө•)۶ෆ 정상적으로 회원가입이 완료 되었습니다! ");
		}else {
			System.out.println(" •᷄ ɞ•᷅  회원가입이 실패하였습니다. 재등록 해주세요!");
		}
}

	
	
	// 로그인
	public void doLogin() {
		Member member = new Member();
		System.out.println(" (っ•ɞ•)っ 접속할 ID를 입력해주세요!    =͟͟͞͞➳❥");
		String id = sc.nextLine();
		System.out.println(" (っ•ɞ•)っ 접속할 PW를 입력해주세요!    =͟͟͞͞➳❥");
		String pw = sc.nextLine();

		member = MemberManage.getInstance().getloginInfo(id);

		if (member != null && member.getMemberId().equals(id) && member.getMemberPw().equals(pw)) {
			memberInfo = member;
			System.out.println(" ₊⋆｡ﾟ☁︎｡⋆｡ ﾟ☾ ﾟ｡⋆ "+ memberInfo.getMemberName() +"님, 환영합니다! ⋆⁺₊⋆ ☾ ⋆⁺₊⋆ ☁︎");
			return;
		} else if (member == null){
			System.out.println(" •᷄ ɞ•᷅  존재하지 않는 ID입니다! 로그인 ID를 다시 확인해주세요.. ");
			return;
		}else if (member.getMemberId().equals(id) && !member.getMemberPw().equals(pw)) {
			System.out.println(" •᷄ ɞ•᷅  잘못된 PW입니다! 로그인 PW를 다시 확인해주세요.. ");
			return;
		}
	}
		
	// 로그아웃
	public void logout() {
		if(memberInfo != null) {
		memberInfo = null;
		
		}
	}
		// 고객 등록
		public void registerMember() {
			Member member = new Member();
			System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
			String id = sc.nextLine();
			
			System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 PW를 입력해주세요!    =͟͟͞͞➳❥");
			String pw = sc.nextLine();
			
			System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 이름을 입력해주세요!    =͟͟͞͞➳❥");
			String name = sc.nextLine();
			
			System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 나이를 입력해주세요!    =͟͟͞͞➳❥");
			int age = Integer.parseInt(sc.nextLine());
			
			System.out.println(" (っ•ɞ•)っ 등록하실 회원님의 전화번호를 입력해주세요!    =͟͟͞͞➳❥");
			String tel = sc.nextLine();
			
			member.setMemberId(id);
			member.setMemberPw(pw);
			member.setMemberName(name);
			member.setMemberage(age);
			member.setMembertel(tel);
			member.setRole("0");
			
			int result = MemberManage.getInstance().getregisterMember(member);
			
			if (result == 1) {
				System.out.println(" ଘ(๑• ө•)۶ෆ 회원 정보가 정상적으로 등록 되었습니다! ");
			}else {
				System.out.println(" •᷄ ɞ•᷅  회원정보가 등록되지 않았습니다! ");
			}
			
		}
	
		// 회원 전체 조회
		public void TotalMemberList() {
			List<Member> list = MemberManage.getInstance().getTotalMemberList();
			for(Member member : list) {
				System.out.println(member.toString());
				System.out.println();
			}
		}
					
		// 회원 단건 조회
		public void MemberList() {
			System.out.println(" (っ•ɞ•)っ 조회하실 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
			String id = sc.nextLine();
			Member member = MemberManage.getInstance().getMemberList(id);
	
			if(member == null) {
				System.out.println(" •᷄ ɞ•᷅  등록되지 않은 ID입니다. ");
			}else {
				System.out.println(member.toString());
			}
		}
		
		// 회원 클래스별 조회
			public void ClassList() {
					System.out.println(" (っ•ɞ•)っ 조회하실 클래스의 이름을 입력해주세요!    =͟͟͞͞➳❥");
					String cname = sc.nextLine();
			List<Member> list = MemberManage.getInstance().getClassList(cname);
			for(Member member : list) {
				System.out.println(member.toString()); 
			
			}
				}
			
		// 회원 정보 조회
		public void MyList() {
			List<Member> list = MemberManage.getInstance().getMyList(MemberService.memberInfo.getMemberId());
		System.out.println(MemberService.memberInfo.getMemberName() + " 님의 회원 정보.•♥"
				+ "	*゜    (\\ (\\\r\n"
				+ "			 c(⌒(_*´ㅅ`)_\r\n");
		for (Member member : list) {
			System.out.println(member.toString());
		}
		}
		
		// 회원 정보 변경 (전화번호)
		public void updateTel() {
			Member member = new Member();
			System.out.println(" (っ•ɞ•)っ 정보를 변경할 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
			String memberid = sc.nextLine();
			
			System.out.println(" (っ•ɞ•)っ 현재 회원님의 PW를 입력해주세요!    =͟͟͞͞➳❥");
			String memberpw = sc.nextLine();
			
			System.out.println(" (っ•ɞ•)っ 변경하실 회원님의 전화번호를 입력해주세요!    =͟͟͞͞➳❥");
			String membertel = sc.nextLine();
			
			member.setMemberId(memberid);
			member.setMemberPw(memberpw);
			member.setMembertel(membertel);
			int result = MemberManage.getInstance().getupdateTel(member);
			
			if (result == 1) {
				System.out.println(" (๑•̀ ਊ•́) 입력하신 정보가 정상적으로 수정되었습니다! ");
			}else {
				System.out.println(" •᷄ ɞ•᷅  입력하신 정보가 수정되지 않았습니다! ");
			}
			
		}
		// 회원 정보 변경 (비밀번호)
		public void updatePw() {
			Member member = new Member();
			System.out.println(" (っ•ɞ•)っ 정보를 변경할 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
			String memberid = sc.nextLine();
					
			System.out.println(" (っ•ɞ•)っ 현재 회원님의 PW를 입력해주세요!    =͟͟͞͞➳❥");
			String memberpw = sc.nextLine();
			
			System.out.println(" (っ•ɞ•)っ 변경하실 회원님의 PW를 입력해주세요!    =͟͟͞͞➳❥");
			String uppw = sc.nextLine();
					
			member.setMemberId(memberid);
			member.setMemberPw(memberpw);
			member.setMemberPw(uppw);
			int result = MemberManage.getInstance().getupdatePw(member);
					
			if (result == 1) {
				System.out.println(" (๑•̀ ਊ•́) 입력하신 정보가 정상적으로 수정되었습니다! ");
			}else {
				System.out.println(" •᷄ ɞ•᷅  입력하신 정보가 수정되지 않았습니다! ");
			}
					
				}
		// 회원 삭제
		public void deleteMember() {
			System.out.println(" (っ•ɞ•)っ 삭제하실 회원님의 ID를 입력해주세요!    =͟͟͞͞➳❥");
			String member = sc.nextLine();
			
			int result = MemberManage.getInstance().getdeleteMember(member);
		
			if (result == 1) {
				System.out.println(" (๑•̀ ਊ•́) 입력하신 회원의 정보가 삭제되었습니다! ");
			}else {
				System.out.println(" •᷄ ɞ•᷅  입력하신 회원의 정보가 삭제되지 않았습니다! ");
			}
		}
}
