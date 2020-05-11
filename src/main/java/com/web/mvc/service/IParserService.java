package com.web.mvc.service;

import com.web.mvc.dto.ParsedData;
/**
 * Parsing service
 *
 */
public interface IParserService {

	/**
	 * Parse the html of the given url
	 * 
	 * @param url : url to be fetched and parsed
	 * @return ParsedData : the response of parsing
	 * 
	 */
	public ParsedData parseUrl(String url);
}
