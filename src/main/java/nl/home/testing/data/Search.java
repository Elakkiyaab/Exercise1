package nl.home.testing.data;


public class Search {

    private String location=null;
    private String distance=null;;
    private String minPrice=null;;
    private String totPrice=null;;
    private String pageTitle=null;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(String totPrice) {
        this.totPrice = totPrice;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }


    public String getPageTitle() {
        return  pageTitle;
    }


}
