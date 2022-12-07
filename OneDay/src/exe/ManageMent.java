package exe;

import java.util.Scanner;

import onedayclass.OnedayService;
import onedaymember.MemberService;

public class ManageMent {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	OnedayService os = new OnedayService();
	
	int Menu = 0;
	public ManageMent() {
		run();
	}
	private void run() {
		while(true) {
			MenuInfo();
			// 관리자 메뉴창
			if(MemberService.memberInfo.getRole().equals("1")) {
				if(Menu == 1) {
					// 회원 등록
					ms.registerMember();
					
				}else if(Menu == 2) {
					// 클래스 추가/삭제
					System.out.println(" 1. 클래스 추가  |  2. 클래스 삭제");
					
					int menu = Integer.parseInt(sc.nextLine());
					if(menu == 1) {
						// 클래스 추가
						os.insertClass();
					}else if(menu ==2) {
						//클래스 삭제
						os.deleteClass();
					}
					
				}else if(Menu == 3) {
					// 클래스 변경
					os.updateClass();
					
				}else if(Menu == 4) {
					// 회원 조회
					System.out.println(" 1. 단건 조회  |  2. 전체 조회  |  3. 클래스별 조회");
					int menu = Integer.parseInt(sc.nextLine());
					
					// 단건 조회
					if (menu == 1) {
						ms.MemberList();
					}
					else if (menu == 2) {
					// 전체 조회
					ms.TotalMemberList();
					
					}else if (menu == 3) {
					// 클래스별 조회
						ms.ClassList();
					}
					
				}else if(Menu == 5) {
					// 회원 삭제
					ms.deleteMember();
				}else if(Menu == 6) {
					// 종료
					ms.logout();
					new Application();
					break;
				}
			}
			// 회원 메뉴창
			else if(MemberService.memberInfo.getRole().equals("0")) {
				if (Menu == 1) {
					// 정보 조회
					ms.MyList();
				}else if (Menu == 2) {
					// 정보 변경
					System.out.println(" 1. 전화번호 수정  |  2. 비밀번호 수정");
					int menu = Integer.parseInt(sc.nextLine());
					// 전화번호 수정
					if (menu == 1) {
					ms.updateTel();
					}
					else if (menu == 2) {
					// 비밀번호 수정
						ms.updatePw();
					}
				}else if (Menu == 3) {
					// 클래스 등록
					os.insertMemberClass();
				}else if (Menu == 4) {
					// 클래스 예약일 변경
					os.updateClassDate();
				}else if (Menu == 5) {
					// 클래스 시간표
					os.ClassTimetable();
				}else if (Menu == 6) {
					// 종료
					ms.logout();
					
					new Application();
					break;
					}
			
				}
			}
		}
		
	private void MenuInfo() {
		// 관리자
	
		if(MemberService.memberInfo.getRole().equals("1")) {
			System.out.println();
			System.out.println(" 1. 회원 등록  |  2. 클래스 추가/삭제  |  3. 클래스 변경  |  4. 회원 조회"
					+ "  |  5. 회원 삭제  |  6. 뒤로가기 ");
		
		}
		// 회원
		else if(MemberService.memberInfo.getRole().equals("0")) {
			System.out.println();
			System.out.println(" 1. 정보 조회  |  2. 정보 변경  |  3. 클래스 등록  |  4. 클래스 예약일 변경  |  5. 클래스 시간표  |  6. 뒤로가기");
			
		}
		System.out.println(" (っ•ɞ•)っ 번호를 입력해주세요!    =͟͟͞͞➳❥");
		Menu = Integer.parseInt(sc.nextLine());
	
		
	}
	}



