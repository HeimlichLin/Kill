package idv.heimlich.Kill.domain.dto.impl;

import idv.heimlich.Kill.common.dao.IConverter;
import idv.heimlich.Kill.common.dao.RowMap;
import idv.heimlich.Kill.domain.dto.IMailqueDTO;

//系統Mail傳送記錄
public class MailqueDTO implements IMailqueDTO {

	public static final IConverter<MailqueDTO> CONVERTER = new IConverter<MailqueDTO>() {

		@Override
		public MailqueDTO convert(RowMap dataObject) {
			final MailqueDTO vo = new MailqueDTO();
			vo.setPgmId(dataObject.getString("PGM_ID"));
			vo.setCreateDate(dataObject.getString("CREATE_DATE"));
			vo.setSubject(dataObject.getString("SUBJECT"));
			vo.setMailTo(dataObject.getString("MAIL_TO"));
			vo.setMailCc(dataObject.getString("MAIL_CC"));
			vo.setMailBcc(dataObject.getString("MAIL_BCC"));
			vo.setMailFrom(dataObject.getString("MAIL_FROM"));
			vo.setMessage(dataObject.getString("MESSAGE"));
			vo.setRemarks(dataObject.getString("REMARKS"));
			vo.setMailId(dataObject.getString("MAIL_ID"));
			vo.setStatus(dataObject.getString("STATUS"));
			vo.setSendDate(dataObject.getString("SEND_DATE"));
			vo.setFilePath(dataObject.getString("FILE_PATH"));
			return vo;
		}

		@Override
		public RowMap toRowMap(MailqueDTO po) {
			final RowMap dataObject = new RowMap();
			dataObject.setValue(MailqueDTO.COLUMNS.PGM_ID.name(), po.getPgmId());
			dataObject.setValue(MailqueDTO.COLUMNS.CREATE_DATE.name(), po.getCreateDate());
			dataObject.setValue(MailqueDTO.COLUMNS.SUBJECT.name(), po.getSubject());
			dataObject.setValue(MailqueDTO.COLUMNS.MAIL_TO.name(), po.getMailTo());
			dataObject.setValue(MailqueDTO.COLUMNS.MAIL_CC.name(), po.getMailCc());
			dataObject.setValue(MailqueDTO.COLUMNS.MAIL_BCC.name(), po.getMailBcc());
			dataObject.setValue(MailqueDTO.COLUMNS.MAIL_FROM.name(), po.getMailFrom());
			dataObject.setValue(MailqueDTO.COLUMNS.MESSAGE.name(), po.getMessage());
			dataObject.setValue(MailqueDTO.COLUMNS.REMARKS.name(), po.getRemarks());
			dataObject.setValue(MailqueDTO.COLUMNS.MAIL_ID.name(), po.getMailId());
			dataObject.setValue(MailqueDTO.COLUMNS.STATUS.name(), po.getStatus());
			dataObject.setValue(MailqueDTO.COLUMNS.SEND_DATE.name(), po.getSendDate());
			dataObject.setValue(MailqueDTO.COLUMNS.FILE_PATH.name(), po.getFilePath());
			return dataObject;
		}
	};

	public enum COLUMNS {
		PGM_ID("產生程式", false), //
		CREATE_DATE("建立日期", false), //
		SUBJECT("信件主旨", false), //
		MAIL_TO("收件者,多筆以分號隔開", false), //
		MAIL_CC("副本", false), //
		MAIL_BCC("密件副本", false), //
		MAIL_FROM("寄件者", false), //
		MESSAGE("信件內容", false), //
		REMARKS("備註", false), //
		MAIL_ID("信件ID", true), //
		STATUS("狀態.W:等待,R:重送,C:完成", false), //
		SEND_DATE("寄件時間", false), //
		FILE_PATH("附件", false), //
		;//

		final String chineseName;
		final boolean isPK;

		private COLUMNS(String chineseName, boolean isPK) {
			this.chineseName = chineseName;
			this.isPK = isPK;
		}

		public String getChineseName() {
			return this.chineseName;
		}

		public boolean isPK() {
			return this.isPK;
		}
	}

	private String pgmId;// 產生程式
	private String createDate;// 建立日期
	private String subject;// 信件主旨
	private String mailTo;// 收件者,多筆以分號隔開
	private String mailCc;// 副本
	private String mailBcc;// 密件副本
	private String mailFrom;// 寄件者
	private String message;// 信件內容
	private String remarks;// 備註
	private String mailId;// 信件id
	private String status;// 狀態.w:等待,r:重送,c:完成
	private String sendDate;// 寄件時間
	private String filePath;// 附件

	@Override
	public String getPgmId() {
		return this.pgmId;
	}

	@Override
	public void setPgmId(String value) {
		this.pgmId = value;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}

	@Override
	public void setSubject(String value) {
		this.subject = value;
	}

	@Override
	public String getMailTo() {
		return this.mailTo;
	}

	@Override
	public void setMailTo(String value) {
		this.mailTo = value;
	}

	@Override
	public String getMailCc() {
		return this.mailCc;
	}

	@Override
	public void setMailCc(String value) {
		this.mailCc = value;
	}

	@Override
	public String getMailBcc() {
		return this.mailBcc;
	}

	@Override
	public void setMailBcc(String value) {
		this.mailBcc = value;
	}

	@Override
	public String getMailFrom() {
		return this.mailFrom;
	}

	@Override
	public void setMailFrom(String value) {
		this.mailFrom = value;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public void setMessage(String value) {
		this.message = value;
	}

	@Override
	public String getRemarks() {
		return this.remarks;
	}

	@Override
	public void setRemarks(String value) {
		this.remarks = value;
	}

	@Override
	public String getMailId() {
		return this.mailId;
	}

	@Override
	public void setMailId(String value) {
		this.mailId = value;
	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(String value) {
		this.status = value;
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}

	@Override
	public void setFilePath(String value) {
		this.filePath = value;
	}

	@Override
	public String getCreateDate() {
		return this.createDate;
	}

	@Override
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String getSendDate() {
		return this.sendDate;
	}

	@Override
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

}
