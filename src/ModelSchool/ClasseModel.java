package ModelSchool;

import java.io.Serializable;

public class ClasseModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nom_classe;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_classe() {
		return nom_classe;
	}
	public void setNom_classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}
	public ClasseModel(String nom_classe) {
		super();
		this.nom_classe = nom_classe;
	}
      public ClasseModel(){
    	 
      }
      
}
