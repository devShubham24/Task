package com.sb.main.taskEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pdmp_user_id")
    private Long pdmpUserId;
    
    @Column(name = "audit_Action")
    private String auditAction;
    
    @Column(name = "user_roles")
    private String userRoles;
    
    @Column(name = "gender")
    private String gender;
    
    // Constructors, getters, setters, etc.
    
    public Task() {
        // Default constructor
    }
    
    // Getters and setters
    
    public Long getPdmpUserId() {
        return pdmpUserId;
    }

    public void setPdmpUserId(Long pdmpUserId) {
        this.pdmpUserId = pdmpUserId;
    }

    public String getAuditAction() {
        return auditAction;
    }

    public void setAuditAction(String auditAction) {
        this.auditAction = auditAction;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
