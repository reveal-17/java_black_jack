public class Dealer extends Paticipant {
    // メソッド
    public void recieveCard() {
        System.out.println("ディーラーが引いたカードは" + this.getRank() + "の" + this.getNumber() + "です。");
        System.out.println("ディーラーの２枚目のカードはわかりません。");
    }
    public void addCard() {
        while (this.getCalcArrayNum() < 16) {
            this.drawCard();
            this.calcCard();
            System.out.println("ディーラーが引いたカードは" + this.getRank() + "の" + this.getNumber() + "です。");
            this.dealersSum();
        }
        if (this.getCalcArrayNum() > 21) {
            this.youWin();
        }
    }
    public void dealersSum() {
        System.out.println("ディーラーの得点は" + this.getCalcArrayNum() + "です。");
    }
    public void deployCard() {
        // ディーラーのカード展開
        System.out.println("ディーラーの2枚目のカードは" + this.getRank() + "の" + this.getNumber() + "でした。");
    }
}
