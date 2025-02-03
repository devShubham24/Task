package com.sb.main.dto2;
public class MaxLoginUserDTO {

    private Long pdmpUserId;    // The user ID
    private Long userCount;     // The count of logins

    // Constructor to handle two fields
   

    public MaxLoginUserDTO(Long pdmpUserId, Long userCount) {
        this.pdmpUserId = pdmpUserId;
        this.userCount = userCount;
    }

	// Getters and Setters
    public Long getPdmpUserId() {
        return pdmpUserId;
    }

    public void setPdmpUserId(Long pdmpUserId) {
        this.pdmpUserId = pdmpUserId;
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }
}
