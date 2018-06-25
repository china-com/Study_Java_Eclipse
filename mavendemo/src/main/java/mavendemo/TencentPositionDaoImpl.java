package mavendemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TencentPositionDaoImpl implements TencentPositionDao{
	public int add(TencentPosition position) {
		String sql = "INSERT INTO tencent_position(p_name, p_link, p_type, p_num, p_location, p_publish_time)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = MySQLUtils.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, position.getPositionName());
			pst.setString(2, position.getPositionLink());
			pst.setString(3, position.getPositionType());
			pst.setString(4, position.getPositionNum());
			pst.setString(5, position.getWorkLocation());
			pst.setString(6, position.getPublishTime());
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					pst = null;
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}
		}
		return 0;
	}

}
