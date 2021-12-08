package order_reg.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostel_reg.beans.User;
import hostel_reg.dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		User u = new User();
		u.setUsername(user);
		u.setPassword(pass);
		
		UserDao dao = new UserDao();
		
		if (dao.validate(u)) {
			response.sendRedirect("orders.jsp");
		} else {
			response.getWriter().print("error");
		}
	}
}
