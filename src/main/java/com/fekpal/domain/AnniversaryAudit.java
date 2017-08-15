package com.fekpal.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "anniversary_audit")
public class AnniversaryAudit extends BasePOJO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    private Club club;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "audit_state")
    private int auditState;

    @Column(name = "audit_result")
    private String auditResult;

    @Column(name = "submit_time")
    private Timestamp submitTime;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
