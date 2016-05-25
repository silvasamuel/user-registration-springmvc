package com.samuelsilva.something.enums;

/**
 * @author samuel.silva
 */

public enum UserStatusEnum {
	ACTIVE("Active", true),
	INACTIVE("Inactive", false);
	
	private String description;
	private Boolean status;
	
	private UserStatusEnum(String description, Boolean status) {
		this.description = description;
		this.setStatus(status);
	}
	
	public static UserStatusEnum recoverByStatus(Boolean status) {
		for (UserStatusEnum statusEntity : UserStatusEnum.values()) {
			if (statusEntity.getStatus().equals(status)) {
				return statusEntity;
			}
		}
		return null;
	}

	// Gets and Sets
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
