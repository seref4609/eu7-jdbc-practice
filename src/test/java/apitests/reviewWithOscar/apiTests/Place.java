
package apitests.reviewWithOscar.apiTests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Place {

    @SerializedName("place name")
    @Expose
    private String placeName;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("state abbreviation")
    @Expose
    private String stateAbbreviation;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Place() {
    }

    /**
     * 
     * @param stateAbbreviation
     * @param latitude
     * @param state
     * @param placeName
     * @param longitude
     */
    public Place(String placeName, String longitude, String state, String stateAbbreviation, String latitude) {
        super();
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}
