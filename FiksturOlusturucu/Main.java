package FiksturOlusturucu;

public class Main {
    public static void main(String[] args) {
        LeagueFixture t = new LeagueFixture();
        t.buildLeague();
        t.printFixture();
    }
}