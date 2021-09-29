/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.part2;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author urvashijain
 */
public class MapperClass extends Mapper<LongWritable, Text, Text, IntWritable>{
    IntWritable maxPrice = new IntWritable();
    Text stockName = new Text();
    
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] arr = line.split(",");
        int max = 0;
        for(String val : arr){
            if(Integer.parseInt(val)>max){
                max = Integer.parseInt(val);
            }
        }
        maxPrice.set(max);
        stockName.set(arr[0].concat(arr[6]));
        context.write(stockName, maxPrice);
    }
}
