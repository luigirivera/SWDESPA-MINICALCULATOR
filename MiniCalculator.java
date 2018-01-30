import java.util.Scanner;

interface Computor{
	public int compute(int val1, int val2);
}

class Add implements Computor{
	public int compute(int val1, int val2)
	{
		return val1 + val2;
	}
}

class Subtract implements Computor{
	public int compute(int val1, int val2)
	{
		return val1 - val2;
	}
}

class Multiply implements Computor{
	public int compute(int val1, int val2)
	{
		return val1 * val2;
	}
}

class Divide implements Computor{
	public int compute(int val1, int val2)
	{
		try
		{
			return (int) val1 / val2;
		}
		catch(ArithmeticException e)
		{
			if(val2 == 0)
				System.out.println("ERROR: You can not divide by 0");
		}
	}
}

class Calculator{
	Scanner input = new Scanner(System.in);
	String expression;
	String[] operation;
	String symbol;
	Computor operator;
	int[] values = new int[2];
	
	public void calculatorStart()
	{
		do
		{
			System.out.print("Please enter your expression or enter '***' to exit: ");
			expression = input.nextLine();
			expression = expression.trim();
			if(!expression.equals(Symbols.EXIT.toString()))
			{
				System.out.print("Result: ");
				
				operation = expression.split("\\s", 3);
				symbol = operation[1];
				values[0] = Integer.parseInt(operation[0]);
				values[1] = Integer.parseInt(operation[2]);
				findOperation();
				
			}
				
		}while(!expression.equals(Symbols.EXIT.toString()));
			
		input.close();
	}
	
	private void findOperation()
	{
		Add addi = new Add();
		Subtract sub = new Subtract();
		Multiply mul = new Multiply();
		Divide div = new Divide();
		
		if(symbol.equals(Symbols.ADD.toString()))
			operator = addi; 
		else if(symbol.equals(Symbols.SUB.toString()))
			operator = sub;
		else if(symbol.equals(Symbols.MULT.toString()))
			operator = mul;
		else if(symbol.equals(Symbols.DIV.toString()))
			operator = div;
		else
			System.out.println("ERROR: Invalid Operation");
		
		doOperation();
	}
	
	private void doOperation()
	{
		System.out.println(operator.compute(values[0], values[1]));
	}
	
}

public class MiniCalculator{
	public static void main(String[] args)
	{
		Calculator mc = new Calculator();
		mc.calculatorStart();
	}
}