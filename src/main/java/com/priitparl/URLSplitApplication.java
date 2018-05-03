package com.priitparl;

import com.priitparl.model.URLDataModel;
import com.priitparl.service.URLRegexSplit;
import com.priitparl.service.URLSplitter;
import com.priitparl.service.URLStateMachineSplit;

public class URLSplitApplication {

    private static final int ITERATION_COUNT = 10000;

    public static void main(String[] args) throws Exception {
        try {
            String inputUrlString = args[0];

            URLSplitter urlRegexSplitter = new URLRegexSplit();
            URLSplitter urlStateMachineSplitter = new URLStateMachineSplit();

            URLDataModel urlDataModelRegex = null;
            URLDataModel urlDataModelStateMachine = null;

            long start = System.currentTimeMillis();
            for (int i = 0; i < ITERATION_COUNT; i++)
                urlDataModelRegex = urlRegexSplitter.splitURL(inputUrlString);
            long regexEnd = System.currentTimeMillis() - start;

            start = System.currentTimeMillis();
            for (int i = 0; i < ITERATION_COUNT; i++)
                urlDataModelStateMachine = urlStateMachineSplitter.splitURL(inputUrlString);
            long stateMachineEnd = System.currentTimeMillis() - start;

            System.out.println("Regex:");
            System.out.println(urlDataModelRegex.toString());
            System.out.println("State machine:");
            System.out.println(urlDataModelStateMachine.toString());
            System.out.println(String.format("Regex: %dmsec", regexEnd));
            System.out.println(String.format("State: %dmsec", stateMachineEnd));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
