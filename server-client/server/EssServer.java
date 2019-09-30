package server;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import server.OriginatorMessage;


public class EssServer implements Observer{
	public ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public ArrayList<AbsenceRequest> absenceList = new ArrayList<AbsenceRequest>();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void update(Observable obs, Object obj) {
		System.out.println(OriginatorMessage.class.cast(obj).getMessage());
		String message[] = OriginatorMessage.class.cast(obj).getMessage().toString().split(":");
		
		try {
			if(OriginatorMessage.class.cast(obj).getOriginator() != null)
			{ 	
				save();
				if(message[0].equals("M"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(login(message[1], message[2]));
				}
				else if(message[0].equals("A"))
				{	
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(addEmployee(message[1], message[2], message[3], message[4], message[5], message[6],formatter.parse(message[7]), message[8], Integer.parseInt(message[9]), message[10], message[11]));
				}
				else if(message[0].equals("B")){
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(deleteEmployee(message[1]));			
				}
				else if(message[0].equals("C")){
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(Employee.updateEmployee(employeeList, message[1], message[2], message[3], message[4], message[5], message[6], formatter.parse(message[7]), message[8], message[9], message[10]));
				}
				else if(message[0].equals("E"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(searchForEmployee(Integer.parseInt(message[1]), message[2]));				
				}
				else if(message[0].equals("F"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(sortEmployeeRecords(Integer.parseInt(message[1])));				
				}
				else if(message[0].equals("G"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(Employee.requestAbsence(message[1], message[2], formatter.parse(message[3]), formatter.parse(message[4]), absenceList));
				}
				else if(message[0].equals("H"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(Employee.deleteAbsenceRequest(message[1], absenceList));
				}
				else if(message[0].equals("I"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(listAbsenceRequests());
				}
				else if(message[0].equals("J"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(checkForSchedulingConflicts(message[1]));
				}
				else if(message[0].equals("K"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(viewAbsenceTypeReport());
				}
				else if(message[0].equals("L"))
				{
					OriginatorMessage.class.cast(obj).getOriginator().sendToClient(viewTeamAbsenceReport(message[1]));
				}
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	//completed
	public void runTCPserver(){
		ObservableOriginatorServer server = new ObservableOriginatorServer(5555);
		load();
		try {
			server.listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.addObserver(this);
	}
	
	//completed
	public  String searchForEmployee(int searchType, String searchString){
		ArrayList<Employee> foundEmployees = new ArrayList<Employee>();
		boolean found = false;
		for (int i=0;i<employeeList.size();i++){
			if(searchType == 1){	
				if(employeeList.get(i).getFirstName().equals(searchString))
				{
					foundEmployees.add(employeeList.get(i));
					found = true;
				}
			}
			else if(searchType == 2){
				if(employeeList.get(i).getEmployeeID().equals(searchString))
				{
					
					foundEmployees.add(employeeList.get(i));
					found = true;
				}
			}
			else if(searchType == 3){
				if(employeeList.get(i).getPhoneNumber().equals(searchString))
				{
					foundEmployees.add(employeeList.get(i));
					found = true;
				}
			}
		}		
		String employeesFound = "";
		if(found)
		{
			for(int i=0;i<foundEmployees.size();i++){
				employeesFound += foundEmployees.get(i).getFirstName()
						+ " " + foundEmployees.get(i).getLastName()
						+ ", " + foundEmployees.get(i).getEmployeeID()
						+ ", " + foundEmployees.get(i).getClass().getSimpleName()
						+ "\n";
			}
			
			return "1:"+employeesFound;
		}
		else
			return "0:No Employees Found";
		
	}
	
	public String addEmployee(String employeeID, String firstName, String lastName, String address, String phoneNumber, String office, Date dateOfJoining, String qualifications, int employeeRank, String ManagerID, String password ){
		System.out.println(employeeRank);
		switch(employeeRank){
		case 1:
			System.out.println("case1");
			Manager m = new Manager();
			m.setEmployeeID(employeeID);
			m.setFirstName(firstName);
			m.setLastName(lastName);
			m.setAddress(address);
			m.setPhoneNumber(phoneNumber);
			m.setOffice(office);
			m.setDateOfJoining(dateOfJoining);
			m.setQualifications(qualifications);
			m.setPassword(password);
			employeeList.add(m);
			
			for(int i=0;i<employeeList.size();i++)
			{
				if(employeeList.get(i).getEmployeeID().equals(ManagerID))
					if(employeeList.get(i).getEmployeeID().getClass().getSimpleName().equals("Manager"))
					{						
						m.setManagerEmployeeID(ManagerID);
						((Manager)employeeList.get(i)).subordinates.add(m);
						return "1";
					}
					else
						return "0:Employee ID doesn't belong to a manager";	
			}
			
			return "1";
		case 2:
			Secretary s = new Secretary();
			for(int i=0;i<employeeList.size();i++)
			{
				if(employeeList.get(i).getEmployeeID().equals(ManagerID))
					if(employeeList.get(i).getClass().getSimpleName().equals("Manager"))
					{
						System.out.println(employeeList.get(i).getEmployeeID() + ": "+ employeeList.get(i).getClass().getSimpleName());
						s.setEmployeeID(employeeID);
						s.setManagerEmployeeID(ManagerID);
						s.setFirstName(firstName);
						s.setLastName(lastName);
						s.setAddress(address);
						s.setPhoneNumber(phoneNumber);
						s.setOffice(office);
						s.setDateOfJoining(dateOfJoining);
						s.setQualifications(qualifications);
						s.setPassword(password);
						((Manager)employeeList.get(i)).subordinates.add(s);
						employeeList.add(s);
						return "1";
					}
					else
						return "0:Employee ID doesn't belong to a manager";	
			}
			return "0:Employee ID can't be found";
		case 3:
			Technician t = new Technician();
			
			for(int i=0;i<employeeList.size();i++)
			{
				if(employeeList.get(i).getEmployeeID().equals(ManagerID))
					if(employeeList.get(i).getClass().getSimpleName().equals("Manager"))
					{
						System.out.println(employeeList.get(i).getEmployeeID() + ": "+ employeeList.get(i).getClass().getSimpleName());
						t.setEmployeeID(employeeID);
						t.setManagerEmployeeID(ManagerID);
						t.setFirstName(firstName);
						t.setLastName(lastName);
						t.setAddress(address);
						t.setPhoneNumber(phoneNumber);
						t.setOffice(office);
						t.setDateOfJoining(dateOfJoining);
						t.setQualifications(qualifications);
						t.setPassword(password);
						((Manager)employeeList.get(i)).subordinates.add(t);
						employeeList.add(t);
						return "1";
					}
					else
						return "0:Employee ID doesn't belong to a manager"+employeeList.get(0).getClass().getSimpleName();	
			}
			return "0:Employee ID can't be found";
		default:
			return null;
		}		
	}
	
	//completed
	private String sortEmployeeRecords(int sortingField){
	if(sortingField == 1){
		Collections.sort(employeeList, new Comparator<Employee>() {
	        @Override
	        public int compare(Employee e2, Employee e1)
	        {
	            return  e1.getLastName().compareTo(e2.getLastName());
	        }
	    });
	}
	else if(sortingField == 2){
		Collections.sort(employeeList, new Comparator<Employee>() {
	        @Override
	        public int compare(Employee e2, Employee e1)
	        {
	            return  e1.getEmployeeID().compareTo(e2.getEmployeeID());
	        }
	    });
	}
	else if(sortingField == 3){
		Collections.sort(employeeList, new Comparator<Employee>() {
	        @Override
	        public int compare(Employee e2, Employee e1)
	        {
	            return  e1.getDateOfJoining().compareTo(e2.getDateOfJoining());
	        }
	    });
	}
	
	String employeesFound =  "";
	
	for(int i=0;i < employeeList.size();i++){
		employeesFound += employeeList.get(i).getFirstName()
				+ " " + employeeList.get(i).getLastName()
				+ ", " + employeeList.get(i).getEmployeeID()
				+ ", " + employeeList.get(i).getClass().getSimpleName()
				+ "\n";
	}
		return "1:"+employeesFound;
	}
	
	//completed
	private String deleteEmployee(String employeeID){
		boolean found = false;
		for(int i =0;i<employeeList.size();i++){
			if(employeeList.get(i).getEmployeeID().equals(employeeID)){
				employeeList.remove(i);
				found = true;
			}
		}
		
		if(found)
			return "1";
		else
			return "0:Employee Not Found";
				
		
	}
	
	//completed
	private String listAbsenceRequests(){
		String absences="";
		for(int i=0;i<absenceList.size();i++)
		{
			absences += "ID= "+absenceList.get(i).absenceRequestID +
					", Employee ID= " + absenceList.get(i).EmployeeID +
					", Absence Type= " + absenceList.get(i).absenceType +
					", Start Date= " + absenceList.get(i).startDate + 
					", End Date= " + absenceList.get(i).endDate + "\n";
			
		}
		
		if(absenceList.size() == 0)
			return "0:No Absence Requests Found";
		else
			return "1:"+absences;
			
	}
	
	//completed
	public String checkForSchedulingConflicts(String managerID){
		int conflicts=0;
		boolean managerFound = false;
		int size=0;
		for (int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).getClass().getName().equals("Manager"))
			{	
				managerFound = true;
				size = ((Manager)employeeList.get(i)).subordinates.size();
				for(int j=0;j<((Manager)employeeList.get(i)).subordinates.size();j++){
					for(int k=0;k<absenceList.size();k++){
						if(absenceList.get(k).EmployeeID.equals(((Manager)employeeList.get(i)).subordinates.get(j).getEmployeeID()))
							conflicts++;	
							break;
					}
				}
			}
		}
		if(managerFound)
			if(conflicts/(double)size > 0.30)
				return "1";
			else
				return "0:No Conflicts";
		else
			return "0:No Manager Found";
	}
	
	//completed
	private String login (String userID, String password){
		boolean found = false;
		String type="";
		for(int i=0;i<employeeList.size();i++)
		{
			if(employeeList.get(i).getEmployeeID().equals(userID) && 
					employeeList.get(i).getPassword().equals(password)){
				found = true;
				type = employeeList.get(i).getClass().getSimpleName();
			}
		}
		
		if(found)
			return "1:"+type;
		else
			return "0:No Match Found";
	}
	
	//completed
	private String viewAbsenceTypeReport(){
		Integer vacation=0, sick=0, compensation=0;
		
		for(int i=0;i<absenceList.size();i++){
			if(absenceList.get(i).absenceType.equals("Vacation"))
				vacation++;
			else if(absenceList.get(i).absenceType.equals("Sick"))
				sick++;
			else if(absenceList.get(i).absenceType.equals("Compensation"))
				compensation++;
		}
		
		return "1:Vacation Time- "+ vacation.toString() +
				" Sick Time- " + sick.toString() +
				" Compensation Time- " + compensation.toString();
	}
	
	//Completed
	private String viewTeamAbsenceReport(String EmployeeID){
		boolean found = false;
		ArrayList<Employee> employees = null;
		
		for(int i=0;i<employeeList.size();i++){
			if(employeeList.get(i).getEmployeeID().equals(EmployeeID))
			{
				if(employeeList.get(i).getClass().getSimpleName().equals("Manager"))
				{
					employees = ((Manager)employeeList.get(i)).subordinates;
					found = true;
				}
			}
		}
		String employeeAbsences="";
		if(found){
			for(int i=0;i<employees.size();i++){
				employeeAbsences += employees.get(i).getFirstName() + ": \n";
				for(int j=0;j<absenceList.size();j++){
					if(employees.get(i).getEmployeeID().equals(absenceList.get(j).EmployeeID))
					{
						employeeAbsences += absenceList.get(j).startDate.toString();
						employeeAbsences += " - " + absenceList.get(j).endDate.toString() + "\n";
					}
				}
				employeeAbsences += "\n\n";
			}
			
		}
		
		if(found)
			return "1:"+employeeAbsences;
		else
			return "0:No Employees Found";
	}
	
	//completed
	public void save(){	
		
		  try {
			  FileOutputStream fileOut = new FileOutputStream("employee.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(employeeList);
		         out.close();
		         fileOut.close();
		         System.out.println("Serialized employees is saved in employee.ser");
		         
		       FileOutputStream fileOut2 = new FileOutputStream("absence.ser");
		         ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
		       	 out2.writeObject(absenceList);
		         out2.close();
		         fileOut2.close();
		       
		         System.out.println("Serialized absence requests is saved in absence.ser");
		      }catch(IOException i) {
		         i.printStackTrace();
		      }
	}
	
	//completed
	public void load(){
		 System.out.println("Reading Files..");
		 employeeList.clear();
		 absenceList.clear();
		 
		 boolean EOF=false;
	      try {
	         FileInputStream fileIn = new FileInputStream("employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         employeeList = (ArrayList<Employee>) in.readObject();
	         
	         FileInputStream fileIn2 = new FileInputStream("absences.ser");
	         ObjectInputStream in2 = new ObjectInputStream(fileIn2);
	         absenceList = (ArrayList<AbsenceRequest>) in2.readObject();
	         
	         in.close();
	         in2.close();
	         fileIn2.close();
	         fileIn.close();
	      }catch(IOException i) {
	         if(i instanceof EOFException)
	         {
	        	 System.out.println("EOF EXCPETION");
	        	 EOF = true;
	         }
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }  
	}

}
