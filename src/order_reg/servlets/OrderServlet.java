package order_reg.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostel_reg.beans.Orders;
import hostel_reg.dao.OrderDao;

/**
 * Servlet implementation class PlayerServlet
 */
@WebServlet({"/orders", "/orders/update", "/orders/delete",})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getServletPath().equals("/orders/delete")) {
			String id = request.getParameter("id");
			
			OrderDao dao = new OrderDao();
		    int result = dao.delete(id);
		      
		    if (result > 0) {
		    	response.sendRedirect("../orders.jsp");
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
		String date = request.getParameter("date");
		String block = request.getParameter("blocks");
		int RoomNo = Integer.parseInt(request.getParameter("room"));
		String residence = request.getParameter("recd");
		String disability = request.getParameter("dis");
		int period =Integer.parseInt(request.getParameter("perd"));
		
		Orders u = new Orders();
		u.setNames(name);
		u.setDate(date);
		u.setBlock(block);
		u.setRoomNo(RoomNo);
		u.setResidence(residence);
		u.setDisability(disability);
		u.setPeriod(period);
      
		OrderDao dao = new OrderDao();
		int result = 0;
      
		switch(request.getServletPath()) {
      		case "/orders":
      			result = dao.insert(u);
      		
      			if (result > 0) {
      				response.sendRedirect("orders.jsp");
      			}
      			break;
      		case "/orders/update":
      			int id = Integer.parseInt(request.getParameter("id"));
      			u.setId(id);
      			result = dao.update(u);
      		
      			if (result > 0) {
      				response.sendRedirect("../orders.jsp");
      			}
      			break;
		}
      
		response.getWriter().print("error");
	}

}
