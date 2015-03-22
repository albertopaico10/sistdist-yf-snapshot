package com.project.george.model.facade;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.george.bean.catalog.presentation.BeanRequestPresentation;
import com.project.george.bean.catalog.presentation.BeanResponseListPresentation;
import com.project.george.bean.catalog.presentation.BeanResponsePresentation;
import com.project.george.bean.catalog.presentation.canonical.BeanListPresentation;
import com.project.george.bean.catalog.presentation.canonical.BeanResponseCanonicalPresentation;
import com.project.george.common.CommonConstants;
import com.project.george.common.UtilMethods;
import com.project.george.facade.business.ClinicApplicationBusiness;
import com.project.george.facade.service.impl.PresentationServiceImpl;
import com.project.george.model.TbPresentation;
import com.project.george.model.bean.BeanResponseWeb;
import com.project.george.model.dao.TablePresentationDao;
import com.project.george.model.dto.PresentationDTO;

@Service
@Transactional
public class TablePresentationManagerImpl implements TablePresentationManager {
	private static Logger logger = Logger.getLogger(TablePresentationManagerImpl.class);
	
	@Autowired
	TablePresentationDao custmTablePresentation;
	@Autowired
	ClinicApplicationBusiness clinicApplicationBusiness;
	
	public List<PresentationDTO> listAllPresentation() throws Exception {
		System.out.println("Inside listAllPresentation");
		List<TbPresentation> listAllPresentation=custmTablePresentation.listAllPresentation();
		
		List<PresentationDTO> newListAllPresentation=new ArrayList<PresentationDTO>();
		
		UtilMethods utilMethods=new UtilMethods();
		
		for (TbPresentation beanPresentation:listAllPresentation) {
			 PresentationDTO beanPresentationDTO=new PresentationDTO();
			 beanPresentationDTO=utilMethods.copyValuesPresentationDTO(beanPresentation, beanPresentationDTO);
			 newListAllPresentation.add(beanPresentationDTO);
		}
		if(newListAllPresentation.size()==0){
			newListAllPresentation=null;
		}
		return newListAllPresentation;
	}
	
	public String addNewPresentation(TbPresentation tbPresentationBean) throws Exception {
		String returnRsponse=CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTATION_NEW;
		try {
			custmTablePresentation.addNewPresentation(tbPresentationBean);
		} catch (Exception e) {
			returnRsponse=CommonConstants.ERROR;
		}
		return returnRsponse;
	}
	
	public String deletePresentation(int idPresentation) throws Exception {
		String returnRsponse=CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTATION_NEW;
		TbPresentation tbPresentationBean=new TbPresentation();
		tbPresentationBean=custmTablePresentation.beanPresentationSpecific(idPresentation);
		tbPresentationBean.setId(idPresentation);
		tbPresentationBean.setStatus(2);//--2 is Inactive
		custmTablePresentation.deletePresentation(tbPresentationBean);
		return returnRsponse;
	}
	//----------------------------------------------------------------------------------------------------------------
	public BeanResponseWeb insertNewPresentation(PresentationDTO beanPresentationDTO) throws Exception {
		logger.info(CommonConstants.Logger.LOGGER_START);
		BeanRequestPresentation beanPresentationRequest=new BeanRequestPresentation();
		beanPresentationRequest.setNamePresentation(beanPresentationDTO.getNamePresentation());

		//--Call Service for save Presentation
		BeanResponseListPresentation beanResponsePresentation=clinicApplicationBusiness.savePresentation(beanPresentationRequest);

		//--Response Web layer
		BeanResponseWeb beanResponseWeb=new BeanResponseWeb();
		if(CommonConstants.ResponseIdResult.RESULT_CORRECT.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("Se grabo con Exito...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_ERROR.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("Hubo un error en el proceso...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_NOTWORKING.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("El Servicio no esta Activo. Por favor comunicarse con el Administrador...!!");
		}
		//--List All Presentation to Service
		BeanResponseListPresentation beanListResponse=clinicApplicationBusiness.listAllPresentation();
		System.out.println("Cantidad de registros : "+beanListResponse.getBeanListPresentation().size());
		List<PresentationDTO> newListAllPresentation=new ArrayList<PresentationDTO>();
		UtilMethods utilMethods=new UtilMethods();
		for(BeanResponseCanonicalPresentation beanCanonicalPresentation:beanListResponse.getBeanListPresentation()){
			 PresentationDTO reponsebeanPresentationDTO=new PresentationDTO();
			 beanPresentationDTO=utilMethods.copyValuesPresentationDTOfromService(beanCanonicalPresentation, reponsebeanPresentationDTO);
			 newListAllPresentation.add(reponsebeanPresentationDTO);
		}
		beanResponseWeb.setListPresentationDTO(newListAllPresentation);
		logger.info(CommonConstants.Logger.LOGGER_END);
		return beanResponseWeb;
	}

	public List<PresentationDTO> listPresentationComplete() throws Exception {
		logger.info(CommonConstants.Logger.LOGGER_START);
		//--Call Service List Presentation
		BeanResponseListPresentation beanListResponse=clinicApplicationBusiness.listAllPresentation();
		System.out.println("Cantidad de registros : "+beanListResponse.getBeanListPresentation().size());
		List<PresentationDTO> newListAllPresentation=new ArrayList<PresentationDTO>();
		UtilMethods utilMethods=new UtilMethods();
		for(BeanResponseCanonicalPresentation beanCanonicalPresentation:beanListResponse.getBeanListPresentation()){
			 PresentationDTO beanPresentationDTO=new PresentationDTO();
			 beanPresentationDTO=utilMethods.copyValuesPresentationDTOfromService(beanCanonicalPresentation, beanPresentationDTO);
			 newListAllPresentation.add(beanPresentationDTO);
		}
		logger.info(CommonConstants.Logger.LOGGER_START);
		return newListAllPresentation;
	}
	
	public BeanResponseWeb updatePresentation(PresentationDTO beanPresentationDTO) throws Exception {
		logger.info(CommonConstants.Logger.LOGGER_START);
		BeanRequestPresentation beanPresentationRequest=new BeanRequestPresentation();
		beanPresentationRequest.setId(beanPresentationDTO.getId());
		beanPresentationRequest.setNamePresentation(beanPresentationDTO.getNamePresentation());
		
		//--Call Service for save Presentation
		BeanResponseListPresentation beanResponsePresentation=clinicApplicationBusiness.updatePresentation(beanPresentationRequest);
		//--Response Web layer
		BeanResponseWeb beanResponseWeb=new BeanResponseWeb();
		if(CommonConstants.ResponseIdResult.RESULT_CORRECT_UPDATE.equals(beanResponsePresentation.getResult())){
			System.out.println("***************** TODO ES CORRECTO ES UN CAMBIO CORRECTO.....!!!");
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("Se grabo con Exito...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_ERROR.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("Hubo un error en el proceso...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_NOTWORKING.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("El Servicio no esta Activo. Por favor comunicarse con el Administrador...!!");
		}
		//--List All Presentation to Service
		BeanResponseListPresentation beanListResponse=clinicApplicationBusiness.listAllPresentation();
		System.out.println("Cantidad de registros : "+beanListResponse.getBeanListPresentation().size());
		List<PresentationDTO> newListAllPresentation=new ArrayList<PresentationDTO>();
		UtilMethods utilMethods=new UtilMethods();
		for(BeanResponseCanonicalPresentation beanCanonicalPresentation:beanListResponse.getBeanListPresentation()){
			 PresentationDTO reponsebeanPresentationDTO=new PresentationDTO();
			 reponsebeanPresentationDTO=utilMethods.copyValuesPresentationDTOfromService(beanCanonicalPresentation, reponsebeanPresentationDTO);
			 newListAllPresentation.add(reponsebeanPresentationDTO);
		}
		beanResponseWeb.setListPresentationDTO(newListAllPresentation);
		logger.info(CommonConstants.Logger.LOGGER_END);
		return beanResponseWeb;
	}
	
	public BeanResponseWeb deletePresentationWS(int idPresentation) throws Exception {
		logger.info(CommonConstants.Logger.LOGGER_START);
		BeanRequestPresentation beanPresentationRequest=new BeanRequestPresentation();
		beanPresentationRequest.setId(idPresentation);
		
		//--Call Service for save Presentation
		BeanResponseListPresentation beanResponsePresentation=clinicApplicationBusiness.deletePresentation(beanPresentationRequest);
		//--Response Web layer
		BeanResponseWeb beanResponseWeb=new BeanResponseWeb();
		if(CommonConstants.ResponseIdResult.RESULT_CORRECT_DELETE.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTATION_NEW);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("Se grabo con Exito...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_ERROR.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("Hubo un error en el proceso...!!");
		}else if(CommonConstants.ResponseIdResult.RESULT_NOTWORKING.equals(beanResponsePresentation.getResult())){
			beanResponseWeb.setRedirectTo(CommonConstants.ManteniencePresentation.RESPONSE_MANTENIENCE_PRESENTENTION);
			beanResponseWeb.setStatusResponse(beanResponsePresentation.getResult());
			beanResponseWeb.setMessage("El Servicio no esta Activo. Por favor comunicarse con el Administrador...!!");
		}
		//--List All Presentation to Service
//		BeanResponseListPresentation beanListResponse=clinicApplicationBusiness.listAllPresentation();
//		System.out.println("Cantidad de registros : "+beanListResponse.getBeanListPresentation().size());
//		List<PresentationDTO> newListAllPresentation=new ArrayList<PresentationDTO>();
//		UtilMethods utilMethods=new UtilMethods();
//		for(BeanResponseCanonicalPresentation beanCanonicalPresentation:beanListResponse.getBeanListPresentation()){
//			 PresentationDTO reponsebeanPresentationDTO=new PresentationDTO();
//			 reponsebeanPresentationDTO=utilMethods.copyValuesPresentationDTOfromService(beanCanonicalPresentation, reponsebeanPresentationDTO);
//			 newListAllPresentation.add(reponsebeanPresentationDTO);
//		}
//		beanResponseWeb.setListPresentationDTO(newListAllPresentation);
		logger.info(CommonConstants.Logger.LOGGER_END);
		return beanResponseWeb;
	}

}
