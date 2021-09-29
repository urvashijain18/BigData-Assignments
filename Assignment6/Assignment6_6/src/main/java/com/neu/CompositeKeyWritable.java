/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

/**
 *
 * @author urvashijain
 */
public class CompositeKeyWritable implements WritableComparable<CompositeKeyWritable> {
    private String ipAddress;
    private String website;
    private String accessDate;

    public CompositeKeyWritable() {
    }

    public CompositeKeyWritable(String ipAddress, String website, String accessDate) {
        this.ipAddress = ipAddress;
        this.website = website;
        this.accessDate = accessDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeUTF(ipAddress);
        d.writeUTF(website);
        d.writeUTF(accessDate);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        ipAddress = in.readUTF();
        website = in.readUTF();
        accessDate = in.readUTF();
    }

    @Override
    public int compareTo(CompositeKeyWritable o) {
        int result = this.getAccessDate().compareTo(o.getAccessDate());
        return (result < 0 ? -1 : (result == 0 ? 0 : 1));
    }
}
