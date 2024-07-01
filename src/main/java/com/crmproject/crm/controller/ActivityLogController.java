package com.crmproject.crm.controller;

import com.crmproject.crm.model.ActivityLog;
import com.crmproject.crm.model.Customer;
import com.crmproject.crm.model.User;
import com.crmproject.crm.repository.ActivityLogRepository;
import com.crmproject.crm.repository.CustomerRepository;
import com.crmproject.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activitylogs")
public class ActivityLogController {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogRepository.findAll();
    }

    @PostMapping
    public ActivityLog addActivityLog(@RequestBody ActivityLog activityLog) {
        Customer customer = customerRepository.findById(activityLog.getCustomer().getId()).orElse(null);
        User user = userRepository.findById(activityLog.getUser().getId()).orElse(null);
        if (customer != null && user != null) {
            activityLog.setCustomer(customer);
            activityLog.setUser(user);
            return activityLogRepository.save(activityLog);
        }
        return null; // Or handle error appropriately
    }

    // Other CRUD operations as needed
}
