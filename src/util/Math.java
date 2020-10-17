package util;

public class Math {
	
	public static enum OPERATOR { NOOP, PLUS, MINUS, DIVIDE, MULTIPLY, HEX };
	// This method translates the decimal to hexidecimal
	public static String translateIt(double arg1, OPERATOR mathOp) {

		int newarg = (int) arg1;
		int temp;
		String calcAnswer = "";
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		switch(mathOp){
			case HEX:
				while(newarg > 0){
					temp = newarg%16;
					calcAnswer = hex[temp] + calcAnswer;
					newarg = newarg/16;
				}
				return calcAnswer;
			default:
				return calcAnswer;	
		} // end switch


	}
    // this method does calculations based on user input
	public static double calculateIt(double arg1, OPERATOR mathOp, double arg2) {
		
		double calcAnswer;		
		switch(mathOp)
	    {
	        case PLUS:
	            calcAnswer = arg1 + arg2;
	            break;
	        case MINUS:
	            calcAnswer = arg1 - arg2;
	            break;
	        case DIVIDE:
	            calcAnswer = arg1 / arg2;
	            break;
	        case MULTIPLY:
	            calcAnswer = arg1 * arg2;
	            break;
	        case NOOP:
	        default:	
	            calcAnswer = arg1;
	    } // end switch
		return calcAnswer;
	}
}
	
