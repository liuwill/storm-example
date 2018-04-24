package com.liuwill.data;

import org.apache.storm.Config;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Liu Will - liuwill@live.com on 2018/4/23.
 * Copyright (c) 2012-2017 All Rights Reserved.
 *
 * @author: liuwill@live.com liuwill
 * @date 2018/4/23
 * @desc
 */
public class SaleVolumeBoltTest {
    private SaleVolumeBolt saleVolumeBolt;

    @Mock
    private TopologyContext topologyContext;

    @Mock
    private SaleOrder saleOrder;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);

        // The factory will return our mock `notifier`
        saleVolumeBolt = new SaleVolumeBolt();// new TestFactory(notifier)
        // Now the bolt is holding on to our mock and is under our control!
        saleVolumeBolt.prepare(new Config(), topologyContext);
    }

    @Test
    public void testExecute() {
        long userId = 24;
        Tuple tuple = mock(Tuple.class);
        when(tuple.getLongByField("12")).thenReturn(userId);// PreviousBolt.USER_ID_FIELD_NAME
        BasicOutputCollector collector = mock(BasicOutputCollector.class);

        saleVolumeBolt.execute(tuple, collector);

        // Here we just verify a call on `notifier`, but we could have stubbed out behavior befor
        //  the call to execute, too.
        // verify(saleOrder).notifyUser(userId);
        verify(collector).emit(new Values(userId));
    }
}
