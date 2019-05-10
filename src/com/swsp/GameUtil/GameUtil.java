 package com.swsp.GameUtil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


/**
 * 一个存放各中工具方法的类
 * @author Tom
 *
 */
public class GameUtil 
{
	private GameUtil(){}
	
	/**
	 * 载入图片的方法
	 * @param imgPath
	 * @return Image
	 */
	public static Image getImage (String imgPath)
	{
		URL u = GameUtil.class.getClassLoader().getResource(imgPath);
		BufferedImage img = null ;
		try 
		{
			img = ImageIO.read(u);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
		return img ;
	}
	
}
