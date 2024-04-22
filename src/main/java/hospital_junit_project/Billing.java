package hospital_junit_project;

class Billing {
    private int billingId;
    private Patient patient;
    private double totalAmount;
    private String paymentStatus;

    public Billing(int billingId, Patient patient, double totalAmount, String paymentStatus) {
        this.billingId = billingId;
        this.patient = patient;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }
    
    
}