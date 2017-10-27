package syllableCounter;

public class SimpleSyllableCounter {

	int countSyllables ( String oldWord ){
		String word = oldWord.toLowerCase();
		int syllables = 0;
		char c = ' ';
		State state = State.START;
		for(int i = 0 ; i < word.length() ; i++) {
			c = word.charAt(i);
			if (c == '\'') continue;
			switch (state) {
			case START:
				if( Character.isWhitespace(c) ){

				}
				if ( isVowel(c) || c == 'y'){
					state = State.SINGLE_VOWEL;
				}
				else if ( Character.isLetter(c) ){
					state = State.CONSONANT;
				}
				else {
					state = State.NONWORD;
				}
				break;
			case CONSONANT:
				if ( isVowel(c) || c== 'y'){
					state = State.SINGLE_VOWEL;
				}
				else if ( Character.isLetter(c) ){
					//Stay in CONSONANT state.
				}
				else if ( c == '-'){
					state = State.HYPHEN;
				}
				else{
					state = State.NONWORD;
				}
				break;
			case SINGLE_VOWEL:
				syllables += 1;
				if ( isVowel(c) ){
					state = State.MULTIVOWEL;
				}
				else if ( Character.isLetter(c) ){
					state = State.CONSONANT;
				}
				else if ( c == '-'){
					state = State.HYPHEN;
				}
				else{
					state = State.NONWORD;
				}
				break;
			case MULTIVOWEL:
				if ( isVowel(c) ){
					//Stay in MULTIVOWEL state.
				}
				else if ( Character.isLetter(c) ){
					state = State.CONSONANT;
				}
				else if ( c == '-'){
					state = State.HYPHEN;
				}
				else{
					state = State.NONWORD;
				}
				break;
			case HYPHEN:
				if ( isVowel(c) ){
					state = State.SINGLE_VOWEL;
				}
				else if ( Character.isLetter(c) ){
					state = State.CONSONANT;
				}
				else{
					state = State.NONWORD;
				}
				break;
			case NONWORD:
				syllables = 0;
				break;
			}

		}
		if( state == State.SINGLE_VOWEL ){
			if( c != 'e'  || syllables == 0){
				syllables += 1;
			}
		}
		return syllables;

	}

	boolean isVowel(char c){
		return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
	}
}
