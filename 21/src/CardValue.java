
public class CardValue {

	public static String getCardValue(CardValues cardVal) 
	{
		String ret;
		switch(cardVal)
		{
			case SIX: 	ret = "6"; break;
			case SEVEN: ret = "7"; break;
			case EIGHT: ret = "8"; break;
			case NINE: ret = "9"; break;
			case TEN: ret = "10"; break;
			case JACK: ret = "J"; break; 
			case QUEEN: ret = "Q"; break;
			case KING: ret = "K"; break;
			case ACE: ret = "A"; break;
			default: ret = " ";
		}
		return ret;
	}
	
	public static CardValues getRandomCardValue()
	{
		int rCardVal = (int) (1 + Math.random()*9);

		return getCardValueByNumber( rCardVal );
	}
	
	public static CardValues getCardValueByNumber(int number) 
	{
		CardValues randCardVal = CardValues.SIX;
		
		switch(number)
		{
			case 1: randCardVal = CardValues.SIX; break;
			case 2: randCardVal = CardValues.SEVEN; break;
			case 3: randCardVal = CardValues.EIGHT; break;
			case 4: randCardVal = CardValues.NINE; break;
			case 5: randCardVal = CardValues.TEN; break;
			case 6: randCardVal = CardValues.JACK; break;
			case 7: randCardVal = CardValues.QUEEN; break;
			case 8: randCardVal = CardValues.KING; break;
			case 9: randCardVal = CardValues.ACE; break;
		}
		
		return randCardVal;
	}
	
	public static int getScoreByCardValue(CardValues cardVal) 
	{
		int score = 0;
		
		switch(cardVal)
		{
			case SIX: score = 6; break;
			case SEVEN: score = 7; break;
			case EIGHT: score = 8; break;
			case NINE: score = 9; break;
			case TEN: score = 10; break;
			case JACK: score = 2; break;
			case QUEEN: score = 3; break;
			case KING: score = 4; break;
			case ACE: score = 11; break;
		}
		
		return score;
	}	
}
