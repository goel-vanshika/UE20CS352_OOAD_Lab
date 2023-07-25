
public class VLLeave extends Leave {
    private String startDate;
    private String endDate;

    public VLLeave(String requestDate, String startDate, String endDate) {
        super("New", requestDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}