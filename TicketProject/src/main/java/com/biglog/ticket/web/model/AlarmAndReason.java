package com.biglog.ticket.web.model;

/**
 * Created by ngw on 2017/3/13.
 */
public class AlarmAndReason {

    private String alarmTitle;//告警标题

    private String reasonClassification;//原因分类

    private String reasonSubdivision;//原因明细

    private String failureReason;//故障原因

    public AlarmAndReason(String alarmTitle,String reasonClassification,String reasonSubdivision,String failureReason){

        this.alarmTitle = alarmTitle;

        this.reasonClassification = reasonClassification;

        this.reasonSubdivision = reasonSubdivision;

        this.failureReason = failureReason;
    }

    public AlarmAndReason(){}

    public String getAlarmTitle() {
        return alarmTitle;
    }

    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getReasonClassification() {
        return reasonClassification;
    }

    public void setReasonClassification(String reasonClassification) {
        this.reasonClassification = reasonClassification;
    }

    public String getReasonSubdivision() {
        return reasonSubdivision;
    }

    public void setReasonSubdivision(String reasonSubdivision) {
        this.reasonSubdivision = reasonSubdivision;
    }
}
