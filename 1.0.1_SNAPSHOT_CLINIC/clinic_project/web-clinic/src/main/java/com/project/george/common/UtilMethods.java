package com.project.george.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.project.george.bean.catalog.presentation.canonical.BeanResponseCanonicalPresentation;
import com.project.george.model.TbArea;
import com.project.george.model.TbDetailKardex;
import com.project.george.model.TbKardex;
import com.project.george.model.TbNewPatient;
import com.project.george.model.TbPatient;
import com.project.george.model.TbPresentation;
import com.project.george.model.TbRole;
import com.project.george.model.TbProduct;
import com.project.george.model.TbUser;
import com.project.george.model.dto.TbAreasDTO;
import com.project.george.model.dto.TbDetailKardexDTO;
import com.project.george.model.dto.TbKardexDTO;
import com.project.george.model.dto.TbNewPatientDTO;
import com.project.george.model.dto.TbPatientDTO;
import com.project.george.model.dto.PresentationDTO;
import com.project.george.model.dto.TbRoleDTO;
import com.project.george.model.dto.ProductDTO;
import com.project.george.model.dto.TbUserDTO;

public class UtilMethods {
	
	public TbDetailKardexDTO copyValuesTbDetailKardexDTO(TbDetailKardex beanFrom,TbDetailKardexDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setComprobanteClase(beanFrom.getComprobante_clase());
		beanTo.setComprobanteNumero(beanFrom.getComprobante_number());
		beanTo.setCantidad(beanFrom.getCantidad());
		beanTo.setTypeOperation(beanFrom.getTypeOperation());
		beanTo.setPriceProduct(beanFrom.getPrice_Product());
		beanTo.setPriceSale(beanFrom.getPrice_sale());
		beanTo.setDateCreated(beanFrom.getDateCreated());
		return beanTo;
	}
	
	public TbKardexDTO copyValuesTbKardexDTO(TbKardex beanFrom,TbKardexDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setCountProduct(beanFrom.getCountProduct());
		beanTo.setTotalEgress(beanFrom.getTotalEgress());
		beanTo.setTotalEntry(beanFrom.getTotalEntry());
		beanTo.setNameProduct(beanFrom.getTbProduct().getNameProduct());
		beanTo.setNamePresentation(beanFrom.getTbProduct().getTbPresentation().getNamePresentation());
		beanTo.setIdProduct(beanFrom.getTbProduct().getId());
		beanTo.setPriceTotalProduct(beanFrom.getPriceTotalProduct());
		beanTo.setPriceTotalSale(beanFrom.getPriceTotalSale());
		return beanTo;
	}
	
	public ProductDTO copyValuesTypeProductDTO(TbProduct beanFrom,ProductDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setNameProduct(beanFrom.getNameProduct());
		beanTo.setStatus(beanFrom.getStatus());
		beanTo.setNamePresentation(beanFrom.getTbPresentation().getNamePresentation());
		beanTo.setIdPresentation(beanFrom.getTbPresentation().getId());
		beanTo.setPrice(beanFrom.getPrice_Product());
		beanTo.setPriceSale(beanFrom.getPrice_sale());
		beanTo.setExpirationDate(convertFormatString(beanFrom.getExpirationDate(), CommonConstants.FormatDate.MM_DD_YYYY));
		return beanTo;
		
	}
	
	public PresentationDTO copyValuesPresentationDTO(TbPresentation beanFrom,PresentationDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setNamePresentation(beanFrom.getNamePresentation());
		beanTo.setStatus(beanFrom.getStatus());
		return beanTo;
		
	}
	
	public PresentationDTO copyValuesPresentationDTOfromService(BeanResponseCanonicalPresentation beanFrom,PresentationDTO beanTo){
		beanTo.setId(beanFrom.Id);
		beanTo.setNamePresentation(beanFrom.NamePresentation);
		beanTo.setStatus(beanFrom.Status);
		return beanTo;
		
	}

	public TbUserDTO copyValuesUserDTO(TbUser beanFrom,TbUserDTO beanTo){
		beanTo.setApellidoUsuario(beanFrom.getApellidoUsuario());
		beanTo.setDateCreated(beanFrom.getDateCreated());
		beanTo.setDateUpdated(beanFrom.getDateUpdated());
		beanTo.setId(beanFrom.getId());
		beanTo.setNombreUsuario(beanFrom.getNombreUsuario());
		beanTo.setPassword(beanFrom.getPassword());
		beanTo.setUserCreated(beanFrom.getUserCreated());
		beanTo.setUserName(beanFrom.getUserName());
		beanTo.setUserUpdated(beanTo.getUserUpdated());
		beanTo.setLastLoginFormat(convertFormatString(beanFrom.getLastLoginDate(), CommonConstants.FormatDate.MM_DD_YYYY_HHMMSS));
		return beanTo;
	}
	
	public TbRoleDTO copyValuesRoleDTO(TbRole beanFrom,TbRoleDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setNombreRole(beanFrom.getNombreRole());
		beanTo.setStatus(beanFrom.getStatus());
		return beanTo;
	}
	
	public TbAreasDTO copyValuesAreasDTO(TbArea beanFrom,TbAreasDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setNameArea(beanFrom.getNameArea());
		beanTo.setStatus(beanFrom.getStatus());
		return beanTo;
	}
	
	public TbPatientDTO copyValuesPatientDTO(TbPatient beanFrom,TbPatientDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setNamePatient(beanFrom.getNamePatient());
		beanTo.setLastNamePatient(beanFrom.getLastNamePatient());
		beanTo.setCompleteName(beanFrom.getNamePatient()+", "+beanFrom.getLastNamePatient());
		beanTo.setDni(beanFrom.getDni());
		beanTo.setBirthDay(beanFrom.getBirthDay());
		beanTo.setEdad(obtainEdad(beanFrom.getBirthDay()));
		beanTo.setAdress(beanFrom.getAdress());
		beanTo.setIdArea(beanFrom.getTbArea().getId());
		beanTo.setNameAra(beanFrom.getTbArea().getNameArea());
		beanTo.setDistrictName(beanFrom.getDistrictName());
		beanTo.setHistoryClinic(beanFrom.getHistoryClinic());
		beanTo.setBirthDayFormat(convertFormatString(beanFrom.getBirthDay(), CommonConstants.FormatDate.MM_DD_YYYY));
		return beanTo;
	}
	
	public TbNewPatientDTO copyValuesNewPatientDTO(TbNewPatient beanFrom,TbNewPatientDTO beanTo){
		beanTo.setId(beanFrom.getId());
		beanTo.setNamePatient(beanFrom.getNamePatient());
		beanTo.setLastNamePatient(beanFrom.getLastNamePatient());
		beanTo.setCompleteName(beanFrom.getNamePatient()+", "+beanFrom.getLastNamePatient());
		beanTo.setDni(beanFrom.getDni());
		beanTo.setBirthDay(beanFrom.getBirthDay());
		beanTo.setEdad(obtainEdad(beanFrom.getBirthDay()));
		beanTo.setAddress(beanFrom.getAdress());
		beanTo.setDistrictName(beanFrom.getDistrictName());
		beanTo.setCodeHistoryClinic(beanFrom.getCodeHistoryClinic());
		beanTo.setBirthDayFormat(convertFormatString(beanFrom.getBirthDay(), CommonConstants.FormatDate.MM_DD_YYYY));
		beanTo.setIdSexo(beanFrom.getSex());
		if(beanFrom.getNameReference()==null){
			beanTo.setNameReference("");
		}else{
			beanTo.setNameReference(beanFrom.getNameReference());
		}
		if(beanFrom.getPhoneReference()==null){
			beanFrom.setPhoneReference("");
		}else{
			beanTo.setPhoneReference(beanFrom.getPhoneReference());
		}
		
		return beanTo;
	}
	
	public int obtainEdad(Date birthDate){
		int age=0;
		try {
			Calendar birth = new GregorianCalendar();
			Calendar today = new GregorianCalendar();
						
			int factor=0;
			
			Date currentDate=new Date();
			
			birth.setTime(birthDate);
			today.setTime(currentDate);
			if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)){
				if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)){
					if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)){
						factor = 0;
					}
				}
				else{
					factor = -1;
				}
			}
			age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
			
		} catch (Exception e) {
			System.out.println("Error conversion : "+e.toString());
		}		
		return age;
	}
	
	public String convertFormatString(Date date,String formatTo){
		DateFormat df = new SimpleDateFormat(formatTo);
		String returnDate = df.format(date);
		return returnDate;
	}	
	
	public Date getCurrentDate(){
		Date currentDate=new Date();
		return currentDate;
	}
	
	public static String getStringMessageDigest(String message, String algorithm) {
		byte[] digest = null;
		byte[] buffer = message.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.reset();
			messageDigest.update(buffer);
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException ex) {
			System.out.println("Error creando Digest");
		}
		return toHexadecimal(digest);
	}
	
	public static String toHexadecimal(byte[] digest) {
		String hash = "";
		for (byte aux : digest) {
			int b = aux & 0xff;
			if (Integer.toHexString(b).length() == 1)
				hash += "0";
			hash += Integer.toHexString(b);
		}
		return hash;
	}

		

}
