package Exception;

public class InquiryException extends Exception {
	int code;
	
	public InquiryException(int code) {
		super();
		this.code = code;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.code+ super.getMessage();
	}
}
