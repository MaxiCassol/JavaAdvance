package TeamPerformance;

import java.util.ArrayList;
import java.util.List;

class TeamMember2 {
    private String name;
    private int qualityOfWork;
    private int productivity;
    private int communication;
    private int hoursPerWeek;
    private boolean hasChildren;
    private int yearsWorking;
    private int age;

    public TeamMember2(String name, int qualityOfWork, int productivity, int communication, int hoursPerWeek, boolean hasChildren, int yearsWorking, int age) {
        this.name = name;
        this.qualityOfWork = qualityOfWork;
        this.productivity = productivity;
        this.communication = communication;
        this.hoursPerWeek = hoursPerWeek;
        this.hasChildren = hasChildren;
        this.yearsWorking = yearsWorking;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getQualityOfWork() {
        return qualityOfWork;
    }

    public int getProductivity() {
        return productivity;
    }

    public int getCommunication() {
        return communication;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public boolean hasChildren() {
        return hasChildren;
    }

    public int getYearsWorking() {
        return yearsWorking;
    }

    public int getAge() {
        return age;
    }
    public boolean isEligibleForBonus() {
        int averagePerformance = (qualityOfWork + productivity + communication) / 3;
        return averagePerformance >= 8 && hoursPerWeek > 30 && hasChildren;
    }

    public int calculateBonusAmount() {
        if (isEligibleForBonus()) {
            return (yearsWorking * 1000) + ((age / 2) * 500);
        }
        return 0;
    }

    public boolean getBonus() {
        return isEligibleForBonus();
    }

    public int getBonusAmount() {
        return calculateBonusAmount();
    }
}

public class TeamPerformanceManager2 {

    public static List<TeamMember> parseJsonData(String jsonData) {
        List<TeamMember> team = new ArrayList<>();

        // ReSplit JSON into each member
        String data = jsonData.split("\"team_performance\":\\[")[1].replace("]", ""); // Remove closing bracket
        String[] membersData = data.split("\\},"); // Split by member separation

        for (String memberData : membersData) {
            String name = extractValue(memberData, "\"name\": \"", "\",");
            int qualityOfWork = Integer.parseInt(extractValue(memberData, "\"quality_of_work\": ", ","));
            int productivity = Integer.parseInt(extractValue(memberData, "\"productivity\": ", ","));
            int communication = Integer.parseInt(extractValue(memberData, "\"communication\": ", ","));
            int hoursPerWeek = Integer.parseInt(extractValue(memberData, "\"hours_per_week\": ", ","));
            boolean hasChildren = Boolean.parseBoolean(extractValue(memberData, "\"has_children\": ", ","));
            int yearsWorking = Integer.parseInt(extractValue(memberData, "\"years_working\": ", ","));
            int age = Integer.parseInt(extractValue(memberData, "\"age\": ", "}"));

            team.add(new TeamMember(name, qualityOfWork, productivity, communication, hoursPerWeek, hasChildren, yearsWorking, age));
        }

        return team;
    }

    public static String extractValue(String data, String startTag, String endTag) {
        int startIndex = data.indexOf(startTag) + startTag.length();
        int endIndex = data.indexOf(endTag, startIndex);
        return data.substring(startIndex, endIndex);
    }

    public static List<TeamMember> calculateBonus(List<TeamMember> team) {
        List<TeamMember> bonusEligibleMembers = new ArrayList<>();
        for (TeamMember member : team) {
            if (member.isEligibleForBonus()) {
                // Bonus-eligible members count
                totalBonusEligibleMembers++;
                // Total bonus amount
                totalBonusAmount += member.calculateBonusAmount();
                // Update member with biggest bonus
                if (member.getBonusAmount() > biggestBonus) {
                    biggestBonus = member.getBonusAmount();
                    memberWithBiggestBonus = member;
                }
                // Bonus-eligible member
                bonusEligibleMembers.add(member);
            }
        }
        return bonusEligibleMembers;
    }

    public static void main(String[] args) {
        // JSON String format
        String jsonData = "{\"team_performance\": [{\"name\": \"Maxi Miliano\",\"role\": \"Software Engineer\",\"years_working\": 5,\"age\": 30,\"has_children\": false,\"academic_titles\": [\"Bachelor's in Computer Science\", \"Master's in Software Engineering\"],\"performance_data\": {\"quality_of_work\": 9,\"productivity\": 8,\"communication\": 7},\"hours_per_week\": 40}]}";

        // Parse JSON data and create TeamMember objects
        List<TeamMember> team = parseJsonData(jsonData);

        // Bonus for team members
        List<TeamMember> bonusEligibleMembers = calculateBonus(team);

        // Average bonus amount
        double averageBonusAmount = totalBonusAmount / (double) totalBonusEligibleMembers;

        // Print out totals and average
        System.out.println("Total team members: " + team.size());
        System.out.println("Total bonus-eligible members: " + totalBonusEligibleMembers);
        System.out.println("Average bonus amount: " + averageBonusAmount);

        // Print out data of member with the biggest bonus
        if (memberWithBiggestBonus != null) {
            System.out.println("Member with biggest bonus:");
            System.out.println("Name: " + memberWithBiggestBonus.getName());
            System.out.println("Bonus: " + memberWithBiggestBonus.getBonus());
            System.out.println("BonusAmount: " + memberWithBiggestBonus.getBonusAmount());
        } else {
            System.out.println("No member eligible for bonus.");
        }

        // Print out details
        for (TeamMember member : bonusEligibleMembers) {
            System.out.println("Name: " + member.getName());
            System.out.println("Bonus: " + member.getBonus());
            System.out.println("BonusAmount: " + member.getBonusAmount());
            System.out.println();
        }
    }

    // Variables to bonus-eligible members, bonus amount, and biggest bonus
    private static int totalBonusEligibleMembers = 0;
    private static int totalBonusAmount = 0;
    private static int biggestBonus = 0;
    private static TeamMember memberWithBiggestBonus = null;
}

