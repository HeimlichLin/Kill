package idv.heimlich.Kill.domain.dto.impl;

import idv.heimlich.Kill.common.dao.IConverter;
import idv.heimlich.Kill.common.dao.RowMap;
import idv.heimlich.Kill.domain.dto.IJobqueDTO;

//Job隊伍
public class JobqueDTO implements IJobqueDTO {

	public static final IConverter<JobqueDTO> CONVERTER = new IConverter<JobqueDTO>() {

		@Override
		public JobqueDTO convert(RowMap dataObject) {
			final JobqueDTO vo = new JobqueDTO();
			vo.setTranactionId(dataObject.getString("TRANACTION_ID"));
			vo.setJobId(dataObject.getString("JOB_ID"));
			vo.setCreateTime(dataObject.getString("CREATE_TIME"));
			vo.setExecuteTime(dataObject.getString("EXECUTE_TIME"));
			vo.setMessage(dataObject.getString("MESSAGE"));
			vo.setStauts(dataObject.getString("STAUTS"));
			return vo;
		}

		@Override
		public RowMap toRowMap(JobqueDTO po) {
			final RowMap dataObject = new RowMap();
			dataObject.setValue(JobqueDTO.COLUMNS.TRANACTION_ID.name(), po.getTranactionId());
			dataObject.setValue(JobqueDTO.COLUMNS.JOB_ID.name(), po.getJobId());
			dataObject.setValue(JobqueDTO.COLUMNS.CREATE_TIME.name(), po.getCreateTime());
			dataObject.setValue(JobqueDTO.COLUMNS.EXECUTE_TIME.name(), po.getExecuteTime());
			dataObject.setValue(JobqueDTO.COLUMNS.MESSAGE.name(), po.getMessage());
			dataObject.setValue(JobqueDTO.COLUMNS.STAUTS.name(), po.getStauts());
			return dataObject;
		}
	};

	public enum COLUMNS {
		TRANACTION_ID("交易序號", true), //
		JOB_ID("產生程式", false), //
		CREATE_TIME("建立日期", false), //
		EXECUTE_TIME("寄件時間", false), //
		MESSAGE("訊息", false), //
		STAUTS("狀態(W:等待執行 E:異常 S:成功)", false), //
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

	private String tranactionId;// 交易序號
	private String jobId;// 產生程式
	private String createTime;// 建立日期
	private String executeTime;// 寄件時間
	private String message;// 訊息
	private String stauts;// 狀態(w:等待執行 e:異常 s:成功)

	@Override
	public String getTranactionId() {
		return this.tranactionId;
	}

	@Override
	public void setTranactionId(String value) {
		this.tranactionId = value;
	}

	@Override
	public String getJobId() {
		return this.jobId;
	}

	@Override
	public void setJobId(String value) {
		this.jobId = value;
	}

	@Override
	public String getCreateTime() {
		return this.createTime;
	}

	@Override
	public void setCreateTime(String value) {
		this.createTime = value;
	}

	@Override
	public String getExecuteTime() {
		return this.executeTime;
	}

	@Override
	public void setExecuteTime(String value) {
		this.executeTime = value;
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
	public String getStauts() {
		return this.stauts;
	}

	@Override
	public void setStauts(String value) {
		this.stauts = value;
	}

}
