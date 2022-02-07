import java.util.Scanner;			// Include the Scanner object

public class CalculatorRefactored{
    public static void printTitle(){
	/* Documentation on how to use the program
	 */
	System.out.println("\nTo use this calculator, enter any expression with or without spaces"
	                 + "\nThe expression can include any of the following operators:\n"
	                 + "\t+, - , / ,\n"
			 + "* -> multiplication \n"
			 + "% -> Modulus(Reminder)\n"
			 + "^ -> Get the power of \n"
	                 + "Use last to use the last result of the previous calculation\n"
	                 + "Use quit to quit the program\n");
    
    }

    /* Split the array of expression
     * ... into a string
     */
    public static String getMathExpression(String linesOfText[]){
	String mathExpression = "";
	for(String word : linesOfText){
	    mathExpression += word;
	}
	return mathExpression;
    }

    public static boolean checkNumberSign(String mathExpression, int characterPosition, String numberString){
	if((mathExpression.charAt(characterPosition) == '+' || mathExpression.charAt(characterPosition) == '-' )){
	    numberString +=  mathExpression.charAt(characterPosition++) + "";
	    return true;
	}
	return false;
    }
    public static boolean checkDotCharacter(String mathExpression, int characterPosition, String numberString){
	if((characterPosition < charsToBeProcessed) && (mathExpression.charAt(characterPosition) == '.')){
	    numberString += "" + expression.charAt(index++);
	    getDigits(mathExpression, characterPosition, numberString);
	    return true;
	}
	return false;
    }
    public static String getDigits(String mathExpression, int characterPosition, String numberString){
	int charsToBeProcessed = mathExpression.length();
	/* Copy the remaning digits until no digit is found to the
	 * numberstring
	 */
	while((characterPosition < charsToBeProcessed) && (Character.isDigit(mathExpression.charAt(characterPosition)))){
	    numberString += "" + mathExpression.charAt(characterPosition++);
	}
	return numberString;
    }
    public static String getNumberText( String mathExpression, int characterPosition, String numberString,
	    double currentResult, double previousResult, String previousResultCode){

	int charsToBeProcessed = getMathExpression.length();

	if((characterPosition < charsToBeProcessed) && (mathExpression.startsWith(lastResultString))){
	    characterPosition += previousResultCode.length();		// Skip the character    
	    expression = expression.substring(index);	// Remove the lastResultString from the string
	    characterPosition=0;
	    charsToBeProcessed = expression.length();
	}
	else{
	    /* Find the left operand for the first operator
	     * Check the sign and copy it
	     */
	    if((mathExpression.charAt(characterPosition) == '+' || mathExpression.charAt(characterPosition) == '-' )){
		numberString +=  mathExpression.charAt(characterPosition++) + "";
	    }
	    getDigits(mathExpression, characterPosition, numberString);
	    /* Add the decimal part and the fractional part of a decimal number
	     * and the the rest of the digits
	     */
	    if((characterPosition < charsToBeProcessed) && (mathExpression.charAt(characterPosition) == '.')){
		numberString += "" + expression.charAt(index++);
		getDigits(mathExpression, characterPosition, numberString);
	    }
	    /* If the numberString is not empty
	     * save this as the first result
	     */
	    if(numberString.length() > 0) {
		currentResult += Double.valueOf(numberString);
	    }
	}
	return numberString;
    }

    // public void getTheNumber(String numberString){
	// /* Convert the number found as double
	 // * ... It will be the first number 
	 // * ... saved as the result
	 // */
	// try{    // Handle the erro due to non number value
	    // if(numberString.length() > 0) {
		// result += Double.valueOf(numberString);
	    // }
	// }catch(NumberFormatException e){
	    // System.out.println("Syntax error: " + expression.charAt(index) + "\n");
	    // errorsFound = true;
	// }
    // }
    public static void main(String[] args){
	/* Initialization variables
	 */
	String line[];				    // Stores the input string
	String whiteSpace	= "\\s";	    // Regular expression for whitespace
	String expression   	="";		    // Calculation string
	int charsToBeProcessed	= 0;		    // Number of charcters to be processed
	String exitCode		= "quit";	    // Code to quit the program
	int index		= 0;		    // Index used as calculation is processed
	String numberString	= "";		    // Stores number as a string as calculation is performed
	boolean errorsFound	= false;	    // Checks if errors where found
	double number		= 0.0;		    // Stores the value of the number found
	char operator	    	= 0;		    // Operator
	double result	    	= 0.0;		    // Operation result
	double previousResult	= 0.0;		    // Stores the last result
	String previousResultCode = "last";	    // Code for the previus result

	Scanner kbScan	= new Scanner(System.in);	// Create a scanner object, keyboard scanner
	/* Creation method
	 */
	printTitle();

	/* Loop this until quit
	 *
	 * Read data continually until the user enters quit,
	 * ... then terminate the program
	 */
	while(kbScan.hasNextLine()){			// Get the line of text
	    /* Read the string
	     * and split the string
	     */
	    line = kbScan.nextLine().split(whiteSpace);

	    expression = getMathExpression(line);

	    System.out.println(expression);
	    if(expression.equals(exitCode)){	// If it is entered
		break;
	    }   
	    /* Get the number of characters to be processed
	     */
	    charsToBeProcessed = expression.length();

	    /* Perform the following to the last charater of the expression
	     */
	    if(charsToBeProcessed > 0){
		index = 0;		// Start at the first character
		/* Loop this two
		 */
		while((index < charsToBeProcessed)){
		    numberString = "";			// Reset the string
		    /* Read the two numbers and and operator
		     * Get the result
		     */
		    /* Get the number text for the first number
		     */
		    numberString = getNumberText(expression, index, numberString, previousResult, previousResultCode);
		    index = 0;
		    System.out.println(numberString);

		    /* Get the first number
		     * Then get the get the first result and convert it
		     */
		    // System.out.println(":: [before conversion] " + number + "{numberString} " + numberString);
		    if(!numberString.isBlank()) {
			number = Double.valueOf(numberString);

			// System.out.println(":: [after conversion] " + number);
			// System.out.println(":: +=++ [ second number and the rest ] 2a [ dot] numberstring>" + numberString + " [index]" + index + " [ result ] " + result);

			/* Perform calculation on the number
			 * ... save it as the result
			 */
			switch(operator){
			    case '+':	/* Additions */
			    result += number;
			    break;
			    case '-':	/* Subtraction */
			    result -= number;
			    break;
			    case '*':	/* Multiplication */
			    result *= number;
			    break;
			    case '/':	/* Division */
			    if(number == 0.0){
				System.out.println("\nDivision by zero error\n");
			    }else{
				result /= number;
			    }
			    break;
			    case '%':	/* Remider operator */
			    if(number == 0){
				System.out.println("\nDivision by zero error\n");
			    }else{
				result %= number;
			    }
			    break;
			    case '^':	/* Power of operator */
			    result = Math.pow(result, number);
			    break;
			    default:
			    System.out.println(operator + " Invalid operator! ");
			    break;
			}
		    }
		    /* Display the result
		     */
		    if(!errorsFound) {
			System.out.println(result + "\n");
		    }
		}
	    }
	    previousResult = result; // Save the result
	    result	  = 0.0;    // Reset the result
	    errorsFound	  = false;  // Reset errorFounds
	    numberString  = "";	    // Reset the string
	    expression	  = "";	    // Reset the string
	}
	kbScan.close();		    // Close the scanner object
    }
}

/*
 *
	private Calculator(String numberString, int charsToBeProcessed,
		int index, double number, char operator, double result,
		boolean errorsFoundfalse, String exitCode, String expression,
		String whiteSpace, double lastResult, String lastResultString){

		// this.line[]		= line[];
		this.numberString	= numberString; 
		this.charsToBeProcessed	= charsToBeProcessed;
		this.index		= index;
		this.number		= number;
		this.operator	    	= operator;
		this.result	    	= result;
		this.errorsFound	= errorsFound;
		this.exitCode		= exitCode;
		this.expression   	= expression;
		this.whiteSpace		= whiteSpace;
		this.lastResult		= lastResult;
		this.lastResultString	= lastResultString;
	}

	public static Calculator readLine(String line[], String stringSeparator, int numberOfCharacters){
	    // this.line[]			= line[];				    // Stores the input string
	    this.whiteSpace		= stringSeparator;    // Regular expression for whitespace
	    this.numberOfCharacters	= numberOfCharacters;

	    return line;
	}

	public static Calculator Expression(String line[], operator, numberOfCharacters, index){
	    // this.line[]	    = line[];				    // Stores the input string
	    this.operator	    = operator;
	    this.numberOfCharacters = numberOfCharacters;
	    this.index		    = index;
	    return expression;
	}

	public static Calculator Calculate(double result, double  number, double index){
	    this.index	    = index;
	    this.number	    = number;
	    this.operator   = operator;
	    return result;
	}

	*/
