package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String passworld = "MySQL";

	private Connection conectar(){
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, passworld);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void teste() {
		try {
			Connection con=conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void inserir(JavaBeans contato) {
		String create="INSERT INTO contatos (nome,fone,email) VALUES (?,?,?)";
		try {
			Connection con=conectar();
			PreparedStatement pst=con.prepareStatement(create);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
	}
	
	public ArrayList<JavaBeans> listar(){
		ArrayList<JavaBeans> contatos=new ArrayList<>();
		String read="SELECT*FROM contatos ORDER BY nome";
		try {
			Connection con=conectar();
			PreparedStatement pst=con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String idcon=rs.getString(1);
				String nome=rs.getString(2);
				String fone=rs.getString(3);
				String email=rs.getString(4);
				
				contatos.add(new JavaBeans(idcon,nome,fone,email));
			}
			con.close();
			return contatos;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
