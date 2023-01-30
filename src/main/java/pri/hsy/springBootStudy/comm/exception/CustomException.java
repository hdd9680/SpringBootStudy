package pri.hsy.springBootStudy.comm.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 7025988974714978913L;
	private final HttpStatus errorCode;
    private String[] params;
    
    public CustomException(final HttpStatus errorCode, String... params) {
        this.errorCode = errorCode;
        this.params = params;
    }

}
