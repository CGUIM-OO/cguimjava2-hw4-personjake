import java.util.ArrayList;

public class Player {
	private String name;

	private int chips;
	private int bet;
	private ArrayList<Card> oneRoundCard = new ArrayList<Card>();
	//this.name為上面的變數 改為加入的參數name (chips亦如此)
	public Player(String name, int chips) {
		this.name = name;
		this.chips = chips;
	}
	//回傳name
	public String getName() {
		return name;
	}
	//先設原本bet為1 如果 現有的籌碼小於押注籌碼 則全下，若籌碼沒了，則不會押注，其他則照籌碼多少押多少
	public int makeBet() {
		bet=1;
		if (chips < bet)
			return chips;
		else if(chips == 0)
			return 0;
		else {
			
			return bet;
		}
	}

	//ArrayList oneRoundCard 設為進來的 ArrayList cards
	public void setOneRoundCard(ArrayList<Card> cards) {

		oneRoundCard = cards;

	}
   //利用到getTotalValue的方法，如果牌小於16則回傳true繼續hitMe要牌，其餘回傳false不要牌
	public boolean hitMe() {
		
		if (getTotalValue() < 16) {
			return true;
		}
	
		return false;

	}
	
//total為總合，初始化為0，利用enhanced forloop 將oneRoundCard 依依讀出來，在每次讀出來時total加上該牌的rank值(JQK為10)，並最後回傳total
	public int getTotalValue() {
		int total = 0;
		for (Card a : oneRoundCard) {
			if(a.getRank()>10)
			{total +=10;}
			else{
			total += a.getRank();}
		}
		
		return total;
	}
//回傳chips
	public int getCurrentChips() {
		return chips;
	}
//籌碼加上贏得的加注(diff正數為贏，負數為輸)	
	public void increaseChips(int diff) {
		chips += diff;
	}
//印出玩家名稱和籌碼多少。
	public void sayHello() {
		getName();
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}
}
