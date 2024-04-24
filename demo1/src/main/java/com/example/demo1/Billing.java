package com.example.demo1;

class Billing {
    private static int billingId =0;
    private Patient patient;
    private double totalAmount;

    public Billing(Patient patient, double totalAmount) {
        billingId++;
        this.patient = patient;
        this.totalAmount = totalAmount;
    }

    public int getBillingId() {
        return billingId;
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
        this.totalAmount = totalAmount;
    }


    @Override
    public String toString() {
        return "Billing{" +
                "patient=" + patient +
                ", totalAmount=" + totalAmount +
                '}';
    }
}