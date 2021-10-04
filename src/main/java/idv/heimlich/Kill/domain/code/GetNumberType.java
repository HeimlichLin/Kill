package idv.heimlich.Kill.domain.code;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import idv.heimlich.Kill.common.utils.YYYYMMDDUtils;

public enum GetNumberType {

	YYYYMMDD12N {
		@Override
		public String[] codes(String... codes) {
			final String yyyymmdd = YYYYMMDDUtils.getText();
			return new String[] { yyyymmdd.substring(0, 4), //
					yyyymmdd.substring(4, 6), //
					yyyymmdd.substring(6, 8) //
			};
		}

		@Override
		public String getId(String sys1, String sys2, String sys3, BigDecimal bigDecimal) {
			final StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(sys1);
			stringBuilder.append(sys2);
			stringBuilder.append(sys3);
			stringBuilder.append(StringUtils.leftPad(bigDecimal.toString(), 12, "0"));
			return stringBuilder.toString();
		}
	}, // 年月日12碼數字

	;

	public abstract String[] codes(String... codes);

	public abstract String getId(String sys1, String sys2, String sys3, BigDecimal bigDecimal);

}
