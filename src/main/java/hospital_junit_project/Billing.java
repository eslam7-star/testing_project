package hospital_junit_project;

class Billing {
    private static int billings_count =0;
    private int billing_id;
    private Patient patient;
    private double totalAmount;

    public Billing(Patient patient, double totalAmount) {
        billings_count++;
        billing_id =billings_count;
        this.patient = patient;
        this.totalAmount = totalAmount;
    }

    public int getBillingId() {
        return billing_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
     if (totalAmount>=0)
    	this.totalAmount = totalAmount;
     else 
    	 System.out.println("Enter valid total amount ");
    }

    public static int getBillings_count() {
        return billings_count;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "patient=" + patient +
                ", totalAmount=" + totalAmount +
                '}';
    }
}