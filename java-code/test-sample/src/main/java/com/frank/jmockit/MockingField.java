package com.frank.jmockit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;

/**
 * this shows how to mock field of a object;
 */
public class MockingField {

    static class ToBeMockedClassA {
        private final Object obj = new Object();



    }


    @Test
    public void testMockFinalField() {
        new MockUp<ToBeMockedClassA>() {
            @Mock
            public void $init(Invocation inv) {
                ToBeMockedClassA client = inv.getInvokedInstance();
                Deencapsulation.setField(client, "obj", null);
            }
        };
        ToBeMockedClassA a = new ToBeMockedClassA();
        Assert.assertNull(a.obj);
    }


}
