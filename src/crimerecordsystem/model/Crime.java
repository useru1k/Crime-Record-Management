package crimerecordsystem.model;

import java.sql.Date;

public class Crime {
    private int crimeId;
    private Date crimeDate;
    private String description;
    private String details;
    private int stationId;
    private String status;

    public Crime(int crimeId, Date crimeDate, String description, String details, int stationId, String status) {
        this.crimeId = crimeId;
        this.crimeDate = crimeDate;
        this.description = description;
        this.details = details;
        this.stationId = stationId;
        this.status = status;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public Date getCrimeDate() {
        return crimeDate;
    }

    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public int getStationId() {
        return stationId;
    }

    public String getStatus() {
        return status;
    }
}
