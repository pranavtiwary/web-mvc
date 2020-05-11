package com.web.mvc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.mvc.dto.ParsedData;
import com.web.mvc.request.ParsingRequest;
import com.web.mvc.service.IParserService;
import com.web.mvc.validator.RequestValidator;
/**
 * Parsing controller
 * 
 *
 */
@Controller
public class ParsingController {

	private static final Logger logger = LoggerFactory.getLogger(ParsingController.class);

	private static final String PARSE_RESPONSE_PAGE = "parse-response";

	private static final String PARSED_DATA_ATTRIB = "parsedData";

	private static final String INDEX_PAGE = "home";

	@Autowired
	private IParserService service;

	@Autowired
	private RequestValidator validator;

	/**
	 * Add validator
	 * 
	 * @param binder
	 */
	@InitBinder("parsingRequest")
	protected void init(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	/**
	 * Post request that serves the actual parsing request
	 * @param parsingRequest
	 * @param bindingResult
	 * @param error
	 * @return
	 */
	@RequestMapping(name="/parse", method = RequestMethod.POST)
	public ModelAndView parse(@Valid @ModelAttribute ParsingRequest parsingRequest,
			BindingResult bindingResult, Errors error) {
		logger.info("Got Request to parse the HTML  : {}", parsingRequest);
		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView(INDEX_PAGE);
			return mv;
		}
		ParsedData parsedData = service.parseUrl(parsingRequest.getUrl());
		ModelAndView mv = new ModelAndView(PARSE_RESPONSE_PAGE);
		mv.addObject(PARSED_DATA_ATTRIB, parsedData);
		return mv;
	}
}
