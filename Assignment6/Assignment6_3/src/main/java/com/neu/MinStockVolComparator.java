/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 *
 * @author urvashijain
 */
public class MinStockVolComparator extends WritableComparator{
    public MinStockVolComparator(){
        super(CompositeKeyWritable.class, true);
    }

    //minimum stock volume
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        CompositeKeyWritable ckw1 = (CompositeKeyWritable) a;
        CompositeKeyWritable ckw2 = (CompositeKeyWritable) b;

        int result = ckw1.getStockVolume().compareTo(ckw2.getStockVolume());
        return result;
    }
}
