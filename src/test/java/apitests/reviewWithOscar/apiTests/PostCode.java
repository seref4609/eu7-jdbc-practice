
package apitests.reviewWithOscar.apiTests;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PostCode {

    @SerializedName("post code")
    @Expose
    private String postCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country abbreviation")
    @Expose
    private String countryAbbreviation;
    @SerializedName("places")
    @Expose
    private List<Place> places = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PostCode() {
    }

    /**
     * 
     * @param country
     * @param places
     * @param countryAbbreviation
     * @param postCode
     */
    public PostCode(String postCode, String country, String countryAbbreviation, List<Place> places) {
        super();
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.places = places;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}
