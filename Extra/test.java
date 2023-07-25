import java.util.*;

class Card
{
    public String suit;
    public String value;

    public Card(String suit, String value)
    {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getValue()
    {
        return value;
    }

    public String toString() 
    {
        return value + " of " + suit;
    }
}

class Pile
{
    public Stack<Card> cards;
    public Pile()
    {
        cards = new Stack<Card>();
    }

    public void pushCard(Card card) 
    {
        if (cards.size() < 10) 
        {
            cards.push(card);
        } 
        else 
        {
            System.out.println("The pile is already full.");
        }
    }

    public Card popCard() 
    {
        if (!cards.isEmpty()) 
        {
            return cards.pop();
        } 
        else 
        {
            System.out.println("The pile is empty.");
            return null;
        }
    }

    public Card peekCard() 
    {
        if (!cards.isEmpty()) 
        {
            return cards.peek();
        } 
        else 
        {
            System.out.println("The pile is empty.");
            return null;
        }    
    }
}

class test
{
    public static void main(String args[])
    {
        Pile pile = new Pile();
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of cards to add to pile: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.print("Mention Suit "+(i+1)+": ");
            String suit1 = sc.next();
            System.out.print("Mention Value "+(i+1)+": ");
            String value1 = sc.next();
            Card card = new Card(suit1, value1);
            pile.pushCard(card);
        }

        System.out.println("Cards in pile: ");
        for (Card card : pile.cards) 
        {
            System.out.println(card.toString());
        }
        do
        {
            System.out.print("Choose task: 1.Push 2.Peek 3.Pop : ");
            int task = sc.nextInt();
            if(task==1)
            {
                System.out.print("Mention Suit: ");
                String suit2 = sc.next();
                System.out.print("Mention Value: ");
                String value2 = sc.next();
                Card card2 = new Card(suit2, value2);
                pile.pushCard(card2);
            }
            else if(task==2)
            {
                System.out.println("Peeking at top card in pile:");
                Card topCard = pile.peekCard();
                System.out.println("Top card: " + topCard.toString());
            }
            else if(task==3)
            {
                System.out.println("Drawing a card from pile:");
                Card drawnCard = pile.popCard();
                System.out.println("Drawn card: " + drawnCard.toString());
            }
            else
            {
                System.out.println("Invalid Choice");
            }
        }
        while(true);
    }
}