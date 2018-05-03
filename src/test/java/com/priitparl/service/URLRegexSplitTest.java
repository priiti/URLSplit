package com.priitparl.service;

import com.priitparl.model.URLDataModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by priitparl on 03/05/2018.
 */
public class URLRegexSplitTest {


    private URLSplitter urlSplitter;

    @Before
    public void setup() {
        urlSplitter = new URLRegexSplit();
    }

    @Test
    public void testURLSplitReturnHttp() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com:8090/path?params");
        assertEquals("https", urlDataModel.getScheme());
    }

    @Test
    public void testURLSplitReturnHost() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com:8090/path?params");
        assertEquals("website.com", urlDataModel.getHost());
    }

    @Test
    public void testURLSplitReturnPort() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com:3000/path?params");
        assertEquals("3000", urlDataModel.getPort());
    }

    @Test
    public void testURLSplitReturnPortNull() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com/path?params");
        assertEquals(null, urlDataModel.getPort());
    }

    @Test
    public void testURLSplitReturnPath() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com/store/product?params");
        assertEquals("/store/product", urlDataModel.getPath());
    }

    @Test
    public void testURLSplitReturnParams() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com/store/product?jacket-leather");
        assertEquals("jacket-leather", urlDataModel.getParams());
    }

    @Test
    public void testURLSplitReturnParamsNull() throws Exception {
        URLDataModel urlDataModel = urlSplitter.splitURL("https://website.com/store/product");
        assertEquals(null, urlDataModel.getParams());
    }

}