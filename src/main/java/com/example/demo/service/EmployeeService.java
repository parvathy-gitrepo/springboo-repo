package com.example.demo.service;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

   /* public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }*/

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee details) {

        Employee employee = getEmployeeById(id);

        employee.setName(details.getName());
        employee.setDepartment(details.getDepartment());
        employee.setSalary(details.getSalary());

        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        repository.delete(employee);
    }

	/*public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}*/

	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}