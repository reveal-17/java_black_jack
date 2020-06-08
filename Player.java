import java.util.Scanner;
public class Player extends Paticipant {
    // フィールド
    private String choice;

    // ゲッターセッター
    public String getChoice() {
        return this.choice;
    }

    // メソッド
    public void recieveCard() {
        System.out.println("あなたが引いたカードは" + this.getRank() + "の" + this.getNumber() + "です。");
    }

    public void playersSum() {
        System.out.println("あなたの現在の得点は" + this.getCalcArrayNum() + "です。");
    }

    public void submitChoice() {
        int all = 0;
        while (all == 0) {
            try {
                System.out.println("カードを引きますか？引く場合はYを、引かない場合はNを入力してください。");
                Scanner scan = new Scanner(System.in);
                switch (scan.next()) {
                    case "Y":
                        // Nと入力されるまで以下を行う
                        this.drawCard();
                        // 引いたカードの合計得点を計算
                        this.calcCard();
                        // 引いたカードを表示
                        this.recieveCard();
                        // 合計得点を表示
                        this.playersSum();
                        if (this.getCalcArrayNum() > 21) {
                            this.youLose();
                            all++;
                        }
                        break;
                    case "N":
                        all++;
                        break;
                }
            } catch (Exception e) {

            }
        }
    }
}
