package com.cg.api.apkafkagw.model;

public class OrderMeta {

    private long orderId;
    private String tableNo;

    public OrderMeta() {
    }

    public OrderMeta(long orderId, String tableNo) {
        this.orderId = orderId;
        this.tableNo = tableNo;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    @Override
    public String toString() {
        return "OrderMeta{" +
                "orderId=" + orderId +
                ", tableNo='" + tableNo + '\'' +
                '}';
    }
}
