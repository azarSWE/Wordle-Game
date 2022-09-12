
/**
 * This class represents a word in the game that is comprised of any number of letters
 * @author azararya
 */
public class Word {
	
	// firstLetter is a node which is a reference to the first node in the linked list
	private LinearNode<Letter> firstLetter;
	
	/**
	 * Constructor initializes the Word object so the Letter objects in array “letters” is stored within its linked structure.
	 * @param letters is an array of class Letter objects
	 */
	public Word(Letter[] letters) {
		LinearNode<Letter> previousLetter = null;
		LinearNode<Letter> currentLetter;
		for (int i = 0; i < letters.length; i++) {
			currentLetter = new LinearNode<Letter>(letters[i]);
			// instance variable firstLetter points to the first Letter object 
			if (i == 0) {
				firstLetter = currentLetter;
				previousLetter = currentLetter;
				continue;
			}
			previousLetter.setNext(currentLetter);
			previousLetter = currentLetter;
			
		}
	}
	
	/**
	 * 	This method gives a String representation of a Word object
	 * @return String 
	 */
	public String toString () {
		String s = "Word: ";
		LinearNode<Letter> currentNode = firstLetter;
		while (currentNode != null) {
//			if (currentNode.getElement() == null) {
//				s += currentNode.getElement().toString();
//				break;
//				}
			s += currentNode.getElement().toString() + " ";
			currentNode = currentNode.getNext();
			
		}
		return s;		
	}
	
	/**
	 * This method checks if a node contains a specific Letter object
	 * @param letter is a node which stores a Letter object
	 * @return boolean
	 */
	private boolean containLetter(LinearNode<Letter> letter) {
		LinearNode<Letter> currentNode = firstLetter;
		while (currentNode != null) {
			if (letter.getElement().equals(currentNode.getElement()))
					return true;
			currentNode = currentNode.getNext();
		}
		return false;
	}

	/**
	 * This method updates each of Letters’ “label” attribute with respect to the mystery word
	 * @param mystery mystery word
	 * @return returns true if this word is identical in content to the mystery word
	 */
	public boolean labelWord (Word mystery) {
		LinearNode<Letter> thisNode = this.firstLetter;
		LinearNode<Letter> mysteryNode = mystery.firstLetter;
		boolean isEqual = true;
		while (true) {
			// check thisNOde and mysteryNode for the null
			if (thisNode == null || mysteryNode == null) {
				
				// when thisNode equals null
				if (thisNode == null && mysteryNode != null) {
					isEqual = false;
					break;
				}
				
				// when mysteryNode equals null check if the remaining nodes of this Word exists in Word mystery
				else {
					isEqual = false;
					while (true) {
						if (mystery.containLetter(thisNode)) 
							thisNode.getElement().setUsed();
						else
							thisNode.getElement().setUnused();
						thisNode = thisNode.getNext();
						if (thisNode == null) 
							return isEqual;
					}
				}
			}
			
			// when thisNode and mysteryNode are not null
			if (thisNode.getElement().toString().equals(mysteryNode.getElement().toString())) {
					thisNode.getElement().setCorrect();
			} 
			else {
				if (mystery.containLetter(thisNode)) 
					thisNode.getElement().setUsed();
				else
					thisNode.getElement().setUnused();
				isEqual = false;
				}
			thisNode = thisNode.getNext();
			mysteryNode = mysteryNode.getNext();
			if (thisNode == null && mysteryNode == null) 
				break;
				
			}
		
		return isEqual;
	}
}


