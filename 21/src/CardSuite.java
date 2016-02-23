public class CardSuite {

	public static String getCardSuiteSymbol(CardSuites cardSuite) {
		String ret;
		
		switch(cardSuite)
		{
		/*  Draw card with utf-8 blocks symbols
		 *  I have some problems to out in windows console
		 *   		
			case SPADES: ret = "♠"; break;
			case CLUBS:	ret = "♣"; break;
			case HEARTS: ret = "♥"; break;
			case DIAMONDS: ret = "♦"; break;
		*/
			case SPADES: ret = "@"; break;
			case CLUBS:	ret = "#"; break;
			case HEARTS: ret = "$"; break;
			case DIAMONDS: ret = "%"; break;		
			default: ret=" ";
		}
		
		return ret;
	}
	
	public static CardSuites getRandomCardSuite()
	{
		int rCardSuite = (int) (1 + Math.random()*4);
		
		return getCardSuiteByNumber( rCardSuite );
	}
	
	public static CardSuites getCardSuiteByNumber(int number)
	{
		CardSuites randCardSuite = CardSuites.SPADES;
		
		switch(number)
		{
			case 1: randCardSuite = CardSuites.SPADES; break;
			case 2: randCardSuite = CardSuites.CLUBS; break;
			case 3: randCardSuite = CardSuites.HEARTS; break;
			case 4: randCardSuite = CardSuites.DIAMONDS; break;
		}
		
		return randCardSuite;		
	}	
	
}
