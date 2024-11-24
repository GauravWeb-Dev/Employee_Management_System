package com.solution.controller;

import com.solution.Employee.Employee;

public interface IController {
    public Employee select(Integer id);
    public void insert();
    public void update();
    public void delete();
    
}
