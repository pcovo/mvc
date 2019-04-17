package br.com.ccee.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle; 

public class Conexao {

	private static Connection con = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("config");

	public static Connection getConnection() {
		try {
			if(con == null || con.isClosed()) {
				try{  
					Class.forName(rb.getString("class.forName.oracle"));  
					con=DriverManager.getConnection(rb.getString("driver.manager.oracle"),rb.getString("oracle.usr"),rb.getString("oracle.pwd"));  
					return con;
				}catch(Exception e){
					System.out.println("Erro ao Criar Conexão");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}  
}