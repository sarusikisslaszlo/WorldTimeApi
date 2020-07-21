package udemx.time_api.app.domain;

public class WorldTimeApi {

    private String datetime;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "The time is " + datetime;
    }
}
