
public class TechLead implements LeaveProcessor {
    private LeaveProcessor successor;

    @Override
    public void processLeave(Leave leave) {
        if (leave instanceof SLLeave) {
            System.out.println("TechLead processed SLLeave");
            leave.setApprovedBy("TechLead");
            leave.setLeaveStatus("Approved");
        } else {
            successor.processLeave(leave);
        }
    }

    public void setSuccessor(LeaveProcessor successor) {
        this.successor = successor;
    }
}