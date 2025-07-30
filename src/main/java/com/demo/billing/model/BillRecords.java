package com.demo.billing.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "billrecords")
public class BillRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;


    @Temporal(TemporalType.DATE)
    @Column(name = "billDate", insertable = false, updatable = false)
    private LocalDate billDate;

    private double billAmount;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    public BillRecords(){
    }


    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId){
        this.billId = billId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }
    public double getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(double billAmount){
        this.billAmount = billAmount;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }


}
