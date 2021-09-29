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
public class MapperClass extends Mapper<LongWritable, Text, IntWritable, CompositeKeyWritable>{
    private IntWritable date = new IntWritable();
    
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    
        String line = value.toString();
        String[] tokens = line.split(",");

        String stockPriceAdjClose = null;
        String stockVolume = null;
        String dateKey = null;
        
        try {
            if (tokens.length == 9) {
                stockVolume = tokens[7];
                stockPriceAdjClose = tokens[8];
                dateKey = tokens[2];
            } else{
                stockVolume = "0";
                stockPriceAdjClose = "0";
                dateKey = "0";
            }
        } catch (Exception ex) {
            //Do Nothing
        }
        
        CompositeKeyWritable obj = new CompositeKeyWritable(stockVolume, stockPriceAdjClose);
        context.write(date, obj);
    }
}
