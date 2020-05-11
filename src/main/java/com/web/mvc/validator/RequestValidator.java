package com.web.mvc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.web.mvc.request.ParsingRequest;

/**
 * Validator of parsing request
 *
 */
@Component
public class RequestValidator implements Validator {

	private static final String URL_REGEX ="(?i)^(?:(?:https?|ftp)://)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)"
			+ "(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])"
			+ "(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}"
			+ "(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)"
			+ "(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)"
			+ "(?::\\d{2,5})?(?:[/?#]\\S*)?$";

	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

	@Override
	public boolean supports(Class<?> clazz) {
		return ParsingRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ParsingRequest req = (ParsingRequest) target;
		if(null==req.getUrl()){
			errors.rejectValue("url", null, "Url can not be empty");
			return;
		}
		Matcher urlMatcher = URL_PATTERN.matcher(req.getUrl());
		if (!urlMatcher.matches()) {
			errors.rejectValue("url", null, "Url seems incorrect");
		}
	}

}
