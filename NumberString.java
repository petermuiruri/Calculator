class NumberString{
    public int length ;		    // Length of the string
    public String value;	    // Value of the string
    public int characterPosition;   // Current index of the string

    // NumberString(int strlength, String strValue, int index){
	// length	= strlength;
	// value	= strvalue;
	// characterPosition = index;
    // }
    public void setValue(String strValue){
	this.value += strValue;
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
