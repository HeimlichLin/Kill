package idv.heimlich.Kill.domain.restful.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class QueryJobResponseVo extends BaseResponseVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty( "TRANACTIONID" )
	private String tranactionId;// 交易序號
	
	@JsonProperty( "JOBID" )
	private String jobId;// 產生程式
	
	@JsonProperty( "CREATETIME" )
	private String createTime;// 建立日期
	
	@JsonProperty( "EXECUTETIME" )
	private String executeTime;// 寄件時間
	
	@JsonProperty( "MESSAGE" )
	private String message;// 訊息
	
	@JsonProperty( "STAUTS" )
	private String stauts;// 狀態(w:等待執行 e:異常 s:成功)
	
	public String getTranactionId() {
		return tranactionId;
	}
	public void setTranactionId(String tranactionId) {
		this.tranactionId = tranactionId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getExecuteTime() {
		return executeTime;
	}
	public void setExecuteTime(String executeTime) {
		this.executeTime = executeTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

}
