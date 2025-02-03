package com.sb.main.linechartDTO;

import java.sql.Timestamp;

public class TreadsDTO {
    private String type;
    private Timestamp createdAt;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public TreadsDTO(String type, Timestamp createdAt) {
		
		this.type = type;
		this.createdAt = createdAt;
	}
	public TreadsDTO() {
		
		// TODO Auto-generated constructor stub
	}

   
    }