package idv.heimlich.Kill.domain.dto.impl;

import idv.heimlich.Kill.domain.dto.IMailCreateDTO;

public class MailCreateDTO implements IMailCreateDTO {

	private String pgmId;// 產生程式
	private String subject;// 信件主旨
	private String mailTo;// 收件者,多筆以分號隔開
	private String mailCc;// 副本
	private String mailBcc;// 密件副本
	private String mailFrom;// = ApContext.getContext().getSetting("owner_mail");// 寄件者
	private String message;// 信件內容
	private String remarks;// 備註
	private String filePath;// 附件

	@Override
	public String getPgmId() {
		return this.pgmId;
	}

	@Override
	public void setPgmId(String pgmId) {
		this.pgmId = pgmId;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}

	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getMailTo() {
		return this.mailTo;
	}

	@Override
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	@Override
	public String getMailCc() {
		return this.mailCc;
	}

	@Override
	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	@Override
	public String getMailBcc() {
		return this.mailBcc;
	}

	@Override
	public void setMailBcc(String mailBcc) {
		this.mailBcc = mailBcc;
	}

	@Override
	public String getMailFrom() {
		return this.mailFrom;
	}

	@Override
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getRemarks() {
		return this.remarks;
	}

	@Override
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}

	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
