package iuh.fit.se.dao;

import iuh.fit.se.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void update(Employee employee);
    List<Employee> getAll();
    Employee getById(int id);
    void deleteById(int id);
    void save(Employee employee);
}