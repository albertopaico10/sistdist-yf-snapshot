package com.project.george.util;

public class CommonConstants {

	public final static String PRODUCT_SOAP = "http://localhost:2766/Producto.svc";
	public final static String KARDEX_REST = "http://localhost:53924/KardexService.svc/Kardex";
	public final static String PRODUCT_REST = "http://localhost:53924/KardexService.svc/Producto";
	public final static String PRODUCT_REST_ALL = "http://localhost:53924/KardexService.svc/ProductAll";
	public final static String PRODUCT_REST_STATUS = "http://localhost:53924/KardexService.svc/ProductDelete";
	public final static String PRODUCT_REST_BODY = "http://localhost:53924/KardexService.svc/ProductBody";
	
	
	public class Logger{
		public final static String LOGGER_START="********START********";
		public final static String LOGGER_END="********END********";
		
	}
	
	public class ResponseWebService{
		public final static String RESP_WS_SUCCESS="SUCCESS";
		public final static String RESP_WS_SUCCESS_SAVE="SUCCESS_SAVE";
		public final static String RESP_WS_SUCCESS_LIST="SUCCESS_LIST";
		public final static String RESP_WS_ERROR="ERROR";
		public final static String RESP_WS_EXIST="EXIST";
		public final static String RESP_WS_NOT_EXIST="NOT_EXIST";
		public final static String RESP_WS_CONNECTION_REFUSE="CONNECTION_REFUSE";
		public final static String RESP_WS_PRESENTATION_EXIST="PRESENTATION_EXIST";
		public final static String RESP_WS_MESSAGES_INSUFFICIENT_PRODUCT="INSUFFICIENT_PRODUCT";
	}
	
	public class ResponseWebLayer{
		public final static String RESP_SL_SUCCESS="SUCCESS";
		public final static String RESP_SL_SUCCESS_LIST="SUCCESS_LIST";
		public final static String RESP_SL_SUCCESS_UPDATE="SUCCESS_UPDATE";
		public final static String RESP_SL_SUCCESS_DELETE="SUCCESS_DELETE";
		public final static String RESP_SL_ERROR="ERROR";
		public static final String RESP_SL_NOTWORKING="NOTWORKING";
		
	}
}
