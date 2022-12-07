package exe;

import java.util.Scanner;

import onedaymember.MemberService;

public class Application {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	int Menu = 0;
	
	public Application() {
		run();
	}
	
	

	private void run() {
		boolean t = true;
		System.out.println();
		System.out.println("   안녕하세요! 프로그램 도우미 오리입니다!  ଘ(๑• ө•)۶ෆ ");
		System.out.println();
		System.out.println(" (っ•ɞ•)っ 번호를 선택해주세요!    =͟͟͞͞➳❥");
		System.out.println("   1. 회원가입    |    2. 로그인     |   3. 프로그램 종료");
		while(t) {
			Menu = Integer.parseInt(sc.nextLine());

		switch (Menu) {
		case 1 :
			ms.signIn();
			if (MemberService.memberInfo != null) {
				new ManageMent();
			break;
			}
				
		case 2:
			ms.doLogin();
			if (MemberService.memberInfo != null) {
				new ManageMent();
				break;
			}
			
			
		case 3:
			System.out.println(" bye ~ ฅ₍⁻ʚ⁻₎ 프로그램을 종료합니다.");
			t = false;
			break;
		}
		}
	}

}
