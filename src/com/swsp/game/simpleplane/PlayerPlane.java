package com.swsp.game.simpleplane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import com.swsp.GameUtil.GameConstants;
import com.swsp.GameUtil.GameUtil;

/**
 * 玩家飞机类
 * @author Tom
 *
 */
public class PlayerPlane
{

	/**
	 * 控制飞机方向的变量  
	 * 玩家飞机移动方法,控制不飞出游戏界面（计算图片边框）
	 */
	private boolean left , right , up , down ;
	private int x =30, y=30 ,speed=10;
	private Image playerPlaneImg = GameUtil.getImage("GameImage/plane.png");
	private boolean live= true;
	


	public boolean isLive()
	{
		return live;
	}


	public void move()
	{
		if (left  && x > 0)    x -= speed ;
		if (up    && y > 30)    y -= speed ;
 		if (right && x < GameConstants.GAME_WEDTH  -playerPlaneImg.getWidth(null))  x += speed  ;
 		if (down  && y < GameConstants.GAME_HEIGHT -playerPlaneImg.getHeight(null))  y += speed ;
	}

	/**
	 * 键盘行为增加方向方法
	 * @param e
	 */
	public void addDirection(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT   : left  = true ;  break;
			case KeyEvent.VK_UP     : up    = true ;  break;
			case KeyEvent.VK_RIGHT  : right = true ;  break;
			case KeyEvent.VK_DOWN   : down  = true ;  break;			
			default :                                 break;
		}
	}
	
	/**
	 * 键盘行为停止方向方法
	 * @param e
	 */
	public void stopDirection(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_LEFT   : left  = false ;  break;
			case KeyEvent.VK_UP     : up    = false ;  break;
			case KeyEvent.VK_RIGHT  : right = false ;  break;
			case KeyEvent.VK_DOWN   : down  = false ;  break;
			default :                                  break;
		}
	}
	
	public void draw(Graphics g)
	{
		move();
		if(live)
		{
			g.drawImage(playerPlaneImg, x, y, null);
		}
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(x, y, playerPlaneImg.getWidth(null), playerPlaneImg.getHeight(null));
	}
	
	public void kill()
	{
		live = false ;
	}
}
