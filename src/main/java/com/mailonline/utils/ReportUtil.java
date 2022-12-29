package com.mailonline.utils;

public class ReportUtil {

	public static String generateHTMLTable(String teamName,String position,String points)
	{
		String htmlStr1 = "<html><head><style>table, th, td {border: 1px solid black;}</style></head><body><table><tr><th> Team Name </th><th> Position </th><th> Points </th></tr>";
		String htmlStr2 = "</table></body></html>";
		String teamDetails = "<tr><td>" + teamName + "</td>"
					+ "<td>" + position + "</td>"
					+ "<td>" + points + "</td></tr>";
			return htmlStr1 + teamDetails + htmlStr2;
	}
	
}
