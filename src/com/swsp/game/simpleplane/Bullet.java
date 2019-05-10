package com.swsp.game.simpleplane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.swsp.GameUtil.GameUtil;

public class Bullet 
{

	private int x = 250;
	private int y = 250;
	private int speed =10;
	private double degree = Math.random() * Math.PI * 2;
	private boolean live= true;
	String bulletPath = "GameImage/bullet.gif";
	Image bulletPathImg = GameUtil.getImage(bulletPath);


	public void move()
	{
		x = (int) (x + speed*Math.cos(degree));
		y = (int) (y + speed*Math.sin(degree));
		if( y < 0 || y > 600 )
		{
			degree =  - degree;
		}
		if( x < 0 || x > 600 )
		{
			degree = Math.PI - degree;
		}

	}


	public Bullet( int x, int y, int speed)
	{
		this.x = x ;
		this.y = y ;
		this.speed = speed ;
		degree = Math.random() * Math.PI * 2;
	}
	
	public void draw(Graphics g)
	{
		move();
		if(live)
		g.drawImage(bulletPathImg, (int)x, (int)y, null);
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle((int) x, (int) y, bulletPathImg.getWidth(null), bulletPathImg.getHeight(null));
	}
	
	public void kill()
	{
		live = false ;
	}

}
