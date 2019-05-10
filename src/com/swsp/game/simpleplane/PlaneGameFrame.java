package com.swsp.game.simpleplane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.swsp.GameUtil.GameConstants;
import com.swsp.GameUtil.GameFrame;


@SuppressWarnings("serial")
/**
 * 飞机游戏框架类
 * @author Tom
 *
 */

public class PlaneGameFrame extends GameFrame 
{
	int x = 0 ;
	PlayerPlane playerPlane = new PlayerPlane ();
	Date start = new Date();
	Date end = new Date();
	static List<Bullet> bius = new ArrayList<Bullet>();
	static
	{
		for(int i = 0 ;i < 20 ; i++)
		bius.add( new Bullet(250, 250, 5));
	}
	

	
	public static void main(String[] args)
	{ 
		PlaneGameFrame a = new PlaneGameFrame();
		a.setSleepTime(30);
		a.launchFrame();
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(GameConstants.bg,	0, 0, null);
		
	
		playerPlane.draw(g);
		
		for(Bullet i :bius)
		{
			i.draw(g);
			if(playerPlane.getRectangle().intersects(i.getRectangle()) && playerPlane.isLive())
			{
				end.setTime(System.currentTimeMillis());
				i.kill() ;
				playerPlane.kill();
				break;
			}
		}
		
		if(!playerPlane.isLive())
		{
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("黑体", Font.BOLD, 100));
			g.drawString("Game Over", 50, 200);
			g.drawString(end.getTime()-start.getTime() + "ms", 120, 350);
		}
	
	}
	
	@Override
	public void launchFrame()
	{
		super.launchFrame();
		start.setTime(System.currentTimeMillis());
		System.out.println(start);
		addKeyListener(new KeyMonitor());
	}

	/**
	 * 键盘监控器类
	 * 定义内部类方便调用外部属性
	 * @author admin
	 *
	 */ 
	class KeyMonitor extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			playerPlane.addDirection(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e)
		{
			playerPlane.stopDirection(e);
		}
		
	}
}
