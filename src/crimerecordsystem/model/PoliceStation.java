package crimerecordsystem.model;

public class PoliceStation {
    private int stationId;
    private String stationName;

    public PoliceStation(int stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
    }

    public int getStationId() {
        return stationId;
    }

    public String getStationName() {
        return stationName;
    }
}
