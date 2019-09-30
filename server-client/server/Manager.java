package server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee implements java.io.Serializable {
	
	public ArrayList<Employee> subordinates = new ArrayList<Employee>();
}