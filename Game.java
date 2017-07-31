//Name: Pranay Kotian
//Date: 13/6/2016
//Game: Mario

//All sprites (pictures) were sourced from:
//http://www.spriters-resource.com/snes/smarioworld/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.net.*;
import java.io.IOException.*;

public class Game extends Applet implements ActionListener
{
    Panel p_screen; //to hold all of the screens
    Panel screen1, screen2, screen3, screen4; //the screens
    CardLayout cdLayout = new CardLayout ();

    //pic [level] [row] [col]
    int pic[] [] [] = {{{21, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 7, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 1, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 8, 1, 8, 7, 10, 10},
		{10, 10, 7, 1, 8, 3, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 8, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 7, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 1

	    {{22, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 1, 1, 1, 1, 10, 10, 10},
		{10, 10, 7, 2, 8, 1, 1, 10, 10, 10},
		{10, 10, 10, 10, 1, 8, 7, 10, 10, 10},
		{10, 10, 7, 10, 10, 8, 1, 10, 10, 10},
		{10, 10, 1, 10, 1, 7, 1, 10, 10, 10},
		{10, 10, 8, 1, 9, 8, 8, 7, 10, 10},
		{10, 10, 1, 1, 1, 7, 1, 1, 10, 10},
		{10, 10, 10, 1, 1, 1, 1, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 2

	    {{23, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 7, 10, 10, 10},
		{10, 10, 7, 1, 1, 8, 1, 10, 10, 10},
		{10, 10, 1, 8, 8, 1, 1, 1, 10, 10},
		{10, 10, 1, 10, 1, 1, 7, 1, 10, 10},
		{10, 10, 7, 1, 1, 8, 1, 1, 10, 10},
		{10, 10, 10, 10, 1, 1, 7, 10, 10, 10},
		{10, 10, 10, 10, 8, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 3

	    {{24, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 4, 1, 10, 7, 1, 1, 10, 10},
		{10, 10, 1, 1, 10, 1, 8, 1, 10, 10},
		{10, 10, 1, 1, 8, 7, 1, 1, 10, 10},
		{10, 10, 10, 8, 10, 10, 10, 10, 10, 10},
		{10, 10, 1, 1, 1, 1, 1, 1, 10, 10},
		{10, 10, 1, 1, 7, 1, 1, 1, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 4

	    {{25, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 1, 1, 1, 10, 10, 10, 10},
		{10, 10, 10, 8, 10, 1, 10, 10, 10, 10},
		{10, 10, 1, 1, 1, 8, 3, 1, 10, 10},
		{10, 10, 1, 10, 1, 1, 10, 1, 10, 10},
		{10, 10, 1, 10, 7, 1, 7, 1, 10, 10},
		{10, 10, 1, 1, 1, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 5

	    {{26, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 1, 1, 10, 10, 10, 10},
		{10, 10, 10, 10, 8, 1, 10, 10, 10, 10},
		{10, 10, 1, 8, 1, 1, 3, 10, 10, 10},
		{10, 10, 1, 7, 7, 7, 1, 10, 10, 10},
		{10, 10, 10, 8, 1, 1, 10, 10, 10, 10},
		{10, 10, 10, 1, 1, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 6
	};

    int picori[] [] [] = {{{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 7, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 1, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 8, 1, 8, 7, 10, 10},
		{10, 10, 7, 1, 8, 3, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 8, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 7, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 1

	    {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 1, 1, 1, 1, 10, 10, 10},
		{10, 10, 7, 2, 8, 1, 1, 10, 10, 10},
		{10, 10, 10, 10, 1, 8, 7, 10, 10, 10},
		{10, 10, 7, 10, 10, 8, 1, 10, 10, 10},
		{10, 10, 1, 10, 1, 7, 1, 10, 10, 10},
		{10, 10, 8, 1, 9, 8, 8, 7, 10, 10},
		{10, 10, 1, 1, 1, 7, 1, 1, 10, 10},
		{10, 10, 10, 1, 1, 1, 1, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 2

	    {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 7, 10, 10, 10},
		{10, 10, 7, 1, 1, 8, 1, 10, 10, 10},
		{10, 10, 1, 8, 8, 1, 1, 1, 10, 10},
		{10, 10, 1, 10, 1, 1, 7, 1, 10, 10},
		{10, 10, 7, 1, 1, 8, 1, 1, 10, 10},
		{10, 10, 10, 10, 1, 1, 7, 10, 10, 10},
		{10, 10, 10, 10, 8, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 3

	    {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 4, 1, 10, 7, 1, 1, 10, 10},
		{10, 10, 1, 1, 10, 1, 8, 1, 10, 10},
		{10, 10, 1, 1, 8, 7, 1, 1, 10, 10},
		{10, 10, 10, 8, 10, 10, 10, 10, 10, 10},
		{10, 10, 1, 1, 1, 1, 1, 1, 10, 10},
		{10, 10, 1, 1, 7, 1, 1, 1, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 4

	    {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 1, 1, 1, 10, 10, 10, 10},
		{10, 10, 10, 8, 10, 1, 10, 10, 10, 10},
		{10, 10, 1, 1, 1, 8, 3, 1, 10, 10},
		{10, 10, 1, 10, 1, 1, 10, 1, 10, 10},
		{10, 10, 1, 10, 7, 1, 7, 1, 10, 10},
		{10, 10, 1, 1, 1, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 5

	    {{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 1, 1, 10, 10, 10, 10},
		{10, 10, 10, 10, 8, 1, 10, 10, 10, 10},
		{10, 10, 1, 8, 1, 1, 3, 10, 10, 10},
		{10, 10, 1, 7, 7, 7, 1, 10, 10, 10},
		{10, 10, 10, 8, 1, 1, 10, 10, 10, 10},
		{10, 10, 10, 1, 1, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}},
	//Level 6
	};

    int y0 = 5, x0 = 5, y1 = 2, x1 = 3, y2 = 8, x2 = 4, y3 = 2, x3 = 2, y4 = 4, x4 = 6, y5 = 4, x5 = 6;
    //Mario's position

    int row = 10;
    int col = 10;

    //Grid array
    JButton b[] = new JButton [row * col];

    //Movement buttons array
    JButton a[] = new JButton [6];

    //Level buttons array
    JButton c[] = new JButton [6];

    //Background image
    Image backGround;

    int level = 0;

    public void init ()
    {
	p_screen = new Panel ();
	p_screen.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	setSize (1024, 864);

	setLayout (new BorderLayout ());
	add ("Center", p_screen);
    }


    public void screen1 ()
    { //Title screen
	screen1 = new Panel ();

	//Super Mario World title image
	Panel y = new Panel (new GridLayout (1, 1));
	JLabel titlepic1 = new JLabel (createImageIcon ("Pictures/titlepic1.jpg"));
	y.add (titlepic1);

	//Sokoban title image
	Panel x = new Panel (new GridLayout (1, 1));
	JLabel titlepic2 = new JLabel (createImageIcon ("Pictures/titlepic2.jpg"));
	x.add (titlepic2);

	//Background image
	backGround = getImage (getCodeBase (), "Pictures/back.jpg");
	BackGroundPanel screen1 = new BackGroundPanel ();
	screen1.setLayout (new FlowLayout ());
	screen1.setBackGroundImage (backGround);

	Panel z = new Panel (new GridLayout (1, 2));
	//Play button
	JButton ply = new JButton (createImageIcon ("Pictures/playbutton.png"));
	ply.setPreferredSize (new Dimension (450, 114));
	ply.setActionCommand ("s4");
	ply.addActionListener (this);
	ply.setBorderPainted (false);
	ply.setBackground (new Color (114, 172, 212));
	z.add (ply);

	//Instructions button
	JButton ins = new JButton (createImageIcon ("Pictures/insbutton.png"));
	ins.setPreferredSize (new Dimension (450, 114));
	ins.setActionCommand ("s2");
	ins.addActionListener (this);
	ins.setBorderPainted (false);
	ins.setBackground (new Color (114, 172, 212));
	z.add (ins);

	//If the widgets aren't placed in panels they appear underneath the background image
	screen1.add (y);
	screen1.add (z);
	screen1.add (x);

	p_screen.add ("1", screen1);
    }


    public void screen2 ()
    { //Instructions screen
	screen2 = new Panel ();

	//Super Mario World title image
	Panel y = new Panel (new GridLayout (1, 1));
	JLabel instrucpic1 = new JLabel (createImageIcon ("Pictures/instrucpic1.jpg"));
	y.add (instrucpic1);

	Panel x = new Panel (new GridLayout (1, 1));
	JLabel ins = new JLabel (createImageIcon ("Pictures/instrucpic2.jpg"));
	x.add (ins);

	//Background image
	backGround = getImage (getCodeBase (), "Pictures/back.jpg");
	BackGroundPanel screen2 = new BackGroundPanel ();
	screen2.setLayout (new FlowLayout ());
	screen2.setBackGroundImage (backGround);

	Panel z = new Panel (new GridLayout (1, 2));
	//Back button
	JButton back = new JButton (createImageIcon ("Pictures/backbutton.png"));
	back.setPreferredSize (new Dimension (450, 114));
	back.setBorderPainted (false);
	back.setBackground (new Color (114, 172, 212));
	back.setActionCommand ("s1");
	back.addActionListener (this);
	z.add (back);

	//Play button
	JButton ply = new JButton (createImageIcon ("Pictures/playbutton.png"));
	ply.setPreferredSize (new Dimension (450, 114));
	ply.setActionCommand ("s4");
	ply.addActionListener (this);
	ply.setBorderPainted (false);
	ply.setBackground (new Color (114, 172, 212));
	z.add (ply);

	//If the widgets aren't placed in panels they appear underneath the background image
	screen2.add (y);
	screen2.add (z);
	screen2.add (x);

	p_screen.add ("2", screen2);
    }


    public void screen3 ()
    { //Game Screen
	screen3 = new Panel ();

	//Background image
	backGround = getImage (getCodeBase (), "Pictures/back.jpg");
	BackGroundPanel screen3 = new BackGroundPanel ();
	screen3.setLayout (new FlowLayout ());
	screen3.setBackGroundImage (backGround);

	Panel z = new Panel (new GridLayout (1, 1));
	//Back button
	JButton back = new JButton (createImageIcon ("Pictures/backbutton.png"));
	back.setPreferredSize (new Dimension (450, 114));
	back.setBorderPainted (false);
	back.setBackground (new Color (114, 172, 212));
	back.setActionCommand ("s4");
	back.addActionListener (this);
	z.add (back);

	//Reset button
	JButton reset = new JButton (createImageIcon ("Pictures/resetbutton.png"));
	reset.setPreferredSize (new Dimension (450, 114));
	reset.setBorderPainted (false);
	reset.setBackground (new Color (114, 172, 212));
	reset.setActionCommand ("reset");
	reset.addActionListener (this);
	z.add (reset);

	//Grid
	Panel y = new Panel (new GridLayout (row, row));
	for (int i = 0 ; i < b.length ; i++)
	{
	    // for random grass icons (may or may not use this)
	    //int ran = (int) (Math.random () * (9) + 1);
	    //b [i] = new JButton (createImageIcon (ran+".jpg"));

	    b [i] = new JButton (createImageIcon ("Pictures/1.jpg"));
	    b [i].setPreferredSize (new Dimension (64, 64));
	    b [i].addActionListener (this);
	    b [i].setActionCommand ("" + i);
	    b [i].setBorderPainted (false);
	    y.add (b [i]);
	}
	redraw ();

	//Movement buttons
	Panel x = new Panel (new GridLayout (2, 3));
	for (int i = 0 ; i < a.length ; i++)
	{
	    if (i == 0 || i == 2)
	    {
		a [i] = new JButton ();
		a [i].setBackground (Color.white);
		a [i].setEnabled (false);
		a [i].setPreferredSize (new Dimension (64, 64));
		a [i].setBorderPainted (false);
		a [i].setBackground (new Color (114, 172, 212));
	    }
	    else
	    {
		a [i] = new JButton (createImageIcon ("Pictures/a" + i + ".png"));
		a [i].setPreferredSize (new Dimension (66, 66));
		a [i].addActionListener (this);
		a [i].setActionCommand ("a" + i);
		a [i].setBorderPainted (false);
		a [i].setBackground (new Color (114, 172, 212));
	    }
	    x.add (a [i]);
	}

	//If the widgets aren't placed in panels they appear underneath the background image
	screen3.add (z);
	screen3.add (y);
	screen3.add (x);

	p_screen.add ("3", screen3);
    }


    public void screen4 ()
    { //Level Select Screen
	screen4 = new Panel ();

	//Background image
	backGround = getImage (getCodeBase (), "Pictures/back.jpg");
	BackGroundPanel screen4 = new BackGroundPanel ();
	screen4.setLayout (new FlowLayout ());
	screen4.setBackGroundImage (backGround);

	//Back button
	Panel a = new Panel (new GridLayout (1, 2));
	JButton back = new JButton (createImageIcon ("Pictures/backbutton.png"));
	back.setPreferredSize (new Dimension (450, 114));
	back.setBorderPainted (false);
	back.setBackground (new Color (114, 172, 212));
	back.setActionCommand ("s1");
	back.addActionListener (this);
	a.add (back);

	//Reset game button
	JButton resetg = new JButton (createImageIcon ("Pictures/resetgamebutton.png"));
	resetg.setPreferredSize (new Dimension (450, 114));
	resetg.setBorderPainted (false);
	resetg.setBackground (new Color (114, 172, 212));
	resetg.setActionCommand ("resetg");
	resetg.addActionListener (this);
	a.add (resetg);
	//The reason the reset game button is put on the level select screen is because it doesn't fit onto
	//the blue background of the title screen

	//Level buttons
	Panel b = new Panel (new GridLayout (3, 2));
	for (int i = 0 ; i < c.length ; i++)
	{
	    c [i] = new JButton (createImageIcon ("Pictures/lvl" + (i + 1) + ".png"));
	    c [i].setPreferredSize (new Dimension (460, 124));
	    c [i].addActionListener (this);
	    c [i].setActionCommand ("l" + i);

	    c [i].setBorderPainted (false);
	    c [i].setBackground (new Color (114, 172, 212));

	    // Doesnt work when setting an image as background
	    //c [i].setOpaque(false);
	    //c [i].setContentAreaFilled(false);
	    b.add (c [i]);
	}

	//Disables locked levels which will be enabled when you user beats the previous level

	c [1].setEnabled (false);
	c [2].setEnabled (false);
	c [3].setEnabled (false);
	c [4].setEnabled (false);
	c [5].setEnabled (false);

	//If the widgets aren't placed in panels they appear underneath the background image
	screen4.add (a);
	screen4.add (b);

	p_screen.add ("4", screen4);
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = Game.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("s1"))
	{
	    cdLayout.show (p_screen, "1");
	}
	else if (e.getActionCommand ().equals ("s2"))
	{
	    cdLayout.show (p_screen, "2");
	}
	else if (e.getActionCommand ().equals ("s3"))
	{
	    cdLayout.show (p_screen, "3");
	}
	else if (e.getActionCommand ().equals ("s4"))
	{
	    cdLayout.show (p_screen, "4");
	}
	else if (e.getActionCommand ().equals ("l0"))
	{
	    level = 0;
	    cdLayout.show (p_screen, "3");
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("l1"))
	{
	    level = 1;
	    cdLayout.show (p_screen, "3");
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("l2"))
	{
	    level = 2;
	    cdLayout.show (p_screen, "3");
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("l3"))
	{
	    level = 3;
	    cdLayout.show (p_screen, "3");
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("l4"))
	{
	    level = 4;
	    cdLayout.show (p_screen, "3");
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("l5"))
	{
	    level = 5;
	    cdLayout.show (p_screen, "3");
	    redraw ();
	}
	else if (e.getActionCommand ().equals ("a1"))
	{
	    moveup ();
	}
	else if (e.getActionCommand ().equals ("a3"))
	{
	    moveleft ();
	}
	else if (e.getActionCommand ().equals ("a4"))
	{
	    movedown ();
	}
	else if (e.getActionCommand ().equals ("a5"))
	{
	    moveright ();
	}
	else if (e.getActionCommand ().equals ("reset"))
	{
	    reset ();
	}
	else if (e.getActionCommand ().equals ("resetg"))
	{
	    resetg ();
	}
    }


    public void moveup ()
    {
	//Temp variables that change depending on the level (because the Mario's starting position is different
	//for each level
	//The real variables with Mario's position will be updated after movement is completed
	int ty = 0;
	int tx = 0;
	if (level == 0)
	{
	    ty = y0;
	    tx = x0;
	}
	else if (level == 1)
	{
	    ty = y1;
	    tx = x1;
	}
	else if (level == 2)
	{
	    ty = y2;
	    tx = x2;
	}
	else if (level == 3)
	{
	    ty = y3;
	    tx = x3;
	}
	else if (level == 4)
	{
	    ty = y4;
	    tx = x4;
	}
	else if (level == 5)
	{
	    ty = y5;
	    tx = x5;
	}
	if (pic [level] [ty] [tx] < 10)
	{
	    if (pic [level] [ty - 1] [tx] == 10) //Walking into wall
		pic [level] [ty] [tx] = 5;
	    else if (pic [level] [ty - 1] [tx] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 1;
		ty -= 1;
		pic [level] [ty] [tx] = 5;
	    }
	    else if (pic [level] [ty - 1] [tx] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty - 2] [tx] == 10 || pic [level] [ty - 2] [tx] == 8 || pic [level] [ty - 2] [tx] == 9)
		    pic [level] [ty] [tx] = 5; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty - 2] [tx] == 1)
		{
		    pic [level] [ty] [tx] = 1;
		    ty -= 1;
		    pic [level] [ty] [tx] = 5;
		    pic [level] [ty - 1] [tx] = 8;
		}
		else if (pic [level] [ty - 2] [tx] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    ty -= 1;
		    pic [level] [ty] [tx] = 5;
		    pic [level] [ty - 1] [tx] = 9;
		}
	    }
	    else if (pic [level] [ty - 1] [tx] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty - 2] [tx] == 10 || pic [level] [ty - 2] [tx] == 8 || pic [level] [ty - 2] [tx] == 9)
		    pic [level] [ty] [tx] = 5; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty - 2] [tx] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    ty -= 1;
		    pic [level] [ty] [tx] = 15;
		    pic [level] [ty - 1] [tx] = 8;
		}
		else if (pic [level] [ty - 2] [tx] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 1;
		    ty -= 1;
		    pic [level] [ty] [tx] = 15;
		    pic [level] [ty - 1] [tx] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 1;
		ty -= 1;
		pic [level] [ty] [tx] = 15;
	    }
	}

	//This near identical set of code is needed for when Mario is currently standing on a marker block
	//If this code isn't here when Mario moves off the marker block it turns into a regular grass block
	//SIDE NOTE: There is probably a more efficient way to code this
	else
	{
	    if (pic [level] [ty - 1] [tx] == 10) //Walking into wall
		pic [level] [ty] [tx] = 15;
	    else if (pic [level] [ty - 1] [tx] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 7;
		ty -= 1;
		pic [level] [ty] [tx] = 5;
	    }
	    else if (pic [level] [ty - 1] [tx] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty - 2] [tx] == 10 || pic [level] [ty - 2] [tx] == 8 || pic [level] [ty - 2] [tx] == 9)
		    pic [level] [ty] [tx] = 15; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty - 2] [tx] == 1)
		{
		    pic [level] [ty] [tx] = 7;
		    ty -= 1;
		    pic [level] [ty] [tx] = 5;
		    pic [level] [ty - 1] [tx] = 8;
		}
		else if (pic [level] [ty - 2] [tx] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    ty -= 1;
		    pic [level] [ty] [tx] = 5;
		    pic [level] [ty - 1] [tx] = 9;
		}
	    }
	    else if (pic [level] [ty - 1] [tx] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty - 2] [tx] == 10 || pic [level] [ty - 2] [tx] == 8 || pic [level] [ty - 2] [tx] == 9)
		    pic [level] [ty] [tx] = 15; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty - 2] [tx] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    ty -= 1;
		    pic [level] [ty] [tx] = 5;
		    pic [level] [ty - 1] [tx] = 8;
		}
		else if (pic [level] [ty - 2] [tx] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 7;
		    ty -= 1;
		    pic [level] [ty] [tx] = 15;
		    pic [level] [ty - 1] [tx] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 7;
		ty -= 1;
		pic [level] [ty] [tx] = 15;
	    }
	}
	redraw ();
	if (level == 0)
	{
	    y0 = ty;
	    x0 = tx;
	}
	else if (level == 1)
	{
	    y1 = ty;
	    x1 = tx;
	}
	else if (level == 2)
	{
	    y2 = ty;
	    x2 = tx;
	}
	else if (level == 3)
	{
	    y3 = ty;
	    x3 = tx;
	}
	else if (level == 4)
	{
	    y4 = ty;
	    x4 = tx;
	}
	else if (level == 5)
	{
	    y5 = ty;
	    x5 = tx;
	}
	win ();
    }


    public void movedown ()
    {
	//Temp variables that change depending on the level (because the Mario's starting position is different
	//for each level
	//The real variables with Mario's position will be updated after movement is completed
	int ty = 0;
	int tx = 0;
	if (level == 0)
	{
	    ty = y0;
	    tx = x0;
	}
	else if (level == 1)
	{
	    ty = y1;
	    tx = x1;
	}
	else if (level == 2)
	{
	    ty = y2;
	    tx = x2;
	}
	else if (level == 3)
	{
	    ty = y3;
	    tx = x3;
	}
	else if (level == 4)
	{
	    ty = y4;
	    tx = x4;
	}
	else if (level == 5)
	{
	    ty = y5;
	    tx = x5;
	}
	if (pic [level] [ty] [tx] < 10)
	{
	    if (pic [level] [ty + 1] [tx] == 10) //Walking into wall
		pic [level] [ty] [tx] = 4;
	    else if (pic [level] [ty + 1] [tx] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 1;
		ty += 1;
		pic [level] [ty] [tx] = 4;
	    }
	    else if (pic [level] [ty + 1] [tx] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty + 2] [tx] == 10 || pic [level] [ty + 2] [tx] == 8 || pic [level] [ty + 2] [tx] == 9)
		    pic [level] [ty] [tx] = 4; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty + 2] [tx] == 1)
		{
		    pic [level] [ty] [tx] = 1;
		    ty += 1;
		    pic [level] [ty] [tx] = 4;
		    pic [level] [ty + 1] [tx] = 8;
		}
		else if (pic [level] [ty + 2] [tx] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    ty += 1;
		    pic [level] [ty] [tx] = 4;
		    pic [level] [ty + 1] [tx] = 9;
		}
	    }
	    else if (pic [level] [ty + 1] [tx] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty + 2] [tx] == 10 || pic [level] [ty + 2] [tx] == 8 || pic [level] [ty + 2] [tx] == 9)
		    pic [level] [ty] [tx] = 4; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty + 2] [tx] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    ty += 1;
		    pic [level] [ty] [tx] = 14;
		    pic [level] [ty + 1] [tx] = 8;
		}
		else if (pic [level] [ty + 2] [tx] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 1;
		    ty += 1;
		    pic [level] [ty] [tx] = 14;
		    pic [level] [ty + 1] [tx] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 1;
		ty += 1;
		pic [level] [ty] [tx] = 14;
	    }
	}

	//This near identical set of code is needed for when Mario is currently standing on a marker block
	//If this code isn't here when Mario moves off the marker block it turns into a regular grass block
	//SIDE NOTE: There is probably a more efficient way to code this
	else
	{
	    if (pic [level] [ty + 1] [tx] == 10) //Walking into wall
		pic [level] [ty] [tx] = 14;
	    else if (pic [level] [ty + 1] [tx] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 7;
		ty += 1;
		pic [level] [ty] [tx] = 4;
	    }
	    else if (pic [level] [ty + 1] [tx] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty + 2] [tx] == 10 || pic [level] [ty + 2] [tx] == 8 || pic [level] [ty + 2] [tx] == 9)
		    pic [level] [ty] [tx] = 14; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty + 2] [tx] == 1)
		{
		    pic [level] [ty] [tx] = 7;
		    ty += 1;
		    pic [level] [ty] [tx] = 4;
		    pic [level] [ty + 1] [tx] = 8;
		}
		else if (pic [level] [ty + 2] [tx] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    ty += 1;
		    pic [level] [ty] [tx] = 4;
		    pic [level] [ty + 1] [tx] = 9;
		}
	    }
	    else if (pic [level] [ty + 1] [tx] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty + 2] [tx] == 10 || pic [level] [ty + 2] [tx] == 8 || pic [level] [ty + 2] [tx] == 9)
		    pic [level] [ty] [tx] = 14; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty + 2] [tx] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    ty += 1;
		    pic [level] [ty] [tx] = 4;
		    pic [level] [ty + 1] [tx] = 8;
		}
		else if (pic [level] [ty + 2] [tx] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 7;
		    ty += 1;
		    pic [level] [ty] [tx] = 14;
		    pic [level] [ty + 1] [tx] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 7;
		ty += 1;
		pic [level] [ty] [tx] = 14;
	    }
	}
	redraw ();
	if (level == 0)
	{
	    y0 = ty;
	    x0 = tx;
	}
	else if (level == 1)
	{
	    y1 = ty;
	    x1 = tx;
	}
	else if (level == 2)
	{
	    y2 = ty;
	    x2 = tx;
	}
	else if (level == 3)
	{
	    y3 = ty;
	    x3 = tx;
	}
	else if (level == 4)
	{
	    y4 = ty;
	    x4 = tx;
	}
	else if (level == 5)
	{
	    y5 = ty;
	    x5 = tx;
	}
	win ();
    }


    public void moveleft ()
    {
	//Temp variables that change depending on the level (because the Mario's starting position is different
	//for each level
	//The real variables with Mario's position will be updated after movement is completed
	int ty = 0;
	int tx = 0;
	if (level == 0)
	{
	    ty = y0;
	    tx = x0;
	}
	else if (level == 1)
	{
	    ty = y1;
	    tx = x1;
	}
	else if (level == 2)
	{
	    ty = y2;
	    tx = x2;
	}
	else if (level == 3)
	{
	    ty = y3;
	    tx = x3;
	}
	else if (level == 4)
	{
	    ty = y4;
	    tx = x4;
	}
	else if (level == 5)
	{
	    ty = y5;
	    tx = x5;
	}
	if (pic [level] [ty] [tx] < 10)
	{
	    if (pic [level] [ty] [tx - 1] == 10) //Walking into wall
		pic [level] [ty] [tx] = 3;
	    else if (pic [level] [ty] [tx - 1] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 1;
		tx -= 1;
		pic [level] [ty] [tx] = 3;
	    }
	    else if (pic [level] [ty] [tx - 1] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty] [tx - 2] == 10 || pic [level] [ty] [tx - 2] == 8 || pic [level] [ty] [tx - 2] == 9)
		    pic [level] [ty] [tx] = 3; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx - 2] == 1)
		{
		    pic [level] [ty] [tx] = 1;
		    tx -= 1;
		    pic [level] [ty] [tx] = 3;
		    pic [level] [ty] [tx - 1] = 8;
		}
		else if (pic [level] [ty] [tx - 2] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    tx -= 1;
		    pic [level] [ty] [tx] = 3;
		    pic [level] [ty] [tx - 1] = 9;
		}
	    }
	    else if (pic [level] [ty] [tx - 1] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty] [tx - 2] == 10 || pic [level] [ty] [tx - 2] == 8 || pic [level] [ty] [tx - 2] == 9)
		    pic [level] [ty] [tx] = 3; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx - 2] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    tx -= 1;
		    pic [level] [ty] [tx] = 13;
		    pic [level] [ty] [tx - 1] = 8;
		}
		else if (pic [level] [ty] [tx - 2] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 1;
		    tx -= 1;
		    pic [level] [ty] [tx] = 13;
		    pic [level] [ty] [tx - 1] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 1;
		tx -= 1;
		pic [level] [ty] [tx] = 13;
	    }
	}

	//This near identical set of code is needed for when Mario is currently standing on a marker block
	//If this code isn't here when Mario moves off the marker block it turns into a regular grass block
	//SIDE NOTE: There is probably a more efficient way to code this
	else
	{
	    if (pic [level] [ty] [tx - 1] == 10) //Walking into wall
		pic [level] [ty] [tx] = 13;
	    else if (pic [level] [ty] [tx - 1] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 7;
		tx -= 1;
		pic [level] [ty] [tx] = 3;
	    }
	    else if (pic [level] [ty] [tx - 1] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty] [tx - 2] == 10 || pic [level] [ty] [tx - 2] == 8 || pic [level] [ty] [tx - 2] == 9)
		    pic [level] [ty] [tx] = 13; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx - 2] == 1)
		{
		    pic [level] [ty] [tx] = 7;
		    tx -= 1;
		    pic [level] [ty] [tx] = 3;
		    pic [level] [ty] [tx - 1] = 8;
		}
		else if (pic [level] [ty] [tx - 2] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    tx -= 1;
		    pic [level] [ty] [tx] = 3;
		    pic [level] [ty] [tx - 1] = 9;
		}
	    }
	    else if (pic [level] [ty] [tx - 1] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty] [tx - 2] == 10 || pic [level] [ty] [tx - 2] == 8 || pic [level] [ty] [tx - 2] == 9)
		    pic [level] [ty] [tx] = 13; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx - 2] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    tx -= 1;
		    pic [level] [ty] [tx] = 3;
		    pic [level] [ty] [tx - 1] = 8;
		}
		else if (pic [level] [ty] [tx - 2] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 7;
		    tx -= 1;
		    pic [level] [ty] [tx] = 13;
		    pic [level] [ty] [tx - 1] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 7;
		tx -= 1;
		pic [level] [ty] [tx] = 13;
	    }
	}
	redraw ();
	if (level == 0)
	{
	    y0 = ty;
	    x0 = tx;
	}
	else if (level == 1)
	{
	    y1 = ty;
	    x1 = tx;
	}
	else if (level == 2)
	{
	    y2 = ty;
	    x2 = tx;
	}
	else if (level == 3)
	{
	    y3 = ty;
	    x3 = tx;
	}
	else if (level == 4)
	{
	    y4 = ty;
	    x4 = tx;
	}
	else if (level == 5)
	{
	    y5 = ty;
	    x5 = tx;
	}
	win ();
    }


    public void moveright ()
    {
	//Temp variables that change depending on the level (because the Mario's starting position is different
	//for each level
	//The real variables with Mario's position will be updated after movement is completed
	int ty = 0;
	int tx = 0;
	if (level == 0)
	{
	    ty = y0;
	    tx = x0;
	}
	else if (level == 1)
	{
	    ty = y1;
	    tx = x1;
	}
	else if (level == 2)
	{
	    ty = y2;
	    tx = x2;
	}
	else if (level == 3)
	{
	    ty = y3;
	    tx = x3;
	}
	else if (level == 4)
	{
	    ty = y4;
	    tx = x4;
	}
	else if (level == 5)
	{
	    ty = y5;
	    tx = x5;
	}
	if (pic [level] [ty] [tx] < 10)
	{
	    if (pic [level] [ty] [tx + 1] == 10) //Walking into wall
		pic [level] [ty] [tx] = 2;
	    else if (pic [level] [ty] [tx + 1] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 1;
		tx += 1;
		pic [level] [ty] [tx] = 2;
	    }
	    else if (pic [level] [ty] [tx + 1] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty] [tx + 2] == 10 || pic [level] [ty] [tx - 2] == 8 || pic [level] [ty] [tx + 2] == 9)
		    pic [level] [ty] [tx] = 2; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx + 2] == 1)
		{
		    pic [level] [ty] [tx] = 1;
		    tx += 1;
		    pic [level] [ty] [tx] = 2;
		    pic [level] [ty] [tx + 1] = 8;
		}
		else if (pic [level] [ty] [tx + 2] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    tx += 1;
		    pic [level] [ty] [tx] = 2;
		    pic [level] [ty] [tx + 1] = 9;
		}
	    }
	    else if (pic [level] [ty] [tx + 1] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty] [tx + 2] == 10 || pic [level] [ty] [tx + 2] == 8 || pic [level] [ty] [tx + 2] == 9)
		    pic [level] [ty] [tx] = 2; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx + 2] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 1;
		    tx += 1;
		    pic [level] [ty] [tx] = 12;
		    pic [level] [ty] [tx + 1] = 8;
		}
		else if (pic [level] [ty] [tx + 2] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 1;
		    tx += 1;
		    pic [level] [ty] [tx] = 12;
		    pic [level] [ty] [tx + 1] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 1;
		tx += 1;
		pic [level] [ty] [tx] = 12;
	    }
	}

	//This near identical set of code is needed for when Mario is currently standing on a marker block
	//If this code isn't here when Mario moves off the marker block it turns into a regular grass block
	//SIDE NOTE: There is probably a more efficient way to code this
	else
	{
	    if (pic [level] [ty] [tx + 1] == 10) //Walking into wall
		pic [level] [ty] [tx] = 12;
	    else if (pic [level] [ty] [tx + 1] == 1) //Walking into grass
	    {
		pic [level] [ty] [tx] = 7;
		tx += 1;
		pic [level] [ty] [tx] = 2;
	    }
	    else if (pic [level] [ty] [tx + 1] == 8) //If you are walking into a moveable block
	    {
		if (pic [level] [ty] [tx + 2] == 10 || pic [level] [ty] [tx + 2] == 8 || pic [level] [ty] [tx + 2] == 9)
		    pic [level] [ty] [tx] = 12; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx + 2] == 1)
		{
		    pic [level] [ty] [tx] = 7;
		    tx += 1;
		    pic [level] [ty] [tx] = 2;
		    pic [level] [ty] [tx + 1] = 8;
		}
		else if (pic [level] [ty] [tx + 2] == 7) //Marker is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    tx += 1;
		    pic [level] [ty] [tx] = 2;
		    pic [level] [ty] [tx + 1] = 9;
		}
	    }
	    else if (pic [level] [ty] [tx + 1] == 9) //If you are walking into a moveable block already on marker
	    {
		if (pic [level] [ty] [tx + 2] == 10 || pic [level] [ty] [tx + 2] == 8 || pic [level] [ty] [tx + 2] == 9)
		    pic [level] [ty] [tx] = 12; //Dont move if block behind is wall/another block/placed block
		else if (pic [level] [ty] [tx + 2] == 1) //Grass is behind block
		{
		    pic [level] [ty] [tx] = 7;
		    tx += 1;
		    pic [level] [ty] [tx] = 2;
		    pic [level] [ty] [tx + 1] = 8;
		}
		else if (pic [level] [ty] [tx + 2] == 7) //Marker is behind block
		{ //This never actually occurs in the game (only ever happens horizontally on level 6) but is added just
		    //if anytime in the future a level where this occurs is added to the game
		    pic [level] [ty] [tx] = 7;
		    tx += 1;
		    pic [level] [ty] [tx] = 12;
		    pic [level] [ty] [tx + 1] = 9;
		}
	    }
	    else
	    {
		pic [level] [ty] [tx] = 7;
		tx += 1;
		pic [level] [ty] [tx] = 12;
	    }
	}
	redraw ();
	if (level == 0)
	{
	    y0 = ty;
	    x0 = tx;
	}
	else if (level == 1)
	{
	    y1 = ty;
	    x1 = tx;
	}
	else if (level == 2)
	{
	    y2 = ty;
	    x2 = tx;
	}
	else if (level == 3)
	{
	    y3 = ty;
	    x3 = tx;
	}
	else if (level == 4)
	{
	    y4 = ty;
	    x4 = tx;
	}
	else if (level == 5)
	{
	    y5 = ty;
	    x5 = tx;
	}
	win ();
    }


    public void win ()
    { //Checks if you have won
	char win = 'y';
	for (int i = 0 ; i < 10 ; i++)
	{
	    for (int j = 0 ; j < 10 ; j++)
	    {
		if (pic [level] [i] [j] == 7 || pic [level] [i] [j] == 12 || pic [level] [i] [j] == 13 || pic [level] [i] [j] == 14 || pic [level] [i] [j] == 15)
		    win = 'n';
	    }
	}
	if (win == 'y')
	{
	    if (level == 0)
	    {
		pic [level] [y0] [x0] = 6;
		c [1].setEnabled (true);
	    }
	    else if (level == 1)
	    {
		pic [level] [y1] [x1] = 6;
		c [2].setEnabled (true);
	    }
	    else if (level == 2)
	    {
		pic [level] [y2] [x2] = 6;
		c [3].setEnabled (true);
	    }
	    else if (level == 3)
	    {
		pic [level] [y3] [x3] = 6;
		c [4].setEnabled (true);
	    }
	    else if (level == 4)
	    {
		pic [level] [y4] [x4] = 6;
		c [5].setEnabled (true);
	    }
	    else
		pic [level] [y5] [x5] = 6;

	    JOptionPane.showMessageDialog (null, "You have completed the activity!", "IBMC 2017!", JOptionPane.INFORMATION_MESSAGE);
	    JOptionPane.showMessageDialog (null, "The next activity is now unlocked!", "IBMC 2017!", JOptionPane.INFORMATION_MESSAGE);
	    JOptionPane.showMessageDialog (null, "Click 'Back' to return to level select or 'Reset' to replay the level.", "IBMC 2017!", JOptionPane.INFORMATION_MESSAGE);

	}
	redraw ();

    }


    public void reset ()
    { //Resets current level
	//Resets that level
	for (int i = 0 ; i < 10 ; i++)
	{
	    for (int j = 0 ; j < 10 ; j++)
	    {
		pic [level] [i] [j] = picori [level] [i] [j];
	    }
	}
	redraw ();

	//Resets starting position for that level
	if (level == 0)
	{
	    y0 = 5;
	    x0 = 5;
	}
	else if (level == 1)
	{
	    y1 = 2;
	    x1 = 3;
	}
	else if (level == 2)
	{
	    y2 = 8;
	    x2 = 4;
	}
	else if (level == 3)
	{
	    y3 = 2;
	    x3 = 2;
	}
	else if (level == 4)
	{
	    y4 = 4;
	    x4 = 6;
	}
	else
	{
	    y5 = 4;
	    x5 = 6;
	}
    }


    public void resetg ()
    { //Resets entire game
	//All level boards return to their original state
	int input = JOptionPane.showConfirmDialog (null, "Progress on all levels will be deleted.\nAre you sure you want to reset?",
		"ENTIRE GAME RESET", JOptionPane.YES_NO_OPTION);

	if (input == 0)
	{
	    for (int i = 0 ; i < 5 ; i++)
	    {
		for (int j = 0 ; j < 10 ; j++)
		{
		    for (int k = 0 ; k < 10 ; k++)
			pic [i] [j] [k] = picori [i] [j] [k];
		}
	    }
	    redraw ();

	    //All original starting positions are set
	    y0 = 5;
	    y1 = 2;
	    x1 = 3;
	    y2 = 8;
	    x2 = 4;
	    y3 = 2;
	    x3 = 2;
	    y4 = 4;
	    x4 = 6;
	    y5 = 4;
	    x5 = 6;

	    //All levels now locked
	    c [1].setEnabled (false);
	    c [2].setEnabled (false);
	    c [3].setEnabled (false);
	    c [4].setEnabled (false);
	    c [5].setEnabled (false);
	}
    }


    public void redraw ()
    {
	int move = 0;
	for (int i = 0 ; i < 10 ; i++)
	{
	    for (int j = 0 ; j < 10 ; j++)
	    {
		b [move].setIcon (createImageIcon ("Pictures/" + pic [level] [i] [j] + ".jpg"));
		move++;
	    }
	}
    }
}
