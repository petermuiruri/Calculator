import java.util.Scanner;			// Include the Scanner object

public class Calculator{
    /* Documentation on how to use the program
     */
    public static void printTitle(){
	System.out.println("\nTo use this calculator, enter any expression with or without spaces"
			 + "\nThe expression can include any of the following operators:\n"
			 + "\t+, - , / ,\n"
			 + "% -> Modulus(Reminder)\n"
			 + "* -> multiplication \n"
			 + "^ -> Get the power of \n"
			 + "Use last to use the previous result of the previous calculation\n"
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

    /* Check for a character
     */
    public static boolean checkNumberSign(String mathExpression, int characterPosition, String numberString){
	if((mathExpression.charAt(characterPosition) == '+' || mathExpression.charAt(characterPosition) == '-' )){
	    numberString +=  mathExpression.charAt(characterPosition++) + "";
	    return true;
	}
	return false;
    }

    /* Check for the dot character
     */
    public static boolean checkDotCharacter(String mathExpression, int characterPosition, String numberString){
	if((characterPosition < mathExpression.length()) && (mathExpression.charAt(characterPosition) == '.')){
	    return true;
	}else{
	    return false;
	}
    }


    public static void main(String[] args){
	/* Initialization variables
	 */
	String line[];				    // Stores the input string
	String whiteSpace	= "\\s";	    // Regular expression for whitespace
	String exitCode		= "quit";	    // Code to quit the program
	int charsToBeProcessed	= 0;		    // Number of charcters to be processed
	double result	    	= 0.0;		    // Operation result
	double previousResult	= 0.0;		    // Stores the previous result
	String previousResultCode = "last";	    // Code for the previus result
	boolean errorsFound	= false;	    // Checks if the program should continue
	char operator	    	= 0;		    // Operator
	double number		= 0.0;		    // Stores the value of the number found

	Expression expression = new Expression();   // New expression object
	expression.value = "";
	NumberString numberString = new NumberString();   // New expression object

	/* Print the title of the program
	 */
	printTitle();

	Scanner kbScan	= new Scanner(System.in);	// Create a scanner object, keyboard scanner

	/* Read data continually until the user enters quit,
	 * ... then terminate the program
	 */
	while(kbScan.hasNextLine()){			// Get the line of text
	    /* Get the next line and split it into an array of strings
	     */
	    line = kbScan.nextLine().split(whiteSpace);
	    
	    /* Get the Math expression from the line
	     */
	    expression.value = getMathExpression(line);
	    expression.length = expression.value.length();

	    /* Check whether the exit code is entered
	     */
	    if(expression.value.equals(exitCode)){	// If it is entered
		break;
	    }   

	    /* Get the number of characters to be processed
	     */
	    charsToBeProcessed = expression.value.length();

	    /* Perform the following to the last charater of the expression
	     */
	    if(charsToBeProcessed > 0){
		expression.characterPosition = 0;   // Start at the first character

		/* Do this until the last character of the expression
		 */
		while((expression.characterPosition< charsToBeProcessed)){
		    numberString.value = "";			// Reset the string

		    if((expression.characterPosition < charsToBeProcessed) && (expression.value.indexOf(previousResultCode, expression.characterPosition) == expression.characterPosition)){
			result = previousResult;
			expression.characterPosition += previousResultCode.length();		// Skip the word    
		    } else{
			/* Find the left operand for the first operator
			 * Check the sign and copy it
			 */
			// public static boolean checkNumberSign(String mathExpression, int characterPosition, String numberString){
			if(checkNumberSign(expression.value, expression.characterPosition, numberString.value)){
			    numberString.value +=  expression.value.charAt(expression.characterPosition++) + "";
			}

			/* Copy the remaning digits until no digit is found to the
			 * numberstring
			 */
			while((expression.characterPosition < charsToBeProcessed) && (Character.isDigit(expression.value.charAt(expression.characterPosition)))){
			    numberString.value += "" + expression.value.charAt(expression.characterPosition++);
			}

			/* Add the decimal part and the fractional part of a decimal
			 * number
			 */
			if(checkDotCharacter(expression.value, expression.characterPosition, numberString.value)){
			    numberString.value  += "" + expression.value.charAt(expression.characterPosition++);
			    while((expression.characterPosition < charsToBeProcessed) && Character.isDigit(expression.value.charAt(expression.characterPosition))){
				    numberString.value += "" + expression.value.charAt(expression.characterPosition++);
			    }
			}

			/* Check if the previous result code is ued if so
			 * .. save the value and increment the index
			 */
			if((expression.characterPosition < charsToBeProcessed) && (expression.value.indexOf(previousResultCode, expression.characterPosition) == expression.characterPosition)){
			    numberString.value += previousResult;
			    expression.characterPosition += previousResultCode.length();
			}


			/* Convert the number found as double
			 * ... It will be the first number 
			 * ... saved as the result
			 */
			try{	    // Handle the erro due to non number value
			    if(numberString.value.length() > 0) {
				result += Double.valueOf(numberString.value);
			    }
			}catch(NumberFormatException e){
			    System.out.println("Syntax error: " + expression.value.charAt(expression.characterPosition) + "\n");
			    errorsFound = true;
			}
		    }

		    /* Find the left operand for the first operator
		     * Check the sign and copy it
		     */
		    if(expression.characterPosition < charsToBeProcessed){ // Save the next operator and proceed to the next character
			operator =  expression.value.charAt(expression.characterPosition++);
		    }

		    /* Reset the numberstring string for the next value
		    */
		    numberString.value = "";

		    /* Check if the number is proceeded by its sign and save it
		    */
		    // if((expression.value.charAt(expression.characterPosition) == '+' || expression.value.charAt(expression.characterPosition) == '-' )){
			// numberString.value +=  expression.value.charAt(expression.characterPosition++) + "";
		    // }

		    if(checkNumberSign(expression.value, expression.characterPosition, numberString.value)){
			numberString.value +=  expression.value.charAt(expression.characterPosition++) + "";
		    }
		    /* Copy all the digits after the operator
		    */
		    while((expression.characterPosition < charsToBeProcessed) && Character.isDigit(expression.value.charAt(expression.characterPosition))){
			    numberString.value += "" + expression.value.charAt(expression.characterPosition++);
		    }
		    /* Copy the . symbol 
		    */
		    if(checkDotCharacter(expression.value, expression.characterPosition, numberString.value)){
			numberString.value  += "" + expression.value.charAt(expression.characterPosition++);
			while((expression.characterPosition < charsToBeProcessed) && Character.isDigit(expression.value.charAt(expression.characterPosition))){
				numberString.value += "" + expression.value.charAt(expression.characterPosition++);
			}
		    }

		    /* Check if the previous result code is ued if so
		     * .. save the value and increment the index
		     */
		    if((expression.characterPosition < charsToBeProcessed) && (expression.value.indexOf(previousResultCode, expression.characterPosition) == expression.characterPosition)){
			numberString.value += previousResult;
			expression.characterPosition += previousResultCode.length();
		    }

		    /* Get the first number
		     * Then get the get the first result and convert it
		     */
		    if(!numberString.value.isBlank() && !errorsFound) {
			try{	    // Handle the erro due to non number value
			    number = Double.valueOf(numberString.value);
			}catch(NumberFormatException e){
			    number=0.0;
			}
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
				errorsFound=true;
			    }else{
				result /= number;
			    }
			    break;
			    case '%':	/* Remider operator */
			    if(number == 0){
				System.out.println("\nDivision by zero error\n");
				errorsFound=true;
			    }else{
				result %= number;
			    }
			    break;
			    case '^':	/* Power of operator */
			    result = Math.pow(result, number);
			    break;
			    default:
			    System.out.println("Invalid operator: " + operator + "\n");
			    errorsFound=true;
			    break;
			}
		    }
		}
		/* Print out the result
		 * ..when there is no errors
		 */
		if(!errorsFound)
		    System.out.println(result + "\n");
	    }

	    previousResult	= result;   // Save the result
	    errorsFound		= false;    // Reset error check
	    numberString.value	= "";	    // Reset number string
	    expression.value	= "";	    // Reset the string
	    result = 0.0;		    // Reset the result
	}
	kbScan.close();		    // Close the scanner object
    }
}
