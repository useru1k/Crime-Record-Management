package crimerecordsystem.model;

public class Criminal {
    private int criminalId;
    private String criminalName;
    private int age;
    private String gender;
    private String address;
    private int stationId;
    private String mark;

    public Criminal(int criminalId, String criminalName, int age, String gender, String address, int stationId, String mark) {
        this.criminalId = criminalId;
        this.criminalName = criminalName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.stationId = stationId;
        this.mark = mark;
    }

    public int getCriminalId() {
        return criminalId;
    }

    public String getCriminalName() {
        return criminalName;
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

    public int getStationId() {
        return stationId;
    }

    public String getMark() {
        return mark;
    }
}
