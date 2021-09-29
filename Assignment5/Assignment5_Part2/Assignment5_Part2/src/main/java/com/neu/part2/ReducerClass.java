/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.part2;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author urvashijain
 */
public class ReducerClass extends Reducer<Text, IntWritable, Text, IntWritable>{
    IntWritable intWritableMax = new IntWritable();
    
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
       int max = 0;
       for(IntWritable val : values){
           if(val.get() > max){
               max = val.get();
           }
       }
       intWritableMax.set(max);
       context.write(key, intWritableMax);
    }
}
