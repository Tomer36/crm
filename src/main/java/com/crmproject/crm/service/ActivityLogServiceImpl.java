package com.crmproject.crm.service;

import com.crmproject.crm.dto.ActivityLogDTO;
import com.crmproject.crm.model.ActivityLog;
import com.crmproject.crm.model.Customer;
import com.crmproject.crm.model.User;
import com.crmproject.crm.repository.ActivityLogRepository;
import com.crmproject.crm.repository.CustomerRepository;
import com.crmproject.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogRepository.findAll();
    }

    @Override
    public Optional<ActivityLog> getActivityLogById(Long id) {
        return activityLogRepository.findById(id);
    }

    @Override
    public ActivityLog saveActivityLog(ActivityLogDTO activityLogDTO) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setDescription(activityLogDTO.getDescription());
        activityLog.setTimestamp(activityLogDTO.getTimestamp());
        activityLog.setTreatmentNumber(activityLogDTO.getTreatmentNumber());
        Customer customer = customerRepository.findById(activityLogDTO.getCustomerId()).orElse(null);
        User user = userRepository.findById(activityLogDTO.getUserId()).orElse(null);
        activityLog.setCustomer(customer);
        activityLog.setUser(user);
        return activityLogRepository.save(activityLog);
    }

    @Override
    public ActivityLog updateActivityLog(Long id, ActivityLogDTO activityLogDTO) {
        return activityLogRepository.findById(id).map(activityLog -> {
            activityLog.setDescription(activityLogDTO.getDescription());
            activityLog.setTimestamp(activityLogDTO.getTimestamp());
            activityLog.setTreatmentNumber(activityLogDTO.getTreatmentNumber());
            activityLog.setCustomer(customerRepository.findById(activityLogDTO.getCustomerId()).orElse(null));
            activityLog.setUser(userRepository.findById(activityLogDTO.getUserId()).orElse(null));
            return activityLogRepository.save(activityLog);
        }).orElseThrow(() -> new RuntimeException("ActivityLog not found with id " + id));
    }

    @Override
    public void deleteActivityLog(Long id) {
        activityLogRepository.deleteById(id);
    }
}
