package order_reg.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostel_reg.beans.User;
import hostel_reg.dao.UserDao;


/**
 * Servlet implementation class UserSevlet
 */
@WebServlet({"/users", "/users/delete", "/users/update"})
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().equals("/users/delete")) {
			String id = request.getParameter("id");
			
			UserDao dao = new UserDao();
		    int result = dao.delete(id);
		      
		    if (result > 0) {
		    	response.sendRedirect("../users.jsp");
		    } else {
		    	response.getWriter().print("error");
		    }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
      
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		u.setUsername(user);
		u.setPassword(pass);
      
		UserDao dao = new UserDao();
		int result = 0;
      
		switch(request.getServletPath()) {
      		case "/users":
      			result = dao.insert(u);
      		
      			if (result > 0) {
      				response.sendRedirect("users.jsp");
      			}
      			break;
      		case "/users/update":
      			int id = Integer.parseInt(request.getParameter("id"));
      			u.setId(id);
      			result = dao.update(u);
      		
      			if (result > 0) {
      				response.sendRedirect("../users.jsp");
      			}
      			break;
		}
      
		response.getWriter().print("error");
	}

}
