package stockInformation;

class QAInvalidUserException extends Exception {
	public QAInvalidUserException() {
		super("Invalid username or password");
	}

	public QAInvalidUserException(String msg) {
		super(msg);
	}
}

class QAInvalidPasswordFormatException extends Exception {
	public QAInvalidPasswordFormatException() {
		super("Invalid password");
	}

	public QAInvalidPasswordFormatException(String msg) {
		super(msg);
	}
}

class QAInvalidUsernameFormatException extends Exception {
	public QAInvalidUsernameFormatException() {
		super("Invalid username format");
	}

	public QAInvalidUsernameFormatException(String msg) {
		super(msg);
	}
}

class QAInvalidCompanyIDException extends Exception {
	public QAInvalidCompanyIDException() {
		super("Invalid companyID");
	}

	public QAInvalidCompanyIDException(String msg) {
		super(msg);
	}
}
