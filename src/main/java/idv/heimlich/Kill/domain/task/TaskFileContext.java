package idv.heimlich.Kill.domain.task;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import idv.heimlich.Kill.common.exception.ApBusinessException;
import idv.heimlich.Kill.domain.code.TaskStatus;

public class TaskFileContext implements TaskContext {

	private static final String PCLMS_LOG_TASKS = "/PCLMS/log/tasks/";

//	private final static Logger LOG = MyLoggerFactory.getLogger(Mylogs.tasksLog);
	private final static File TASK_FOLDER = new File(PCLMS_LOG_TASKS);
	private final static File START_FILE = new File(TASK_FOLDER, ".done");
	private final File stopFile;
	private final String procNo;

	public TaskFileContext(final String procNo) {
		this.procNo = procNo;
		this.stopFile = new File(TASK_FOLDER, procNo + "~");// 重啟檔案規則/PCLMS/log/tasks/{procNo}~
	}

	@Override
	public void start() {
		final long startTime = System.currentTimeMillis();
		System.out.println("Launch init setting...");
		// this.initFolder();

		this.deleteLog();
		System.out.println("Launch clean pre log..");
		this.executeContinueflg();
		System.out.println("Launch over spent:" + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override
	public boolean isContinue() {
		final boolean exists = this.isContinueNotExit();
		if (!exists) {
//			LOG.info(this.procNo + " call  System exit ");
//			LOG.info("if you want to execute  call TaskLaunch.getLaunch().start() will start");
			this.pingKilled();
			System.exit(0);
		}
		return exists;
	}

	@Override
	public boolean isContinueNotExit() {
		final Long startTime = System.currentTimeMillis();
		final boolean exists = this.START_FILE.exists() && (!this.stopFile.exists());
		if (this.stopFile.exists()) {// 重啟一次就刪除
			this.stopFile.delete();
		}
//		LOG.debug("isContinue  " + this.procNo + ":" + (System.currentTimeMillis() - startTime) + "ms");
		return exists;
	}

	@Override
	public void terminate(int timeout) {
		final long startTime = System.currentTimeMillis();
		System.out.println("terminate init ");
		final File file = this.START_FILE;
		if (!file.exists()) {
			throw new ApBusinessException("has terminate");
		}
		final boolean delete = file.delete();
		if (!delete) {
			System.out.println("delte error ");
			try {
				FileUtils.forceDelete(file);
			} catch (final IOException e) {
//				LOG.error("delete error", e);
			}
		}
		boolean isCheck = true;
		System.out.println("wait to terminate " + timeout + "s");
		final Date noewDate = new Date();
		while (!this.getRunningList().isEmpty() && isCheck) {

			final List<String> message = new ArrayList<String>();
			for (final File f : this.getRunningList()) {
				message.add(f.getName() + " wait to " + TaskStatus.IDLE);
			}
			System.out.println(StringUtils.join(message, "\n"));
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (final InterruptedException e) {
				isCheck = false;
			}
			final long diff = (new Date().getTime() - noewDate.getTime());
			System.out.println("has wait for " + diff / 1000 + "s");

			if (diff >= timeout * 1000) {
				System.out.println("time out " + timeout + "s");
				isCheck = false;
			}
		}
		System.out.println(" terminate over  spent:" + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override
	public void pinRunning() {
		this.toStatus(TaskStatus.RUNNNING);
	}

	@Override
	public void pingIdle() {
		this.toStatus(TaskStatus.IDLE);
	}

	@Override
	public void pingKilled() {
		this.toStatus(TaskStatus.KILLED);
	}

	@Override
	public void sendStopMessage() {
		try {
			this.stopFile.createNewFile();
		} catch (final IOException e) {
			throw new ApBusinessException("建立暫存失敗", e);
		}
	}

	public List<File> getRunningList() {
		final File lastExecuteFolder = this.getLastExecuteFolder();
		final File[] listFiles = lastExecuteFolder.listFiles(new FileFilter() {

			@Override
			public boolean accept(final File pathname) {
				return pathname.getName().startsWith(TaskStatus.RUNNNING.getText());
			}
		});
		return Arrays.asList(listFiles);
	}

	private void executeContinueflg() {

		try {
			if (this.START_FILE.exists()) {
				final boolean delete = this.START_FILE.delete();
				if (!delete) {
					throw new ApBusinessException("檔案刪除失敗" + this.START_FILE);
				}
			}
			final boolean createNewFile = this.START_FILE.createNewFile();
			if (!createNewFile) {
				final boolean createNewFile2 = this.START_FILE.getParentFile().createNewFile();
				if (!createNewFile2) {
					throw new ApBusinessException("無法建立folder:" + this.START_FILE.getParentFile());
				}
				final boolean createLock = this.START_FILE.createNewFile();
				if (createLock) {
					throw new ApBusinessException("建立file失敗:" + this.START_FILE);
				}
			}
		} catch (final IOException e) {
//			LOG.error("job IOException", e);
		}
	}

	private void deleteLog() {
		if (this.TASK_FOLDER.exists()) {
			final File[] fils = this.TASK_FOLDER.listFiles();
			for (final File file : fils) {
				file.delete();
			}

		} else {
			this.TASK_FOLDER.mkdirs();
		}

	}

	/**
	 * 變更執行狀態
	 * 
	 * @param status
	 */
	private void toStatus(final TaskStatus status) {
		final File f = this.getLastExecuteFolder();
		final File taskFile = this.getProcFile();
		final File target = new File(f, status.getText() + "." + this.procNo);
		taskFile.renameTo(target);
		target.setLastModified(System.currentTimeMillis());// 修改最後修改時間
	}

	private File getProcFile() {
		final File f = this.getLastExecuteFolder();
		final File[] listFiles = f.listFiles(new FileFilter() {

			@Override
			public boolean accept(final File pathname) {
				return pathname.getName().endsWith(TaskFileContext.this.procNo);
			}
		});
		File taskFile = null;
		if (listFiles.length == 0) {
			taskFile = new File(f, TaskStatus.IDLE.getText() + "." + this.procNo);
			try {
				taskFile.createNewFile();

			} catch (final IOException e) {
				e.printStackTrace();
			}
		} else {
			taskFile = listFiles[0];
		}
		return taskFile;

	}

	/**
	 * 取得最新
	 * 
	 * @return
	 */
	private File getLastExecuteFolder() {
		return this.TASK_FOLDER;
	}

	public String getStatus() {
		final File taskFile = this.getProcFile();
		if (taskFile == null) {
			return TaskStatus.IDLE.getText();
		}
		return StringUtils.substringBefore(taskFile.getName(), ".");
	}

}
