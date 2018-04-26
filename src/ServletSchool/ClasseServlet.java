package ServletSchool;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClasseImple;
import ModelSchool.ClasseModel;

/**
 * Servlet implementation class ClasseServlet
 */
@WebServlet("/ClasseServlet")
public class ClasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public  void init() throws ServletException{
    	//ClasseImple cla = new ClasseImple();
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClasseImple cla = new ClasseImple();
		int okk = 0;
		  List<ClasseModel> liste = cla.lisyeClasse();
		  request.setAttribute("liste", liste);
		    if(request.getParameter("").toString().equals("")){
		    	int idclasse =Integer.parseInt(request.getParameter(""));
		    	ClasseImple c = new ClasseImple();
		    	   c.delete(idclasse);
		    	   okk =1;
		    	   request.setAttribute("messge okk ", okk);    	   
		    }
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///doGet(request, response);$
		try {
			  ClasseModel  cl =new ClasseModel();
				String nom_classe = request.getParameter("nom_classe");
				cl.setNom_classe(nom_classe);
				ClasseImple classe =new 
						  ClasseImple();
				  int res = classe.save(cl);
				  if(res ==1){
					System.out.println("Enregitrement reusiis");
					
				  }else{
					  System.out.println("Echec de l'enregitrement");    
				  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
