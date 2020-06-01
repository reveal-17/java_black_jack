public class Main {
    public static void main(String[] args) {
        System.out.println("☆★☆★☆★☆★☆★ブラックジャックへようこそ！☆★☆★☆★☆★☆★");
        System.out.println("ゲームを開始します。");
        Player p = new Player();
        Dealer d = new Dealer();
        Deck.initDeck();
        // プレイヤーがカードを２枚受け取る
        p.drawCard();
        p.recieveCard();
        p.drawCard();
        p.recieveCard();
        // ディーラーがカードを2枚受け取る
        d.drawCard();
        d.recieveCard();
        d.drawCard();
        // プレイヤーの現在の得点
        p.calcCard();
        p.playersSum();
        // プレイヤーの選択
        p.submitChoice();
        if (p.getCalcArrayNum() < 21) {
            // ディーラーのカード展開
            d.deployCard();
            // ディーラーの現在の得点
            d.calcCard();
            d.dealersSum();
            // ディーラーの得点が17以上になるまでカードを引く
            d.addCard();
            // 勝敗
            if (p.getCalcArrayNum() > d.getCalcArrayNum()) {
                p.youWin();
            } else if (p.getCalcArrayNum() < d.getCalcArrayNum()) {
                p.youLose();
            } else {
                p.drawGame();
            }
        }
    }
}
