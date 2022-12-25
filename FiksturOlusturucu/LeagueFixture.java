package FiksturOlusturucu;


import java.util.*;

public class LeagueFixture {

    Scanner input = new Scanner(System.in);
    private int teamCount;

    LinkedHashSet<String> teams = new LinkedHashSet<>();
    HashSet<String> allMatchs = new HashSet<>();
    ArrayList<String> fixture = new ArrayList<>();
    ArrayList<String> competitions = new ArrayList<>();


    public void buildLeague() {
        System.out.print("Enter The Number Of Teams: ");
        teamCount = input.nextInt();
        while (teamCount < 2) {
            System.out.print("Enter a Valid Team Number: ");
            teamCount = input.nextInt();
        }

        while (teams.size() < teamCount) {
            System.out.print("Enter a Team Name : ");
            String t = input.next();
            t = t.toUpperCase();
            teams.add(t);
        }
        if (teamCount % 2 != 0) {
            teams.add("BAY");
            teamCount++;
        }
    }

    public void setAllMatchs() {
        ArrayList<String> teamNames = new ArrayList<>(teams);
        for (int i = 0; i < teamCount; i++) {
            for (int j = 0; j < teamCount; j++) {
                if (i != j) {
                    allMatchs.add(teamNames.get(i) + " vs " + teamNames.get(j));
                }
            }
        }
    }


    public void printFixture() {
        int weekCount = (teamCount - 1) * 2;
        int matchPerWeek = teamCount / 2;
        setAllMatchs();
        competitions.addAll(allMatchs);
        ArrayList<String> playedGames = new ArrayList<>();
        for (int i = 0; i < weekCount; i++) {
            int matchCount = 0;
            ArrayList<String> fixtureForWeek = new ArrayList<>();
            System.out.println("---------------------------------");
            System.out.println("Week " + (i + 1) + ":");
            for (int j = 0; j < competitions.size(); j++) {
                if (!playedGames.contains(competitions.get(j))) {
                    if (matchCount != matchPerWeek) {
                        String matches = competitions.get(j);
                        String[] competitionTeams = matches.split(" ");
                        if (!fixtureForWeek.contains(competitionTeams[0])) {
                            if (!fixtureForWeek.contains(competitionTeams[2])) {
                                fixtureForWeek.add(competitionTeams[0]);
                                fixtureForWeek.add(competitionTeams[2]);
                                System.out.println(competitions.get(j));
                                playedGames.add(competitions.get(j));
                                matchCount++;
                            }
                        }
                    }
                }
            }
        }
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }
}



