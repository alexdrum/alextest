package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * VMArgs：-verbose:gc -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author zhaojw
 */
public class HeapOOM {

    static class OOMObject {
        private String fuckYou = "fuckYou";

        public OOMObject(String fuckYouCount) {
            this.fuckYou = this.fuckYou + fuckYouCount;
        }

    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<OOMObject>();

        int i = 0;
        while (true){
            list.add(new OOMObject(String.valueOf(i)));
        }
    }
}
