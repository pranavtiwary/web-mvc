package com.web.mvc.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Common Utility class
 *
 */
public class ParserUtility {

	/**
	 * Find domain name of an URL
	 * 
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 */
	public static String findDomainName(String url) throws MalformedURLException{
		String domainName = null;
		domainName = new URL(url).getHost();
		String[] levels = domainName.split("\\.");
		if (levels.length > 1)
		{
			domainName = levels[levels.length - 2] + "." + levels[levels.length - 1];
		}
		return domainName;
	}
}
