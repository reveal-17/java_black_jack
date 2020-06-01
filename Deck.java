public class Deck {
    // フィールド
    static int[] deck;
    static int numberOfCards = 52;
    // メソッド
    public static void initDeck() {
        Deck.deck = new int[52];
        for (int i = 0; i < 52; i++) {
            Deck.deck[i] = i;
        }
    }
}
