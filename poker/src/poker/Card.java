package poker;

public class Card implements Comparable<Card>{

	public String values;
	public int suit;
	public int cardrank;
	public Card(String val) {
		super();
		this.suit = en_suit(val);
		this.cardrank = en_cardrank(val);
		values = val;
	}
	
	
	int en_suit(String val) {
		if (val.charAt(1) == 'D')
			return 0;
		else if (val.charAt(1) == 'H')
			return 1;
		else if (val.charAt(1) == 'S')
			return 2;
		else if (val.charAt(1) == 'C')
			return 3;
		
		return 10;
	}
	
	int en_cardrank(String val) {
		if (val.charAt(0) == '2')
			return 2;
		else if (val.charAt(0) == '3')
			return 3;
		else if (val.charAt(0) == '4')
			return 4;
		else if (val.charAt(0) == '5')
			return 5;
		else if (val.charAt(0) == '6')
			return 6;
		else if (val.charAt(0) == '7')
			return 7;
		else if (val.charAt(0) == '8')
			return 8;
		else if (val.charAt(0) == '9')
			return 9;
		else if (val.charAt(0) == 'T')
			return 10;
		else if (val.charAt(0) == 'J')
			return 11;
		else if (val.charAt(0) == 'Q')
			return 12;
		else if (val.charAt(0) == 'K')
			return 13;
		else if (val.charAt(0) == 'A')
			return 14;

		return 0;
	}
	
	public String toString() {
		return values;
		
	}
	
	@Override
	public int compareTo(Card o) 
	{
	     if (this.cardrank == (o.cardrank))
	            return 0;
	     else if ((this.cardrank) < (o.cardrank))
	            return 1;
	     else
	           return -1;
	}
}
