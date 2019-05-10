 package com.swsp.GameUtil;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;


/**
 * һ����Ÿ��й��߷�������
 * @author Tom
 *
 */
public class GameUtil 
{
	private GameUtil(){}
	
	/**
	 * ����ͼƬ�ķ���
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
