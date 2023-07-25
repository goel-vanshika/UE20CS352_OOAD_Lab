import java.util.Scanner;

public class LeaveManagementSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter employee name: ");
            String empName = sc.nextLine();

            System.out.print("Enter employee role: ");
            String role = sc.nextLine();

            System.out.print("Enter leave type (CL, SL, VL): ");
            String type = sc.nextLine();

            System.out.print("Enter request date (yyyy-dd-mm): ");
            String requestDate = sc.nextLine();

            System.out.print("Enter start date (yyyy-dd-mm): ");
            String startDate = sc.nextLine();

            System.out.print("Enter end date (yyyy-dd-mm): ");
            String endDate = sc.nextLine();
            
            Employee employee = new Employee(empName, role);
            Leave leave = LeaveFactory.createLeave(type, requestDate, startDate, endDate);

            // Set up chain of responsibility
            TechLead techLead = new TechLead();
            ProjectManager projectManager = new ProjectManager();
            Director director = new Director();
            techLead.setSuccessor(projectManager);
            projectManager.setSuccessor(director);

            // Process leave
            techLead.processLeave(leave);

            // Display request and approval details
            System.out.println("Leave status: " + leave.getLeaveStatus());
            System.out.println("Approved by: " + leave.getApprovedBy());
            System.out.println("Request date: " + leave.getRequestDate());
            System.out.println("Start date: " + startDate);
            System.out.println("End date: " + endDate);
            System.out.println("Approval date: " + leave.getApprovalDate());
        }
    }
}
