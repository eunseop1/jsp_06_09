package kr.human.member.service;

import java.util.Random;

public class PasswordService {
	//임시 비번 만드는 서비스 클래스
	public static String makeNewPassword() {
		Random random = new Random();
		String newPassword = "";
		
		for(int i = 0; i < 10; i++) {
			switch (random.nextInt(4)) {
			case 0:
				newPassword += random.nextInt(10);
				break;
			case 1:
				newPassword += (char)('A'+random.nextInt(26));//0부터 25까지
				break;
			case 2:
				newPassword += (char)('a'+random.nextInt(26));
				break;
			case 3:
				newPassword += "~!@#$%^&*+-".charAt(random.nextInt(11));//11개의 글자내에서 난수의 위치에서 잘라낸다
				break;
			}
		}
		
		return newPassword;
	}
	
}
