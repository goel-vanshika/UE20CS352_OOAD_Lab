
public class CLLeave extends Leave {
    private String reason;

    public CLLeave(String requestDate) {
        super("New", requestDate);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}