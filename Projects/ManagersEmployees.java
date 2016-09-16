import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

abstract class Employee {
	String name, position, department;
    public void print(){};
}

class Manager extends Employee {
	private List<Employee> subordinates;
	
	public Manager(String name, String position, String department) {
		super.name = name;
		super.position = position;
		super.department = department;
		
		subordinates = new ArrayList<Employee>();
	}

	public void print() {
		System.out.println(name + ", " + position + ", " + department);
		for (Employee emp : subordinates) {
            emp.print();
        }
	}
	
	public void add(Employee emp) {
        subordinates.add(emp);
    }
}

class Staff extends Employee {
	public Staff(String name, String position, String department) {
		super.name = name;
		super.position = position;
		super.department = department;
	}
	
	public void print() {
        System.out.println("\t" + name + ", " + position + ", " + department);
    }
}

public class ManagersEmployees {
	public static void main(String[] args) {
		boolean firstLine = false;
		List <Manager> managerList = new ArrayList<Manager>();
		List <Staff> staffList = new ArrayList<Staff>();
		List <File> fileList = new ArrayList<File>();
				
		File file1 = new File("src/Input1");
		File file2 = new File("src/Input2");
		File file3 = new File("src/Input3");
		
		fileList.add(file1);
		fileList.add(file2);
		fileList.add(file3);
		
		//cycle through the files to find each staff member and their manager
		for(int i=0; i < fileList.size(); i++) {
			try {
				Scanner read = new Scanner (fileList.get(i));
				read.useDelimiter(",|\\n|\\(");
				String name, position, department;
				firstLine = true;
		
				while (read.hasNext()) {
					if (firstLine) {
						name = read.next();
						position = read.next();
						department = read.next();
						Manager manager = new Manager (name, position, department);
						managerList.add(manager);
						firstLine = false;
					}
					else {
						name = read.next();
						position = read.next();
						department = read.next();
						Staff staff = new Staff(name, position, department);
						staffList.add(staff);
					}
				}
				read.close();
			}
			catch (IOException e) {
	            System.out.println("File Read Error");
			}
			
			for(int j=0; j < staffList.size(); j++) {
				managerList.get(i).add(staffList.get(j));
		    }
			
			staffList.clear();
		}
		
		for(int i=1; i < managerList.size(); i++) {
			managerList.get(0).add(managerList.get(i));
		}
		
		managerList.get(0).print();
		
    }
}
