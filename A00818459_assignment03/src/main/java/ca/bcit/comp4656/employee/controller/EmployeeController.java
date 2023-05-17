package ca.bcit.comp4656.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 2857475378135647370L;

	private Command command;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		command = new Command();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String home = "/JSPs/index.jsp";
		try {
			command.getEmployees(request);
		} catch (Exception e) {
			home = "/JSPs/ErrorPage.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(home);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			command.execute(request);
		} finally {
			doGet(request, response);
		}

	}
	
}
