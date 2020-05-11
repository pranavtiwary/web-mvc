package com.web.mvc.request;

/**
 * Parsing request 
 *
 */
public class ParsingRequest {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ParsingRequest [url=" + url + "]";
	}
}
