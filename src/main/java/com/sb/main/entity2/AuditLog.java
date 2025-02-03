package com.sb.main.entity2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.sb.main.entity.AuditType;

@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_log_id")
    private Long auditLogId;

    @Column(name = "pdmp_user_id", nullable = false)
    private Long pdmpUserId;

    @Column(name = "affected_user_id", nullable = false)
    private Long affectedUserId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "case_id", nullable = false)
    private Long caseId;

    @Column(name = "file_id", nullable = false)
    private Long fileId;

    @Column(name = "comments", nullable = false, length = 500)
    private String comments;

    @Column(name = "audit_type_id", nullable = false)
    private Long auditTypeId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "audit_source", nullable = false, length = 255)
    private String auditSource;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "audit_type_id", insertable = false, updatable = false)
    private AuditType auditType;


    public AuditType getAuditType() {
		return auditType;
	}

	public void setAuditType(AuditType auditType) {
		this.auditType = auditType;
	}

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuditSource() {
        return auditSource;
    }

    public void setAuditSource(String auditSource) {
        this.auditSource = auditSource;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
	public String toString() {
		return "AuditLog [auditLogId=" + auditLogId + "]";
	}

	public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
