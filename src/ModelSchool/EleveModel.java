package ModelSchool;

import java.io.Serializable;

public class EleveModel implements Serializable {
	private static final long serialVersionUID = 1L;
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private int id_classe;
    
    public EleveModel(){
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getIdclasse() {
		return id_classe;
	}

	public void setIdclasse(int id_classe) {
		this.id_classe = id_classe;
	}

	public EleveModel(String nom, String prenom, String adresse, int id_classe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.id_classe = id_classe;
	}
    
    
}
