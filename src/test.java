import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.EleveImple;
import ModelSchool.EleveModel;;

public class test {

	private static Scanner clavier;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            System.out.println("Entre le nom de la  classe");
            clavier = new Scanner(System.in);
            String nom = clavier.nextLine();
               EleveImple el = new  EleveImple();
               List<EleveModel> listeEleClasse = new ArrayList<EleveModel>();
                listeEleClasse = el.listeEleveClasse(nom);
                if(!listeEleClasse.isEmpty()){
                for(EleveModel ele: listeEleClasse){
                	System.out.println("\n");
                	System.out.println("******************************");
                	System.out.println("\n nom :"+ ele.getNom());
                	System.out.println("\n prenom: "+ ele.getPrenom());
                	System.out.println("\n adresse :" +ele.getAdresse());
                	
                }
                }else System.out.println("Pas d'eleve ou erreu");
             
	}
}
