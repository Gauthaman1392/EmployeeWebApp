package service;

import java.io.IOException;

import model.Employee;
import repositories.EmployeeDao;

public class EmployeeServices {

	EmployeeDao empDao = new EmployeeDao();
	

	public EmployeeInformations getEmployeeInformation(String empId) throws IOException {
		EmployeeInformations empInfo = new EmployeeInformations();
		empInfo.setEmployee(empDao.getEmployee(empId));
		
		return empInfo;

	}

}
