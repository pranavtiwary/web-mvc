package com.web.mvc.dto;
/**
 * Response of parsing as a DTO
 *
 */
public class ParsedData {

	private int h1Tags;
	private int h2Tags;
	private int h3Tags;
	private int h4Tags;
	private int h5Tags;
	private int h6Tags;
	private String title;
	private String version;
	private String docVersion;
	private String docType;
	private int hrefLinkCount;
	private int mediaLinkCount;
	private long internalHrefLinkCount;
	private long internalMediaLinkCount;
	private boolean hasLoginForm;

	public ParsedData() {
	}
	public int getHrefLinkCount() {
		return hrefLinkCount;
	}
	public void setHrefLinkCount(int hrefLinkCount) {
		this.hrefLinkCount = hrefLinkCount;
	}
	public int getMediaLinkCount() {
		return mediaLinkCount;
	}
	public void setMediaLinkCount(int mediaLinkCount) {
		this.mediaLinkCount = mediaLinkCount;
	}
	public long getInternalHrefLinkCount() {
		return internalHrefLinkCount;
	}
	public void setInternalHrefLinkCount(int internalHrefLinkCount) {
		this.internalHrefLinkCount = internalHrefLinkCount;
	}
	public long getInternalMediaLinkCount() {
		return internalMediaLinkCount;
	}
	public void setInternalMediaLinkCount(int internalMediaLinkCount) {
		this.internalMediaLinkCount = internalMediaLinkCount;
	}
	public String getDocVersion() {
		return docVersion;
	}
	public void setDocVersion(String docVersion) {
		this.docVersion = docVersion;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public int getH1Tags() {
		return h1Tags;
	}
	public void setH1Tags(int h1Tags) {
		this.h1Tags = h1Tags;
	}
	public int getH2Tags() {
		return h2Tags;
	}
	public void setH2Tags(int h2Tags) {
		this.h2Tags = h2Tags;
	}
	public int getH3Tags() {
		return h3Tags;
	}
	public void setH3Tags(int h3Tags) {
		this.h3Tags = h3Tags;
	}
	public int getH4Tags() {
		return h4Tags;
	}
	public void setH4Tags(int h4Tags) {
		this.h4Tags = h4Tags;
	}
	public int getH5Tags() {
		return h5Tags;
	}
	public void setH5Tags(int h5Tags) {
		this.h5Tags = h5Tags;
	}
	public int getH6Tags() {
		return h6Tags;
	}
	public void setH6Tags(int h6Tags) {
		this.h6Tags = h6Tags;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setHeadLineTags(int h1Tags, int h2Tags, int h3Tags, int h4Tags, int h5Tags, int h6Tags) {
		this.h1Tags = h1Tags;
		this.h2Tags = h2Tags;
		this.h3Tags = h3Tags;
		this.h4Tags = h4Tags;
		this.h5Tags = h5Tags;
		this.h6Tags = h6Tags;
	}
	public void setTitleDocAndVersion(String title, String docVersion, String docType) {
		this.title=title;
		this.docVersion=docVersion;
		this.docType=docType;
	}
	public void setLinkCounts(int hrefLinkCount, long hrefInternalCount, int mediaLinkCount, long mediaInternalCount) {
		this.hrefLinkCount=hrefLinkCount;
		this.internalHrefLinkCount=hrefInternalCount;
		this.mediaLinkCount=mediaLinkCount;
		this.internalMediaLinkCount=mediaInternalCount;
	}
	public boolean isHasLoginForm() {
		return hasLoginForm;
	}
	public void setHasLoginForm(boolean hasLoginForm) {
		this.hasLoginForm = hasLoginForm;
	}
	@Override
	public String toString() {
		return "ParsedData [h1Tags=" + h1Tags + ", h2Tags=" + h2Tags + ", h3Tags=" + h3Tags + ", h4Tags=" + h4Tags
				+ ", h5Tags=" + h5Tags + ", h6Tags=" + h6Tags + ", title=" + title + ", version=" + version
				+ ", docVersion=" + docVersion + ", docType=" + docType + ", hrefLinkCount=" + hrefLinkCount
				+ ", mediaLinkCount=" + mediaLinkCount + ", internalHrefLinkCount=" + internalHrefLinkCount
				+ ", internalMediaLinkCount=" + internalMediaLinkCount + ", hasLoginForm=" + hasLoginForm + "]";
	}
	
}
