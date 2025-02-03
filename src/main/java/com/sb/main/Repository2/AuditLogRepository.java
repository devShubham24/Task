package com.sb.main.Repository2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sb.main.dto2.MaxLoginUserDTO;
import com.sb.main.entity2.AuditLog;
import com.sb.main.maxauditlogdto.MaxAuditLogsDTO;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByAuditTypeId(Long auditTypeId);

    @Query(value = "SELECT al.* FROM audit_log al " +
            "INNER JOIN audit_type at ON at.audit_type_id = al.audit_type_id " +
            "WHERE at.type = :type", nativeQuery = true)
    List<AuditLog> findAuditLogsByTypeByJoin(@Param("type") String type);  

    @Query(value = "SELECT * FROM audit_log " +
                   "WHERE audit_type_id = (SELECT audit_type_id FROM audit_type WHERE type = :type)", nativeQuery = true)
    List<AuditLog> findAuditLogsByTypeBySubQuery(@Param("type") String type);
    
    @Query("SELECT al FROM AuditLog al JOIN FETCH al.auditType at WHERE at.type = :type")
    List<AuditLog> findByAuditType1(@Param("type") String type);

    @Query(value ="SELECT pdmp_user_id, COUNT(pdmp_user_id) AS user_login " +
            "FROM audit_log " +
            "GROUP BY pdmp_user_id " +
            "ORDER BY user_login DESC" , 
    nativeQuery = true)
    List<Object[]> fetchMaxLoginUser();
    
    @Query(value="SELECT audit_source AS auditSource, COUNT(audit_source) AS auditlogsCount " +
            "FROM audit_log " +
            "GROUP BY audit_source " +  // Use original column name
            "ORDER BY auditlogsCount DESC", nativeQuery = true)
List<MaxAuditLogsDTO> fetchMaxAuditcount();
}
