package crimerecordsystem.view;

public class UserView {
    public static void showLoginMenu() {
        System.out.println("\nCrime Record System");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
    }

    public static void showAdminMenu() {
        System.out.println("\nAdmin Menu");
        System.out.println("1. Add Police Station");
        System.out.println("2. Add Crime");
        System.out.println("3. Update Crime");
        System.out.println("4. Delete Crime");
        System.out.println("5. Add Criminal");
        System.out.println("6. Add Victim");
        System.out.println("7. Link Criminal to Crime");
        System.out.println("8. Link Victim to Crime");
        System.out.println("9. View All Crimes");
        System.out.println("10. Logout");
        System.out.print("Enter choice: ");
    }

    public static void showOfficerMenu() {
        System.out.println("\nOfficer Menu");
        System.out.println("1. Add Crime");
        System.out.println("2. Update Crime");
        System.out.println("3. Add Criminal");
        System.out.println("4. Add Victim");
        System.out.println("5. View All Crimes");
        System.out.println("6. Logout");
        System.out.print("Enter choice: ");
    }
}
