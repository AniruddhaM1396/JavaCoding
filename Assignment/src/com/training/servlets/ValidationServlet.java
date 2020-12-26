package com.training.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/valid")
public class ValidationServlet extends HttpServlet {
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy called ");
	}

	@Override
	public void init() throws ServletException {	
		super.init();
		System.out.println("init called ");
	}

	private Validator validator;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        this.validator = new Validator();
        
        System.out.println("constructor called ");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//System.out.println(name);

		UserInfo user = new UserInfo(name, password);		

		boolean isValidUser = Validator.isValid(user);		
		System.out.println(isValidUser);

		RequestDispatcher dispatcher;

		if(isValidUser) {	
			HttpSession session = request.getSession();
			System.out.println(name);
			session.setAttribute("user", name);
			//request.setAttribute("message","Welcome "+name );
			dispatcher = request.getRequestDispatcher("input.jsp");		
		}
		else {
			request.setAttribute("message","Invalid Access" );
			dispatcher = request.getRequestDispatcher("index.jsp");
		}

		dispatcher.forward(request, response);	
	}

}
