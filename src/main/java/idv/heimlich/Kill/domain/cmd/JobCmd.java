package idv.heimlich.Kill.domain.cmd;

import idv.heimlich.Kill.domain.service.JobCmdService;
import idv.heimlich.Kill.domain.service.impl.JobCmdServiceImpl;

public class JobCmd {

//	final static CommonLogger logger = MyLoggerFactory.getLogger(Mylogs.JobCmd);

	private final transient JobCmdService jmdService = JobCmdServiceImpl.get();

	public void doCmd() {
//		logger.debug("JobCmd rum start!");
		try {
			this.jmdService.cmd();
		} finally {
//			logger.debug("JobCmd rum end!");
		}

	}

}
