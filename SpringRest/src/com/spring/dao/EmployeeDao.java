package com.spring.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @return
	 */
	public List<Employee> getListOfEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		/*Connection connection = ConnectionsUtils.getConnection();
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select * from employee");
				while (resultSet.next()) {
					Employee employee = new Employee();
					employee.setId(resultSet.getInt("ID"));
					employee.setDeptId(resultSet.getInt("DEPT_ID"));
					employee.setName(resultSet.getString("NAME"));
					employee.setSalary(resultSet.getDouble("SALARY"));
					//String hobbies = resultSet.getString("hobbies");
//					if(hobbies != null) {
//						employee.setHobbies(hobbies.split(","));
//					}
					list.add(employee);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Employee");
		List<?> list1 = query.list();
		list = (List<Employee>)list1;
		session.close();
		return list;
	}
	
	/**
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	public int save(Employee employee) throws Exception {
		Session session = sessionFactory.openSession();
		int result = 0;
		try {
			result = (Integer) session.save(employee);
		} catch (Exception e) {
			throw new Exception("Error while saving Data");
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return result;
	}

}
