package com.liuwill.data;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * Created by Liu Will - liuwill@live.com on 2018/4/22.
 * Copyright (c) 2012-2017 All Rights Reserved.
 *
 * @author: liuwill@live.com liuwill
 * @date 2018/4/22
 * @desc
 */
public class SaleVolumeParser extends BaseRichBolt {
    private OutputCollector collector;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple input) {
        SaleOrder saleOrder = SaleOrder.buildSaleOrder(input.getString(0));
        collector.emit(new Values(saleOrder.getTimestamp(), saleOrder.getOrderId(), saleOrder.getSkuId(), saleOrder.getUsername()));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("timestamp", "sku_id", "order_id", "username"));
    }
}
