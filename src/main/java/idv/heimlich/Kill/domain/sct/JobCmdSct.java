package idv.heimlich.Kill.domain.sct;

import idv.heimlich.Kill.domain.cmd.JobCmd;
import idv.heimlich.Kill.domain.code.TaskIds;
import idv.heimlich.Kill.domain.task.TaskLaunch;

public class JobCmdSct {

	public static void main(final String[] args) {
		TaskLaunch.getLaunch().startNow(TaskIds.JobCmd.name(), () -> {
			new JobCmd().doCmd();
		});

	}

}
