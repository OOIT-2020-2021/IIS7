package introduction;

public class Variables {

	public static void main(String[] args) {
		
		double firstNumber;
		firstNumber = 1;
		double secondNumber = 5;
		int result = (int) (firstNumber / secondNumber);
		System.out.println(result);
		
		double doubleResult = firstNumber/secondNumber;
		System.out.println(doubleResult);
		
		boolean alwaysTrue = true;
		boolean secondBoolean = false;
		System.out.println(alwaysTrue && secondBoolean);
		System.out.println(alwaysTrue || secondBoolean);
		
		String name = "Petar";
		String lastName = "Petrović";
		System.out.println(name + " " + lastName + " Njegoš");

		// IF ELSE blok
		if(firstNumber > 0) 
			System.out.println("Number is positive.");
		else if(firstNumber < 0)
			System.out.println("Number is negative.");
		else
			System.out.println("Number is equal to zero.");
		
		
		// WHILE
		// Pomocu WHILE petlje ispisati brojeve od 1 do 10
		int i = 1;
		while (i<=10) {
			System.out.println(i);
			i++;
		}
		
		
		// Pomocu WHILE petlje ispisemo faktorijel broj 5 (5!)
		i = 5;
		int factorial = 1;
		while(i>0) {
			factorial = factorial * i;
			i--;
		}
		System.out.println("while 5! = " + factorial);
		
		// Pomocu DO WHILE petlje ispisemo faktorijel broj 5 (5!)
		i = 5;
		factorial = 1;
		do {
			// factorial = factorial * i;
			factorial *= i;
			i--;
		} while (i>0);
		System.out.println("do while 5! = " + factorial);
		
		// Pomocu FOR petlje ispisati neparne brojeve od 1 do 10
		for (int j = 1; j <= 10; j++) {
			if (j % 2 == 0) {
				continue;
				// break;
			}
			System.out.println("Number " + j + " is odd.");
		}
		
	}

}
