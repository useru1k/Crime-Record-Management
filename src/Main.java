package crimerecordsystem;

import crimerecordsystem.controller.*;
import crimerecordsystem.view.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        CrimeController crimeController = new CrimeController();
        CriminalController criminalController = new CriminalController();
        VictimController victimController = new VictimController();
        PoliceStationController stationController = new PoliceStationController();

        while (true) {
            UserView.showLoginMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String userName = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                crimerecordsystem.model.User user = userController.login(userName, password);
                if (user != null) {
                    System.out.println("Login successful! Role: " + user.getUserRole());
                    if (user.getUserRole().equals("admin")) {
                        adminMenu(scanner, crimeController, criminalController, victimController, stationController);
                    } else {
                        officerMenu(scanner, crimeController, criminalController, victimController);
                    }
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else if (choice == 2) {
                userController.register(scanner);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void adminMenu(Scanner scanner, CrimeController crimeController, CriminalController criminalController, 
                                 VictimController victimController, PoliceStationController stationController) {
        while (true) {
            UserView.showAdminMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter police station name: ");
                    String stationName = scanner.nextLine();
                    stationController.addPoliceStation(new crimerecordsystem.model.PoliceStation(0, stationName));
                    break;
                case 2:
                    crimeController.addCrime(scanner);
                    break;
                case 3:
                    crimeController.updateCrime(scanner);
                    break;
                case 4:
                    crimeController.deleteCrime(scanner);
                    break;
                case 5:
                    criminalController.addCriminal(scanner);
                    break;
                case 6:
                    victimController.addVictim(scanner);
                    break;
                case 7:
                    crimeController.linkCriminalToCrime(scanner);
                    break;
                case 8:
                    crimeController.linkVictimToCrime(scanner);
                    break;
                case 9:
                    crimeController.viewAllCrimes();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void officerMenu(Scanner scanner, CrimeController crimeController, 
                                   CriminalController criminalController, VictimController victimController) {
        while (true) {
            UserView.showOfficerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    crimeController.addCrime(scanner);
                    break;
                case 2:
                    crimeController.updateCrime(scanner);
                    break;
                case 3:
                    criminalController.addCriminal(scanner);
                    break;
                case 4:
                    victimController.addVictim(scanner);
                    break;
                case 5:
                    crimeController.viewAllCrimes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
