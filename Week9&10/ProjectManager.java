
public class ProjectManager implements LeaveProcessor {
    private LeaveProcessor successor;

    @Override
    public void processLeave(Leave leave) {
        if (leave instanceof CLLeave) {
            System.out.println("ProjectManager processed CLLeave");
            leave.setApprovedBy("ProjectManager");
            leave.setLeaveStatus("Approved");
        } else {
            successor.processLeave(leave);
        }
    }

    public void setSuccessor(LeaveProcessor successor) {
        this.successor = successor;
    }
}