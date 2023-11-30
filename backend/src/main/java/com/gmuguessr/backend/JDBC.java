package com.gmuguessr.backend;

import java.sql.*;

public class JDBC {
	private static Connection conn = null;

	public static void connect() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://aws.connect.psdb.cloud/mason-maps?sslMode=VERIFY_IDENTITY",
				"l88a7qc1qgrvghik02nf",
				"pscale_pw_78wgdyn68VMRCHepSi84I2wGM9L2kAH3JatZU4uz2Qt");

		JDBC.conn = conn;
	}

	public static void disconnect() throws SQLException {
		conn.close();
	}

	public static ResultSet query(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
}
