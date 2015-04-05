package com.project.george.util;

public class CommonConstants {

	public final static String PRODUCT_SOAP = "http://Alberto-LENO-PC:2766/Producto.svc";
	public final static String KARDEX_REST = "http://localhost:53924/KardexService.svc/Kardex";
	public final static String PRODUCT_REST = "http://localhost:53924/KardexService.svc/Producto";
	
	public class Logger{
		public final static String LOGGER_START="********START********";
		public final static String LOGGER_END="********END********";
		
	}
	
	public class ResponseWebService{
		public final static String RESP_WS_SUCCESS="SUCCESS";
		public final static String RESP_WS_ERROR="ERROR";
	}
	
	public class ResponseWebLayer{
		public final static String RESP_SL_SUCCESS="SUCCESS";
		public final static String RESP_SL_SUCCESS_UPDATE="SUCCESS_UPDATE";
		public final static String RESP_SL_SUCCESS_DELETE="SUCCESS_DELETE";
		public final static String RESP_SL_ERROR="ERROR";
		public static final String RESP_SL_NOTWORKING="NOTWORKING";
		
	}
}
