package DAO;

import java.util.List;

import ModelSchool.ClasseModel;

public interface IClasseDAO {
    public int save (ClasseModel classe);
    public int delete(int idc);
    public List<ClasseModel> lisyeClasse();
    public ClasseModel getClasseModel(String nom_classe) throws Exception;
    public int getclasseID(String nom_classe);
    public int modifier(String nomUpdate);
}
