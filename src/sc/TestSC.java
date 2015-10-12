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
	}
	
	@Test
	public final void addMoreThenTwoNumbers(){
		Assert.assertEquals(1+2+3+4, StringCalc.add("1,2,3,4"));
	}
	
	@Test
	public final void newLineSeperator(){
		Assert.assertEquals(6, StringCalc.add("1\n2,3"));
		Assert.assertEquals(1, StringCalc.add("1,\n"));
	}
	
	@Test
	public final void changeDelimineter(){
		Assert.assertEquals(3, StringCalc.add("//;\n1;2"));
		Assert.assertEquals(6, StringCalc.add("//;\n1;2,3"));
	}
	
	@Test
	public final void negativesNotAllowed(){
		try{
				StringCalc.add("-1,2");
		} catch (RuntimeException except) {
			Assert.assertEquals("Negatives not allowed: -1", except.getMessage());
		}
		
		try{
			StringCalc.add("2,-4,3,-5");
		} catch (RuntimeException except) {
			Assert.assertEquals("Negatives not allowed: -4,-5", except.getMessage());
		}
	}
	
	@Test
	public final void notOverThousand(){
		Assert.assertEquals(2, StringCalc.add("1001,2"));
		Assert.assertEquals(3, StringCalc.add("1001,5000\n1,2"));
	}
	
	@Test
	public final void anyLengthDelimenters(){
		Assert.assertEquals(6, StringCalc.add("//[***]\n1***2***3"));
		Assert.assertEquals(6, StringCalc.add("//[%%%]\n1%%%2%%%3"));
		Assert.assertEquals(6, StringCalc.add("//[+++]\n1+++2+++3"));
	}
	
	@Test
	public final void allowMultipleDelim(){
		Assert.assertEquals(15, StringCalc.add("//[*][%][+][s]\n1*2%3+4s5"));
	}
}
