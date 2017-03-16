package com.biglog.ticket;

import com.biglog.ticket.core.segmentation.JiebaSegmenter;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by ngw on 2017/3/6.
 */
public class SegmentationTest extends TestCase{

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testSegmentation(){

        JiebaSegmenter jiebaSegmenter = new JiebaSegmenter();

        String s = "运营商工单质检系统";

        System.out.println(jiebaSegmenter.process(s, JiebaSegmenter.SegMode.SEARCH).toString());

    }
}
