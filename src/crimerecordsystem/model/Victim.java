package crimerecordsystem.model;

public class Victim {
    private int victimId;
    private String victimName;
    private int age;
    private String gender;
    private String address;

    public Victim(int victimId, String victimName, int age, String gender, String address) {
        this.victimId = victimId;
        this.victimName = victimName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public int getVictimId() {
        return victimId;
    }

    public String getVictimName() {
        return victimName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}
