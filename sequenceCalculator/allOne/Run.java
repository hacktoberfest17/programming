package allOne;

public class Run {
	public static void run() {
		boolean isOpen = true;

		while (isOpen) {
			System.out.println("Your answer is: " + MainMenu.mainMenuSelection());
			MainMenu.quitMenu();
			double cont = Input.input("Continue?");
			if (cont == 2) {
				isOpen = false;
			}
		}
	}
}
