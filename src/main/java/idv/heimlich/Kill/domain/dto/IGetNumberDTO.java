package idv.heimlich.Kill.domain.dto;

//取號檔案
public interface IGetNumberDTO {

	//get產生程式
	public String getPgmId();

	//set產生程式
	public void setPgmId(String pgmId);

	//get代碼1
	public String getSyscode1();

	//set代碼1
	public void setSyscode1(String syscode1);

	//get代碼2
	public String getSyscode2();

	//set代碼2
	public void setSyscode2(String syscode2);

	//get代碼3
	public String getSyscode3();

	//set代碼3
	public void setSyscode3(String syscode3);

	//get目前號碼
	public java.math.BigDecimal getCount();

	//set目前號碼
	public void setCount(java.math.BigDecimal count);

}
