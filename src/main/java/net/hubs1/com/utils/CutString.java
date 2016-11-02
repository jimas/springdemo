package net.hubs1.com.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutString {
     /** 
     * 判断是否是一个中文汉字 
     *  
     * @param c 
     *            字符 
     * @return true表示是中文汉字，false表示是英文字母 
     * @throws UnsupportedEncodingException 
     *             使用了JAVA不支持的编码格式 
     */ 
    public static boolean isChineseChar(char str){
        boolean temp = false;
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
        Matcher m=p.matcher(str+""); 
        if(m.find()){ 
            temp =  true;
        }
        return temp;
    }
 
    /** 
     * 按字节截取字符串 
     *  
     * @param orignal 
     *            原始字符串 
     * @param count 
     *            截取位数 
     * @return 截取后的字符串 
     * @throws UnsupportedEncodingException 
     *             使用了JAVA不支持的编码格式 
     */ 
    public static String substring(String orignal, int count,String charsetName)  
            throws UnsupportedEncodingException {  
        // 原始字符不为null，也不是空字符串  
        if (orignal != null && !"".equals(orignal)) {  
            orignal = new String(orignal.getBytes(), charsetName);//
            // 要截取的字节数大于0，且小于原始字符串的字节数  
            if (count > 0 && count < orignal.getBytes(charsetName).length) {  
                StringBuffer buff = new StringBuffer();  
                char c;  
                for (int i = 0; i < count; i++) {
                    c = orignal.charAt(i);  
                    if (CutString.isChineseChar(c)) {  
                        // 遇到中文汉字，已截取字节长度 + 该中文字节长度 > count 跳出 for 循环  
                        if((buff.toString().getBytes(charsetName).length+(c+"").getBytes(charsetName).length)>count){
                            break;
                        }
                    }  
                    buff.append(c);  
                }  
                return new String(buff.toString().getBytes(),charsetName);  
            }  
        }  
        return orignal;  
    }  
 
    
    /**  
     * 判断传进来的字符串，是否  
     * 大于指定的字节，如果大于递归调用
     * 直到小于指定字节数  
     * @param s  
     *            原始字符串  
     * @param num  
     *            传进来指定字节数  
     * @return String 截取后的字符串  
     */ 
    public static String idgui(String s,int num){
        int changdu = s.getBytes().length;
        if(changdu > num){
            s = s.substring(0, s.length() - 1);
            s = idgui(s,num);
        }
        return s;
    }
    
    public static void main(String[] args) throws Exception{  
        // 原始字符串  
        String s = "我ZWR爱你们JAVA";  
        System.out.println("原始字符串：" + s + " : 字节数是: " + s.getBytes().length);  

/*            System.out.println("截取前1位：" + CutString.substring(s, 1));  
            System.out.println("截取前2位：" + CutString.substring(s, 2));  
            System.out.println("截取前4位：" + CutString.substring(s, 4)); */ 
            //System.out.println("截取前12位：" + CutString.substring(s, 12));  
            System.out.println("截取前12字节：" + CutString.idgui(s, 11));  
            
            System.out.println("中文".getBytes().length);
            System.out.println("中文".getBytes("GBK").length);
       
    }   
}