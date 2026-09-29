package com.example.demo.practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Same role as the ArrayList<Employee> in the console version
    private final List<Employee> employees = new ArrayList<>();

    // GET /employees -> shows all employee details (like displayEmployee loop)
    @GetMapping
    public List<Employee> getAll() {
        return employees;
    }

    // GET /employees/{id} -> search employee by ID
    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // POST /employees -> add a new employee (id, name, salary provided by the caller)
    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    // DELETE /employees/{id} -> remove an employee
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        employees.removeIf(e -> e.getId() == id);
        return "Deleted employee " + id;
    }
}
