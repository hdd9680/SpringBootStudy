package pri.hsy.springBootStudy.comm.exception;

import org.springframework.http.HttpStatus;

public class CustomExceptionFactory {
	
	public static CustomException makeCustomException(HttpStatus httpStatus, String keyword) {
		return new CustomException(httpStatus, keyword);
	}
	
	public static CustomException unvalidData(String keyword) {
		return new CustomException(HttpStatus.BAD_REQUEST, keyword + " 유효하지 않습니다.");
	}
	
	public static CustomException unvalidData(HttpStatus httpStatus, String keyword) {
		return new CustomException(httpStatus, keyword + " 유효하지 않습니다.");
	}
	
	
}
