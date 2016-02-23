import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Playground pg = new Playground();
		
		Scanner sc = new Scanner(System.in);
		String cmd;

		pg.newGame();
		pg.showNextCard(Playground.USER_HUMAN);
		int pcCardsShow = 1;
		boolean pcTurnEnd = false;
		int userWinsCount = 0;
		int pcWinsCount = 0;
		do {
			
			pg.clear();	
			
			System.out.println("PC cards:");
			
			pg.drawCards(pcCardsShow, Playground.USER_PC);

			if (pcTurnEnd) {
				pg.drawScores( pcCardsShow, Playground.USER_PC);
				System.out.print("PC score: ");
				pg.showScore( Playground.USER_PC );
			}			
			
						

			System.out.println("Your cards:");
			
			int userVisibleCardsCount = pg.getVisibleCardsCount(Playground.USER_HUMAN); 
			
			pg.drawCards( userVisibleCardsCount, Playground.USER_HUMAN);
			pg.drawScores( userVisibleCardsCount, Playground.USER_HUMAN);
			
			System.out.print("Your score: ");
			pg.showScore( Playground.USER_HUMAN );

			hr();
			
			int userScores = pg.calculateScore(Playground.USER_HUMAN);
			int pcScores = pg.calculateScore(Playground.USER_PC);
			
			if (userScores<21 && !pcTurnEnd)
			{
				System.out.print("Your choice (n=new game; m=more cards; c=pc turn; q=quit): ");
			}
			else if(userScores==21 || (pcTurnEnd && (pcScores>21 || userScores>pcScores)))
			{
				userWinsCount++;
				System.out.println("Game over: Congratulations! You are WINNER!");
				System.out.println("Total score "+userWinsCount+":"+pcWinsCount);				
				hr();				
				System.out.print("Your choice (n=new game; q=quit): ");

			} 
			else if (pcTurnEnd && userScores==pcScores)
			{
				System.out.println("Game over: Draw!");
				System.out.println("Total score "+userWinsCount+":"+pcWinsCount);				
				hr();				
				System.out.print("Your choice (n=new game; q=quit): ");
			} else {
				pcWinsCount++;
				System.out.println("Game over: Unfortunately, you are LOSE!");
				System.out.println("Total score "+userWinsCount+":"+pcWinsCount);				
				hr();				
				System.out.print("Your choice (n=new game; q=quit): ");
			}
			
			cmd = sc.next();
			
			if (userScores<21 && !pcTurnEnd) {
				if (cmd.equals("M") || cmd.equals("m")) pg.showNextCard(Playground.USER_HUMAN);
				else if (cmd.equals("C") || cmd.equals("c") || cmd.equals(","))
				{
					do {
						int cardsCount = (int) (1+Math.random()*3);
						for (int i=0; i<=cardsCount; i++) 
						{
							pg.showNextCard(Playground.USER_PC);
							if (pg.calculateScore(Playground.USER_PC)>19) break;
						}
					} while (pg.calculateScore(Playground.USER_PC)<14);
					pcCardsShow = pg.getVisibleCardsCount(Playground.USER_PC);
					pcTurnEnd = true;
				}
			}
			
			if (cmd.equals("n") || cmd.equals("n")) 
			{
				pg.clear();		
				pg.newGame();
				pg.showNextCard(Playground.USER_HUMAN);
				pcCardsShow = 1;
				pcTurnEnd = false;
			}
			
		} while (!cmd.equals("q") && !cmd.equals("Q"));

		pg.clear();
		
		System.out.println("Thank you for playing!");
		
	}
	
	public static void hr() {
		/*  Draw card with utf-8 blocks symbols
		 *  I have some problems to out in windows console
		System.out.println("──────────────────────────────────────────────────");
		*/
		System.out.println("--------------------------------------------------");
	}

}
