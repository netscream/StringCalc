package sc;

public class StringCalc {
	public static int add(String Input){
		String stringSplit = "\n|,";
		String delimineterChanger = "//";
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
			Input = Input.substring(Input.indexOf("\n") + 1);
		}
		int sumInput = 0;
		if (Input.length() > 0)
		{
			String[] inputArr;
			if (CutString.length() > 1)
			{
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
