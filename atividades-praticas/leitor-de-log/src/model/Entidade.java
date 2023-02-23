package model;

public class Entidade {

  private String alarmSerialNo;

  private String syncNo;

  private String parentSerialNo;

  private String subnetId;

  private String managedElementId;

  private String managedElementType;

  private String alarmId;

  private String alarmName;

  public String getAlarmSerialNo() {
    return this.alarmSerialNo;
  }

  public void setAlarmSerialNo(String alarmSerialNo) {
    this.alarmSerialNo = alarmSerialNo;
  }

  public String getSyncNo() {
    return this.syncNo;
  }

  public void setSyncNo(String syncNo) {
    this.syncNo = syncNo;
  }

  public String getParentSerialNo() {
    return this.parentSerialNo;
  }

  public void setParentSerialNo(String parentSerialNo) {
    this.parentSerialNo = parentSerialNo;
  }

  public String getSubnetId() {
    return this.subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }

  public String getManagedElementId() {
    return this.managedElementId;
  }

  public void setManagedElementId(String managedElementId) {
    this.managedElementId = managedElementId;
  }

  public String getManagedElementType() {
    return this.managedElementType;
  }

  public void setManagedElementType(String managedElementType) {
    this.managedElementType = managedElementType;
  }

  public String getAlarmId() {
    return this.alarmId;
  }

  public void setAlarmId(String alarmId) {
    this.alarmId = alarmId;
  }

  public String getAlarmName() {
    return this.alarmName;
  }

  public void setAlarmName(String alarmName) {
    this.alarmName = alarmName;
  }

  @Override
  public String toString() {
    return "{" +
        "alarmSerialNo='" + getAlarmSerialNo() + "'" +
        ", syncNo='" + getSyncNo() + "'" +
        ", parentSerialNo='" + getParentSerialNo() + "'" +
        ", subnetId='" + getSubnetId() + "'" +
        ", managedElementId='" + getManagedElementId() + "'" +
        ", managedElementType='" + getManagedElementType() + "'" +
        ", alarmId='" + getAlarmId() + "'" +
        ", alarmName='" + getAlarmName() + "'" +
        "}";
  }

}
