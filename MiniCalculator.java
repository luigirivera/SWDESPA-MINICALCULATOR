import java.util.Scanner;

interface Computor{
	public String compute(float val1, float val2);
}

class Invalid implements Computor{
    public String compute(float val1, float val2)
    {
        return "ERROR: Invalid operation";
    }
}

class Add implements Computor{
	public String compute(float val1, float val2)
	{
		return String.valueOf((int)(val1 + val2));
	}
}

class Subtract implements Computor{
	public String compute(float val1, float val2)
	{
		return String.valueOf((int)(val1 - val2));
	}
}

class Multiply implements Computor{
	public String compute(float val1, float val2)
	{
		return String.valueOf((int)(val1 * val2));
	}
}

class Divide implements Computor{
	public String compute(float val1, float val2)
	{
        if (val2==0)
            return "ERROR: Can't divide by 0";
        else
            return String.valueOf((int)(val1/val2));
	}
}

class Parser{
    
}

class Calculator{
	public void calculatorStart()
	{
        String expression;
        Scanner input = new Scanner(System.in);
        String[] parsedExpression = new String[2];
		do
		{
			expression = input.nextLine();
			expression = expression.trim();
			if(!expression.equals(Symbols.EXIT.toString()))
			{
                //placing space between every character
                expression = expression.replace("", " ");
                //removing extra space between numbers joined by decimal point
                expression = expression.replaceAll("[\\.][\\s]", ".");
                expression = expression.replaceAll("[\\s][\\.]", ".");
                //removing extra space between digits of a number
                expression = expression.replaceAll("([0-9])([\\s])", "$1");
                //removing extra space on the sides
                expression = expression.trim();
                //split expression into 3 strings using whitespace as splitter
				parsedExpression = expression.split("\\s+", 3);
				printResult(Float.parseFloat(parsedExpression[0]), Float.parseFloat(parsedExpression[2]), findComputor(parsedExpression[1]));
			}
				
		}while(!expression.equals(Symbols.EXIT.toString()));
			
		input.close();
	}
	
	private Computor findComputor(String symbol) {
        /* Why not switch statement?
            Switch cases would have needed "constant string expression" */
        if (symbol.equals(Symbols.ADD.toString()))
            return new Add();
        else if (symbol.equals(Symbols.SUB.toString()))
            return new Subtract();
        else if (symbol.equals(Symbols.MULT.toString()))
            return new Multiply();
        else if (symbol.equals(Symbols.DIV.toString()))
            return new Divide();
        else
            return new Invalid();
	}
	
	private void printResult(float val1, float val2, Computor computor)
	{
		System.out.println(computor.compute(val1, val2));
	}
	
}

public class MiniCalculator{
	public static void main(String[] args)
	{
		Calculator mc = new Calculator();
		mc.calculatorStart();
	}
}
