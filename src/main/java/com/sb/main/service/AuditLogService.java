package com.sb.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.sb.main.Repository.AuditTypeRepository;
import com.sb.main.Repository2.AuditLogRepository;
import com.sb.main.dto.AuditLogDTO;
import com.sb.main.dto2.MaxLoginUserDTO;
import com.sb.main.entity.AuditType;
import com.sb.main.entity2.AuditLog;
import com.sb.main.linechartDTO.TreadsDTO;
import com.sb.main.maxauditlogdto.MaxAuditLogsDTO;
import com.sb.main.taskEntity.Task;
import com.sb.main.taskRepository.TaskRepo;

@Service
public class AuditLogService {
	@Autowired
	private  TaskRepo    taskdao;
    private final AuditTypeRepository auditTypeRepository;
    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditTypeRepository auditTypeRepository, AuditLogRepository auditLogRepository) {
        this.auditTypeRepository = auditTypeRepository;
        this.auditLogRepository = auditLogRepository;
    }

    public List<AuditLog> getLogsByTypeWithoutQuery(String type) {
        AuditType auditType = auditTypeRepository.findByType(type);
        if (auditType != null) {
            return auditLogRepository.findByAuditTypeId(auditType.getAuditTypeId());
        }
        return List.of();  // Return an empty list if no matching type is found
    }

    public List<AuditType> getAllDataOfAuditType() {
        return auditTypeRepository.findAll();}
        
        public List<AuditLog> getAuditLogByJoin(String type) {
       
            return auditLogRepository.findAuditLogsByTypeByJoin(type);   // The getLogsByType() method calls auditLogRepository.findAuditLogsByType(type) to fetch audit logs of the specified type from the database. It returns the result to the controller.
        }
        public List<AuditLog>getAuditLogBySubQuery(String type){
        	System.out.println("coming here:::");
        	try {
      
        	return auditLogRepository.findAuditLogsByTypeBySubQuery(type);
        	}
        	catch(Exception e) {
        		System.out.println(e);
        		return null;
        	}
        }
        //making dto way 1: using  a  dto class and making getter and setter method 

        public List<AuditLogDTO> getAllDto(String type) {
            List<AuditLog> auditLogs = auditLogRepository.findByAuditType1(type);
            List<AuditLogDTO> auditLogDTOs = new ArrayList<>();
           
            for (AuditLog auditLog : auditLogs) {
                AuditLogDTO auditLogDTO = new AuditLogDTO();
               
                // Map fields from AuditLog to AuditLogDTO
                auditLogDTO.setAuditLogId(auditLog.getAuditLogId());
                auditLogDTO.setPdmpUserId(auditLog.getPdmpUserId());
                auditLogDTO.setAffectedUserId(auditLog.getAffectedUserId());
                auditLogDTO.setRoleId(auditLog.getRoleId());
                auditLogDTO.setCaseId(auditLog.getCaseId());
                auditLogDTO.setFileId(auditLog.getFileId());
                auditLogDTO.setComments(auditLog.getComments());
                auditLogDTO.setAuditSource(auditLog.getAuditSource());
                auditLogDTO.setIpAddress(auditLog.getIpAddress());
                auditLogDTO.setCreatedAt(auditLog.getCreatedAt());
                auditLogDTO.setAuditTypeId(auditLog.getAuditTypeId());
                    //    tostring() method
                System.out.println(auditLog.toString());
               
              //  System.out.println(audit);
                // Set related AuditType fields
                
                AuditType auditType = auditLog.getAuditType();
                if (auditType != null) {
                    auditLogDTO.setAuditType(auditType.getType());
                    auditLogDTO.setAuditDescription(auditType.getDescription());
                    auditLogDTO.setAuditTypeCreatedAt(auditType.getCreatedAt());
                    System.out.println(auditType.getType());
                }
                auditLogDTOs.add(auditLogDTO);
            }

            return auditLogDTOs;
            
        }
        public List<MaxLoginUserDTO> fetchMaxLoginUserData() {
            // Fetch data from the repository using the native query
            List<Object[]> results = auditLogRepository.fetchMaxLoginUser();

            // Map the Object[] results to MaxLoginUserDTO using the constructor
            List<MaxLoginUserDTO> dtoList = new ArrayList<>();
            for (Object[] row : results) {
                MaxLoginUserDTO dto = new MaxLoginUserDTO(
                    (Long) row[0],  // pdmpUserId
                    (Long) row[1]   // userCount
                );
                dtoList.add(dto);
            }

            return dtoList;
        }
        public List<TreadsDTO> getLineChartData() {
            // Fetch raw data from the repository query
            List<TreadsDTO> rawData = auditTypeRepository.getLineChartDto();

            // Create a new list to store the mapped DTOs
            List<TreadsDTO> mappedData = new ArrayList<>();     // Create a list to hold the DTOs

            for (TreadsDTO dto : rawData) {
                // Create a new DTO instance
                TreadsDTO mappedDto = new TreadsDTO();
                mappedDto.setType(dto.getType());
                mappedDto.setCreatedAt(dto.getCreatedAt());
                
                // Add to the mapped list
                mappedData.add(mappedDto);
            }

            return mappedData;
        } 
        //Task 5
        public  List<MaxAuditLogsDTO>getmaxAuditLogs(){
        List<MaxAuditLogsDTO> rawData =	auditLogRepository.fetchMaxAuditcount();
        List<MaxAuditLogsDTO> mappedData = new ArrayList<>();

        for (MaxAuditLogsDTO dto : rawData) {
            // Create a new DTO instance
        	MaxAuditLogsDTO   mappedDto = new MaxAuditLogsDTO();
            mappedDto.setAuditSource(dto.getAuditSource());
            mappedDto.setAuditlogsCount(dto.getAuditlogsCount());
            
            // Add to the mapped list
            mappedData.add(mappedDto);
        }
        return   mappedData;
        }
        public List<Task>getAlltaskData(){
			return  taskdao.findAll();
        	
        }
    }

    

