package onedaymember;

import java.nio.file.attribute.AclEntry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.util.List;

import common.DAO;
import onedayclass.OnedayClass;
import onedayclass.OnedayManage;

public class MemberManage extends DAO{
	
	// 싱글톤
	private static MemberManage mm = new MemberManage();
	
	private MemberManage() {
	}
	
	public static MemberManage getInstance() {
		return mm;
	}
	OnedayClass oc = new OnedayClass();
	
	// 회원가입
	public int getsignIn (Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into onedaymember (member_id, member_pw,"
					+ "member_name, member_age, member_tel, member_role) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberage());
			pstmt.setString(5, member.getMembertel());
			pstmt.setString(6, member.getRole());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}



	
	// 로그인
	
	public Member getloginInfo(String id) {
		Member member = null;
		try {
			conn();
			String sql = "select * from onedaymember where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 member = new Member();
				 
				 member.setMemberId(rs.getString("member_id"));
				 member.setMemberPw(rs.getString("member_pw"));
				 member.setMemberName(rs.getString("member_name"));
				 member.setRole(rs.getString("member_role"));
				 member.setMembertel(rs.getString("member_tel"));
				 member.setMemberage(rs.getInt("member_age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
	// 멤버 등록
	public int getregisterMember (Member member) {
		int result = 0;
		try {
			conn();
			String sql = "insert into onedaymember (member_id, member_pw, "
					+ "member_name, member_age, member_tel, member_role) values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberage());
			pstmt.setString(5, member.getMembertel());
			pstmt.setString(6, member.getRole());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	

	// 회원 전체 조회
	public List<Member> getTotalMemberList() {
		List<Member> list = new ArrayList<>();
		Member member=null;
		try {
			conn();
			String sql = "select * from onedaymember";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				member = new Member();
				
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberage(rs.getInt("member_age"));
				member.setMembertel(rs.getString("member_tel"));
				member.setClassName(rs.getString("class_name"));
				member.setClassDate(rs.getString("class_date"));
				
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	// 회원 단건 조회
	public Member getMemberList(String Id) {
		Member member = null;
		try {
			conn();
			String sql = "select onedaymember.member_id, onedaymember.member_name,\r\n"
					+ "onedaymember.member_age, onedaymember.member_tel, onedaymember.class_name,\r\n"
					+ "onedaymember.class_date, onedayclass.class_name\r\n"
					+ "from onedaymember join onedayclass\r\n"
					+ "on onedaymember.class_name = onedayclass.class_name where onedaymember.member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberage(rs.getInt("member_age"));
				member.setMembertel(rs.getString("member_tel"));
				member.setClassName(rs.getString("class_name"));
				member.setClassDate(rs.getString("class_date"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
	
	// 회원 클래스별 조회
	public List<Member> getClassList(String cname) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select onedaymember.member_id, onedaymember.member_name,\r\n"
					+ "onedaymember.member_age, onedaymember.member_tel, onedaymember.class_name,\r\n"
					+ "onedaymember.class_date, onedayclass.class_name\r\n"
					+ "from onedaymember join onedayclass\r\n"
					+ "on onedaymember.class_name = onedayclass.class_name\r\n "
					+ "where onedayclass.class_name = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberage(rs.getInt("member_age"));
				member.setMembertel(rs.getString("member_tel"));
				member.setClassName(rs.getString("class_name"));
				member.setClassDate(rs.getString("class_date"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	// 회원 정보 조회
	public List<Member> getMyList(String memberId) {
		List<Member> list = new ArrayList<>();
		Member member = null;
		try {
			conn();
			String sql = "select onedaymember.member_id, onedaymember.member_name,\r\n"
					+ "onedaymember.member_age, onedaymember.member_tel, onedaymember.class_name, onedaymember.class_date,\r\n"
					+ "onedayclass.class_name\r\n"
					+ "from onedaymember join onedayclass\r\n"
					+ "on onedaymember.class_name = onedayclass.class_name where onedaymember.member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberage(rs.getInt("member_age"));
				member.setMembertel(rs.getString("member_tel"));
				member.setClassName(rs.getString("class_name"));
				member.setClassDate(rs.getString("class_date"));
				
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	// 회원 정보 변경 (전화번호)
	public int getupdateTel(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update onedaymember set member_tel = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMembertel());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// 회원 정보 변경 (비밀번호)
	public int getupdatePw(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update onedaymember set member_pw = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// 회원 삭제
	public int getdeleteMember(String id) {
		int result = 0;
		try {
			conn();
			String sql = "delete from onedaymember where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
}
