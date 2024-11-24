package com.solution.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solution.Employee.Employee;


@WebServlet(urlPatterns="/search" , loadOnStartup=10)
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("SearchServlet File is loading");
	}
   
    public SearchServlet() {
        super();
        System.out.println("SerachServlet is Instantiated");
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   String id1 = request.getParameter("id");
	   
	   Integer id = Integer.parseInt(id1);
	   
	   IController contr = new ControllerImpl();
	  Employee emp = contr.select(id);
	  
	  PrintWriter out = response.getWriter();
	  out.println("<html><head><title>Result</title></head><body>");
	  out.println("<center>");
	  out.println("<h1>Employee Data</h1>");
	  out.println("<table border='1'>");
	  out.println("<tr> <th>ID</th>  <td>"+emp.getId()+"</td> </tr>");
	  out.println("<tr> <th>Name</th>  <td>"+emp.getName()+"</td> </tr>");
	  out.println("<tr> <th>Salary</th>  <td>"+emp.getSalary()+"</td> </tr>");
	  out.println("<tr> <th>City</th>  <td>"+emp.getCity()+"</td> </tr>");
	  out.println("</br> <a href='index.html'> home page</a> ");
	  out.println("</table>");
	  out.println("</center></body></html>");
	  
	   out.close();
	   
	 
	
	}

}
