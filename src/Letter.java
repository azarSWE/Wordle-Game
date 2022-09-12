
/**
 * This class represents a single letter that will be used in the game. 
 * Each game letter also has an accompanying integer label.
 * @author azararya
 */
public class Letter {
	
	// instance variables 
	private char letter;
	private int label;
	
	// These constants are possible values for "label" instance variable.
	private static final int UNSET = 0;
	private static final int UNUSED = 1;
	private static final int USED = 2;
	private static final int CORRECT = 3;
	
	/**
	 * Constructor initializes label to UNSET and set the value of instance variable letter to c
	 * @param instance variable letter is set to c
	 */
	public Letter (char c) {
		label = UNSET;
		letter = c;
	}
	
	/**
	 * This method compares the “letter” attributes of otherObject and this object
	 * @param otherObject is a object of class Object.
	 */
	public boolean equals (Object otherObject) {
		if (otherObject instanceof Letter) {
			if (this.letter == ((Letter)otherObject).letter) 
				return true;
			 else return false;
			
		} else return false;
	}
	
	/**
	 * This method assigns a sign "+, -, !, space" to the each label 
	 * @return a string includes sign which is related to the label of a letter
	 */
	public String decorator () {
		String s = "";
		if (label == USED) 
			s = "+";
		else if (label == UNUSED) 
			s = "-";
		else if (label == CORRECT) 
			s = "!";
		else if (label == UNSET) 
			s = " ";
		return s;
	}
	
	/**
	 * This method is an overridden method that gives a representation 
	 * of letter & label which uses the helper method decorator.
	 */
	
	public String toString () {
		String s;
		s = decorator() + letter + decorator();
		return s;
		
	}
	
	/**
	 * This method is used to change the value of attribute “label” to UNUSED
	 */
	public void setUnused () {
		label = UNUSED;
	}
	
	/**
	 * This method is used to change the value of attribute “label” to USED
	 */
	public void setUsed () {
		label = USED;
	}
	
	/**
	 * This method is used to change the value of attribute “label” to CORRECT
	 */
	public void setCorrect () {
		label = CORRECT;
	}
	
	/**
	 * This method returns true if the attribute “label” is set to UNUSED
	 * @return a boolean variable 
	 */
	public boolean isUnused () {
		if (label == UNUSED) {
			return true;
		} else return false;
	}
	
	/**
	 * This method produces an array of objects of the class Letter from the string s given as parameter.
	 * @param s is a string parameter
	 * @return an array of class Letter objects
	 */
	public static Letter[] fromString (String s) {
		Letter[] arrayObjects = new Letter[s.length()];
		for (int i = 0; i < arrayObjects.length; i++) {
			arrayObjects[i]= new Letter(s.charAt(i));
		}
		return arrayObjects;
			
		}
}

	

