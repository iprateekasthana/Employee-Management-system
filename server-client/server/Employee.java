package server;

import java.util.Date;
import java.util.List;

import server.EssServer;

public class Employee implements java.io.Serializable {
	private String employeeID, ManagerEmployeeID;
	private String password, firstName, lastName, address, phoneNumber, office, qualifications;
	private Date dateOfJoining;
	
	
	
	public String getManagerEmployeeID() {
		return ManagerEmployeeID;
	}

	public void setManagerEmployeeID(String managerEmployeeID) {
		ManagerEmployeeID = managerEmployeeID;
	}

	public static String updateEmployee(List<Employee> employeeList, String employeeID, String firstName, 
			String lastName, String address, String phoneNumber, String office,
					Date dateOfJoining, String qualifications, String managerID, String password){
		for(int i=0;i<employeeList.size();i++)
		{
			if(employeeList.get(i).getEmployeeID().equals(employeeID)){
				for(int j=0;j<employeeList.size();j++)
				{
					if(employeeList.get(j).getEmployeeID().equals(managerID))
						if(employeeList.get(j).getClass().getSimpleName().equals("Manager"))
						{
							employeeList.get(i).setManagerEmployeeID(managerID);
							employeeList.get(i).setFirstName(firstName);
							employeeList.get(i).setLastName(lastName);
							employeeList.get(i).setAddress(address);
							employeeList.get(i).setPhoneNumber(phoneNumber);
							employeeList.get(i).setOffice(office);
							employeeList.get(i).setDateOfJoining(dateOfJoining);
							employeeList.get(i).setQualifications(qualifications);
							employeeList.get(i).setPassword(password);
							return "1";
						}
				}
				return "0: Manager ID cannot be found";
			}
				
		}
		return "0: Employee ID cannot be found";
		
	}
	
	public static String requestAbsence(String EmployeeID, String at, Date startDate, Date endDate, List<AbsenceRequest> absenceList){
		AbsenceRequest ar = new AbsenceRequest();
		ar.startDate = startDate;
		ar.endDate = endDate;
		ar.absenceType = at;
		ar.EmployeeID = EmployeeID;
		ar.absenceRequestID = at.substring(0, 2) + startDate.toString().substring(0,3) + endDate.toString().substring(0,3) + EmployeeID.toString().substring(0,2);
		
		absenceList.add(ar);
		
		System.out.println(startDate.toString());
		
		return "1:"+ar.absenceRequestID;
	}
	
	public static String deleteAbsenceRequest(String absenceRequestID, List<AbsenceRequest> absenceList){
		boolean found=false;
		for(int i=0;i<absenceList.size();i++){
			if( absenceList.get(i).absenceRequestID.equals(absenceRequestID) ){
				absenceList.remove(i);
				found = true;
			}
		}
		if(found)
			return "1";
		else
			return "0";
	}
	
	
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	
}
