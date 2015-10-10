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
	
	@Test
	public final void addMoreThenTwoNumbers(){
		Assert.assertEquals(1+2+3+4, StringCalc.add("1,2,3,4"));
	}
	
	@Test
	public final void newLineSeperator(){
		Assert.assertEquals(6, StringCalc.add("1\n2,3"));
		//Assert.assertEquals(1, StringCalc.add("1,\n"));
	}
	
	@Test
	public final void changeDelimineter(){
		Assert.assertEquals(3, StringCalc.add("//;\n1;2"));
		Assert.assertEquals(6, StringCalc.add("//;\n1;2,3"));
	}
}
