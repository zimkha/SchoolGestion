package DAO;
import java.util.List;

import ModelSchool.EleveModel;
public interface IEleveDAO {

public int save(EleveModel eleve);
public int delete(int idE);
public List<EleveModel> listeEleve();
public List<EleveModel> listeEleveClasse(String nom_classe);

}
