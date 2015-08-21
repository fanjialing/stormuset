package org.storm.uset.db.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *  h2数据库帮助类
 *  引用jar包
 *   <dependency>
 *	<groupId>com.h2database</groupId>
 *	<artifactId>h2</artifactId>
 *	<version>1.4.187</version>
 *	</dependency> 
 * 
 * @author fanjialing
 *
 */
public class H2Helper {
	//获取文件路径
	public static final	String  USER_DIR  = System.getProperty("user.dir")+"/data/";
    //h2 驱动包名
	public static final String  H2_DRIVER = "org.h2.Driver";
    //h2 jdbc
	public static final String  H2_JDBC = "jdbc:h2:";
    //h2 数据库名
	public static final String  H2_DATABASE_NAME= "im";
	
	/**
	 * 获取 H2 数据库连接,并创建数据库
	 * @return
	 */
	public static Connection getConnection(){
		   Connection conn = null;
		   try {
			Class.forName(H2_DRIVER);
			conn = DriverManager.getConnection(H2_JDBC+USER_DIR+H2_DATABASE_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		   return conn;
	}
	
	public static void main(String[] args) {
		Connection connection = H2Helper.getConnection();
		System.out.println(connection);
	}
}
