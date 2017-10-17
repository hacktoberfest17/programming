public class PasswordStrength {
    public static void main(final String ar[]) {
        String password = AbraKadabra1287832FQENi;

        boolean hasLetter = false;
        boolean hasDigit = false;
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (Character.isLetter(x)) {
					if(Character.isUpperCase(x)){
						
						hasUpperCase = true;
						
					}else if(Character.isLowerCase(x)){
						
						hasLowerCase = true;
					}
					
                    hasLetter = true;
                }

                else if (Character.isDigit(x)) {

                    hasDigit = true;
                }

                // no need to check further, break the loop
                if(hasLetter && hasDigit && hasUpperCase && hasLowerCase){

                    break;
                }

            }
            if (hasLetter && hasDigit && hasUpperCase && hasLowerCase) {
                System.out.println("STRONG");
            } else {
                System.out.println("NOT STRONG");
            }
        } else {
            System.out.println("HAVE AT LEAST 8 CHARACTERS");
        }
    }
}
