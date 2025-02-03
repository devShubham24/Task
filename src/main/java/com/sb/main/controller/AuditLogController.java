package com.sb.main.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.main.AuditLogDTO;
import com.sb.main.entity.AuditType;
import com.sb.main.entity2.AuditLog;
import com.sb.main.linechartDTO.TreadsDTO;
import com.sb.main.maxauditlogdto.MaxAuditLogsDTO;
import com.sb.main.service.AuditLogService;
import com.sb.main.taskEntity.Task;
import com.sb.main.dto.AuditLogDTO;
import com.sb.main.dto2.MaxLoginUserDTO;

@RestController
public class AuditLogController {
       Logger log=LoggerFactory.getLogger(AuditLogController.class);
    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    // Task-2   (Create an API that takes an input (Type) and fetches all records related to the given Type from the audit_log table, displaying the results in JSON format.)
    @GetMapping("/get-audit-log/{type}")                //  without the using of Sql query get all data of audit_log table
    public List<AuditLog> getLogsByType(@PathVariable String type) {
    	
        return auditLogService.getLogsByTypeWithoutQuery(type);
    }	

    // Task -1 (Get all the data of audit Type table in the form of json)
    @GetMapping("/get-audit-type")
    public List<AuditType> getAllAuditTypes() {
        return auditLogService.getAllDataOfAuditType();
    }
     //fetch audit-log data by its corresponding type through the help of Join
    @GetMapping("/get-audit-log-by-join")
    public List<AuditLog> getAuditLogsByType1(@RequestParam String type) {
        return auditLogService.getAuditLogByJoin(type);
    }
    //fetch audit-log data by its corresponding type through the help of subQuery
    @GetMapping("/get-audit-log-by-sub")
    public List<AuditLog> getAuditLogsByType2(@RequestParam String type) {
    	System.out.println("comgin here ");
        return auditLogService.getAuditLogBySubQuery(type);
    }
    //      Logger-------
      @GetMapping("/get-logger")
    public String runLog() {
    	  int a,b,c;
    	  try { a=20;
    		    b=2;
    		    c=a/b;
    		  log.warn("Do not divide by zero");
    		  log.info("Your Arithmatics operation result is:"+c);
    	  }catch(Exception e) {
    		  log.error("Divide error");
    	  }
		return "Wellcome1234";
    	  
    }
      

      
      @GetMapping("/get-dto")
      public List<AuditLogDTO> getAllDtos(@RequestParam String type) {
          return auditLogService.getAllDto(type);
      }
          // task--2
          @GetMapping("/max-login-users")
          public List<MaxLoginUserDTO> getMaxLoginUsers() {
              return auditLogService.fetchMaxLoginUserData();
          } //task--1
          @GetMapping("/line-chart-data")
          public List<TreadsDTO>fetchlinechartDto(){
			return auditLogService.getLineChartData();						       	  
          }
          //  task -5
          @GetMapping("/Audit-log-count")
         public List<MaxAuditLogsDTO>maxAuditLogscount(){
			return auditLogService.getmaxAuditLogs();
        	 
         }
          @GetMapping("/get-Task-data")
          public List<Task>getAlldataOfTask(){
			return auditLogService.getAlltaskData();
        	  
          }
	
}

