package com.swsp.GameUtil;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
/**
 * ��Ϸ�������
 * @author T
 */
public class GameFrame extends Frame
{
	
	/**
	 * ��������� �������ã�
	 * @param args
	 */
	public static void main(String[] args)
	{
		GameFrame a = new GameFrame() ;
		a.launchFrame();
	}
	
	/**
	 * �����������
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
	 * ���ƿ�����ݷ���
	 * �̳д���Ķ�Ӧ����д�˷���
	 * @return 
	 */
	public void paint(Graphics g)
	{
	}
	
	/**
	 * 
	 * �����߳�����ʱ��ķ�����Ĭ��60ms
	 * @param sleepTime
	 */
	private int sleepTime = 60 ;
	public void setSleepTime(int sleepTime)
	{
		this.sleepTime = sleepTime;
	}
	
	/**
	 * �ڲ��߳���
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
	 * ˫����������˸
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

