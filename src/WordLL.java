
/**
 * This class stores a mystery word and all word guesses tried so far. 
 * It keeps a history of the past word guesses in a linked structure.
 * @author azararya
 */
public class WordLL {
	
	// instance variables 
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	/**
	 * Constructor initializes instance variables history and mysteryWord
	 * @param mysteryWord is set to mystery
	 */
	public WordLL (Word mystery) {
		history = null;
		mysteryWord = mystery;
	}
	
	/**
	 * This method takes a Word as an argument to test against this games’ mystery word
	 * @param guess is an object of Word class
	 * @return boolean 
	 */
	public boolean tryWord (Word guess) {
		guess.labelWord(mysteryWord);
		LinearNode<Word> wordNode = new LinearNode<Word>(guess);
		wordNode.setNext(history);
		history = wordNode;
		if (guess.toString().equals(mysteryWord.toString()))
			return true;
		else
			return false;
	}
	
	
	/**
	 * This class creates a String representation of the past guesses with the most recent guess first
	 */
	public String toString () {
		String s = "";
		LinearNode<Word> currentWord = history;
		history = currentWord;
		while (currentWord != null) {
			if (currentWord.getNext() != null)
				s += currentWord.getElement().toString() + "\n";
			else
				s += currentWord.getElement().toString();
			currentWord = currentWord.getNext();
			
		}
		return s;
	}

}
