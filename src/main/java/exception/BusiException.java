package exception;

public class BusiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8922627834222599679L;
	
	private String retCode;
	
	private String retMsg;

	public BusiException(String retCode, String retMsg) {
		super();
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
	
	
	

}
