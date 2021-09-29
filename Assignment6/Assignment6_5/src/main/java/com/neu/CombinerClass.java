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
public class CombinerClass extends Reducer<IntWritable, CompositeValueWritable, IntWritable, CompositeValueWritable>{
    IntWritable result = new IntWritable();
    Text text = new Text();
    
    @Override
    protected void reduce(IntWritable key, Iterable<CompositeValueWritable> values, Context context) throws IOException, InterruptedException {
        
        double localStockPriceAdjClose = 0;
        int localCount = 0;
        double avg = 0;
        
        for(CompositeValueWritable val : values){
            localStockPriceAdjClose += val.getStockPriceAdjCose();
            localCount += val.getCount();
        }
        
        avg = localStockPriceAdjClose/localCount;
        
        CompositeValueWritable compositeKeyWritable = new CompositeValueWritable(localStockPriceAdjClose, localCount);
        context.write(key, compositeKeyWritable);
    }
}
