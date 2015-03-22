package com.project.george.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.george.facade.service.impl.PresentationServiceImpl;

//import com.jayway.jsonpath.JsonPath;
//import com.jayway.jsonpath.PathNotFoundException;
//import net.minidev.json.JSONArray;
//import net.minidev.json.JSONObject;

public final class JsonUtils {
	private static Logger LOG = Logger.getLogger(PresentationServiceImpl.class);

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static final String BLANCK_CHARACTER = "";
	private static final String UNICODE_CHARACTER_EXPRESSION = "\\r|\\t|\\n";
	private static final String UNCHECKED = "unchecked";

	private JsonUtils() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 
	 * @param json
	 *            json string
	 * @param clazz
	 *            class to be converted
	 * @return an object of the specified class
	 */
	@SuppressWarnings(UNCHECKED)
	public static <T> T fromJson(String json, Class<?> clazz) {
		return (T) gson.fromJson(json, clazz);
	}
	@SuppressWarnings(UNCHECKED)
	public static <T> T fromJson(String json, Class<?> clazz,String format) {
		Gson gson = new GsonBuilder().setDateFormat(format).setPrettyPrinting().create();
		return (T) gson.fromJson(json, clazz);
	}

	/**
	 * 
	 * @param obj
	 *            java object
	 * @return json string
	 */
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static String toJson(Object obj,String format) {
		Gson gson = new GsonBuilder().setDateFormat(format).setPrettyPrinting().create();
		return gson.toJson(obj);
	}
	
	/**
	 * 
	 * @param json
	 * @return returns a json converted to List
	 * @throws IOException
	 */
	@SuppressWarnings(UNCHECKED)
	public static Map<String, Object> jsonToMap(String json) throws IOException {
		Map<String, Object> input = new ObjectMapper()
				.readValue(json.replaceAll(UNICODE_CHARACTER_EXPRESSION,
						BLANCK_CHARACTER), Map.class);
		return input;
	}

	/**
	 * 
	 * @param json
	 * @return returns a json converted to map
	 * @throws IOException
	 */
	@SuppressWarnings(UNCHECKED)
	public static List<Object> jsonToList(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Object> input = mapper
				.readValue(json.replaceAll(UNICODE_CHARACTER_EXPRESSION,
						BLANCK_CHARACTER), List.class);
		return input;
	}

	/**
	 * @param json
	 *            json string
	 * @param obj
	 *            java object
	 * @return an object of the specified class
	 */
	@SuppressWarnings(UNCHECKED)
	public static <T> T jsonToJavaObject(String json, Class<?> obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		T output = null;
		try {
			output = (T) mapper.readValue(json.replaceAll(
					UNICODE_CHARACTER_EXPRESSION, BLANCK_CHARACTER), obj);
		} catch (JsonGenerationException e) {
			LOG.error(e.getMessage());
		} catch (JsonMappingException e) {
			LOG.error(e.getMessage());
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return output;
	}

	public static String formatterJson(String json) {
		String newJson = null;
		Object object = null;

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			object = mapper.readValue(json.replaceAll(
					UNICODE_CHARACTER_EXPRESSION, BLANCK_CHARACTER),
					Object.class);
			newJson = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(object);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		LOG.debug("jsonFormatted = " + newJson);
		return newJson;
	}

	public static String formatterJsonWithoutNull(String json) {
		String newJson = null;
		Object object = null;

		com.fasterxml.jackson.databind.ObjectMapper mapper = new  com.fasterxml.jackson.databind.ObjectMapper();
		mapper.configure(
				SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		try {
			object = mapper.readValue(json.replaceAll(
					UNICODE_CHARACTER_EXPRESSION, BLANCK_CHARACTER),
					Object.class);
			newJson = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(object);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		LOG.debug("jsonFormatted = " + newJson);
		return newJson;
	}
	
	public static Map<String, Object> transformToValidMap(String json) {
		Map<String, Object> map = null;
		if (!StringUtils.isEmpty(json)) {
			map = JsonUtils.jsonToJavaObject(json, Map.class);
		}
		return map;
	}
	
	
	/*public static Object extractPath(String json, String path) throws IOException {
		if (StringUtils.isEmpty(path)) {
			return json;
		}
		
		Object o = null;
		try{
			o =  JsonPath.read(json, path);	
		}
		catch (PathNotFoundException e) {
			return o;
		}
		String extractedJson = javaObjectToJson(o);
		if(o instanceof JSONArray){
			return jsonToList(extractedJson);
		}
		else if(o instanceof JSONObject){
			return jsonToMap(extractedJson);			
		}
		else{
			return o;
		}
	}
	
	public static List<Object> extractPathToList(String json, String path)
			throws IOException {
		UtilValidator.isEmpty("The mapper expression must not be empty");
		Object o = JsonPath.read(json, path);
		String extractedJson = javaObjectToJson(o);
		if (o instanceof JSONArray) {
			return jsonToList(extractedJson);
		}
		List<Object> list = new ArrayList<Object>();
		list.add(jsonToMap(extractedJson));
		return list;
	}
	
	public static <T> List<T> extractPathToList(String json, String path,
			Class<?> clazz) throws IOException {
		Object extractedObject = JsonPath.read(json, path);
		if (StringUtils.isEmpty(extractedObject)) {
			return null;
		}
		List<T> newList = new ArrayList<T>();
		String extractedJson = javaObjectToJson(extractedObject);
		if (extractedObject instanceof JSONArray) {
			List<Object> list = jsonToJavaObject(extractedJson, List.class);
			for (Object object : list) {
				T t = JsonUtils.jsonToJavaObject(
						JsonUtils.javaObjectToJson(object), clazz);
				newList.add(t);
			}
			return newList;
		}
		T t = jsonToJavaObject(extractedJson, clazz);
		newList.add(t);
		return newList;
	}

	public static <T> T extractPathToObject(String json, String path,
			Class<?> clazz) throws IOException {
		List<T> list = extractPathToList(json, path, clazz);
		if (!StringUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	public static Object extractPathToObject(String json, String path)
			throws IOException {
		List<Object> list = extractPathToList(json, path);
		if (!StringUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	*/
	
	

}
