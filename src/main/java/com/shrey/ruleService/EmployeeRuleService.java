package com.shrey.ruleService;

import com.shrey.dto.EmployeeDesignationObj;
import com.shrey.facts.Employeefact;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skany on 3/27/17.
 */
@Service
public class EmployeeRuleService {

    private final KieContainer kieContainer;

    @Autowired
    public EmployeeRuleService(KieContainer kieContainer) {
        System.out.println("Initialising a new Employee rule session.");
        this.kieContainer = kieContainer;
    }


    public EmployeeDesignationObj getDesignation (Employeefact employee) {
        EmployeeDesignationObj eObj = new EmployeeDesignationObj();
        eObj.setEmployeeName("Rules applied Name");
        eObj.setDesignation("Rules applied Designation");
        KieSession kieSession = kieContainer.newKieSession("EmployeeSession");
        kieSession.insert(employee);
        kieSession.fireAllRules();
        //EmployeeDesignationObj employeeDesignationObj = findBusPass(kieSession);
        kieSession.dispose();
        return eObj;
    }
}
