package parkinglot.proj.domain;

public class Spot {
    private Integer spotId;
    private String spotType; // small, medium, large
    private boolean electricChargeAvailable;
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public String getSpotType() {
        return spotType;
    }

    public void setSpotType(String spotType) {
        this.spotType = spotType;
    }

    public boolean isElectricChargeAvailable() {
        return electricChargeAvailable;
    }

    public void setElectricChargeAvailable(boolean electricChargeAvailable) {
        this.electricChargeAvailable = electricChargeAvailable;
    }
}
