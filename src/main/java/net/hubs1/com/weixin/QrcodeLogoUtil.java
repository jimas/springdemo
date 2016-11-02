package net.hubs1.com.weixin;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QrcodeLogoUtil {
	
	
	
    private static final String FORMAT_NAME = "PNG";  
    // 二维码尺寸  
    private static final int QRCODE_SIZE = 300;  
    // LOGO宽度  
    private static final int WIDTH = 60;  
    // LOGO高度  
    private static final int HEIGHT = 60;  
	/**
	 * @param content
	 * @param imgPath
	 * @param logo
	 * @return
	 */
	public static int createQRCode(String content, String imgPath,String logo) {  
	       try {  

	           Qrcode qrcodeHandler = new Qrcode();  
	           qrcodeHandler.setQrcodeErrorCorrect('M');  
	           qrcodeHandler.setQrcodeEncodeMode('B');  
	           qrcodeHandler.setQrcodeVersion(7);  

	           // System.out.println(content);  

	           byte[] contentBytes = content.getBytes("gb2312");  
	           //构造一个BufferedImage对象 设置宽、高
	           BufferedImage bufImg = new BufferedImage(QRCODE_SIZE, QRCODE_SIZE, BufferedImage.TYPE_INT_RGB);  
//	           BufferedImage bufImg = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);  
	           Graphics2D gs = bufImg.createGraphics();  
	           gs.setBackground(Color.WHITE);  
//	           gs.clearRect(0, 0, 140, 140);  
	           gs.clearRect(0, 0, QRCODE_SIZE, QRCODE_SIZE);  
	           // 设定图像颜色 > BLACK  
	           gs.setColor(Color.BLACK);  
	           // 设置偏移量 不设置可能导致解析出错  2
	           int pixoff = 2;  

	           // 输出内容 > 二维码  

	           /**
	            * fillRect（x,y,w,h）函数的作用是：填充一个矩形区域，x、y为起始坐标（即左上角坐标）,
	            * 
	            * 后面两个参数分别为：w、h,是矩形区域的宽和高,这里的20表示填充宽度20像素，15表示填充高度15像素。
	            */
	           System.out.println(contentBytes.length);
	           if (contentBytes.length > 0 && contentBytes.length < 120) {  
	               boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
	               int j2 = QRCODE_SIZE/contentBytes.length;
	               int realSize=contentBytes.length*j2;
	               pixoff=(QRCODE_SIZE-realSize)/2;
	               for (int i = 0; i < codeOut.length; i++) {  
	                   for (int j = 0; j < codeOut.length; j++) {  
	                       if (codeOut[j][i]) {  
							gs.fillRect(j * j2 + pixoff, i * j2 + pixoff, j2, j2);  
//	                           gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
	                       }  
	                   }  
	               }  
	           } else {  
	               System.err.println("QRCode content bytes length = "+ contentBytes.length + " not in [ 0,120 ]. ");  
	               return -1;
	           }  

	           Image img = ImageIO.read(new File(logo));//实例化一个Image对象。
	           int width = img.getWidth(null);  
		       int height = img.getHeight(null);  
		       if (width > WIDTH) {  
	                width = WIDTH;  
	            }  
	            if (height > HEIGHT) {  
	                height = HEIGHT;  
	            }  
	            int x = (QRCODE_SIZE - width) / 2;  
		        int y = (QRCODE_SIZE - height) / 2; 
	           gs.drawImage(img, x, y, width, height, null);
//	           gs.drawImage(img, 54, 55, 30, 30, null);
	           gs.dispose();  
	           bufImg.flush();  

	           // 生成二维码QRCode图片  

	           File imgFile = new File(imgPath);  

	           ImageIO.write(bufImg, "png", imgFile);  

	       }catch (Exception e){  
	           e.printStackTrace();  
	           return -100;
	       }  
	       return 0;
	   } 
    
    public static void main(String[] args) {
    	String content="http://weixin.qq.com/q/3DuGZdLlHlNnX0vuIxO0";
		String imgPath="D:/jimasFile/QrCode/Michael_QRCode1.png";
		String logoPath="D:/jimasFile/QrCode/logo.png";
		createQRCode(content, imgPath, logoPath);
		System.out.println("createQRCode success");
	}
}
