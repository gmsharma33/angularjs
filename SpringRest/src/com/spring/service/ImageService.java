package com.spring.service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sharma
 *
 */
@RestController
public class ImageService {

	private static Connection connection = null;

	/**
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	@RequestMapping(value = "/image", method = RequestMethod.GET)
	@CrossOrigin
	public @ResponseBody String getImageFromDB() throws SQLException, IOException {
		String sql = "SELECT * FROM MY_IMAGES";
		Connection oracleConnection = getConnection();
		PreparedStatement preStmt = oracleConnection.prepareStatement(sql);
		ResultSet resultSet = preStmt.executeQuery();
		byte[] bytes = null;
		while (resultSet.next()) {
			Blob blob = resultSet.getBlob("IMG");
			bytes = blob.getBytes(1, (int) blob.length());
			/*os = new FileOutputStream(file + File.separator + title + ".JPG");
			os.write(bytes);
			os.flush();
			os.close();*/
		}
		oracleConnection.close();
		connection = null;
		return new String(bytes);
	}

	/**
	 * @return
	 */
	private Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:TESTDB", "sharma",
					"password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
