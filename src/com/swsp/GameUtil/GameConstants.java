package com.swsp.GameUtil;

import java.awt.Image;

/**
 * 游戏常量参数类
 * @author Tom
 *
 */
public class GameConstants 
{
	public static final int GAME_HEIGHT = 600 ;
	public static final int GAME_WEDTH  = 600 ;
	public static final int HALF_GAME_HEIGHT = GAME_HEIGHT /2 ;
	public static final int HALF_GAME_WEDTH  = GAME_WEDTH  /2 ;
	public static Image bg = GameUtil.getImage("GameImage/bg2.jpg");
	public static Image bullet =  GameUtil.getImage("GameImage/bullet.gif");
	public static Image plane =  GameUtil.getImage("GameImage/plane.png");
	public static Image enemyPlane1 = GameUtil.getImage("GameImage/enemyPlane1.png");
}
