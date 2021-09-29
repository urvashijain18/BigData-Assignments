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
public class MapperClass extends Mapper<LongWritable, Text, CompositeKeyWritable, IntWritable>{
    IntWritable count = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] tokens = line.split(" ");

        String ipAddress = null;
        String website = null;
        String accessDate = null;
        try {
            if (tokens.length == 10) {
                ipAddress = tokens[0];
                website = tokens[5] + " " + tokens[6] + " " + tokens[7];
                accessDate = tokens[3] + tokens[4];
            } else{
                ipAddress = "0.0.0.0";
                website = "none";
                accessDate = "23/Jul/2013:14:33:00 -0400";
            }
        } catch (Exception ex) {
            //Do Nothing
        }

        CompositeKeyWritable obj = new CompositeKeyWritable(ipAddress, website, accessDate);
        context.write(obj, count);
    }       
}
