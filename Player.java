import java.util.Scanner;
public class Player extends Paticipant {
    public void recieveCard() {
        System.out.println("あなたが引いたカードは" + this.getRank() + "の" + this.getNumber() + "です。");
    }
    public void playersSum() {
        System.out.println("あなたの現在の得点は" + this.getCalcArrayNum() + "です。");
    }
    public void submitChoice() {
        System.out.println("カードを引きますか？引く場合はYを、引かない場合はNを入力してください。");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        scan.close();
        while (choice == "N") {
            this.drawCard();
            this.recieveCard();
            this.playersSum();
            if (this.getCalcArrayNum() > 21) {
                this.youLose();
                break;
            }
            continue;
        }
    }
}
