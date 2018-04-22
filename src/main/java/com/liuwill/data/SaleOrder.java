package com.liuwill.data;

import java.util.Date;

/**
 * Created by Liu Will - liuwill@live.com on 2018/4/22.
 * Copyright (c) 2012-2017 All Rights Reserved.
 *
 * @author: liuwill@live.com liuwill
 * @date 2018/4/22
 * @desc
 */
public class SaleOrder {
    private String username;
    private String skuId;
    private String orderId;
    private String timestamp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public static SaleOrder buildSaleOrder(String tuple) {
        SaleOrder saleOrder = new SaleOrder();
        String[] tupleData = tuple.split(" ");

        saleOrder.setTimestamp(tupleData[0]);
        saleOrder.setOrderId(tupleData[0]);
        saleOrder.setSkuId(tupleData[0]);
        saleOrder.setUsername(tupleData[0]);
        return saleOrder;
    }
}
