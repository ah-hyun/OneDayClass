package onedayclass;

import java.util.ArrayList;
import java.util.List;

import common.DAO;
import onedaymember.Member;

public class OnedayManage extends DAO {
	
	// 싱글톤
	private static OnedayManage om = new OnedayManage();
	
	private OnedayManage() {
	}
	
	public static OnedayManage getInstance() {
		return om;
	}

	// 클래스 추가
	public int getInsertClass(OnedayClass onedayclass) {
		int result = 0;
		try {
			conn();
			String sql = "insert into onedayclass (class_name,teacher_name) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, onedayclass.getClassName());
			pstmt.setString(2, onedayclass.getTeacherName());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// 클래스 삭제
	public int getDeleteClass(String className) {
		int result = 0;
		try {
			conn();
			String sql = "delete from onedayclass where class_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, className);
		
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// 클래스 변경
	public int getupdateClass(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update onedaymember set class_name = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getClassName());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// 클래스 회원 등록
	public int getInsertMemberClass(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update onedaymember set class_name = ?, class_date = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getClassName());
			pstmt.setString(2, member.getClassDate());
			pstmt.setString(3, member.getMemberId());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return result;
		
		}
		
		public int getClassTableUp(String cname) {	
			int result = 0;
			try {
				conn();
			String sql = "select count(class_name) from onedaymember where class_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(class_name)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}

	
	// 클래스 예약일 변경
	public int getupdateClassDate(Member member) {
	int result = 0;
	try {
		conn();
		String sql = "update onedaymember set class_date = ? where member_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getClassDate());
		pstmt.setString(2, member.getMemberId());
		result = pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		disconnect();
	}
	return result;
}


	// 클래스 시간표
public List<OnedayClass> getClassTimetable() {
	List<OnedayClass> list = new ArrayList<>();
	OnedayClass oc = null;
	try {
		conn();
		String sql = "select class_name, teacher_name from onedayclass where teacher_name is not null";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			oc = new OnedayClass();
			oc.setClassName(rs.getString("class_name"));
			oc.setTeacherName(rs.getString("teacher_name"));
			list.add(oc);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		disconnect();
	}
	return list;
}
}
