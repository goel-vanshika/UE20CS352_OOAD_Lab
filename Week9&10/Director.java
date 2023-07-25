
public class Director implements LeaveProcessor {
    @Override
    public void processLeave(Leave leave) {
        if (leave instanceof VLLeave) {
            System.out.println("Director processed VLLeave");
            leave.setApprovedBy("Director");
            leave.setLeaveStatus("Approved");
        }
    }
}