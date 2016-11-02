package net.hubs1.com.collection.properties;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import org.apache.log4j.Logger;

/**
 * @Description 文件读写
 * @author weqinjia.liu
 * @Date 2016年9月28日
 */
public class PropertyUtils {
    private static final Logger logger=Logger.getLogger(PropertyUtils.class);
    
    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        String path = PropertyUtils.class.getResource("/").getPath();
        System.out.println(path);
        InputStream ins = PropertyUtils.class.getClassLoader().getResourceAsStream("channelPartner_cn.properties");
        
        String file="";
        RandomAccessFile raf=new RandomAccessFile(file, "rw");
    
    }
    
}
