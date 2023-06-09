package ca.bcit.comp4656.employee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFilter implements Filter {
	
	public void init(FilterConfig config) {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String command = request.getParameter("submit");
		
		if (("Sign Out").equals(command)) {
			req.getSession().invalidate();
			res.sendRedirect(req.getContextPath());
		}

		chain.doFilter(request, response);
	}

}
