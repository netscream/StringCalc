package sc;

public class StringCalc {
	public static int add(String Input){
		String stringSplit = "\n|,";
		String delimineterChanger = "//";
		if (Input.startsWith(delimineterChanger))
		{
			stringSplit += "|";
			stringSplit += Input.substring(Input.indexOf(delimineterChanger)+delimineterChanger.length(), Input.indexOf("\n", Input.indexOf(delimineterChanger) +1));
			Input = Input.substring(Input.indexOf("\n") + 1);
		}
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
				sumInput += Integer.parseInt(inputArr[i]);
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
