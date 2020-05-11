package com.web.mvc;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Test;

import com.web.mvc.service.impl.ParserUtility;

public class DomainNameTest {

	private static final String DOMAIN_NAME = "example.com";

	@Test
	public void testDomainName() throws MalformedURLException{
		String url1="http://www.example.com";
		String url2="http://test.example.com";
		String url3="http://test2.example.com";
		String domainName = ParserUtility.findDomainName(url1);
		assertEquals(domainName, DOMAIN_NAME);
		domainName = ParserUtility.findDomainName(url2);
		assertEquals(domainName, DOMAIN_NAME);
		domainName = ParserUtility.findDomainName(url3);
		assertEquals(domainName, DOMAIN_NAME);
	}
}
