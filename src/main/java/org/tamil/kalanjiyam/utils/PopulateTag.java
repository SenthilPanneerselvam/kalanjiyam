package org.tamil.kalanjiyam.utils;

public class PopulateTag {
	
	private static final String ATHIGARAM_TAG = "INSERT INTO tag VALUES (%s, 'அதிகாரம்', '%s', %s);";
	private static final String PAL_TAG = "INSERT INTO tag VALUES (%s, 'பால்', '%s', %s);";
	
	private static final String[] ATHIGARAMS = new String[]{"கடவுள் வாழ்த்து","வான்சிறப்பு","நீத்தார் பெருமை","அறன் வலியுறுத்தல்","இல்வாழ்க்கை","வாழ்க்கைத் துணைநலம்","மக்கட்பேறு","அன்புடைமை","விருந்தோம்பல்","இனியவை கூறல்","செய்ந்நன்றியறிதல்","நடுவு நிலைமை","அடக்கம் உடைமை","ஒழுக்கம் உடைமை","பிறனில் விழையாமை","பொறையுடைமை","அழுக்காறாமை","வெஃகாமை","புறங்கூறாமை","பயனில சொல்லாமை","தீவினையச்சம்","ஒப்புரவறிதல்","ஈ.கை","புகழ்","அருளுடைமை","புலால் மறுத்தல்","தவம்","கூடா ஒழுக்கம்","கள்ளாமை","வாய்மை","வெகுளாமை","இன்னா செய்யாமை","கொல்லாமை","நிலையாமை","துறவு","மெய்யுணர்தல்","அவா அறுத்தல்","ஊழ்","இறைமாட்சி","கல்வி","கல்லாமை","கேள்வி","அறிவுடைமை","குற்றங்கடிதல்","பெரியாரைத் துணைக்கோடல்","சிற்றினம் சேராமை","தெரிந்து செயல்வகை","வலியறிதல்","காலமறிதல்","இடனறிதல்","தெரிந்து தெளிதல்","தெரிந்து வினையாடல்","சுற்றந் தழால்","பொச்சாவாமை","செங்கோன்மை","கொடுங்கோன்மை","வெருவந்த செய்யாமை","கண்ணோட்டம்","ஒற்றாடல்","ஊக்கம் உடைமை","மடி இன்மை","ஆள்வினை உடைமை","இடுக்கண் அழியாமை","அமைச்சு","சொல்வன்மை","வினைத் தூய்மை","வினைத்திட்பம்","வினை செயல்வகை","தூது","மன்னரைச் சேர்ந்து ஒழுகல்","குறிப்பறிதல்","அவை அறிதல்","அவை அஞ்சாமை","நாடு","அரண்","பொருள் செயல்வகை","படை மாட்சி","படைச் செருக்கு","நட்பு","நட்பாராய்தல்","பழைமை","தீ நட்பு","கூடா நட்பு","பேதைமை","புல்லறிவாண்மை","இகல்","பகை மாட்சி","பகைத்திறம் தெரிதல்","உட்பகை","பெரியாரைப் பிழையாமை","பெண்வழிச் சேறல்","வரைவின் மகளிர்","கள்ளுண்ணாமை","சூது","மருந்து","குடிமை","மானம்","பெருமை","சான்றாண்மை","பண்புடைமை","நன்றியில் செல்வம்","நாணுடைமை","குடிசெயல் வகை","உழவு","நல்குரவு","இரவு","இரவச்சம்","கயமை","தகை அணங்குறுத்தல்","குறிப்பறிதல்","புணர்ச்சி மகிழ்தல்","நலம் புனைந்து உரைத்தல்","காதற் சிறப்புரைத்தல்","நாணுத் துறவுரைத்தல்","அலர் அறிவுறுத்தல்","பிரிவு ஆற்றாமை","படர்மெலிந் திரங்கல்","கண் விதுப்பழிதல்","பசப்புறு பருவரல்","தனிப்படர் மிகுதி","நினைந்தவர் புலம்பல்","கனவுநிலை உரைத்தல்","பொழுதுகண்டு இரங்கல்","உறுப்புநலன் அழிதல்","நெஞ்சொடு கிளத்தல்","நிறையழிதல்","அவர்வயின் விதும்பல்","குறிப்பறிவுறுத்தல்","புணர்ச்சி விதும்பல்","நெஞ்சொடு புலத்தல்","புலவி","புலவி நுணுக்கம்","ஊடலுவகை"};
	
	public static void main(String[] args) {
		int tagId = 101;
		int kuralId = 1;
		int athigaramIndex=0;
		for (;kuralId<=1330;kuralId++,tagId++) {
			//System.out.println(String.format(ATHIGARAM_TAG, tagId,ATHIGARAMS[athigaramIndex],kuralId));
			if (kuralId % 10 ==0) {
				athigaramIndex++;
			}
		}
		// FOR ARAM
		kuralId=1;
		for(;kuralId<=380;kuralId++,tagId++) {
			System.out.println(String.format(PAL_TAG, tagId,"அறம்",kuralId));
		}
		for(;kuralId<=1080;kuralId++,tagId++) {
			System.out.println(String.format(PAL_TAG, tagId,"பொருள்",kuralId));
		}
		for(;kuralId<=1330;kuralId++,tagId++) {
			System.out.println(String.format(PAL_TAG, tagId,"இன்பம்",kuralId));
		}
		
	}

}