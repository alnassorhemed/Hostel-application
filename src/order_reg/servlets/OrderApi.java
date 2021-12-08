package order_reg.servlets;

	import java.io.IOException;
	import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.google.gson.Gson;

import hostel_reg.beans.Orders;
import hostel_reg.dao.OrderDao;

	/**
	 * Servlet implementation class Transactions
	 * @param <Otrder>
	 */
	@WebServlet("/api/orders")
	public class OrderApi<Otrder> extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public OrderApi() {
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
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			
			Orders book = new Gson().fromJson(request.getReader(), Orders.class);
			//add to db using dao
			System.out.print(book.getBlock());
			OrderDao dao = new OrderDao();
			int res = dao.insert(book);
			
			String resp  = "";
			Map<String, String> result = new HashMap<String, String>();
			
			if (res > 0) {
				result.put("response", "success");			
			} else {
				response.setStatus(400);
				result.put("response", "error");
			}
			
			resp = new Gson().toJson(result);
			out.write(resp);
		}

	}
