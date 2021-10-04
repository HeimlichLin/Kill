package idv.heimlich.Kill.domain.job;

import idv.heimlich.Kill.domain.cmd.ShellUtils;
import idv.heimlich.Kill.domain.common.ClmsContract;

/**
 * 執行狀態
 */
public class OxAPstatusJob extends AbstactJob implements Runnable {

//	final static CommonLogger LOGGER = MyLoggerFactory.getLogger(Mylogs.clJobCmd);

	private static final String CALL_SCT = OxAPstatusJob.class.getSimpleName() + ".sct";

	@Override
	public void myExecute() throws Exception {

		final Thread commandThread = new Thread(this);
//		LOGGER.info("Create Command Thread -> " + commandThread.getName());
		commandThread.start();
		commandThread.join();
	}

	@Override
	public void run() {
		final String log = String.format(ClmsContract.CMD_LOG_PATH + "/%s.log", this.transactionId);
//		LOGGER.info("call CALL_SCT:" + CALL_SCT);
		ShellUtils.cmd(log, CALL_SCT);
		this.files = log;
		this.message = "詳細訊息參考附件";

	}

}
