package syllableCounter;

public abstract class AbstractState{

	public abstract void handleChar ( char c );

	public void enterState () {}

	public boolean isVowel(char c){
		return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
	}
}

class StartState extends AbstractState {

	@Override
	public void handleChar(char c) {
		if( Character.isWhitespace(c) ){

		}
		if ( isVowel(c) || c == 'y' ) setState (SINGLEVOWEL) ;
		else if ( Character.isLetter(c) ) setState (CONSONANT);
		else if ( c == '-') setState (HYPHEN);
		else setState (NONWORD);
	}

}

class SingleVowelState extends AbstractState {

	@Override
	public void handleChar(char c) {
		if ( isVowel(c) ) setState (MULTIVOWEL) ;
		else if ( Character.isLetter(c) ) setState (CONSONANT);
		else if ( c == '-') setState (HYPHEN);
		else setState (NONWORD);
	}

	@Override
	public void enterState(){
		syllables++;
	}

}

class WordCounter {
	private final AbstractState START = new StartState( );
	private final AbstractState SINGLEVOWEL = new SingleVowelState( ); //TODO add other states
	private AbstractState state; // the current state
	private int syllableCount = 0;
	/** change to a new state */
	public void setState( AbstractState newstate ) {
		if (newstate != state) newstate.enterState( );
		state = newstate;
	}
}
}
