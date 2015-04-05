package com.project.george.bean.presentation;

public class BeanResponsePresentation{
	public int id;
	public String namePresentation;
	public int status;
	public String dateCreated;
	public String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePresentation() {
		return namePresentation;
	}

	public void setNamePresentation(String namePresentation) {
		this.namePresentation = namePresentation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
