package idv.heimlich.Kill.domain.dto;

public interface IMailCreateDTO {

	String getPgmId();

	void setPgmId(String pgmId);

	String getSubject();

	void setSubject(String subject);

	String getMailTo();

	void setMailTo(String mailTo);

	String getMailCc();

	void setMailCc(String mailCc);

	String getMailBcc();

	void setMailBcc(String mailBcc);

	String getMailFrom();

	void setMailFrom(String mailFrom);

	String getMessage();

	void setMessage(String message);

	String getRemarks();

	void setRemarks(String remarks);

	String getFilePath();

	void setFilePath(String filePath);

}
