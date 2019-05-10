package com.swsp.GameUtil;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
/**
 * 游戏公共框架
 * @author T
 */
public class GameFrame extends Frame
{
	
	/**
	 * 框架主函数 （测试用）
	 * @param args
	 */
	public static void main(String[] args)
	{
		GameFrame a = new GameFrame() ;
		a.launchFrame();
	}
	
	/**
	 * 框架启动方法
	 */
	public void launchFrame ()
	{
		setSize((int) GameConstants.GAME_WEDTH , (int) GameConstants.GAME_HEIGHT);
	 	setVisible(true);
	 	setLocation(400, 100);
	 	
	 	addWindowListener
	 	(
	 			new WindowAdapter ()
	 			{
		 			public void windowClosing(WindowEvent e)
		 			{
		 				System.exit(0);
		 			}
	 			}		
	 	);
	 	new PaintTread().start();
	}
	
	/**
	 * 绘制框架内容方法
	 * 继承此类的都应该重写此方法
	 * @return 
	 */
	public void paint(Graphics g)
	{
	}
	
	/**
	 * 
	 * 设置线程休眠时间的方法，默认60ms
	 * @param sleepTime
	 */
	private int sleepTime = 60 ;
	public void setSleepTime(int sleepTime)
	{
		this.sleepTime = sleepTime;
	}
	
	/**
	 * 内部线程类
	 * @author Tom
	 *60
	 */
	public class PaintTread extends Thread
	{
		public void run ()
		{
			while (true)
			{
				repaint();
				try 
				{
					Thread.sleep(sleepTime);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 双缓冲消除闪烁
	 */
	private Image offScreenImage = null ;
	public void update(Graphics g)
	{
		if(offScreenImage == null)
		{
			offScreenImage = this.createImage((int)GameConstants.GAME_WEDTH, (int)GameConstants.GAME_HEIGHT) ;
		}
		
		Graphics gOff = offScreenImage.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
}

