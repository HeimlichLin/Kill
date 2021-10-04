package idv.heimlich.Kill.domain.restful;

import javax.ws.rs.core.Response;

import idv.heimlich.Kill.domain.code.ReturnCode;
import idv.heimlich.Kill.domain.restful.response.BaseResponseVo;

public class ResponseHelper {

	public static class BuildResponse {

		public static Response OK(BaseResponseVo respVo, ReturnCode rtnCode, String msg) {
			if (respVo == null) {
				return null;
			}
			respVo.setRtnCode(rtnCode);
			// respVo.getRtnMsg().add( rtnCode.getMessage() );
			if (null != msg) {
				respVo.getRtnMsg().add(msg);
			}
			return Response.ok().entity(respVo).build();
		}
	}

}
