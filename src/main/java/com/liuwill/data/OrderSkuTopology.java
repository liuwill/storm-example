package com.liuwill.data;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * Created by Liu Will - liuwill@live.com on 2018/4/22.
 * Copyright (c) 2012-2017 All Rights Reserved.
 *
 * @author: liuwill@live.com liuwill
 * @date 2018/4/22
 * @desc
 */
public class OrderSkuTopology {
    public static void  main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("sku_spout", new RandomSaleVolumeSpout());
        builder.setBolt("order_parser", new SaleVolumeParser(), 4).shuffleGrouping("sku_spout");
        builder.setBolt("sku_recorder", new SaleVolumeBolt(), 4).fieldsGrouping("order_parser", new Fields("orderId"));

        LocalCluster cluster = new LocalCluster();
        Config conf = new Config();

        cluster.submitTopology("sku_sale_volume", conf, builder.createTopology());

        Thread.sleep(10000);
        cluster.shutdown();
    }
}
