public class Document {
    private String documentID;
    private String employeeName;
    private String documentType;
    private String description;
    private String status;
    private String rejectionReason;

    public Document(String documentID, String employeeName, 
                    String documentType, String description) {
        this.documentID = documentID;
        this.employeeName = employeeName;
        this.documentType = documentType;
        this.description = description;
        this.status = "Pending";
        this.rejectionReason = "";
    }

    public String getDocumentID() {
        return documentID;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getDocumentType() {
        return documentType;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public String getRejectionReason() {
        return rejectionReason;
    }
    public void approve() {
        status = "Approved";
    }
    public void reject(String reason) {
        status = "Rejected";
        rejectionReason = reason;
    }


    public void displayDocument() {
        System.out.println("----------------------");
        System.out.println("Document ID: " + documentID);
        System.out.println("Employee: " + employeeName);
        System.out.println("Type: " + documentType);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);

        if(status.equals("Rejected")) {
            System.out.println("Reason: " + rejectionReason);
        }
        System.out.println("----------------------");
    }
}