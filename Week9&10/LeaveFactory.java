
public class LeaveFactory {
    public static Leave createLeave(String type, String requestDate, String startDate, String endDate) {
        switch (type) {
            case "CL":
                return new CLLeave(requestDate);
            case "SL":
                return new SLLeave(requestDate);
            case "VL":
                return new VLLeave(requestDate, startDate, endDate);
            default:
                return new InvalidLeave(requestDate);
        }
    }
}