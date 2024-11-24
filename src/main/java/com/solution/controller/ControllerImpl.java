package com.solution.controller;

import java.util.Scanner;

import com.solution.service.ServiceImpl;
import com.solution.Employee.Employee;
import com.solution.service.IService;

public class ControllerImpl implements IController{
       Scanner sc = null;
       Employee emp = null;
       IService service = null;
       
	@Override
	public Employee select(Integer id) {
		
		 service = new ServiceImpl();
		 emp =service.select(id);
		
	    return emp;
		
	}

	@Override
	public void insert() {
		sc= new Scanner(System.in);
		System.out.print("Id :: ");
		Integer id = sc.nextInt();
		
		System.out.print("Name :: ");
		String name = sc.next();
		
		System.out.print("Salary :: ");
		Integer salary = sc.nextInt();
		
		System.out.print("City :: ");
		String city = sc.next();
		
		emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setCity(city);
		
		service = new ServiceImpl();
		
		int rowCount = service.insert(emp);
		if(rowCount != 0) {
			System.out.println("Data Inserted Sucessfully");
		}else {
			System.out.println("Data Insertion Failed");
		}
		
	}

	@Override
	public void update() {
		sc= new Scanner(System.in);
		System.out.print("Enter Id whose data to be updated :: ");
		Integer id = sc.nextInt();
		
		System.out.print("Name :: ");
		String name = sc.next();
		
		System.out.print("Salary :: ");
		Integer salary = sc.nextInt();
		
		System.out.print("City :: ");
		String city = sc.next();
		
		emp = new Employee();
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setCity(city);
		
		service  = new ServiceImpl();
		Integer rowCount = service.update(emp);
		
		if(rowCount != 0) {
			System.out.println("Data updated Sucessfully");
		}else {
			System.out.println("Data updation Failed");
		}
		
	}

	@Override
	public void delete() {
		Integer rowCount = null;
		sc = new Scanner(System.in);
		System.out.print("Enter id to delete record :: ");
		int id = sc.nextInt();
		service = new ServiceImpl();
		
		
		Employee emp = service.select(id);
		System.out.println(emp);
		
		System.out.println();
	    System.out.print("Do you want to delete this record ??[y/n] :: ");
	    String s = sc.next();
	    
	    System.out.println();
	    
	    if(s.equalsIgnoreCase("y")) {
	     rowCount=service.delete(id);
	    }else {
	    	System.out.println("Data Has been not deleted");
	    }
		
	    if(rowCount != null) {
	    	System.out.println("Record deleted succefully");
	    }
	    else {
	    	System.out.println("deletion failed");
	    }
		
		
		
	}

}
