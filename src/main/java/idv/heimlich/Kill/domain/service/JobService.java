package idv.heimlich.Kill.domain.service;

import idv.heimlich.Kill.domain.restful.response.QueryJobResponseVo;

public interface JobService {

	String sendNewJob(String jobid);

	QueryJobResponseVo queryJob(String id);

}
