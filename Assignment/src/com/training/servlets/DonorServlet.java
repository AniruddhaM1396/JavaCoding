package com.training.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DonorServlet
 */
@WebServlet({ "/DonorServlet", "/donor" })
public class DonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	private DonorDaoImpl dao;
    public DonorServlet() {
        super();
        // TODO Auto-generated constructor stub
        dao=new DonorDaoImpl();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<BloodDonor> donorList = dao.findAll();
		System.out.println(donorList);
		request.setAttribute("donorList",donorList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewDonor.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String donorName = request.getParameter("donorName");
		int donorAge= Integer.parseInt(request.getParameter("donorAge"));
		String donorGender = request.getParameter("donorGender");
		String donorBloodgroup = request.getParameter("donorBloodgroup");
		int donorPhone = Integer.parseInt(request.getParameter("donorPhone"));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"),formatter);
		BloodDonor blooddonor = new BloodDonor(donorName,donorAge,donorGender,donorBloodgroup,donorPhone,dateOfBirth);
		System.out.println(blooddonor);
		int rowsAdded=dao.add(blooddonor);
		System.out.println("Row Added :="+ rowsAdded);
		//request.setAttribute("blooddonor", blooddonor.toString());
		//RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
		//dispatcher.forward(request, response);
	}

}
