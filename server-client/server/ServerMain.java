package server;

import java.util.Date;

public class ServerMain {
	public static void main(String args[]){
		EssServer server = new EssServer();
		server.runTCPserver();
		//server.addEmployee("", "", "", "", "", new Date(), 1, 1);
	//	server.save();
	//	server.load();
		
	//	System.out.println(server.employeeList.get(0).getFirstName());
	//	System.out.println(server.employeeList.get(1).getFirstName());
	//	System.out.println(server.employeeList.size());
	}

}
