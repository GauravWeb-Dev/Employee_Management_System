package com.solution.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.solution.Employee.Employee;
import com.solution.util.JDBCUtil;

public class DaoImpl implements IDao{

	@Override
	public Employee select(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Employee emp = null;
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlSelectQuery = "SELECT ID ,NAME,SALARY,CITY FROM EMPLOYEE WHERE ID = ?";
			
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, id);
				
				resultSet = pstmt.executeQuery();
			}
			
			if(resultSet != null) {
			   emp = new Employee();
				while(resultSet.next()) {
			   emp.setId(resultSet.getInt(1));
			   emp.setName(resultSet.getString(2));
			   emp.setSalary(resultSet.getInt(3));
			   emp.setCity(resultSet.getString(4));
				}
				return emp;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
		
	}

	@Override
	public Integer insert(Employee emp) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlInsertQuery = "Insert into Employee(id,name,salary,city) values (?,?,?,?)";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1, emp.getId());
				pstmt.setString(2, emp.getName());
				pstmt.setInt(3, emp.getSalary());
				pstmt.setString(4, emp.getCity());
				
				 rowCount = pstmt.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
		
		
	}

	@Override
	public Integer update(Employee emp) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlUpdateQuery = "Update Employee set name=? ,salary=?, city=? Where id = ?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			
			if(pstmt != null) {
				pstmt.setString(1, emp.getName());
				pstmt.setInt(2, emp.getSalary());
				pstmt.setString(3, emp.getCity());
				pstmt.setInt(4, emp.getId());
				
				 rowCount = pstmt.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
		
		 
		
	}

	@Override
	public Integer delete(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Integer rowCount = null;
		
		
		try {
			connection  = JDBCUtil.getConnection();
			
			String sqlDeleteQuery = "Delete from Employee Where id = ?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			
			if(pstmt != null) {
				pstmt.setInt(1,id);
				 rowCount = pstmt.executeUpdate();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JDBCUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
		
		
	}

}
