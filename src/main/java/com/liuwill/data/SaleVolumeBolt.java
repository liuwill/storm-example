package com.liuwill.data;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Liu Will - liuwill@live.com on 2018/4/22.
 * Copyright (c) 2012-2017 All Rights Reserved.
 *
 * @author: liuwill@live.com liuwill
 * @date 2018/4/22
 * @desc
 */
public class SaleVolumeBolt extends BaseBasicBolt {
    private static final HashMap<Integer, HashSet<Long>> timestamps = new HashMap<Integer, HashSet<Long>>();

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

    private void addTimestamp (int skuId, long timestamp) {
        HashSet<Long> orderTimestamp = timestamps.get(skuId);
        if (orderTimestamp == null) {
            orderTimestamp = new HashSet<Long>();
            timestamps.put(skuId, orderTimestamp);
        }
        orderTimestamp.add(timestamp);
    }
}
