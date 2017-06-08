package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeInformations;
import service.EmployeeServices;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeServices services = new EmployeeServices();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeId = request.getParameter("employeeID");
		EmployeeInformations employee = services.getEmployeeInformation(employeeId);
		
		response.setContentType("text/html");
		
		
		response.getWriter()
		.append("<html> <body>")
		.append("Employee Id: " + employee.getEmployee().getEmpNo())
		.append("First Name: " + employee.getEmployee().getFirstName())
		.append("Last Name: " + employee.getEmployee().getLastName())
		.append("Hire Date: " + employee.getEmployee().getHireDate())
		.append("Gender: " + employee.getEmployee().getGender())
		.append("</body></html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
