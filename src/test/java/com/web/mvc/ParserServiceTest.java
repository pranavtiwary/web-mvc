package com.web.mvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.web.mvc.dto.ParsedData;
import com.web.mvc.service.IParserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserServiceTest {

	@Autowired
	private IParserService service;
	
	public static final String TITLE_GIT="Sign in to GitHub · GitHub";
	
	@Test
	public void test(){
		ParsedData parsedData = service.parseUrl("https://github.com/login");
		assertNotNull(parsedData);
		assertEquals(TITLE_GIT, parsedData.getTitle());
		assertTrue(parsedData.isHasLoginForm());
		
	}
}
