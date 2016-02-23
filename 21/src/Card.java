
public class Card {
	private CardSuites cardSuite;
	private CardValues cardVal;
	private boolean visible = false;
	private CardView view = new CardView();
	
	Card(CardSuites cardSuite, CardValues cardVal)
	{
		this.cardSuite = cardSuite;
		this.cardVal = cardVal;
	}
	
	Card(CardSuites cardSuite, CardValues cardVal, boolean visible)
	{
		this(cardSuite, cardVal);
		this.visible = visible;
	}
	
	public void drawByLine(int line) {
		if (visible)
		{
			view.drawByLine(cardSuite, cardVal, line);
		}
		else
		{
			view.drawBackByLine(line);
		}
	}
	
	public void drawScoresByLine(int line) {
		if (visible)
		{
			view.drawScoresByLine(cardVal, line);
		}
		else
		{
			view.drawScoresBackByLine(line);
		}
	}	

	public void draw() {
		if (visible)
		{
			view.draw(cardSuite, cardVal);
		}
		else
		{
			view.drawBack();
		}
	}
	
	public void drawEndLine() {
		view.drawEndLine();
	}	
	
	public boolean equals(Card aThat) {
		//check for self-comparison
		if ( this == aThat ) return true;
		//use instanceof instead of getClass here for two reasons
	    //1. if need be, it can match any supertype, and not just one class;
	    //2. it renders an explict check for "that == null" redundant, since
	    //it does the check for null already - "null instanceof [type]" always
	    //returns false. (See Effective Java by Joshua Bloch.)		
		if ( !(aThat instanceof Card) ) return false;
		//Alternative to the above line :
	    //if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

	    //cast to native object is now safe		
		Card that = (Card)aThat;
		
		//now a proper field-by-field evaluation can be made
		
		return that.getCardSuite() == cardSuite && that.getCardVal() == cardVal;
	}
	
	public CardSuites getCardSuite() {
		return cardSuite;
	}

	public CardValues getCardVal() {
		return cardVal;
	}
	
	public boolean isVisible() {
		return visible;
	}	

	public void setVisible(boolean visible) {
		this.visible = visible;
	}	
}
