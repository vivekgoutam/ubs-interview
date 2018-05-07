/**
 * 
 */
package com.ubs.opsit.interviews.impl;

import static com.ubs.opsit.interviews.constants.TimeConverterEnum.*;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.TimeConverter;

/**
 * @author Vivek Gautam
 *
 */
public class TimeConverterImpl implements TimeConverter {
	
	Logger logger = LoggerFactory.getLogger(TimeConverterImpl.class);

	public String convertTime(String aTime) {
		logger.info("TimeConverter started ...");
		if (null == aTime || "".equals(aTime.trim()))
			return ERR_MSG.getValue();

		int[] timeArray = this.splitTheTimeinArray(aTime);

		if (this.isNotValidtimeFormat(timeArray)) {
			return ERR_MSG.getValue();
		}
		logger.info("TimeConverter result...");
		return new StringBuilder().append(getSeconds(timeArray[2])).append(NEW_LINE.getValue())
									.append(getFirstRowOfHours(timeArray[0])).append(NEW_LINE.getValue())
									.append(getSecondRowOfHours(timeArray[0])).append(NEW_LINE.getValue())
									.append(getFirstRowOfMinutes(timeArray[1])).append(NEW_LINE.getValue())
									.append(getSecondRowOfMinutes(timeArray[1]))
									.toString();
	}

	private String getSeconds(int seconds) {
		if (seconds % 2 == 0)
			return Y.getValue();
		else
			return O.getValue();
	}

	private String getFirstRowOfHours(int hours) {
		return calculateOnOff(4, getTopNumberOfOnSigns(hours));
	}

	private String getSecondRowOfHours(int hours) {
		return calculateOnOff(4, hours % 5);
	}

	private String getFirstRowOfMinutes(int minutes) {
		return calculateOnOff(11, getTopNumberOfOnSigns(minutes), Y.getValue()).replaceAll(YYY.getValue(), YYR.getValue());
	}

	private String getSecondRowOfMinutes(int minutes) {
		return calculateOnOff(4, minutes % 5, Y.getValue());
	}

	private String calculateOnOff(int noOflights, int onSignals) {
		return calculateOnOff(noOflights, onSignals, R.getValue());
	}

	private String calculateOnOff(int noOflights, int onSignals, String onSignal) {
		String out = "";
		for (int i = 0; i < onSignals; i++) {
			out += onSignal;
		}
		for (int i = 0; i < (noOflights - onSignals); i++) {
			out += O;
		}
		return out;
	}

	private int getTopNumberOfOnSigns(int number) {
		return (number - (number % 5)) / 5;
	}
	
	private int[] splitTheTimeinArray(String aTime) {
		int[] timeArray = null;
		try {
			timeArray = Arrays.stream(aTime.split(":")).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			logger.error(e.getMessage());
		} 
		return timeArray;
	}

	private boolean isNotValidtimeFormat(int[] timeArray) {
		return null == timeArray || timeArray.length != 3 || timeArray[0] < 0 || timeArray[1] < 0 || timeArray[2] < 0
				|| timeArray[0] > 24 || timeArray[1] > 60 || timeArray[2] > 60;
	}

}
