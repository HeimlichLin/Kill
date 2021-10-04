package idv.heimlich.Kill.domain.code;

import idv.heimlich.Kill.domain.job.AbstactJob;
import idv.heimlich.Kill.domain.job.OxAPstatusJob;

public enum JobComs {

	oxAPstatus(OxAPstatusJob.class), // 檢視狀態
	// oxAPdown(OxAPdownJob.class), // 關閉BACKEND
	// oxAPup(OxAPupJob.class), // 啟動BACKEND
//	killL4(KillL4Job.class), // 刪除 L4 PRO
//	killL1(KillL1Job.class),
	;

	final Class<? extends AbstactJob> jobClass;

	private JobComs(final Class<? extends AbstactJob> jobClass) {
		this.jobClass = jobClass;
	}

	public Class<? extends AbstactJob> getJobClass() {
		return this.jobClass;
	}

}
