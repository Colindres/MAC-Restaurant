package org.mac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private Connection conexion;
	private Statement stm;
	private static Conexion instancia;
	public static Conexion getInstancia(){
		return (instancia==null)?new Conexion():instancia;
	}
	public Conexion(){
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			conexion=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","mac","1234");
			stm=conexion.createStatement();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void ejecutarConsulta(String consulta){
		try {
			stm.execute(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet obtenerConsulta(String consulta){
		ResultSet resultado=null;
		try {
			resultado=stm.executeQuery(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
}