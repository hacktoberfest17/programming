public class Translation {
	
	String selectedLang;

	public Translation(String selectedLang) {
		this.selectedLang = selectedLang;
	}
	
	public static void getTranslation(String lang) {
		
		// Switch statement
		switch(lang) {
		
		case "KLINGON":
			System.out.println("\nQo' vIvan.");
			break;
			
		case "VULCAN":
			System.out.println("\nTonk'peh panu.");
			break;
			
		case "ROMULAN":
			System.out.println("\nJolan'tru rehvie.");
			break;
			
		case "BAJORAN":
			System.out.println("\nHanyu hevo.");
			break;
			
		case "TAMARIAN":
			// Due to limited Tamarian language resources, I made this up
			System.out.println("\nPaleri, bright eyes, his teeth out. All underneath his feet.");
			break;
			
		case "BORG":
			System.out.println("\nResistance is futile.");
			break;
			
		default: 
			break;
		}		
	}
}
