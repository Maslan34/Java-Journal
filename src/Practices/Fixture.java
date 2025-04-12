package Practices;

import java.util.*;

public class Fixture {

    private ArrayList<String> clubs;


    public Fixture(ArrayList<String> clubs) {
        this.clubs = clubs;
        if(clubs.size() % 2 != 0){
            this.clubs.add("PASS");
        }
    }

    public List<LinkedHashMap<String, String>> fixture() {
        List<LinkedHashMap<String, String>> fixture = new ArrayList<>();


        Collections.shuffle(clubs);
        List<String> rotation = new ArrayList<>(clubs);

        int numTeams = rotation.size();
        int matchesPerRound = numTeams / 2;

        String fixedTeam = rotation.remove(0);


        for (int round = 0; round < numTeams - 1; round++) {
            LinkedHashMap<String, String> week = new LinkedHashMap<>();
            week.put(fixedTeam, rotation.get(0));

            for (int i = 1; i < matchesPerRound; i++) {
                String home = rotation.get(i);
                String away = rotation.get(rotation.size() - i);
                week.put(home, away);
            }
            fixture.add(week);
            rotation.add(0, rotation.remove(rotation.size() - 1));
        }

        return fixture;
    }

    public void printFixture(List<LinkedHashMap<String, String>> allRounds) {
        int week = 1;

        System.out.println("\n== First Half ==");
        for (LinkedHashMap<String, String> round : allRounds) {
            System.out.println("\nWeek " + week + ":");
            for (Map.Entry<String, String> entry : round.entrySet()) {
                System.out.println(entry.getKey() + " vs " + entry.getValue());
            }
            week++;
        }

        System.out.println("\n== Second Half ==");
        for (LinkedHashMap<String, String> round : allRounds) {
            System.out.println("\nWeek " + week + ":");
            for (Map.Entry<String, String> entry : round.entrySet()) {
                System.out.println(entry.getValue() + " vs " + entry.getKey());
            }
            week++;
        }
    }


    public static void main(String[] args) {
        int clubCount;
        ArrayList<String> clubs = new ArrayList<>();
        System.out.println("Plese Enter the Number Of Clubs!  Min(2)");
        Scanner sc = new Scanner(System.in);
        clubCount = sc.nextInt();
        sc.nextLine();
        while(clubCount < 2) {
            System.out.println("Wrong Input Please Try Again");
            clubCount = sc.nextInt();
        }

        for(int i = 0; i < clubCount; i++) {
            System.out.println("Please Enter the "+(i+1)+". Club");
            clubs.add(sc.nextLine());
        }

        Fixture fixtureMaker = new Fixture(clubs);
        List<LinkedHashMap<String, String>> fixture = fixtureMaker.fixture();
        fixtureMaker.printFixture(fixture);
    }
}
