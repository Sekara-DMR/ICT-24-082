import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int readInt(String prompt) {

        while (true) {
            System.out.print(prompt);

            try {
                int value = sc.nextInt();
                sc.nextLine(); 
                return value;

            } catch (Exception e) {
                System.out.println("  Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        DAMS system = new DAMS();

        while (true) {
            System.out.println("\n===== DAMS =====");
            System.out.println("1. Employee");
            System.out.println("2. Manager");
            System.out.println("3. Exit");
            int user = readInt("Choose User Type: ");

            // Employee
            if (user == 1) {
                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.println("\n1. Submit Document");
                System.out.println("2. View My Documents");

                int choice = readInt("Choice: ");

                if (choice == 1) {
                    System.out.println("\nSelect Document Type");
                    System.out.println("1.  Leave Request");
                    System.out.println("2.  Short Leave Pass");
                    System.out.println("3.  Purchase Request");
                    System.out.println("4.  Event Proposal");
                    System.out.println("5.  Expense Reimbursement Request");
                    System.out.println("6.  Maintenance Request");
                    System.out.println("7.  Budget Request");
                    System.out.println("8.  Attendance Correction Request");
                    System.out.println("9.  Equipment Request");
                    System.out.println("10. Complaint Report");

                    // taking the valid number in 1-10
                    int type;
                    while (true) {
                        type = readInt("Select (1-10): ");

                        if (type >= 1 && type <= 10) {
                            break; 
                        }
                        System.out.println("  Invalid choice. Please enter a number between 1 and 10.");
                    }
                    String documentType;

                    switch (type) {
                        case 1:  documentType = "Leave Request"; break;
                        case 2:  documentType = "Short Leave Pass"; break;
                        case 3:  documentType = "Purchase Request"; break;
                        case 4:  documentType = "Event Proposal"; break;
                        case 5:  documentType = "Expense Reimbursement Request"; break;
                        case 6:  documentType = "Maintenance Request"; break;
                        case 7:  documentType = "Budget Request"; break;
                        case 8:  documentType = "Attendance Correction Request"; break;
                        case 9:  documentType = "Equipment Request"; break;
                        default: documentType = "Complaint Report"; break; 
                    }


                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    system.submitDocument(name, documentType, desc);
                }

                else if (choice == 2) {
                    system.viewEmployeeDocuments(name);
                }

                else {
                    System.out.println("  Invalid choice. Please select 1 or 2.");
                }
            }

            // Manager
            else if (user == 2) {
                System.out.println("\n--- Manager Menu ---");
                System.out.println("1. View Pending Documents");
                System.out.println("2. Process Next Document");
                System.out.println("3. View Approval History");
                int choice = readInt("Choice: ");

                if (choice == 1) {
                    system.viewPendingDocuments();
                }

                else if (choice == 2) {
                    Document next = system.peekNextDocument();

                    if (next == null) {
                        System.out.println("No pending documents in the queue.");

                    } else {
                        System.out.println("\nProceed to Next Document :");
                        next.displayDocument();

                        System.out.println("1. Approve");
                        System.out.println("2. Reject");

                        int action;
                        while (true) {
                            action = readInt("Action: ");

                            if (action == 1 || action == 2) {
                                break;
                            }
                            System.out.println("  Invalid choice. Please enter 1 (Approve) or 2 (Reject).");
                        }
                        String reason = "";
                        if (action == 2) {
                            System.out.print("Enter rejection reason: ");
                            reason = sc.nextLine();
                        }
                        system.processNextDocument(action, reason);
                    }
                }
                else if (choice == 3) {
                    system.viewHistory();

                }
                else {
                    System.out.println("  Invalid choice. Please select 1, 2, or 3.");
                }
            }


            // Exit
            else if (user == 3) {
                System.out.println("System Closed");
                break;
            }
            else {
                System.out.println("  Invalid option. Please choose 1, 2, or 3.");
            }
        }
        sc.close();
    }
}