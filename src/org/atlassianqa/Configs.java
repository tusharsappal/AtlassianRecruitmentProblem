package org.atlassianqa;

public class Configs {

	public static String HOMEPAGE_URL = "https://tusharsappal.atlassian.net/";
	public static String USERNAME = "sappal.tushar@gmail.com";
	private static String PASSWORD = "Accompany123";
	private static String LOGINPAGE_TITLE = "Atlassian Cloud";


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

	public static void setHOMEPAGEURL(String newHOMEPAGEURL)
	{
		HOMEPAGE_URL = newHOMEPAGEURL;
	}

	public static String getLOGINPAGETITLE() {
		return LOGINPAGE_TITLE;
	}

}
