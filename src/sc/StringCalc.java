package sc;

public class StringCalc {
	public static int add(final String Input){
		String stringSplit = ",";
		int sumInput = 0;
		if (Input.length() > 0)
		{
			String[] inputArr;
			inputArr = Input.split(stringSplit);
			for (int i = 0; i < inputArr.length; i++)
			{
				sumInput += Integer.parseInt(inputArr[i]);
			}
			return sumInput;
		}
		else
		{
			return 0;
		}
	}
}
