/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author urvashijain
 */
public class ReducerClass extends Reducer<CompositeKeyWritable, IntWritable, Text, IntWritable>{
    IntWritable result = new IntWritable();
    Text text = new Text();
    
    @Override
    protected void reduce(CompositeKeyWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int maxVolDate = 0;
//        int minVolDate = 0;
//        int maxPrice = 0;
        
        for(IntWritable val : values){
            maxVolDate = val.get();
            break;
//            minVolDate = val.get();
//            break;
//            maxPrice = val.get();
//            break;
        }
        text.set(key.getStockPriceAdjClose() + "," + key.getStockVolume());
        result.set(maxVolDate);
//        result.set(minVolDate);
//        result.set(maxPrice);
        context.write(text, result);
    }
}
