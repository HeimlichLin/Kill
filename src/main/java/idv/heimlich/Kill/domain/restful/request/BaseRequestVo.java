package idv.heimlich.Kill.domain.restful.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import idv.heimlich.Kill.domain.code.RequestType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequestVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private RequestType reqType;

	private String sessionKey;

	private String accessCode;

	public String getAccessCode() {
		return this.accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getSessionKey() {
		return this.sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public RequestType getReqType() {
		return this.reqType;
	}

	public void setReqType(RequestType reqType) {
		this.reqType = reqType;
	}

}
