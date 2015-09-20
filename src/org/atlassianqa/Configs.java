package org.atlassianqa;
import org.apache.commons.lang3.RandomStringUtils;

public class Configs {

	public static String HOMEPAGE_URL = "https://tusharsappal.atlassian.net/";
	public static String USERNAME = "sappal.tushar@gmail.com";
	private static String PASSWORD = "Accompany123";
	private static String NEW_PAGE_TITLE= RandomStringUtils.randomAlphanumeric(20).toLowerCase()
			+"_sample_test_page";
	private static String EXISTING_PAGE_URL = "https://tusharsappal.atlassian.net/wiki/display/TES/Sample+Test+Page";
    private static String EXISTING_PAGE_TITLE = "Sample Test Page - TestSpace - Confluence";
    
	public static String getPASSWORD() {
		return PASSWORD;
	}

	public static void setPASSWORD(String newPASSWORD) {
		PASSWORD = newPASSWORD;
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public static void setUSERNAME(String newUSERNAME)
	{
		USERNAME = newUSERNAME;
	}

	public static String getHOMEPAGEURL() {
		return HOMEPAGE_URL;
	}

	public static void setHOMEPAGEURL(String newHOMEPAGEURL){
		HOMEPAGE_URL = newHOMEPAGEURL;
	}

	public static String getNewPageTitle() {
		return NEW_PAGE_TITLE;	
	}
	
	public static String getExistingPageURL() {
		return EXISTING_PAGE_URL;
	}
	
	public static String getExistingPageTitle() {
		return EXISTING_PAGE_TITLE;
	}
}
