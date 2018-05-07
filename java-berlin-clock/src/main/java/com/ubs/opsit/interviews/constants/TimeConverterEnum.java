/**
 * 
 */
package com.ubs.opsit.interviews.constants;

/**
 * @author Vivek Gautam
 *
 */
public enum TimeConverterEnum {

	NEW_LINE("\r\n"),
	ERR_MSG("Time format is not correct"),
	Y("Y"),
	O("O"),
	R("R"),
	YYY("YYY"),
	YYR("YYR"); 
	
	private String value;
	
	private TimeConverterEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
