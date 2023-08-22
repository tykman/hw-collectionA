package prosky.skyprospringdemosethw.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import prosky.skyprospringdemosethw.employee.Employee;
import prosky.skyprospringdemosethw.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @ExceptionHandler({HttpStatusCodeException.class})
    public String handlerException(HttpStatusCodeException e) {
        return "Code : " + e.getStatusCode() +
                ". Error : " + e.getMessage();
    }

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer,List<Employee>> getEmployeesByDepartment(
            @RequestParam (required = false) Integer departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }
}
