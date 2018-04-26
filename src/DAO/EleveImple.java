package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import ModelSchool.EleveModel;

public class EleveImple implements IEleveDAO {

	@Override
	public int save(EleveModel eleve) {
		// TODO Auto-generated method stub
		int ok = 0;
		new SingleConnection();
		Connection con = SingleConnection.getConnection();
		String query = "INSERT INTO eleve (nom, prenom, adresse, id_classe) VALUES(?, ?, ?, ?)";
		  try {
			  PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			    ps.setString(1, eleve.getNom());
			    ps.setString(2, eleve.getPrenom());
			    ps.setString(3, eleve.getAdresse());
			    ps.setInt(4, eleve.getIdclasse());
			    ps.executeUpdate();
			    ps.close();
			    ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		   
		return ok;
	}

	@Override
	public int delete(int idE) {
	int ok = 0;	
	    String query = "DELETE * FROM eleve WHERE id= ?";
	    Connection con = SingleConnection.getConnection();
	      try {
			  PreparedStatement ps =(PreparedStatement) con.prepareStatement(query);
			  ps.setInt(1, idE);
			  ps.executeUpdate();
			  ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			ok =0;
		}
		return ok;
	}

	@Override
	public List<EleveModel> listeEleve() {
		List<EleveModel> listeEle = new ArrayList<EleveModel>();
		Connection con = SingleConnection.getConnection();
		String query = "SELECT * FROM eleve";
		try {
			  PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()){
				  EleveModel eleve = new EleveModel();
				  eleve.setId(rs.getInt("id"));
				  eleve.setAdresse(rs.getString("adresse"));
				  eleve.setNom(rs.getString("nom"));
				  eleve.setPrenom(rs.getString("prenom"));
				  listeEle.add(eleve);
			  }
			  ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listeEle;
	}

	@Override
	public List<EleveModel> listeEleveClasse(String nom_classe) {
		// TODO Auto-generated method stub
		List<EleveModel> listeEleClasse = new ArrayList<EleveModel>();
		Connection con = SingleConnection.getConnection();
		String query = "SELECT * FROM eleve WHERE id_classe=(SELECT id FROM classe WHERE nom_classe = ?)";
		try {
			 PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			 ps.setString(1, nom_classe);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 EleveModel eleve = new EleveModel();
				 eleve.setId(rs.getInt("id"));
				 eleve.setNom(rs.getString("nom"));
				 eleve.setPrenom(rs.getString("prenom"));
				 eleve.setAdresse(rs.getString("adresse"));
				 listeEleClasse.add(eleve);
			 }
			 if(listeEleClasse == null) throw new Exception("Pas d'eleve dans la classe donnée");
			 ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listeEleClasse;
	}
   
	

}
