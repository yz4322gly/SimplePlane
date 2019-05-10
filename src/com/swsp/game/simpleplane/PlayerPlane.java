package com.swsp.game.simpleplane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import com.swsp.GameUtil.GameConstants;
import com.swsp.GameUtil.GameUtil;

/**
 * ��ҷɻ���
 * @author Tom
 *
 */
public class PlayerPlane
{

	/**
	 * ���Ʒɻ�����ı���  
	 * ��ҷɻ��ƶ�����,���Ʋ��ɳ���Ϸ���棨����ͼƬ�߿�
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
	 * ������Ϊ���ӷ��򷽷�
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
	 * ������Ϊֹͣ���򷽷�
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
