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
        int sum = 0;
        for(IntWritable val : values){
            sum += val.get();
        }
        text.set(key.getIpAddress() + "::" + key.getWebsite() + "::" + key.getAccessDate());
        result.set(sum);
        context.write(text, result);
    }
}
