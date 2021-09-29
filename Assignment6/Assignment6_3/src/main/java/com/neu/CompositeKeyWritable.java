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
import org.apache.hadoop.io.WritableComparable;


/**
 *
 * @author urvashijain
 */
public class CompositeKeyWritable implements WritableComparable<CompositeKeyWritable>{
    
    private String stockVolume;
    private String stockPriceAdjClose;

    public String getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(String stockVolume) {
        this.stockVolume = stockVolume;
    }

    public String getStockPriceAdjClose() {
        return stockPriceAdjClose;
    }

    public void setStockPriceAdjClose(String stockPriceAdjClose) {
        this.stockPriceAdjClose = stockPriceAdjClose;
    }

    public CompositeKeyWritable(String stockVolume, String stockPriceAdjClose) {
        this.stockVolume = stockVolume;
        this.stockPriceAdjClose = stockPriceAdjClose;
    }

    @Override
    public void write(DataOutput d) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(CompositeKeyWritable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
