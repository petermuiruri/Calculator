# Calculator
java implementation of a calculator

# Calculator

Calculator is a java implementation of a caculator in object oriented design.
It doesn't follow operator precedece.
Calculation are done as they are inputed.

# What is supported
last: keyword is used to retrieve the result of the previous result.
It can be used any where.

Number signes are allowed.
Signs can be combined, for example 1--2, result to 1+2

No brackets arrowed, only the following symbols are allowed:
    Sign	| Specifiction
    -------------------------------------
     -		| Minus
     +  	| Plus
     ^  	| Raise to power
     /  	| Division
     *  	| Multiplicatio
     %    | Remaider
    -------------------------------------

# How to use it

When the program start a short description is given.
public class Calculator{

    To use this calculator, enter any expression with or without spaces
    The expression can include any of the following operators:
	    +, - , / ,
    % -> Modulus(Reminder)
    * -> multiplication
    ^ -> Get the power of
    Use last to use the previous result of the previous calculation
    Use quit to quit the program

# Installation
    To run the progaram run:
	$ java Calculator

    To manually compile the program
	$ javac Calculator.java
	$ java Calculator

# Examples
	1+3 
	4.0
	
	last*4
	16.0
	
	last*4*3-4*9
	1692.0
