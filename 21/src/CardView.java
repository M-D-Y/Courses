import java.io.PrintStream;
import java.io.UnsupportedEncodingException;


public class CardView {
	public static final int CARD_LINE_COUNT = 5;
	public static final int SCORES_LINE_COUNT = 3;
	
	
	PrintStream out;

	CardView() {
		setUTF8SystemOut();	
	}

	private void setUTF8SystemOut() {
		try {
			out = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(CardSuites cardSuite, CardValues cardVal) {
		for (int i=0; i<CARD_LINE_COUNT; i++) 
		{
			drawByLine(cardSuite, cardVal, i);
			drawEndLine();
		}
	}
	
	public void drawByLine(CardSuites cardSuite, CardValues cardVal, int line)
	{
		String css = CardSuite.getCardSuiteSymbol(cardSuite);
		String cvl = getCardVal(cardVal,+1);
		String cvr = getCardVal(cardVal,-1);
		switch (line)
		{
		/*  Draw card with utf-8 blocks symbols
		 *  I have some problems to out in windows console
		 *   
			case 0: out.print("┌─────┐ "); break;
			case 1: out.print("│"+cvl+"   │ "); break;
			case 2: out.print("│  "+css+"  │ "); break;
			case 3: out.print("│   "+cvr+"│ "); break;
			case 4: out.print("└─────┘ "); break;
		*/
		case 0: out.print("+-----+ "); break;
		case 1: out.print("|"+cvl+"   | "); break;
		case 2: out.print("|  "+css+"  | "); break;
		case 3: out.print("|   "+cvr+"| "); break;
		case 4: out.print("+-----+ "); break;		
		}
	}

	private String getCardVal(CardValues cardVal, int direction) 
	{
		String ret="";
		if (cardVal!=CardValues.TEN && direction>0) ret+=" ";
		ret += CardValue.getCardValue(cardVal);
		if (cardVal!=CardValues.TEN && direction<0) ret+=" ";
		return ret;
	}
	
	public void drawBack() {
		for (int i=0; i<CARD_LINE_COUNT; i++) 
		{
			drawBackByLine(i);
			drawEndLine();
		}
	}
	
	public void drawBackByLine(int line)
	{
		switch (line)
		{
		/*  Draw card with utf-8 blocks symbols
		 *  I have some problems to out in windows console
		 *  
			case 0: out.print("┌─────┐ "); break;
			case 1: out.print("│░░░░░│ "); break;
			case 2: out.print("│░░░░░│ "); break;
			case 3: out.print("│░░░░░│ "); break;
			case 4: out.print("└─────┘ "); break;
		*/
			case 0: out.print("+-----+ "); break;
			case 1: out.print("|*****| "); break;
			case 2: out.print("|*****| "); break;
			case 3: out.print("|*****| "); break;
			case 4: out.print("+-----+ "); break;		
		}
	}

	public void drawScores(CardValues cardVal) {
		for (int i=0; i<SCORES_LINE_COUNT; i++) 
		{
			drawScoresByLine(cardVal, i);
			drawEndLine();
		}
	}

	public void drawScoresByLine(CardValues cardVal, int line)
	{
		int score = CardValue.getScoreByCardValue(cardVal);
		String space="";
		if (score<10) space = " "; 
		switch (line)
		{
		/*  Draw card with utf-8 blocks symbols
		 *  I have some problems to out in windows console
		 *  
			case 0: out.print("┌─────┐ "); break;
			case 1: out.print("│ "+space+score+"  │ "); break;
			case 2: out.print("└─────┘ "); break;
		*/
			case 0: out.print("+-----+ "); break;
			case 1: out.print("| "+space+score+"  | "); break;
			case 2: out.print("+-----+ "); break;		
		}
	}

	public void drawScoresBack() {
		for (int i=0; i<SCORES_LINE_COUNT; i++) 
		{
			drawScoresBackByLine(i);
			drawEndLine();
		}
	}

	public void drawScoresBackByLine(int line)
	{
		switch (line)
		{
		/*  Draw card with utf-8 blocks symbols
		 *  I have some problems to out in windows console

			case 0: out.print("┌─────┐ "); break;
			case 1: out.print("│░░░░░│ "); break;
			case 2: out.print("└─────┘ "); break;
		 */
		case 0: out.print("+-----+ "); break;
		case 1: out.print("|░░░░░| "); break;
		case 2: out.print("+-----+ "); break;
		
		}
	}
	
	
	public void drawEndLine()
	{
		out.println("");
	}
	
	

}
