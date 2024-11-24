package com.solution.service;

import com.solution.Employee.Employee;

public interface IService {
	    public Employee select(int id);
	    public Integer insert(Employee emp);
	    public Integer update(Employee emp);
	    public Integer delete(int id);
}
