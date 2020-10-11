package poker;

import java.util.Arrays;

public class Player {

	Card hand[] = new Card[5];
	public int points=0;


	public Player(String a, String b, String c, String d, String e) {
		super();
		hand[0]=new Card(a);
		hand[1]=new Card(b);
		hand[2]=new Card(c);
		hand[3]=new Card(d);
		hand[4]=new Card(e);
		Arrays.sort(hand);
		eval_play_cards();
	}

	public String toString() {
		String temp = "";
		for (Card h:hand)
			temp+=h.toString() + " ";
		return temp;
	}

	public void eval_play_cards()
	{
		points= 0;
		if (this.royalFlush() == 1)
		{
			points+=1000;
		}
		else if (this.straightFlush() == 1)
		{
			points+=900;
		}
		else if (this.fourOfaKind() == 1)
		{
			points+=800;
		}
		else if (this.fullHouse() == 1)
		{
			points+=700;
		}
		else if (this.flush() == 1)
		{
			points+=600;
		}
		else if (this.straight() == 1)
		{
			points+=500;
		}
		else if (this.triple() == 1)
		{
			points+=400;
		}
		else if (this.twoPairs() == 1)
		{
			points+=300;
		}
		else if (this.pair() == 1)
		{
			points+=200;
		}
		else
		{
			int highCard = this.highCard();
			points+=highCard;
		}
	}

	public int royalFlush()
	{
		if (hand[0].cardrank == 14 && hand[1].cardrank == 10 && hand[2].cardrank == 11 &&
				hand[3].cardrank == 12 && hand[4].cardrank == 13)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	public int straightFlush()
	{
		for (int counter = 1; counter < 5; counter++)
			if (hand[0].suit != hand[counter].suit)
				return 0;

		for (int counter1 = 1; counter1 < 5; counter1++)
			if (hand[counter1 - 1].cardrank != (hand[counter1].cardrank + 1))
				return 0;

		return 1;

	}

	public int fourOfaKind()
	{
		Card temp;
		if (hand[0].cardrank != hand[3].cardrank && hand[1].cardrank != hand[4].cardrank)
			return 0;
		if (hand[0].cardrank != hand[1].cardrank && hand[0].cardrank != hand[2].cardrank)
		{
			temp = hand[0];
			hand[0] = hand[4];
			hand[4] = temp;
		}
		return 1;
	}

	public int fullHouse()
	{
		Card temp;
		int comparison = 0;
		for (int counter = 1; counter < 5; counter++)
			if (hand[counter - 1].cardrank == hand[counter].cardrank)
				comparison++;

		if (comparison == 3) {
			if (hand[0].cardrank != hand[1].cardrank || hand[0].cardrank != hand[2].cardrank)
			{
				temp = hand[0];
				hand[0] = hand[4];
				hand[4] = temp;
				temp = hand[1];
				hand[1] = hand[3];
				hand[3] = temp;
			}
			return 1;

		}


		return 0;

	}

	public int flush()
	{
		for (int counter = 1; counter < 5; counter++)
			if (hand[0].suit != hand[counter].suit)
				return 0;

		return 1;
	}

	public int straight()
	{
		for (int counter2 = 1; counter2 < 5; counter2++)
			if (hand[counter2 - 1].cardrank != (hand[counter2].cardrank + 1))
				return 0;

		return 1;
	}

	public int triple()
	{
		Card temp;
		if (hand[0].cardrank == hand[2].cardrank || hand[2].cardrank == hand[4].cardrank
				|| hand[1].cardrank == hand[3].cardrank) {
			if (hand[2].cardrank == hand[4].cardrank) {
				temp = hand[0];
				hand[0] = hand[3];
				hand[3] = temp;
				temp = hand[1];
				hand[1] = hand[4];
				hand[4] = temp;
			}
			return 1;
		}
		return 0;
	}

	public int twoPairs()
	{
		Card temp;
		int check = 0;
		for(int counter = 1; counter < 5; counter++)
			if (hand[counter - 1].cardrank == hand[counter].cardrank)
				check++;

		if (check == 2) {
			int counter = 4;
			if(hand[2].cardrank != hand[3].cardrank)
				counter = 2;
			if(hand[0].cardrank != hand[1].cardrank)
				counter = 0;

			temp = hand[counter];

			for (int j=counter;j<4;j++) {
				hand[j] = hand[j+1];
			}
			hand[4]=temp;
			return 1;
		}

		return 0;

	}

	public int pair()
	{
		Card temp,temp1;
		int check = 0,counter;
		for(counter = 1; counter < 5; counter++)
			if (hand[counter - 1].cardrank == hand[counter].cardrank) {
				temp = hand[counter - 1];
				temp1 = hand[counter];
				for (int j=counter;j>1;j--) {
					hand[j] = hand[j-2];
				}
				hand[0]=temp;
				hand[1]=temp1;
				check++;
			}



		if (check == 1)
			return 1;

		return 0;
	}


	public int highCard()
	{
		int highCard = 0;
		for (int counter = 0; counter < 5; counter++)
			if (hand[counter].cardrank > highCard)
				highCard = hand[counter].cardrank;

		return highCard;
	}

	boolean greaterThan(Player a) {

		if (points == a.points) 
			for (int i=0;i<5;i++) {
				if (hand[i].compareTo(a.hand[i]) == -1)
					return true;
				else if (hand[i].compareTo(a.hand[i]) == 1)
					return false;
			}
		else if (points > a.points)
			return true;

		return false;
	}
}
