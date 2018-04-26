package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import ModelSchool.ClasseModel;

public class ClasseImple implements IClasseDAO {

	@Override
	public int save(ClasseModel classe) {
		// TODO Auto-generated method stub
		int ok =0;
		new SingleConnection();
		Connection con = SingleConnection.getConnection();
		String string = "INSERT INTO classe (nom_classe) VALUES(?)";
		try {
			  PreparedStatement ps = (PreparedStatement) con.prepareStatement(string);
			  ps.setString(1, classe.getNom_classe());
			  ps.executeUpdate();
			  ps.close();
			  ok =1;
			  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ok =0;
		}
	
		return ok;
	}

	@Override
	public int delete(int idc) {
		// TODO Auto-generated method stub
		new SingleConnection();
		Connection con = SingleConnection.getConnection();
		int ok= 0;
		
		String query = "DELETE * FROM classe WHERE id = ?";
		  try {
			 PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			 ps.setInt(1, idc);
			 ps.executeUpdate();
			 ps.close();
			 ok =1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ok =0;
		}
		return ok;
	}

	@Override
	public List<ClasseModel> lisyeClasse() {
		// TODO Auto-generated method stub
		
	List<ClasseModel> listeClasse  = new ArrayList<ClasseModel>();
	Connection con = SingleConnection.getConnection();
	   String query = "SELECT * FROM classe";
	     try {
	    	 PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()){
				    ClasseModel classe = new ClasseModel();
				    classe.setId(rs.getInt("id"));
				    classe.setNom_classe(rs.getString("nom_classe"));
				    listeClasse.add(classe);
			  }
			  ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listeClasse;
	}
	@Override 
	 public ClasseModel getClasseModel(String nom_classe) throws Exception{
		  ClasseModel classe = null;
		  Connection con = SingleConnection.getConnection();
		  String query = "SELECT * FROM classe WHERE nom_classe =?";
		  try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			 ps.setString(1, nom_classe);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				classe = new ClasseModel();
				classe.setId(rs.getInt("id"));
				classe.setNom_classe(rs.getString("nom_classe"));			
			}
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return classe;
		
	}

	@Override
	public int getclasseID(String nom_classe) {
		int id_classe = 0;
		 Connection con = SingleConnection.getConnection();
		  String query = "SELECT id FROM classe WHERE nom_classe LIKE %?%";
		    try {
				  PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
				  ps.setString(1, nom_classe);
				    ResultSet rs = ps.executeQuery();
				       id_classe = rs.getInt("id");
				       if(id_classe==0) throw new Exception("Cette nom bn'existe pas");
			} catch (Exception e) {
				// TODO: handle exception
			}
		return id_classe;
	}

	@Override
	public int modifier(String nomUpdate) {
		int ok=0;
		 Connection con = SingleConnection.getConnection();
		     String query = "UPDATE classe set nom_classe= ?";
		         try {
					    PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
					      ps.setString(1, nomUpdate);
					      ps.executeUpdate();
					      ok = 1;
				       ps.close();	      
				}
		         catch (Exception e) {
					e.printStackTrace();
				}
		return ok;
	}

}
