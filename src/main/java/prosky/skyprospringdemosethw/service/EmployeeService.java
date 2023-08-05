package prosky.skyprospringdemosethw.service;


import org.springframework.stereotype.Service;
import prosky.skyprospringdemosethw.employee.Employee;
import prosky.skyprospringdemosethw.exception.EmployeeAlreadyAddedException;
import prosky.skyprospringdemosethw.exception.EmployeeNotFoundException;
import prosky.skyprospringdemosethw.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public  class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    private final static int MAX_SIZE=2;

    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)){
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName,String lastName){
        Employee employeeForFound= new Employee(firstName, lastName);
        for (Employee e: employees){
            if (e.equals(employeeForFound)) {
                return e;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }

    public Employee remove(String firstName,String lastName){
        Employee employeeForRemove = new Employee(firstName, lastName);
        boolean removeResult = employees.remove(employeeForRemove);
        if (removeResult) {
            return employeeForRemove;
        } else {
            throw new EmployeeNotFoundException("Такой сотрудник в отделе не найден");
        }
    }

    public List<Employee> getAll() {
        return (employees);
    }
}
