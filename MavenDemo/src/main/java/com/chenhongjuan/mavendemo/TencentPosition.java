package com.chenhongjuan.mavendemo;

//ְλ�࣬����ְλ�����ơ�ְλ����������ص㡢����ʱ��
public class TencentPosition {
	private String positionName;
	private String positionLink;
	private String positionType;
	private String positionNum;
	private String workLocation;
	private String publishTime;
	
	public TencentPosition() {
		super();
	}

	public TencentPosition(String positionName, String positionLink, String positionType, String positionNum,
			String workLocation, String publishTime) {
		super();
		this.positionName = positionName;
		this.positionLink = positionLink;
		this.positionType = positionType;
		this.positionNum = positionNum;
		this.workLocation = workLocation;
		this.publishTime = publishTime;
	}
	//���toString()����
	@Override
	public String toString() {
		return "TencentPosition [positionName=" + positionName + ", positionLink=" + positionLink + ", positionType="
				+ positionType + ", positionNum=" + positionNum + ", workLocation=" + workLocation + ", publishTime="
				+ publishTime + "]";
	}

	//�����ֶ��Զ�����get��set����
	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionLink() {
		return positionLink;
	}

	public void setPositionLink(String positionLink) {
		this.positionLink = positionLink;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getPositionNum() {
		return positionNum;
	}

	public void setPositionNum(String positionNum) {
		this.positionNum = positionNum;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	
}
