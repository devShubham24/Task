package com.sb.main.dto;

import java.time.LocalDateTime;

public class AuditLogDTO {

    private Long auditLogId;
    private Long pdmpUserId;
    private Long affectedUserId;
    private Long roleId;
    private Long caseId;
    private Long fileId;
    private String comments;
    private Long auditTypeId;
    private String auditSource;
    private String ipAddress;
    private LocalDateTime createdAt;

    // AuditType related fields directly in the AuditLogDTO
    private String auditType;       // The type field from AuditType
    private String auditDescription; // The description field from AuditType
    private LocalDateTime auditTypeCreatedAt;  // The createdAt field from AuditType
     
     
    // Getters and Setters
    public Long getAuditLogId() {
        return auditLogId;
    }

    public void setAuditLogId(Long auditLogId) {
        this.auditLogId = auditLogId;
    }

    public Long getPdmpUserId() {
        return pdmpUserId;
    }

    public void setPdmpUserId(Long pdmpUserId) {
        this.pdmpUserId = pdmpUserId;
    }

    public Long getAffectedUserId() {
        return affectedUserId;
    }

    public void setAffectedUserId(Long affectedUserId) {
        this.affectedUserId = affectedUserId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getAuditTypeId() {
        return auditTypeId;
    }

    public void setAuditTypeId(Long auditTypeId) {
        this.auditTypeId = auditTypeId;
    }

   // @Override
	//public String toString() {
	//	return "AuditLogDTO [auditLogId=" + auditLogId + "]";
	//}

	public String getAuditSource() {
        return auditSource;
    }

    public void setAuditSource(String auditSource) {
        this.auditSource = auditSource;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // AuditType Fields
    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getAuditDescription() {
        return auditDescription;
    }

    public void setAuditDescription(String auditDescription) {
        this.auditDescription = auditDescription;
    }

    public LocalDateTime getAuditTypeCreatedAt() {
        return auditTypeCreatedAt;
    }

    public void setAuditTypeCreatedAt(LocalDateTime auditTypeCreatedAt) {
        this.auditTypeCreatedAt = auditTypeCreatedAt;
    }
}
