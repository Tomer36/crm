package com.crmproject.crm.service;

import com.crmproject.crm.dto.ActivityLogDTO;
import com.crmproject.crm.model.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    List<ActivityLog> getAllActivityLogs();
    Optional<ActivityLog> getActivityLogById(Long id);
    ActivityLog saveActivityLog(ActivityLogDTO activityLogDTO);
    ActivityLog updateActivityLog(Long id, ActivityLogDTO activityLogDTO);
    void deleteActivityLog(Long id);
}
