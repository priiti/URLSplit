package com.priitparl.service;

import com.priitparl.model.URLDataModel;

public interface URLSplitter {

    URLDataModel splitURL(String inputURL) throws Exception;

}
