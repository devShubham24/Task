package com.sb.main.maxauditlogdto;

public class MaxAuditLogsDTO {
private  String auditSource;
private long  auditlogsCount;
public String getAuditSource() {
	return auditSource;
}
public void setAuditSource(String auditSource) {
	this.auditSource = auditSource;
}
public long getAuditlogsCount() {
	return auditlogsCount;
}
public void setAuditlogsCount(long auditlogsCount) {
	this.auditlogsCount = auditlogsCount;
}
public MaxAuditLogsDTO(String auditSource, long auditlogsCount) {
	super();
	this.auditSource = auditSource;
	this.auditlogsCount = auditlogsCount;
}
public MaxAuditLogsDTO() {
	super();
	// TODO Auto-generated constructor stub
}
}
