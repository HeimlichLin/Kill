package idv.heimlich.Kill.domain.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import idv.heimlich.Kill.domain.code.ReturnCode;
import idv.heimlich.Kill.domain.common.RestResourcePath;
import idv.heimlich.Kill.domain.common.RestResourcePath.JOB_PATH;
import idv.heimlich.Kill.domain.restful.ResponseHelper;
import idv.heimlich.Kill.domain.restful.ResponseHelper.BuildResponse;
import idv.heimlich.Kill.domain.restful.response.QueryJobResponseVo;
import idv.heimlich.Kill.domain.restful.response.TransactionResponseVo;
import idv.heimlich.Kill.domain.service.JobService;

@Path(RestResourcePath.JOB)
@Controller
public class JobController {

	@Autowired
	private Logger logger;

	@Autowired
	private JobService jobService;

	@GET
	@Path(JOB_PATH.OXAPS + "/{actoin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response oxAPS(@PathParam("actoin") String actoin) throws Exception {
		final TransactionResponseVo respVo = new TransactionResponseVo();
		try {
			if (actoin == null) {
				return ResponseHelper.BuildResponse.OK(respVo, ReturnCode.ILLEGAL, "參數不足。");
			}
			if (!actoin.matches("(up|status|down)")) {
				return ResponseHelper.BuildResponse.OK(respVo, ReturnCode.ILLEGAL, "參數錯誤。");
			}
			if (actoin.matches("status")) {
				respVo.setTransaction(this.jobService.sendNewJob("oxAPstatus"));
			} else if (actoin.matches("up")) {
				respVo.setTransaction(this.jobService.sendNewJob("oxAPup"));
			} else if (actoin.matches("down")) {
				respVo.setTransaction(this.jobService.sendNewJob("oxAPdown"));
			}

		} catch (final Exception e) {
			this.logger.error("e");
			throw e;
		}
		return BuildResponse.OK(respVo, ReturnCode.SUCCESS, ReturnCode.SUCCESS.getMessage());
	}

	@GET
	@Path(JOB_PATH.KILL + "/{doc}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response kill(@PathParam("doc") String doc) throws Exception {
		// EX:http://tjmspmc.intranet.com.tw:8037/APCLMS/rest/job/kill/L1
		final TransactionResponseVo respVo = new TransactionResponseVo();
		try {
			if (doc == null) {
				return ResponseHelper.BuildResponse.OK(respVo, ReturnCode.ILLEGAL, "參數不足。");
			}
			// if (!doc.matches("(L4)")) {
			// return ResponseHelper.BuildResponse.OK(respVo,
			// ReturnCode.ILLEGAL, "參數錯誤。");
			// }
			respVo.setTransaction(this.jobService.sendNewJob("kill" + doc));

		} catch (final Exception e) {
			this.logger.error("e");
			throw e;
		}
		return BuildResponse.OK(respVo, ReturnCode.SUCCESS, ReturnCode.SUCCESS.getMessage());
	}

	@GET
	@Path(JOB_PATH.query + "/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response query(@PathParam("id") String id) throws Exception {
		QueryJobResponseVo respVo = new QueryJobResponseVo();
		try {
			if (id == null) {
				return ResponseHelper.BuildResponse.OK(respVo, ReturnCode.ILLEGAL, "參數不足。");
			}
			respVo = this.jobService.queryJob(id);
		} catch (final Exception e) {
			this.logger.error("e");
			throw e;
		}
		return BuildResponse.OK(respVo, ReturnCode.SUCCESS, ReturnCode.SUCCESS.getMessage());
	}

}
