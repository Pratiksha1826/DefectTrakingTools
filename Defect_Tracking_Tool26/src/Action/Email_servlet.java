package Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utility.Mailer;

/**
 * Servlet implementation class Email_servlet
 */
@WebServlet("/Email_servlet")
public class Email_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("in  Email_servlet");
		//String from=request.getParameter("from");
		String to=request.getParameter("to");
		System.out.println("to :"+to);
		String msg=request.getParameter("message");
		System.out.println("message:"+msg);
	    try {
			Mailer.send(to,msg);
			//RequestDispatcher rb= request.getRequestDispatcher("views/AddUser.jsp");
			 // rb.forward(request, response);
			response.sendRedirect("views/AddUser.jsp");

			  System.out.println("message send successfuly");
		} catch (Exception e) {
			System.out.println("------------------in Email_servlet");
			e.printStackTrace();
		}  
	  	    
		
	}

}
