package TeamPerformance;

import java.util.ArrayList;
import java.util.List;

class TeamMember {
    private String name;
    private int qualityOfWork;
    private int productivity;
    private int communication;
    private int hoursPerWeek;
    private boolean hasChildren;
    private int yearsWorking;
    private int age;

    public TeamMember(String name, int qualityOfWork, int productivity, int communication, int hoursPerWeek, boolean hasChildren, int yearsWorking, int age) {
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

public class TeamPerformanceManager {

    public static List<TeamMember> parseJsonData(String jsonData) {
        List<TeamMember> team = new ArrayList<>();

        // Remove curly braces and split JSON data into individual members
        String[] membersData = jsonData.split("\"team_performance\":\\[")[1].split("\\},\\{");

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
                bonusEligibleMembers.add(member);
            }
        }
        return bonusEligibleMembers;
    }

    public static void main(String[] args) {
        // Sample JSON data
        String jsonData = "{\"team_performance\": [{\"name\": \"Maxi Miliano\",\"role\": \"Software Engineer\",\"years_working\": 5,\"age\": 30,\"has_children\": false,\"academic_titles\": [\"Bachelor's in Computer Science\", \"Master's in Software Engineering\"],\"performance_data\": {\"quality_of_work\": 9,\"productivity\": 8,\"communication\": 7},\"hours_per_week\": 40},{\"name\": \"Bob Marley\",\"role\": \"Data Scientist\",\"years_working\": 7,\"age\": 32,\"has_children\": true,\"academic_titles\": [\"Ph.D. in Data Science\"],\"performance_data\": {\"quality_of_work\": 8,\"productivity\": 9,\"communication\": 8},\"hours_per_week\": 45},{\"name\": \"Charlie Garcia\",\"role\": \"Project Manager\",\"years_working\": 8,\"age\": 35,\"has_children\": true,\"academic_titles\": [\"Bachelor's in Business Administration\", \"PMP Certification\"],\"performance_data\": {\"quality_of_work\": 7,\"productivity\": 7,\"communication\": 9},\"hours_per_week\": 50},{\"name\": \"Tom Cruise\",\"role\": \"UX Designer\",\"years_working\": 4,\"age\": 28,\"has_children\": false,\"academic_titles\": [\"Bachelor's in Graphic Design\"],\"performance_data\": {\"quality_of_work\": 9,\"productivity\": 8,\"communication\": 8},\"hours_per_week\": 40}]}";

        // Parse JSON data and create TeamMember objects
        List<TeamMember> team = parseJsonData(jsonData);

        // Calculate bonus for each team member
        List<TeamMember> bonusEligibleMembers = calculateBonus(team);

        // Print bonus data
        for (TeamMember member : bonusEligibleMembers) {
            System.out.println("Name: " + member.getName());
            System.out.println("Bonus: " + member.getBonus());
            System.out.println("BonusAmount: " + member.getBonusAmount());
            System.out.println();
        }
    }
}