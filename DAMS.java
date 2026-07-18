import java.util.*;


public class DAMS {


    // ArrayList:
    ArrayList<Document> documents = new ArrayList<>();

    // Queue: 
    Queue<Document> pendingDocuments = new LinkedList<>();

    // Stack:
    Stack<String> history = new Stack<>();

    int documentNumber = 1;

    public void submitDocument(String name, String type, String description) {

        String id = "D" + String.format("%03d", documentNumber++);
        Document doc = new Document(
                id,
                name,
                type,
                description
        );

        documents.add(doc);       
        pendingDocuments.add(doc); 

        System.out.println("\nDocument Submitted Successfully");
        System.out.println("Document ID: " + id);

    }


    public void viewEmployeeDocuments(String name) {
        boolean found = false;
        for (Document d : documents) {
            if (d.getEmployeeName().equalsIgnoreCase(name)) {
                d.displayDocument();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No documents found.");
        }
    }

    public void viewPendingDocuments() {
        if (pendingDocuments.isEmpty()) {
            System.out.println("No pending documents.");
            return;
        }

        System.out.println("\nPending Documents:");
        int position = 1;
        for (Document d : pendingDocuments) {
            System.out.println("\n[Queue Position: " + position++ + "]");
            d.displayDocument();
        }
    }

    public Document peekNextDocument() {
        return pendingDocuments.peek();
    }

    public void processNextDocument(int choice, String reason) {
        Document next = pendingDocuments.poll();

        if (next == null) {
            System.out.println("No pending documents to process.");
            return;
        }

        if (choice == 1) {
            next.approve();
            history.push(
                next.getDocumentID() + " | " + next.getDocumentType() +
                " (" + next.getEmployeeName() + ") | Approved"
            );

            System.out.println("\nDocument Approved Successfully.");
            System.out.println("Processed: " + next.getDocumentID() + " - " + next.getDocumentType());

        }
        else if (choice == 2) {
            next.reject(reason);
            history.push(
                next.getDocumentID() + " | " + next.getDocumentType() +
                " (" + next.getEmployeeName() + ") | Rejected: " + reason
            );

            System.out.println("\nDocument Rejected.");
            System.out.println("Processed: " + next.getDocumentID() + " - " + next.getDocumentType());

        }

    }

    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No history.");
            return;
        }

        System.out.println("\nApproval History:");
        Stack<String> temp = new Stack<>();
        temp.addAll(history);

        while (!temp.isEmpty()) {
            System.out.println("  " + temp.pop());
        }

    }


}