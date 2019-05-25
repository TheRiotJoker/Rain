import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
public class drop extends JFrame
{
	Image doubleBufferImg;
	Graphics doubleBufferGraphics;
	static int width = 1000; //x actually length
	static int height = 1000;
	public static block[] regen;
	public static Color bg = new Color(222,222,222); //background color
	public static void main(String[] args) throws InterruptedException
	{
		int amountOfDrops = 0;
		String choice = "";
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the amount of drops: ");
		amountOfDrops = checkIsInputNumber(scan.next());
		System.out.println("");
		System.out.println("Available colors: ");
		System.out.println("Blue[Default]");
		System.out.println("Green");
		System.out.println("Purple");
		System.out.println("Red");
		System.out.println("Rainbow");
		System.out.println("Custom");
		System.out.print("Please input the color: ");
		choice = scan.next();
		regen = new block[amountOfDrops];
		for(int i = 0; i < regen.length; i++) //generation block for the rain drops
		{
			regen[i] = new block();
			regen[i].setX(randGen(1000,0)); //rand position on the top of the screen (length wise, left or right)
			regen[i].setY(randGen(200,1)*(-1)); //rand pos off of the screen(in Y direction, so upwards)
			regen[i].setYSize(randGen(15,4)); //length of the block
			regen[i].setXSize((int)(regen[i].getYSize()/4.5)); //the width of the block depending on the length (f(x) = x/4.5)
			switch(choice.toUpperCase())
			{
				case "GREEN":
					if(regen[i].getYSize() > 11)
					{
						regen[i].setG(255-(11));
						regen[i].setB(30+(11*11));
						regen[i].setR(30+(11*11));
					}
					else
					{
						regen[i].setG(255-(regen[i].getYSize()));
						regen[i].setB(30+(regen[i].getYSize()*regen[i].getYSize()));
						regen[i].setR(30+(regen[i].getYSize()*regen[i].getYSize()));
					}	
					bg = new Color(0,0,0);
				break;
				case "PURPLE":
				if(regen[i].getYSize() > 11)
				{
					regen[i].setR(230-(11));
					regen[i].setG(0+(11*11));
					regen[i].setB(230-(11));
				}
				else
				{
					regen[i].setR(190-(regen[i].getYSize()));
					regen[i].setG(0+(regen[i].getYSize()*2));
					regen[i].setB(230-(regen[i].getYSize()*2));
				}	
				bg = new Color(230,230,250);
				break;
				case "RED":
				if(regen[i].getYSize() > 11)
				{
					regen[i].setR(255-(11));
					regen[i].setB(0+(11*11));
					regen[i].setG(0+(11*11));
				}
				else
				{
					regen[i].setR(255-(regen[i].getYSize()));
					regen[i].setB(0+(regen[i].getYSize()*regen[i].getYSize()));
					regen[i].setG(0+(regen[i].getYSize()*regen[i].getYSize()));
				}
				break;
				case "RAINBOW":
				regen[i].setB(randGen(255,0));
				regen[i].setG(randGen(255,0));
				regen[i].setR(randGen(255,0));
				bg = new Color(randGen(255,0),randGen(255,0),randGen(255,0));
				break;
				case "CUSTOM":
				if(i == 0)
				{
					//background colors
					System.out.println("Input the red (0-255) [Background]");
					regen[i].setR(checkIsInputNumber(scan.next()));
					while(regen[i].getR() < 0 || regen[i].getR() > 255)
					{
						System.out.println("Wrong input.");
						regen[i].setR(checkIsInputNumber(scan.next()));
					}
					System.out.println("Input the green (0-255) [Background]");
					regen[i].setG(checkIsInputNumber(scan.next()));
					while(regen[i].getG() < 0 || regen[i].getG() > 255)
					{
						System.out.println("Wrong input.");
						regen[i].setG(checkIsInputNumber(scan.next()));
					}
					System.out.println("Input the blue (0-255) [Background]");
					regen[i].setB(checkIsInputNumber(scan.next()));
					while(regen[i].getB() < 0 || regen[i].getB() > 255)
					{
						System.out.println("Wrong input.");
						regen[i].setB(checkIsInputNumber(scan.next()));
					}
					bg = new Color(regen[i].getR(), regen[i].getG(), regen[i].getB());
					//end of background colors
					//colors of rain drops
					System.out.println("Input the red (0-255)");
					regen[i].setR(checkIsInputNumber(scan.next()));
					while(regen[i].getR() < 0 || regen[i].getR() > 255)
					{
						System.out.println("Wrong input.");
						regen[i].setR(checkIsInputNumber(scan.next()));
					}
					System.out.println("Input the green (0-255)");
					regen[i].setG(checkIsInputNumber(scan.next()));
					while(regen[i].getG() < 0 || regen[i].getG() > 255)
					{
						System.out.println("Wrong input.");
						regen[i].setG(checkIsInputNumber(scan.next()));
					}
					System.out.println("Input the blue (0-255)");
					regen[i].setB(checkIsInputNumber(scan.next()));
					while(regen[i].getB() < 0 || regen[i].getB() > 255)
					{
						System.out.println("Wrong input.");
						regen[i].setB(checkIsInputNumber(scan.next()));
					}
				}
				else
				{
					regen[i].setB(regen[0].getB());
					regen[i].setR(regen[0].getR());
					regen[i].setG(regen[0].getG());
				}
				break;
				default:   
				if(regen[i].getYSize() > 11)
				{
					regen[i].setB(255-(11));
					regen[i].setG(30+(11*11));
					regen[i].setR(30+(11*11));
				}
				else
				{
					regen[i].setB(255-(regen[i].getYSize()));
					regen[i].setG(30+(regen[i].getYSize()*regen[i].getYSize()));
					regen[i].setR(30+(regen[i].getYSize()*regen[i].getYSize()));
				}
			}
			regen[i].setSpeed(randGen((int)(regen[i].getYSize()*1.6),(int)(regen[i].getYSize()*1.6)-5)); //speed gen: for size x the f(x) = 1.8*x (max) and min f(x) = 1.8*x-5 where f is speed
		}
		System.out.println("Starting program.");
		drop gui = new drop();
		gui.setSize(height, width);
		gui.setTitle("Rain");
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setResizable(false);
		gui.setVisible(true);
		scan.close();
		while(true)
		{
			for(int i = 0; i < regen.length; i++)
			{
				regen[i].setY(regen[i].getY()+regen[i].getSpeed()); //movement
				if(regen[i].getY() > width) //if the rain drop goes out of screen
				{
					regen[i].setY(randGen(200,1)*(-1));
					regen[i].setX(randGen(1000,0));
				}
			}
			gui.repaint();
			Thread.sleep(20);
		}
	}
	public static int checkIsInputNumber(String input)
	{
		Scanner scan = new Scanner(System.in);
		boolean isConverted = false;
		while(isConverted == false)
		{
			try
			{
				Integer.parseInt(input);
				isConverted = true;
			}
			catch(NumberFormatException e)
			{
				isConverted = false;
			}
			if(isConverted == false )
			{
				System.out.println("Wrong input");
				input = scan.next();
			}
		}
		return Integer.parseInt(input);
	}
	public void paint(Graphics g)
	{
		doubleBufferImg = createImage(width, height); //creates an image of the current screen
		doubleBufferGraphics = doubleBufferImg.getGraphics(); //gets the graphics of the current screen
		paintComponent(doubleBufferGraphics); //takes the graphics
		g.drawImage(doubleBufferImg,0,0,this); //draws them to the screen (i don't completely understand this either)
	}
	public void paintComponent(Graphics g)
	{
		g.setColor(bg);
		g.fillRect(0,0,width,height);
		for(int i = 0; i < regen.length; i++)
		{
			Color rain = new Color(regen[i].getR(),regen[i].getG(),regen[i].getB());
			g.setColor(rain);
			g.fillRect(regen[i].getX(),regen[i].getY(),regen[i].getXSize(),regen[i].getYSize());
			if(regen[i].getY() == height)
			{
				g.drawLine(regen[i].getX(), regen[i].getY()+22, regen[i].getX()-5, regen[i].getY()+22);
			}	
		}
	}
	public static int randGen(int max, int min)
	{
		Random random = new Random();
		return random.nextInt((max-min)+1)+min;
	}
}
class block
{
	int speed = 0;
	int x = 0;
	int y = 0;
	int ySize = 10;
	int xSize = 3;
	int r = 0;
	int g = 0; 
	int b = 0;
	int getR()
	{
		return r;
	}
	void setR(int r)
	{
		this.r = r;
	}
	int getG()
	{
		return g;
	}
	void setG(int g)
	{
		this.g = g;
	}
	int getB()
	{
		return b;
	}
	void setB(int b)
	{
		this.b = b;
	}
	void setXSize(int xSize)
	{
		this.xSize = xSize;
	}
	int getXSize()
	{
		return xSize;
	}
	void setYSize(int ySize)
	{
		this.ySize = ySize;
	}
	int getYSize()
	{
		return ySize;
	}
	void setSpeed(int speed)
	{
		this.speed = speed;
	}
	int getSpeed()
	{
		return speed;
	}
	int getX()
	{
		return x;
	}
	void setX(int x)
	{
		this.x = x;
	}
	void setY(int y)
	{
		this.y = y;
	}
	int getY()
	{
		return y;
	}
	
}