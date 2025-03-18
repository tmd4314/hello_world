package com.yedam.api;

public class StringUtil {
	static String getGender(String ssn) {
		int pos = -1;
		if(ssn.length() == 13) {
			pos = 6;
		}else if(ssn.length() == 14) {
			pos = 7;
		}
		char gNo = ssn.charAt(pos);
		switch(gNo){
		case '1':
		case '3':
			return "남자 입니다.";
		case '2':
		case '4':
			return "여자 입니다.";
		default:
			return "알수 없음";
		}
	}
	
	// 2.파일명
	static String getFileName(String file) {
		int pos = 0;
		String fileName ="";
		while(true) {
			int idx = file.indexOf("/", pos);
			if(idx == -1) {
				fileName = file.substring(pos, file.indexOf("."));
				break;
			}
			pos = idx + 1;
		}
		return fileName;
	}
	
	// 3.파일 확장자
	static String getExtName(String file) {
		int index = file.lastIndexOf(".");
		if(index > 0) {
			String extension = file.substring(index + 1);
			return extension;
		}
		return "";
	}
}
