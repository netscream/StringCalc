package sc;

import org.junit.Assert;
import org.junit.Test;

import sc.StringCalc;

public class TestSC {
	@Test
	public final void emptyStringAddedReturn0(){
		Assert.assertEquals(0, StringCalc.add("")); //empty string
	}
	
	@Test
	public final void oneNumberAdded(){
		Assert.assertEquals(1, StringCalc.add("1"));
		Assert.assertEquals(11, StringCalc.add("11"));
		Assert.assertEquals(1000, StringCalc.add("1000"));
	}
	
	@Test
	public final void twoNumbersAdded(){
		Assert.assertEquals(3, StringCalc.add("1,2")); //suming up 2 numbers
		Assert.assertEquals(1, StringCalc.add("-1,2")); //suming one negative number
	}
}
