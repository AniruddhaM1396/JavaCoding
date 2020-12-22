package com.training.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentCheck
 */
@WebServlet({ "/PaymentCheck", "/check" })
public class PaymentCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserCredit userCredit;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentCheck() {
        super();
        // TODO Auto-generated constructor stub
        this.userCredit = new UserCredit();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName = request.getParameter("userName");
		int amount = Integer.parseInt(request.getParameter("plans"));
		if(this.userCredit.getUser().containsKey(userName)) {
			int currentLimit =  this.userCredit.getUser().get(userName);
			System.out.println(currentLimit);
			if(currentLimit >= amount) {
				request.setAttribute("Success", 1);
				currentLimit = currentLimit-amount;
				this.userCredit.getUser().replace(userName, currentLimit);	
			}
			else {
				request.setAttribute("Success", 0);			
			}
			request.setAttribute("creditLimit", currentLimit);
		}
		else {
			request.setAttribute("Success", -1);	
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("alert.jsp");
		dispatcher.forward(request, response);
	}
	}


