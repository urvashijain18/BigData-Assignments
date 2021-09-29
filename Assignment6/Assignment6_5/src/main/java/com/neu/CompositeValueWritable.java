/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

/**
 *
 * @author urvashijain
 */
public class CompositeValueWritable implements Writable{
    
    private Double stockPriceAdjCose = new Double(0);
    private long count = 1;

    public CompositeValueWritable() { 
    }
    
    public CompositeValueWritable(Double stockPriceAdjCose, long count) {
        this.stockPriceAdjCose = stockPriceAdjCose;
        this.count = count;
        
    }
    
    public Double getStockPriceAdjCose() {
        return stockPriceAdjCose;
    }

    public void setStockPriceAdjCose(Double stockPriceAdjCose) {
        this.stockPriceAdjCose = stockPriceAdjCose;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(String.valueOf(stockPriceAdjCose));
        out.writeUTF(String.valueOf(count));
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        stockPriceAdjCose = Double.parseDouble(in.readUTF());
        count = Integer.parseInt(in.readUTF());
    }

}
