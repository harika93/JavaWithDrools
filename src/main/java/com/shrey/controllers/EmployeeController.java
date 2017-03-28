package com.shrey.controllers;

import com.shrey.dto.EmployeeDesignationObj;
import com.shrey.facts.Employeefact;
import com.shrey.ruleService.EmployeeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by skany on 3/27/17.
 */
@RestController
public class EmployeeController {

    private final EmployeeRuleService employeeRuleService;

    @Autowired
    public EmployeeController(EmployeeRuleService employeeRuleService) {
        this.employeeRuleService = employeeRuleService;
    }
    @RequestMapping(value = "/getEmployeeDesignation",
            method = RequestMethod.GET, produces = "application/json")
    public EmployeeDesignationObj getEmployeeDesignation(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) int age) {

        Employeefact employeFact = new Employeefact(name, age);
        EmployeeDesignationObj employeeDesignationObj = employeeRuleService.getDesignation(employeFact);
        //System.out.println();
        return employeeDesignationObj;
    }
}
