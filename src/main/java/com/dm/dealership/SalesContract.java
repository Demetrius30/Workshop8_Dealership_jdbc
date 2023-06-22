package com.dm.dealership;

public class SalesContract {
    private int dealershipId;
    private int vinNum;
    private int price;
    private boolean sold;

    public SalesContract() {
    }

    public SalesContract(int dealershipId, int vinNum, int price, boolean sold) {
        this.dealershipId = dealershipId;
        this.vinNum = vinNum;
        this.price = price;
        this.sold = sold;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public int getVinNum() {
        return vinNum;
    }

    public void setVinNum(int vinNum) {
        this.vinNum = vinNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "dealershipId=" + dealershipId +
                ", vinNum=" + vinNum +
                ", price=" + price +
                ", sold=" + sold +
                '}';
    }
}
