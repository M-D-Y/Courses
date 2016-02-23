public class Playground {
	public final static int USER_PC = 0;
	public final static int USER_HUMAN = 1;
	
	Card [][] playground = new Card[18][2];

	public void newGame() {
		clearPlayground();
		addCards(USER_PC);	
		addCards(USER_HUMAN);
	}
	
	private void clearPlayground()
	{
		for (int i=0; i<18; i++) {
			playground[i][USER_PC]=null;
			playground[i][USER_HUMAN]=null;
		}
	}
	
	private void addCards(int userId) {
		for (int i=0; i<18; i++)
		{
			playground[i][userId] = getRandomUniqueCard();
		}
	}
	
	private Card getRandomUniqueCard() 
	{
		Card ret;
		while(true)
		{
			CardSuites randCardSuite = CardSuite.getRandomCardSuite();
			CardValues randCardVal = CardValue.getRandomCardValue();
			Card randCard = new Card(randCardSuite, randCardVal);
			if ( !isCardAlreadyOnThePlayground(randCard) )
			{
				ret = randCard;
				break;
			}
		}
		return ret;
	}
	
	private boolean isCardAlreadyOnThePlayground(Card randCard)
	{
		boolean ret = false;
		for (int i=0; i<18; i++)
		{
			for (int j=0; j<2; j++)
			{
				if (playground[i][j]!=null && playground[i][j].equals(randCard))
				{
					ret = true;
					break;
				}
			}
		}
		return ret;
	}
	
	public void drawCards(int count, int userId)
	{
		for (int j=0; j<CardView.CARD_LINE_COUNT; j++)
		{
			for (int i=0; i<count; i++) 
			{
				playground[i][userId].drawByLine(j);
			}
			playground[0][userId].drawEndLine();			
		}
	}
	
	public void drawScores(int count, int userId)
	{
		for (int j=0; j<CardView.SCORES_LINE_COUNT; j++)
		{
			for (int i=0; i<count; i++) 
			{
				playground[i][userId].drawScoresByLine(j);
			}
			playground[0][userId].drawEndLine();			
		}
	}	
	
	public void showNextCard(int userId)
	{
		for (int i=0; i<18; i++)
		{
			if (!playground[i][userId].isVisible())
			{
				playground[i][userId].setVisible(true);
				break;
			}
		}
	}

	public void showScore(int userId) {
		for (int i=0; i<18; i++)
		{
			if (playground[i][userId].isVisible())
			{
				if (i!=0) System.out.print(" + ");
				System.out.print( CardValue.getScoreByCardValue( playground[i][userId].getCardVal() ) );
			}
			else 
			{
				break;
			}
		}
		if (playground[1][userId].isVisible()) System.out.print(" = "+calculateScore(userId));
		System.out.println("");
		
	}	
	
	
	public int calculateScore(int userId) {
		int score=0;
		for (int i=0; i<18; i++)
		{
			if (playground[i][userId].isVisible())
			{
				score += CardValue.getScoreByCardValue( playground[i][userId].getCardVal() );
			}
			else 
			{
				break;
			}
		}
		return score;
	}

	public void clear() {
		for (int i=0; i<80; i++) 
		{
			System.out.println("");						
		}
	}
	
	public void clear2() {
		String sym;
		for (int i=0; i<40; i++) 
		{
			for (int j=0; j<40; j++)
			{
				sym = CardSuite.getCardSuiteSymbol( CardSuite.getCardSuiteByNumber( (int) (Math.random()*4+1) ) );
				System.out.print(sym+" ");
			}
			System.out.println("");						
			try { Thread.sleep(15); } catch (InterruptedException e) {}
		}
		System.out.println("──────────────────────────────────────────────────");
	}
	
	public int getVisibleCardsCount(int userId) {
		int ret=0;
		for (int i=0; i<18; i++)
		{
			if (playground[i][userId].isVisible())
			{
				ret++;
			} 
			else 
			{
				break;
			}
		}
		return ret;
	}
	
}
