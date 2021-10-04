package idv.heimlich.Kill.domain.code;

import idv.heimlich.Kill.domain.task.ITaskInfo;

public enum TaskIds implements ITaskInfo {
//	clprocL6("移倉訊息處理"), ///
//	clfetchL6("解析移倉訊息"), //
//	clfetchW1("解析加工單訊息"), //
//	clrecvL4("進出倉接收訊息"), //
//	clprocL4("進出倉接收處理"), //
//	clsndnet("傳送L1訊息"), //
//	clBackendManager("報單作業"), //
//	clprocF3("用料清表作業處理"), //
//	clSendMail("寄信服務"), //
//	CleanJobSct("清檔服務"), //
//	BackendMonitorSct("後端訊息檔案監控"), //
//	clrecvFTZL4("接收移倉訊息"), //
//	clrecvFTZL5("接收滯外帳訊息"), //
//	clrecvL8("接收L8滯外帳訊息"), //
//	clrecvPD("接收PD滯外帳訊息"), //
//	clrecvW1("接收處理加工單訊息"), //
//	clprocW1("處理加工單訊息"), //
//	clprocFTZL4("拆解自貿港L4進出倉訊息"), //
//	clprocFTZL5("接收自貿港L5委外加工訊息"), //
//	clrecvF3("接收用料清表Excel訊息"), //
//	clrecvFTZL6("接收移倉訊息"), //
//	clsndL1("接收移倉訊息"), //
//	clsndL4("處理 L4-Outbond (CL070)"), //
//	clprocFTZL6("拆解自貿港L6移倉訊息"), //
//	clprocL8("接收L8國瑞動態用料清表訊息"), //
//	clfetchN1("接收N1通用訊息"), //
//	clReDeclar("報單重收服務"), //
//	cleanDeclarT1("報單接收主檔清檔作業"), //
	JobCmd("命令處理"), //
	;

	String procName;

	private TaskIds(String procName) {
		this.procName = procName;
	}

	@Override
	public String getProcNo() {
		return this.name();
	}

	@Override
	public String getProcName() {
		return this.procName;
	}

}
