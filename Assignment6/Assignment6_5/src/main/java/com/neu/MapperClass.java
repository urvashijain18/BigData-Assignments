/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author urvashijain
 */
public class MapperClass extends Mapper<LongWritable, Text, IntWritable, CompositeValueWritable>{
    
    private IntWritable year = new IntWritable();
    
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    
        String line = value.toString();
        String[] tokens = line.split(",");

        String stockPriceAdjClose = null;
        int count = 1;
        String date = null;
        try {
            if (tokens.length == 9) {
                stockPriceAdjClose = tokens[8];
                date = tokens[2].split("-")[0];
            } else{
                stockPriceAdjClose = "0";
                date = "0";
            }
        } catch (Exception ex) {
            //Do Nothing
        }
        year.set(Integer.parseInt(date));
        CompositeValueWritable obj = new CompositeValueWritable(Double.parseDouble(stockPriceAdjClose), count);
        context.write(year, obj);
    }
}
