package ServletSchool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import DAO.ClasseImple;
import DAO.EleveImple;
import ModelSchool.ClasseModel;
import ModelSchool.EleveModel;

/**
 * Servlet implementation class EleveServlet
 * 
 */
@WebServlet("/EleveServlet")
public class EleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClasseImple cla = new ClasseImple();
		  List<ClasseModel> liste = cla.lisyeClasse();
		  EleveImple im = new EleveImple();
		     List<EleveModel> lis = im.listeEleve();
		  request.setAttribute("liste", liste);
		    request.setAttribute("elevelise", lis);	     
		  this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutEleve.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int refor = 0;
		try {
			  EleveModel ele = new EleveModel();
			  ele.setPrenom(request.getParameter("prenom"));
			  ele.setNom(request.getParameter("nom"));
			  ele.setAdresse(request.getParameter("adresse"));
			  int  id_classe = Integer.parseInt(request.getParameter("id_classe"));
			  ele.setIdclasse(id_classe);
			  EleveImple im_el = new EleveImple();
			  int ok = im_el.save(ele);
			  if(ok!=1) throw new IOException("L'enregistrement a echoue");
			  this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutEleve.jsp").forward(request, response);	
		     } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		     if(request.getParameter("search").toString().equals("Seacrh")){
		    	   String nom_classe = request.getParameter("search_nomclasse");
		    	   refor = 1;
		    	   request.setAttribute("message ", refor);
		     }
	}
}
