package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals(""))
		{
			return 0;
		}
		else
		{
			if(text.contains("-"))
			{
				throw new IllegalArgumentException("Negatives not allowed.");
			}
			if(text.contains(",") | text.contains("\n"))
			{
				String numbers[] = text.split(",|\n");

				return sum(numbers);
			}
			return 1;
		}
		
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static int sum(String [] numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			total += toInt(number);
		}
		return total;
	}
}