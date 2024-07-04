package com.crmproject.crm.controller;

import com.crmproject.crm.dto.ActivityLogDTO;
import com.crmproject.crm.model.ActivityLog;
import com.crmproject.crm.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/activitylogs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping
    @Operation(summary = "Get all activity logs", description = "Retrieve all activity logs from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved activity logs"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogService.getAllActivityLogs();
    }

    @PostMapping
    @Operation(summary = "Add a new activity log", description = "Add a new activity log to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added activity log"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ActivityLog addActivityLog(@RequestBody ActivityLogDTO activityLogDTO) {
        return activityLogService.saveActivityLog(activityLogDTO);
    }

    // Other CRUD operations as needed
}
