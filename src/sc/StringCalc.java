package sc;
/**************************************************************************
 * T-303-Hugb Hugbúnaðarfræði
 * Project: TDD with string calculator
 * Class: StringCalc
 * @author Hlynur
 *
 **************************************************************************/
public class StringCalc {
	public static int add(String Input){
		/**************************
		 * 		   REGEX
		 **************************/
		String stringSplit = "\n|,";
		String delimineterChanger = "//";
		/********************************************************************************
		 * 			Here above you can set stringSplitter for regex and
		 * 			delimineterChangerParameter etc. first char in a string to 
		 * 			be able to make new regex compares.
		 ********************************************************************************/
		
		stringSplit = makeRegex(Input, delimineterChanger, stringSplit);
		if (stringSplit.length() > 3)
		{
			Input = Input.substring(Input.indexOf("\n") + 1);
		}
		return calculate(stringSplit, Input);
	}
	
	private static String makeRegex(String Input, String delimineterChanger, String stringSplit){
		/********************************************************************
		 * 		Private function to make changes to String for REGEX
		 ********************************************************************/
		String CutString = "";
		if (Input.startsWith(delimineterChanger))
		{
			CutString = Input.substring(Input.indexOf(delimineterChanger), Input.indexOf("\n"));
			if (CutString.indexOf("[") != -1)
			{
				while(CutString.indexOf("[") != -1){
					stringSplit += "|";
					stringSplit += "\\Q" + CutString.substring(CutString.indexOf("[")+1, CutString.indexOf("]")) + "\\E";
					CutString = CutString.substring(CutString.indexOf("]")+1);
				}
			}
			else
			{
				stringSplit += "|";
				stringSplit += Input.substring(Input.indexOf(delimineterChanger)+delimineterChanger.length(), Input.indexOf("\n", Input.indexOf(delimineterChanger) +1));
			}
		}
		return stringSplit;
	}
	
	private static int calculate(String stringSplit, String Input){
		/*******************************************************************
		 * 	Private calculator to calculate the sum of all the numbers
		 * 	where the stringSplit contains all values for possible splitting
		 * 	in REGEX format	
		 *******************************************************************/
		int sumInput = 0;
		if (Input.length() > 0)
		{
			String[] inputArr;
			inputArr = Input.split(stringSplit);
			
			String negString = "";
			for (int i = 0; i < inputArr.length; i++)
			{
				if (Integer.parseInt(inputArr[i]) < 0)
				{
					if (negString.length() > 0)
					{
						negString += ",";
					}
					negString += inputArr[i];
				}
				if (Integer.parseInt(inputArr[i]) <= 1000)
				{
					sumInput += Integer.parseInt(inputArr[i]);
				}
			}
			if (negString.length() > 0)
			{
				throw new RuntimeException("Negatives not allowed: " + negString);
			}
			return sumInput;
		}
		else
		{
			return 0;
		}
	}
}
