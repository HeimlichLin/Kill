package idv.heimlich.Kill.domain.dto.impl;

import idv.heimlich.Kill.common.dao.IConverter;
import idv.heimlich.Kill.common.dao.RowMap;
import idv.heimlich.Kill.common.utils.BigDecimalUtils;
import idv.heimlich.Kill.domain.dto.IGetNumberDTO;

//取號檔案
public class GetNumberDTO implements IGetNumberDTO {

	public static final IConverter<GetNumberDTO> CONVERTER = new IConverter<GetNumberDTO>() {

		@Override
		public GetNumberDTO convert(RowMap dataObject) {
			final GetNumberDTO vo = new GetNumberDTO();
			vo.setPgmId(dataObject.getString("PGM_ID"));
			vo.setSyscode1(dataObject.getString("SYSCODE1"));
			vo.setSyscode2(dataObject.getString("SYSCODE2"));
			vo.setSyscode3(dataObject.getString("SYSCODE3"));
			vo.setCount(BigDecimalUtils.formObj(dataObject.getValue("COUNT")));
			return vo;
		}

		@Override
		public RowMap toRowMap(GetNumberDTO po) {
			final RowMap dataObject = new RowMap();
			dataObject.setValue(GetNumberDTO.COLUMNS.PGM_ID.name(), po.getPgmId());
			dataObject.setValue(GetNumberDTO.COLUMNS.SYSCODE1.name(), po.getSyscode1());
			dataObject.setValue(GetNumberDTO.COLUMNS.SYSCODE2.name(), po.getSyscode2());
			dataObject.setValue(GetNumberDTO.COLUMNS.SYSCODE3.name(), po.getSyscode3());
			dataObject.setValue(GetNumberDTO.COLUMNS.COUNT.name(), po.getCount());
			return dataObject;
		}
	};

	public enum COLUMNS {
		PGM_ID("產生程式", true), //
		SYSCODE1("代碼1", true), //
		SYSCODE2("代碼2", true), //
		SYSCODE3("代碼3", true), //
		COUNT("目前號碼", false), //
		;//

		final String chineseName;
		final boolean isPK;

		private COLUMNS(String chineseName, boolean isPK) {
			this.chineseName = chineseName;
			this.isPK = isPK;
		}

		public String getChineseName() {
			return this.chineseName;
		}

		public boolean isPK() {
			return this.isPK;
		}
	}

	private String pgmId;// 產生程式
	private String syscode1;// 代碼1
	private String syscode2;// 代碼2
	private String syscode3;// 代碼3
	private java.math.BigDecimal count;// 目前號碼

	@Override
	public String getPgmId() {
		return this.pgmId;
	}

	@Override
	public void setPgmId(String value) {
		this.pgmId = value;
	}

	@Override
	public String getSyscode1() {
		return this.syscode1;
	}

	@Override
	public void setSyscode1(String value) {
		this.syscode1 = value;
	}

	@Override
	public String getSyscode2() {
		return this.syscode2;
	}

	@Override
	public void setSyscode2(String value) {
		this.syscode2 = value;
	}

	@Override
	public String getSyscode3() {
		return this.syscode3;
	}

	@Override
	public void setSyscode3(String value) {
		this.syscode3 = value;
	}

	@Override
	public java.math.BigDecimal getCount() {
		return this.count;
	}

	@Override
	public void setCount(java.math.BigDecimal value) {
		this.count = value;
	}

}
