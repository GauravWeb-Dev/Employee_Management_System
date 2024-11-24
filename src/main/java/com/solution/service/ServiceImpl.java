package com.solution.service;

import com.solution.Employee.Employee;
import com.solution.dao.DaoImpl;
import com.solution.dao.IDao;

public class ServiceImpl implements IService{
     IDao dao = null;
     
	@Override
	public Employee select(int id) {
		 dao = new DaoImpl();
	Employee emp =dao.select(id);
	return emp;
	}

	@Override
	public Integer insert(Employee emp) {
		  dao = new DaoImpl();
		return dao.insert(emp);
		
	}

	@Override
	public Integer update(Employee emp) {
		 dao = new DaoImpl();
			return dao.update(emp);
			
		
	}

	@Override
	public Integer delete(int id) {
		 dao = new DaoImpl();
			return dao.delete(id);
	}

}
