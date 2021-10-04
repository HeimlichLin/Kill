package idv.heimlich.Kill.domain.service;

import idv.heimlich.Kill.domain.code.GetNumberType;

public interface GetNumberService {

	/**
	 * 取號
	 */
	public String getCount(GetNumberType getNumberType, String... codes);

}
