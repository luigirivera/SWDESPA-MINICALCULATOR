/*
    LOPEZ, LUIS ENRICO D.
    RIVERA, LOUIE IV Y.
    SWDESPA S17
*/

public enum Symbols{
	
	ADD,SUB,MULT,DIV,EXIT;
	
	public String toString()
	{
		switch(this){
			case ADD: return "+";
			case SUB: return "-";
			case MULT: return "x";
			case DIV: return "/";
			case EXIT: return "***";
			default: return "invalid";
		}
	}
}
