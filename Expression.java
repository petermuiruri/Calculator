class Expression{
    String value;	    // Stores the value of the expression
    int length;		    // Length of the expression
    int characterPosition;   // Current character index

    // Expression(int strlength, String strValue, int index){
	// length	= strlength;
	// value	= strvalue;
	// characterPosition = index;
    // }
    public void setValue(String strValue){
	this.value = strValue;
    }
    public void setLength(){
	this.length = this.value.length();
    }
    public void setCharacterPosition(int characterPosition){
	this.characterPosition = characterPosition;
    }
    public String getValue(String strValue){
	return this.value;
    }
    public int getLength(){
	return this.length;
    }
    public int getCharacterPosition(){
	return this.characterPosition;
    }
}
