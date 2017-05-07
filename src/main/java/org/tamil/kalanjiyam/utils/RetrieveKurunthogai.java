package org.tamil.kalanjiyam.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RetrieveKurunthogai {

	private static final String KURINJI = "குறிஞ்சி";
	private static final String MULLAI = "முல்லை";
	private static final String MARUTHAM = "மருதம்";
	private static final String NEITHAL = "நெய்தல்";
	private static final String PAALAI = "பாலை";

	private static final StringBuilder insert = new StringBuilder("");
	private static final StringBuilder taginsert = new StringBuilder("");
	private static int id = 1331; 
	private static int tagid = 1;
	
	public static void main(String[] args) throws IOException {
		try{
		for (int startIndex=11,endIndex=20;endIndex<=20;startIndex+=10,endIndex+=10){
			Document doc = Jsoup.connect("https://ta.wikisource.org/wiki/குறுந்தொகை_01_முதல்_10_முடிய").get();
			//Document doc = Jsoup.connect("https://ta.wikisource.org/wiki/குறுந்தொகை_"+ startIndex +"_முதல்_"+ endIndex +"_முடிய").get();
			Elements padalgal = doc.select("#bodyContent h2");
			int eindex = 1;
			if (padalgal.size() < 10) {
				padalgal = doc.select("#bodyContent h1");
				eindex = 0;
			}
				
			for (;eindex<padalgal.size();eindex++) {
				Element padal = padalgal.get(eindex);			
				// process padal identifier
				String identifier = padal.text();
				identifier = identifier.replace("பாடல்","").replace(":", "").replace("-", "");
				identifier = identifier.substring(0, identifier.indexOf("(")).trim();
				//identifier = Integer.valueOf(identifier).toString();
				// process thinai & meta data
				Element thinaiElement = padal.nextElementSibling();
				String thinai = getThinai(thinaiElement);
				// process content
				Element contentElement = thinaiElement.nextElementSibling();
				if (contentElement.text().contains("கூற்று") || contentElement.text().trim().equals("")) {
					contentElement = contentElement.nextElementSibling();
				}
				if (contentElement.text() == null || contentElement.text().trim().equals("")) {
					contentElement = contentElement.nextElementSibling();
				}
				String content = contentElement.text().trim();
				// process situation
				Element situationElement = contentElement.nextElementSibling();
				String situation = situationElement.text().trim().replace("'", "''");
				// process author
				Element authorElement = situationElement.nextElementSibling();
				if (authorElement.text() == null || authorElement.text().trim().equals("")) {
					authorElement = authorElement.nextElementSibling();
				}
				String author = authorElement.text().replace("பாடியவர்", "").replace("-", "").replace(".","").trim();
				// process explanation
				StringBuilder exp = new StringBuilder();
				Element expElement = authorElement.nextElementSibling();
				while (expElement != null && expElement.text().contains("செய்தி") == false && expElement.text().contains("பாடல்") == false)
				{
					expElement = expElement.nextElementSibling();
				};
				if (expElement!= null && expElement.text()!= null && expElement.text().contains("செய்தி")) {
					expElement = expElement.nextElementSibling();
					do {
						exp.append(expElement.text().trim().replace("'", "''"));
						expElement = expElement.nextElementSibling();
					} while(expElement.tagName() == "p");
				}
				
				if (isValid(identifier, thinai, author, situation, content, exp.toString(), eindex, startIndex, endIndex))
					createInsert(identifier,thinai, author, situation, content, exp.toString());
				else {
					tagid++;
					id++;
				}					
			}
		}
		} finally {
			System.out.println(insert.toString());
			System.out.println(taginsert.toString());
		}		
	}
	
	private static boolean isValid(String identifier, String thinai, String author, String situation, String content,
			String exp, int eindex, int startIndex, int endIndex) {
		if (identifier == null || identifier.isEmpty()) {
			System.err.println("Exception in parsing identifier " + "item number: " + eindex + "in group " + startIndex + " - " + endIndex);
			return false;
		}
		/*if(thinai == null || thinai.isEmpty()) {
			System.err.println("Exception in parsing thinai " + "item number: " + eindex + "in group " + startIndex + " - " + endIndex);
			return false;
		}*/
		if(content == null || content.isEmpty()){
			System.err.println("Exception in parsing content " + "item number: " + eindex + "in group " + startIndex + " - " + endIndex);
			return false;
		}
		if(situation == null || situation.isEmpty()){
			System.err.println("Exception in parsing situation " + "item number: " + eindex + "in group " + startIndex + " - " + endIndex);
			return false;
		}
		if(author == null || author.isEmpty()){
			System.err.println("Exception in parsing author " + "item number: " + eindex + "in group " + startIndex + " - " + endIndex);
			return false;
		}
		if(exp.toString().isEmpty()) {
			System.err.println("Exception in parsing exp " + "item number: " + eindex + "in group " + startIndex + " - " + endIndex);
			return false;
		}
		return true;
	}

	private static void createInsert(String identifier, String thinai, String author, String situation, String content,
			String exp) {
		StringBuilder insertst = new StringBuilder("");
		insertst.append("INSERT INTO item(item_id,item_name,item_content,item_exp,item_exp_by,item_situation,author,cat_id) values(" + id + 
				",'"+ identifier +"'," +
				"'"+ content +"'," +
				"'"+ exp +"'," +
				"'"+ "" +"'," +
				"'"+ situation +"'," +
				"'"+ author +"'," +
				"2);" );
		insert.append(insertst.toString());
		if (thinai != null) {
		StringBuilder taginsertst = new StringBuilder("");
		taginsertst.append("INSERT INTO tag(tag_id,tag_name,tag_value,item_id) values(" + tagid +
				",'"+ "THINAI" +"'," +
				"'"+ thinai +"'," +
				id +");"
				);
		taginsert.append(taginsertst.toString());
		tagid++;
		}
		id++;
		
	}

	private static String getThinai(Element nextElementSibling) {
		String thinai = nextElementSibling.text();
		if (thinai.contains(KURINJI)) {
			return KURINJI;
		}
		if (thinai.contains(MULLAI)) {
			return MULLAI;
		}
		if (thinai.contains(MARUTHAM)) {
			return MARUTHAM;
		}
		if (thinai.contains(NEITHAL)) {
			return NEITHAL;
		}
		if (thinai.contains(PAALAI)) {
			return PAALAI;
		}
		return "";
	}
	
}
