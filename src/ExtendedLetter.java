
/**
 * This class is a subclass of Letter and extends the functionality. 
 * Instead of a single character, this class uses a String instance as objects of class Letter 
 * @author azararya
 */
public class ExtendedLetter extends Letter{
	
	// instance variables
	private String content;
	private int family;
	private boolean related;
	private static final int SINGLETON = -1;
	
	/**
	 * Constructor initializes instance variables
	 * @param instance variable content is set to s
	 */
	public ExtendedLetter (String s) {
		super('c');
		content = s;
		related = false;
		family = SINGLETON;
	}
	
	/**
	 * Constructor initializes instance variables
	 * @param instance variable content is set to s
	 * @param instance variable family is set to fam
	 */
	public ExtendedLetter (String s, int fam) {
		super('c');
		content = s;
		related = false;
		family = fam;
	}
	
	/**
	 * This method compares the parameter other with ExtendedLetter object
	 * @param other an object of class Object
	 */
	public boolean equals (Object other) {
		if (other instanceof ExtendedLetter) {
			if (this.family == ((ExtendedLetter)other).family) 
				this.related = true;
			if (this.content ==((ExtendedLetter)other).content)
				return true;
			else return false;
			
		} else  return false;

	}
	
	/**
	 * This is an overridden method that gives a String representation of this ExtendedLetter object
	 */
	public String toString () {
		String s = "";
		if (this.decorator() == "-" && this.related == true)
			s = "." + this.content + ".";
		else {
			s = this.decorator() + this.content + this.decorator();
		}
		return s;
	}
	
	/**
	 * This method creates an array of Letter objects of the same size 
	 * as the size of the array content received as parameter.
	 * @param content an array of strings
	 * @param codes an array of integer
	 * @return an array of Letter objects
	 */
	public static Letter[] fromStrings(String[] content,int[] codes) {
		Letter[] arrayLetters = new Letter[content.length];
		if (codes == null) {
			for (int i = 0; i < arrayLetters.length; i++) {
				ExtendedLetter extendObject =new ExtendedLetter(content[i]);
				arrayLetters[i] = extendObject;
			} 
		}else {
			for (int i = 0; i < arrayLetters.length; i++) {
				ExtendedLetter extendObject =new ExtendedLetter(content[i], codes[i]);
				arrayLetters[i] = extendObject;
			}
		}
		
		return arrayLetters;	
	}
	
}
