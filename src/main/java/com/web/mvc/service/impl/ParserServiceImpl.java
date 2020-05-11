package com.web.mvc.service.impl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.mvc.dto.ParsedData;
import com.web.mvc.service.IParserService;

/**
 * Parsing service impl
 *
 */
@Service
public class ParserServiceImpl implements IParserService {

	private static final Logger logger = LoggerFactory.getLogger(ParserServiceImpl.class);

	@Override
	public ParsedData parseUrl(String url) {
		ParsedData parsedData=null;
		try{
			Document document = Jsoup.connect(url).get();
			parsedData = new ParsedData();
			extractTitleAndVersion(parsedData, document);
			extractHeadlineData(parsedData, document);
			String domainName= null;
			try {
				domainName=ParserUtility.findDomainName(url);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			logger.info("Domain Name of URL entered : {}", domainName);
			if(null!=domainName){
				extractLinkData(parsedData, document, domainName);
			}
			extractPasswordField(parsedData, document);
		}catch(Exception ex){
			logger.error("Error at parsing data", ex);
			parsedData=null;
		}
		logger.info("Parsed Data response : {}", parsedData);
		return parsedData;
	}

	/**
	 * Extract the title and version
	 * 
	 * @param parsedData
	 * @param document
	 */
	private void extractTitleAndVersion(ParsedData parsedData, Document document) {
		String title = document.title();
		String docType = null ,docVersion = null;
		List<Node>nods = document.childNodes();
		for (Node node : nods) {
			if (node instanceof DocumentType) {
				DocumentType documentType = (DocumentType)node;
				docType=documentType.toString();
				docVersion=documentType.attr("publicid");
			}
		}
		parsedData.setTitleDocAndVersion(title, docVersion, docType);
	}

	/**
	 * Extract if there is passwrd field
	 * 
	 * @param parsedData
	 * @param document
	 */
	private void extractPasswordField(ParsedData parsedData, Document document) {
		Elements inputs = document.select("input[type=password]");
		if(null!=inputs && inputs.size()>0){
			parsedData.setHasLoginForm(true);
		}
	}

	/**
	 * Extract the headline like h1, h2..
	 * 
	 * @param parsedData
	 * @param document
	 */
	private void extractHeadlineData(ParsedData parsedData, Document document) {
		Elements hTags = document.select("h1, h2, h3, h4, h5, h6");
		int h1Tags = hTags.select("h1").size();
		int h2Tags = hTags.select("h2").size();
		int h3Tags = hTags.select("h3").size();
		int h4Tags = hTags.select("h4").size();
		int h5Tags = hTags.select("h5").size();
		int h6Tags = hTags.select("h6").size();
		parsedData.setHeadLineTags(h1Tags,h2Tags,h3Tags,h4Tags,h5Tags,h6Tags);
	}

	/**
	 * Extract the link data
	 * 
	 * @param parsedData
	 * @param document
	 * @param domainName
	 */
	private void extractLinkData(ParsedData parsedData, Document document, String domainName) {
		Elements links = document.select("a[href]");
		Elements media = document.select("[src]");

		List<String> hrefLink = links.stream().map(e->e.absUrl("href")).collect(Collectors.toList());
		List<String> mediaLink = media.stream().map(e->e.absUrl("src")).collect(Collectors.toList());

		long hrefInternalCount = hrefLink.stream().map(e->{
			String domainNameOfLink =null;
			try {
				domainNameOfLink = ParserUtility.findDomainName(e);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			return domainNameOfLink;
		}).filter(e->e.equalsIgnoreCase(domainName)).count();

		long mediaInternalCount = mediaLink.stream().map(e->{
			String domainNameOfLink =null;
			try {
				domainNameOfLink = ParserUtility.findDomainName(e);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			return domainNameOfLink;
		}).filter(e->e.equalsIgnoreCase(domainName)).count();
		parsedData.setLinkCounts(hrefLink.size(), hrefInternalCount, mediaLink.size(), mediaInternalCount);
	}

}
