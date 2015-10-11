package sc;

import java.util.regex.Pattern;

public class StringCalc {
	public static int add(String Input){
		String stringSplit = "\n|,";
		String delimineterChanger = "//";
		String CutString = "";
		if (Input.startsWith(delimineterChanger))
		{
			/*stringSplit += "|";
			stringSplit += Input.substring(Input.indexOf(delimineterChanger)+delimineterChanger.length(), Input.indexOf("\n", Input.indexOf(delimineterChanger) +1));
			Input = Input.substring(Input.indexOf("\n") + 1);*/
			CutString = Input.substring(Input.indexOf(delimineterChanger)+delimineterChanger.length(), Input.indexOf("\n", Input.indexOf(delimineterChanger) +1));
			if (CutString.indexOf("[") != -1)
			{
				stringSplit += "|";
				stringSplit += "(.)\\1+" + Input.substring(Input.indexOf(delimineterChanger)+delimineterChanger.length(), Input.indexOf("]", Input.indexOf(delimineterChanger)+delimineterChanger.length())+1);
			}
			else
			{
				stringSplit += "|";
				stringSplit += Input.substring(Input.indexOf(delimineterChanger)+delimineterChanger.length(), Input.indexOf("\n", Input.indexOf(delimineterChanger) +1));
			}
			Input = Input.substring(Input.indexOf("\n") + 1);
		}
		int sumInput = 0;
		if (Input.length() > 0)
		{
			String[] inputArr;
			if (CutString.length() > 1)
			{
				//String[] stringCut = stringSplit.split("|");
				//inputArr = Input.split(stringCut);
				inputArr = Input.split(stringSplit);
			}
			else
			{
				inputArr = Input.split(stringSplit);
			}
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
