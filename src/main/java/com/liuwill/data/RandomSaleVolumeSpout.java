package com.liuwill.data;

import org.apache.storm.shade.org.joda.time.DateTime;
import org.apache.storm.shade.org.joda.time.format.ISODateTimeFormat;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;

import org.apache.storm.shade.org.joda.time.format.DateTimeFormatter;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

/**
 * Created by Liu Will - liuwill@live.com on 2018/4/22.
 * Copyright (c) 2012-2017 All Rights Reserved.
 *
 * @author: liuwill@live.com liuwill
 * @date 2018/4/22
 * @desc
 */
public class RandomSaleVolumeSpout extends BaseRichSpout {
    private static final Random rand = new Random();
    private static final DateTimeFormatter isoFormat = ISODateTimeFormat.dateTimeNoMillis();

    private  SpoutOutputCollector collector;
    private int orderId = 10000;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void nextTuple() {
        Utils.sleep(rand.nextInt(100));
        ++orderId;

        String line = isoFormat.print(DateTime.now()) + " " + orderId + " " + rand.nextInt(10000) + " " + "dummyusername";
        collector.emit(new Values(line));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("line"));
    }
}
