package com.java.maven.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.maven.entity.Customer;
import com.maven.services.CustomerServices;
import com.maven.services.ICustomerServices;
import com.maven.utils.CustomerUtils;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	final static Logger logger=Logger.getLogger(CustomerServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ICustomerServices customerService;
    public CustomerServlet() {
        super();
        customerService=new CustomerServices();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		long custId= Long.parseLong(request.getParameter("customerId"));
		Customer customer=customerService.loadCustomer(custId);
		request.setAttribute("customer", customer);
		/*RequestDispatcher rd= request.getRequestDispatcher("home.html");
		rd.forward(request, response);*/
		response.getWriter().println(customer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer=CustomerUtils.getCustomer(request);
		boolean status=customerService.addCustomer(customer);
		
		if(status) {
			logger.info("Customer added successfully");
			response.getWriter().println("Customer added successfully");
			
		}else {
			logger.error("Something went wrong: please try again");
			response.getWriter().println("Error : something went wrong");
			
		}
		/*RequestDispatcher rd= request.getRequestDispatcher("home.html");
		rd.forward(request, response);*/
	}

}
