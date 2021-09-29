/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 *
 * @author urvashijain
 */
public class NaturalKeyPartitioner extends Partitioner<CompositeKeyWritable, IntWritable>{
    
    @Override
    public int getPartition(CompositeKeyWritable key, IntWritable value, int noOfPartitions) {
        return key.getStockPriceAdjClose().hashCode() % noOfPartitions;
    }
    
//    @Override
//    public int getPartition(CompositeKeyWritable key, IntWritable value, int noOfPartitions) {
//        return key.getStockVolume().hashCode() % noOfPartitions;
//    }
}
