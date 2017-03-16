package com.biglog.ticket.web.model;

/**
 * Created by ngw on 2017/3/13.
 */
public class ReasonAndMeasure {

    private String reasonClassification;//原因分类

    private String reasonSubdivision;//原因明细

    private String failureReason;//故障原因

    private String processingMeasures;//处理措施

    public ReasonAndMeasure(String reasonClassification,String reasonSubdivision,String failureReason,String processingMeasures){

        this.reasonClassification = reasonClassification;

        this.reasonSubdivision = reasonSubdivision;

        this.failureReason = failureReason;

        this.processingMeasures = processingMeasures;
    }

    public ReasonAndMeasure(){}

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getProcessingMeasures() {
        return processingMeasures;
    }

    public void setProcessingMeasures(String processingMeasures) {
        this.processingMeasures = processingMeasures;
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
