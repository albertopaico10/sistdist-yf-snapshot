package com.project.george.bean.kardex.canonical;

import java.util.List;

public class BeanResponseCanonicalListDetailKardex {

	public List<BeanResponseCanonicalKardexDetail> listDetailKardex;
	public String result;
	public String messages;
	
	public List<BeanResponseCanonicalKardexDetail> getListDetailKardex() {
		return listDetailKardex;
	}
	public void setListDetailKardex(
			List<BeanResponseCanonicalKardexDetail> listDetailKardex) {
		this.listDetailKardex = listDetailKardex;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
}
