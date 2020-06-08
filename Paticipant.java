import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public abstract class Paticipant {
    // フィールド
    private String rank;
    private String number;
    private List<Integer> arrayNum = new ArrayList<>();
    private int calcArrayNum;

    // ゲッターセッター
    public String getRank() {
        return this.rank;
    }
    public String getNumber() {
        return this.number;
    }
    public List<Integer> getArrayNum() {
        return this.arrayNum;
    }
    public int getCalcArrayNum() {
        return this.calcArrayNum;
    }

    // メソッド
    public void calcCard() {
        List<Integer> arrayNum = getArrayNum();
        // 合計点を0にして再び計算する
        this.calcArrayNum = 0;
        for (int data : arrayNum) {
            this.calcArrayNum += data;
        }
    }

    public void drawCard() {
        Random r = new Random();
        int cardIndex = r.nextInt(Deck.numberOfCards);
        // 役を決める
        switch (Deck.deck[cardIndex] / 13) {
            case 0:
                this.rank = "スペード";
                break;
            case 1:
                this.rank = "クラブ";
                break;
            case 2:
                this.rank = "ハート";
                break;
            case 3:
                this.rank = "ダイヤ";
                break;
        }
        // 数を決める
        this.number = String.valueOf(Deck.deck[cardIndex] % 13 + 1);
        // A, J, Q, Kに対応
        switch(this.number) {
            case "1":
                this.number = "A";
            case "11":
                this.number = "J";
            case "12":
                this.number = "Q";
            case "13":
                this.number = "K";
        }
        // 引いたカードをデックから消去
        List<Integer> arrayDeck = new ArrayList<>();
        for (int i = 0; i < Deck.deck.length; i++) {
            arrayDeck.add(Deck.deck[i]);
        }
        arrayDeck.remove(cardIndex);
        int[] intDeck = new int[arrayDeck.size()];
        for (int i = 0; i < arrayDeck.size(); i++) {
            intDeck[i] = arrayDeck.get(i);
        }
        Deck.deck = intDeck;
        // 引いたカードの分だけnumberOfCards（枚数）から除く
        Deck.numberOfCards --;
        // 引いた数字をintに変換
        switch (this.number) {
            case "A":
                this.number = "1";
                break;
            case "J":
            case "Q":
            case "K":
                this.number = "10";
                break;
        }
        int drawNum = Integer.parseInt(this.number);
        // 引いた数字をListに格納
        this.arrayNum.add(drawNum);
    }

    public void youLose() {
        System.out.println("あなたの負けです。");
        System.out.println("ゲーム終了。");
    }
    public void youWin() {
        System.out.println("あなたの勝ちです。");
        System.out.println("ゲーム終了。");
    }

    public void drawGame() {
        System.out.println("引き分けです。");
        System.out.println("ゲーム終了。");
    }

    public abstract void recieveCard();
}
