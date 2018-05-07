package com.ubs.opsit.interviews.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TimeConverterTest {

	private TimeConverterImpl timeConverter = null;
	
	@Before
	public void setup() {
		timeConverter = new TimeConverterImpl();
		assertNotNull(timeConverter);
	}
	
	@After
	public void tearDown() {
		this.timeConverter = null;
	}
	
	@Test
	public void WhenTheTimeIs00_00_00_ThenReturnExPectedResult() {
		String aTime = "00:00:00";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Y\r\n" + 
				"OOOO\r\n" + 
				"OOOO\r\n" + 
				"OOOOOOOOOOO\r\n" + 
				"OOOO"  , actualResult);
	}
	
	@Test
	public void WhenTheTimeIs13_17_01_ThenReturnExPectedResult() {
		String aTime = "13:17:01";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("O\r\n" + 
				"RROO\r\n" + 
				"RRRO\r\n" + 
				"YYROOOOOOOO\r\n" + 
				"YYOO", actualResult);
	}
	
	@Test
	public void WhenTheTimeIs23_59_59_ThenReturnExPectedResult() {
		String aTime = "23:59:59";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("O\r\n" + 
				"RRRR\r\n" + 
				"RRRO\r\n" + 
				"YYRYYRYYRYY\r\n" + 
				"YYYY", actualResult);
	}
	
	@Test
	public void WhenTheTimeIs24_00_00_ThenReturnExPectedResult() {
		String aTime = "24:00:00";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Y\r\n" + 
				"RRRR\r\n" + 
				"RRRR\r\n" + 
				"OOOOOOOOOOO\r\n" + 
				"OOOO", actualResult);
	}
	
	@Test
	public void WhenTheTimeIsNotValid_ThenShowErrorMessage() {
		String aTime = "-24:00:00";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	@Test
	public void WhenTheTimeIsNotValid_2_ThenShowErrorMessage() {
		String aTime = null;
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	@Test
	public void WhenTheTimeIsNotValid_3_ThenShowErrorMessage() {
		String aTime = "";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	@Test
	public void WhenTheTimeIsNotValid_4_ThenShowErrorMessage() {
		String aTime = "                 ";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	
	@Test 
	public void WhenTheTimeIsNotValid_5_ThenShowErrorMessage() {
		String aTime = "abcd:kjhk:kjhkh";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	@Test 
	public void WhenTheTimeIsNotValid_6_ThenShowErrorMessage() {
		String aTime = "abcd";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	@Test 
	public void WhenTheTimeIsNotValid_7_ThenShowErrorMessage() {
		String aTime = "1234:1234:1234";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
	
	@Test 
	public void WhenTheTimeIsNotValid_8_ThenShowErrorMessage() {
		String aTime = "1234:1234:1234:1234:12345";
		String actualResult = timeConverter.convertTime(aTime);
		assertEquals("Time format is not correct", actualResult);
	}
}
