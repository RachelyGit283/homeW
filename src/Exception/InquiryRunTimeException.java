package Exception;

public class InquiryRunTimeException extends RuntimeException {
	int code;
	
	public InquiryRunTimeException(int code) {
		super();
		this.code = code;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.code+ super.getMessage();
	} 
}
