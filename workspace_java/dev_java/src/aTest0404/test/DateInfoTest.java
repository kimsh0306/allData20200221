package aTest0404.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aTest0404.DateInfo;

class DateInfoTest {
	DateInfo di = new DateInfo();
	@Test
	void testGetDiffernceDates() {
		assertEquals((long)24,di.getDiffernceDates("2020-30-29", "2020-30-30", "yyyy-MM-dd", 'H'));
	}
}
