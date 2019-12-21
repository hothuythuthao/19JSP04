import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Terminator extends WindowAdapter
{
	 public void windowClosing(WindowEvent e)
	{
		 System.exit(0);
	}
}

class myFrame extends JFrame implements ActionListener, DocumentListener, KeyListener,MouseListener
{
	private JScrollPane scrollPane;
	private JLabel time, ntime, keystroke, nkeystroke, wks, nwks, WPM, nWPM, accuracy, naccuracy;
	private JButton start;
	private JButton stop;
	private Font font;
	
	private JLabel front, mid, end;
	
	private String doc, stringmod, stringpadded ,pad;
	
	private int numtime, numstroke, numwrong, numWPM, numAcc, numWord, length;
	private boolean gamebegin;
	
	private JTextArea textarea;
	
	private char ch;
	private Timer timer;
	
	private JMenuBar menubar;
	private JMenu menu, info;
	private JRadioButtonMenuItem red, blue, gray, yellow, white, greeen, defa;
	private JMenu bgColor, records, mfile;
	private JMenuItem about, usage,history,mOpen,mSave;
	
	private window infoAbout,infoUsage,menuRecords;
	private IOwindow open,save;
	
	private String tmp,fileline[];
	
	private JPanel title,dp, line, tp;
	private slider s;
	private kbPan p;
	
	public static boolean [] keys = new boolean[94];
	public static boolean [] green = new boolean[94];
	public static String hold = "1234567890 -=\\qwertyuiop[]asdfghjkl;\'zxcvbnm,./!@#$%^&*()_+|QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?";
	public static int [] kcode = new int[94];
	
	private int index,prev ;
	
	public myFrame()
	{
		//--cai dat cho frame
		setTitle("Typing Game");
		setSize(1200,800);
		setResizable(false);
		setLocation(100,200);
		
		
		timer = new Timer(1000, this);
		kcode[0] = 65535;
		keys[0] = false;
		green[0] = false;
		for ( int i = 1; i <= 93; i ++)
		{
			keys[i] = false;
			green[i] = false;
			kcode[i] = getKeyCode(hold.charAt(i-1));
		}
		
		numtime = 0;
		numstroke = 0;
		numwrong = 0;
		numWPM = 0;
		numAcc = 0;
		numWord = 1;
		start = new JButton("Start");
		stop = new JButton("Stop");
		time = new JLabel("Time: ");
		font = new Font("Default",Font.BOLD,20);
		time.setFont(font);
		ntime = new JLabel("00:00");
		ntime.setFont(font);
		keystroke = new JLabel("Keystrokes:");
		keystroke.setFont(font);
		nkeystroke = new JLabel("0");
		nkeystroke.setFont(font);
		wks = new JLabel("Incorrects:");
		wks.setFont(font);
		nwks = new JLabel("0");
		nwks.setFont(font);
		WPM = new JLabel("Last WPM: ");
		WPM.setFont(font);
		nWPM = new JLabel("0");
		nWPM.setFont(font);
		accuracy = new JLabel("Accuracy: ");
		accuracy.setFont(font);
		naccuracy = new JLabel("0%");
		naccuracy.setFont(font);
		stringmod = "Enter Your Enter your text here.";
		length = 0;
		gamebegin = false;
		index = 0;
		prev = 0;

		pad = "                              ";
		front = new JLabel("                              ");
		front.setFont(new Font("Consolas",Font.PLAIN,20));
		mid = new JLabel("E");
		mid.setForeground(Color.red);
		mid.setFont(new Font("Consolas",Font.PLAIN,80));
		end = new JLabel("nter your text here.          ");
		end.setFont(new Font("Consolas",Font.PLAIN,20));
		
		stop.setEnabled(false);
		
		textarea = new JTextArea(("Enter your text here."),25,20);
		textarea.setFont(new Font("Default",Font.PLAIN,18));
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setOpaque(true);
		scrollPane = new JScrollPane(textarea);
		
		setIconImage(Main.tk.getImage("mush.png"));
		
		addWindowListener(new Terminator());
		
		setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		Container contentPane = getContentPane();
		
		//--menu
		menubar = new JMenuBar();
		menu = new JMenu("Menu");
		info = new JMenu("Info");
		records = new JMenu("Records");
		about = new JMenuItem("About");
		usage = new JMenuItem("Usage");
		history = new JMenuItem("Load Saved History");
		bgColor = new JMenu("Background Color");
		ButtonGroup group1 = new ButtonGroup();
		defa = new JRadioButtonMenuItem("Default",false);
		red = new JRadioButtonMenuItem("Red",false);
		blue = new JRadioButtonMenuItem("Blue",false);
		yellow = new JRadioButtonMenuItem("Yellow",false);
		greeen = new JRadioButtonMenuItem("Green",false);
		white = new JRadioButtonMenuItem("White",false);
		gray = new JRadioButtonMenuItem("Gray",false);
		group1.add(defa);
		group1.add(red);
		group1.add(blue);
		group1.add(yellow);
		group1.add(greeen);
		group1.add(white);
		group1.add(gray);
		
		records.add(history);
		menu.add(records);
		
		menu.add(bgColor);
		bgColor.add(defa);
		bgColor.addSeparator();
		bgColor.add(red);
		bgColor.add(blue);
		bgColor.add(yellow);
		bgColor.add(greeen);
		bgColor.add(white);
		bgColor.add(gray);

		info.add(about);
		info.add(usage);
		
		menubar.add(menu);
		menubar.add(info);
		fileline = new String[10];
		
		mfile = new JMenu("File");
		mOpen = new JMenuItem("Open");
		mSave = new JMenuItem("Save");
		mfile.add(mOpen);
		mfile.add(mSave);
		menubar.add(mfile);
		save = new IOwindow("Save");
		open = new IOwindow("Open");
		
		infoAbout = new window("About",200,200,"Welcome to Typing Game");
		
		infoUsage = new window("Usage",200,200,"Welcome to Typing Game");

		updateRecord();
		
		//panel and grid
		title = new JPanel();
		title.setBorder(BorderFactory.createLineBorder(Color.darkGray, 5));
		JLabel welcome = new JLabel("Welcome to Typing Game");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		title.add(welcome);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.gridwidth = 3;
		grid.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(title,grid);
				
		grid.ipady = 187; 
		grid.ipadx = 510;
		grid.gridwidth = 1;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 1;
		
		s = new slider();
		p = new kbPan();
		contentPane.add(s,grid);

		//--bang hien thi chinh
		dp = new JPanel();
		dp.setLayout(new GridLayout(6,2));
		dp.setBorder(BorderFactory.createLineBorder(Color.red, 5));
		dp.add(time);
		dp.add(ntime);
		dp.add(keystroke);
		dp.add(nkeystroke);
		dp.add(wks);
		dp.add(nwks);
		dp.add(WPM);
		dp.add(nWPM);
		dp.add(accuracy);
		dp.add(naccuracy);
		dp.add(start);
		dp.add(stop);
		
		grid.ipady = 40;
		grid.ipadx = -20;
		grid.gridwidth = 1;
		grid.gridx = 1;
		grid.gridy = 1;
		contentPane.add(dp,grid);
		
		//--dieu khien de go dong
		line = new JPanel();
		line.setLayout(new FlowLayout());
		line.add(front);
		line.add(mid);
		line.add(end);
		line.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
		grid.gridwidth = 2;
		grid.ipadx = 0;
		grid.ipady = 0;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 2;
		contentPane.add(line,grid);
		
		//--ban phim
		grid.ipady = 291; 
		grid.ipadx = 780;
		grid.gridwidth = 2;
		grid.gridx = 0;
		grid.gridy = 3;
		grid.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(p,grid);
		
		//--text area panel
		tp = new JPanel();
		tp.setBorder(BorderFactory.createLineBorder(Color.magenta, 5));
		tp.setLayout(new BorderLayout());
		tp.add(scrollPane);
		
		textarea.setBackground( new Color(240,240,240));
		grid.ipady = 00; 
		grid.ipadx = 10;
		grid.gridwidth = 1;
		grid.gridheight = 3;
		grid.gridx = 2;
		grid.gridy = 1;
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.fill = GridBagConstraints.VERTICAL;
		contentPane.add(tp,grid);
		
		//--them listener
		start.addActionListener(this);
		stop.addActionListener(this);
		textarea.getDocument().addDocumentListener(this);
		addMouseListener(this);
		
		//--menu
		setJMenuBar(menubar);
		defa.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		yellow.addActionListener(this);
		greeen.addActionListener(this);
		white.addActionListener(this);
		gray.addActionListener(this);
		about.addActionListener(this);
		usage.addActionListener(this);
		history.addActionListener(this);
		open.btn.addActionListener(this);
		save.btn.addActionListener(this);
		mOpen.addActionListener(this);
		mSave.addActionListener(this);
		
		setFocusable(true);
        requestFocusInWindow();
		addKeyListener(this);
	}

	//--ham doi mau nen
	public void changeBG(Color c)
	{
		title.setBackground(c);
		dp.setBackground(c);
		line.setBackground(c);
		tp.setBackground(c);
		s.setBackground(c);
		textarea.setBackground(c);
		p.setBackground(c);
		title.repaint();
		dp.repaint();
		line.repaint();
		tp.repaint();
		s.repaint();
		
		
	}
	
	//--thao tac tap tin
	public void updateRecord()
	{
		tmp = "Previous 10 Saved Records:\n";
		try(BufferedReader br = new BufferedReader(new FileReader("record.dat"))) 
		{
			int i = 0;
		    for(String line; (line = br.readLine()) != null &&  (i < 10); ) {
		    	fileline[i++] = line;
		    }
		}
		catch(Exception e)
		{
			System.out.println("Error: " + e);
		}
		for (int i = 0; i < 10; i ++)
		{
			tmp = tmp + "\n"  + fileline[i];
		}
		menuRecords = new window("Records",1050,400,tmp);
	}
	
	//--su kien nhan phim
	public void actionPerformed(ActionEvent e) 
	{
		
		Object source = e.getSource();
		if( source == timer)
		{
			numtime++;
			updateTime();
		}
		if( source == start )
		{

			slider.slidetoggle = false;
			textarea.setEditable(false);
			start.setEnabled(false);
			stop.setEnabled(true);
			requestFocusInWindow();
			
			updateChange();
			stringpadded = pad + stringmod + pad;
			
			front.setText(stringpadded.substring(0,30));
			mid.setText(""+stringmod.charAt(index));
			end.setText(stringpadded.substring(index+31,61));
			length = stringmod.length();
			
			//--chu mau xanh
			int t = hold.indexOf(stringmod.charAt(0));
			if ( t >= 48 ) //--khi can dung shift
			{
				keys[0] = true;
				green[0] = true;
			}
			prev = t;
			keys[t+1] = true;
			green[t+1] = true;
			p.repaint();
			timer.start();
			gamebegin = true;

			
		}
		
		if ( source == stop )
		{
			slider.slidetoggle = true;
			textarea.setEditable(true);
			start.setEnabled(true);
			stop.setEnabled(false);
			requestFocusInWindow();
			
			//--cap nhat thong tin
			timer.stop();
			updateWPM();
			updateAccuracy();

			
			for ( int i = 0; i < 94; i ++)
			{
				keys[i] = false;
				green[i] = false;
			}
			updateChange();
			line.repaint();
			
			//luu va cap nhap records
			String timeTmp;
			if ( numtime%60 < 10 )
				timeTmp =  numtime/60+":0"+numtime%60;
			else
				timeTmp = numtime/60+":"+numtime%60;
			
			fileline[9] = "Time: "+ timeTmp +"\tKeystrokes:    "+ numstroke +
					"\tIncorrects:    " + numwrong  +"\tWPM: " + numWPM +"\tAccuracy: "+ numAcc +"%";
			
			//--dat lai thoi gian
			numtime = 0;
			gamebegin = false;
			updateChange();
			
			//--dat lai cac thong tin
			index = 0;
			numstroke = 0;
			numwrong = 0;
			numWord = 0;
			
			
			try (FileWriter fw = new FileWriter("record.dat"))
			{
				fw.write(fileline[9]);
				
				for (int i = 0; i < 9; i++)
				{
					fw.write("\n"+fileline[i]);
				}
			 
				fw.close();
			}
			catch(Exception e1)
			{
				System.out.println("Error: " + e1);
			}
			
			updateRecord();

		}
		
		//--menu
		if (source == defa)
		{
			Color c = new Color(240,240,240);
			changeBG(c);
		}
		else if(source == red)
		{
			Color c = new Color(255,164,191);
			changeBG(c);
		}
		else if (source == blue)
		{
			Color c = new Color(181,178,255);
			changeBG(c);
		}
		else if (source == yellow)
		{
			Color c = new Color(255,252,178);
			changeBG(c);
		}
		else if (source == greeen)
		{
			Color c = new Color(178,255,216);
			changeBG(c);
		}
		else if (source == white)
		{
			Color c = new Color(255,255,255);
			changeBG(c);
		}
		else if (source == gray)
		{
			Color c = new Color(161,161,161);
			changeBG(c);
		}
		
		if(source == about)
		{
			infoAbout.setVisible(true);
		}
		if(source == usage)
		{
			infoUsage.setVisible(true);
		}
		if (source == history)
		{
			menuRecords.setVisible(true);
		}
		
		
		//IOwindows functions
		if (source == mOpen)
		{
			open.setVisible(true);
		}
		if (source == mSave)
		{
			save.setVisible(true);
		}
		if ( source == open.btn )
		{
			open.setVisible(false);
			String tmp = "";
			//--doc va mo text
			try(BufferedReader br = new BufferedReader(new FileReader(open.field.getText()))) 
			{
			    for(String line; (line = br.readLine()) != null; ) 
			    {
			    	tmp = tmp + "\n" + line;
			    }
			    textarea.setText(tmp);
			}
			catch(Exception e1)
			{
				System.out.println("Error: " + e1);
			}

		}
		if ( source == save.btn )
		{
			save.setVisible(false);
			//--luu text
			try (FileWriter fw = new FileWriter(save.field.getText()))
			{
				fw.write(textarea.getText());
				fw.close();
			}
			catch(Exception e1)
			{
				System.out.println("Error: " + e1);
			}
		}
	}
	
	public void changedUpdate(DocumentEvent e) {}
	public void insertUpdate(DocumentEvent e) 
	{
		updateChange();
		line.repaint();
	}
	public void removeUpdate(DocumentEvent e) 
	{
		updateChange();
		line.repaint();
	}
	
	//--cap nhat neu van ban bi thay doi
	public void updateChange()
	{
		doc = textarea.getText();
		if ( doc.equals(""))
		{
			doc = " ";
		}

		
		doc = doc.replace("\n", "").replace("\r", "").replace("\t", " ");
		doc = doc+" ";
		String trimmed = doc.trim();
		numWord = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		if (doc.equals(""))
		{
			mid.setText(" ");
			stringmod = " ";
		}
		else
		{
			if (s.difficulty() == 1)
			{
				stringmod = doc;
			}
			else if (s.difficulty() == 2)
			{
				stringmod = doc.toLowerCase();
			}
			else if (s.difficulty() == 3 )
			{
				stringmod = striping(doc);
			}
			else if (s.difficulty() == 4)
			{
				stringmod = doc.toUpperCase();
//				stringmod = doc.toLowerCase();
//				stringmod = striping(stringmod);
			}
			else
				stringmod = doc;
			mid.setText(stringmod.substring(0, 1));
		}
		stringpadded = pad + stringmod + pad + pad;
		front.setText(stringpadded.substring(0,30));
		end.setText(stringpadded.substring(31,61));
	}
	
	//--tinh toan va cap nhat bang chuc nang hien thi
	public void updateWrongStroke()
	{
		numwrong++;
		nwks.setText(""+numwrong);
		dp.repaint();
	}
	public void updateKeyStroke()
	{
		numstroke++;
		nkeystroke.setText(""+numstroke);
		repaint();
	}
	public void updateWPM()
	{
		String tmp = stringmod.substring(0,numstroke-numwrong);
		String trimmed = tmp.trim();
		numWord = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		if(numtime < 1)
			numtime = 1;
		numWPM = (int)((numWord/(float)(numtime))*60);
		nWPM.setText(""+numWPM);
		dp.repaint();
	}
	public void updateAccuracy()
	{
		if (numstroke != 0)
		{
			numAcc = (int)(100-((float)(numwrong/(float)(numstroke))*100));
		}
		naccuracy.setText(numAcc+"%");
		dp.repaint();
		
	}
	public void updateTime()
	{
		if ( numtime%60 < 10 )
			ntime.setText( numtime/60+":0"+numtime%60);
		else
			ntime.setText(numtime/60+":"+numtime%60);
		dp.repaint();
	}
	
	public String striping(String x) {
	    return x.replaceAll("\\p{Punct}+", " ");
	}
	
	public int getKeyCode(char tmp)
	{
	KeyStroke ks = KeyStroke.getKeyStroke(tmp, 0);
		return ks.getKeyCode();
	}

	
	
	//--ham listener
	public void keyPressed(KeyEvent e) 
	{
		int kc = e.getKeyChar();
		if ( kc == kcode[0])
			keys[0] = true;
		
		for (int i = 1; i <= 93; i++)
		{
			if ( kc == kcode[i] )
			{
				keys[i] = true;
				ch = (char)kcode[i];
			}
		}
		
		//--chay khi tro choi bat dau
		if ( gamebegin )
		{
			if(kc != kcode[0])
				updateKeyStroke();
			if(ch == stringmod.charAt(index))
			{
				index++;
				keys[prev+1] = false;
				green[prev+1] = false;
				
				front.setText(stringpadded.substring(index,index+30));
				mid.setText(""+stringmod.charAt(index));
				end.setText(stringpadded.substring(index+31,index+61));
				line.repaint();
				
			}
			else
			{
				if(kc != kcode[0])
					updateWrongStroke();
			}
			//--tao diem mau xanh cho phim duoc nhan
			int t = hold.indexOf(stringmod.charAt(index));
			prev = t;
			if ( t >= 48 )
			{
				keys[0] = true;
				green[0] = true;
			}
			keys[t+1] = true;
			green[t+1] = true;

			updateAccuracy();
		}
		//--dung khi den cuoi tap tin
		if (index == length-1)
			stop.doClick();
		p.repaint();
	}

	public void keyReleased(KeyEvent e) 
	{
		int kc = e.getKeyChar();
		if ( kc == kcode[0])
			keys[0] = false;
		for (int i = 1; i <= 93; i++)
		{
			if ( kc == kcode[i] )
				keys[i] = false;
		}
		
		p.repaint();
	}

	public void keyTyped(KeyEvent e) {}
	public void mouseClicked(MouseEvent arg0){
		updateChange();
		line.repaint();
		requestFocusInWindow();
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}

class slider extends JPanel implements MouseListener, MouseMotionListener
{
	public static boolean slidetoggle = true;
	private Image im;
	private int x;
	private int y;
	public slider()
	{
		im = Main.tk.getImage("slide.gif");
		x = 46; y = 79;
		super.setBorder(BorderFactory.createLineBorder(Color.orange,5));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	//--ham muc do
	public int difficulty()
	{
		if (x == 46 )
			return 1;
		else if ( x == 179 )
			return 2;
		else if ( x == 313 )
			return 3;
		else
			return 4;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im, 16, 0, null );
		g.setColor(Color.red);
		g.fillOval(x, 79, 40, 40);
		g.setColor(Color.black);
		g.drawOval(x, 79, 40, 40);
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		if (slidetoggle)
		{
			x = e.getX();
			y = e.getY();
			if ( (x >= 66 && x <= 466)&& ( y >= 49 && y <= 149 ) )
			{
				x = e.getX()-20;
				repaint();
			}
		}
		
	}
	
	public void mousePressed(MouseEvent e) 
	{
		if (slidetoggle)
		{
			x = e.getX();
			y = e.getY();
			if ( (x >= 66 && x <= 446) && ( y >= 79 && y <= 119 ) )
			{
				x = e.getX()-20;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if (slidetoggle)
			{
			if(  x <= 118 )
				x = 46;
			else if ( x > 118 && x <= 250 )
				x = 179;
			else if ( x > 250 && x <= 388 )
				x = 313;
			else if (x > 388  )
				x = 446;
			else;
			repaint();
			
		}
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

class kbPan extends JPanel
{
	private Image im;
	public kbPan()
	{
		im = Main.tk.getImage("kb.gif");
		super.setBorder(BorderFactory.createLineBorder(new Color(255,140,0), 5));
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(im, 0, 0, null );
		g.setColor(new Color(255,0,0,185));

		if ( myFrame.keys[0] )
		{
			if (myFrame.green[0])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(17,180, 50, 50);
			g.fillOval(700, 179, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[11])
		{
			if (myFrame.green[11])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(227,240, 375, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[1] ||  myFrame.keys[48] )
		{
			if (myFrame.green[1]||  myFrame.green[48])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(58,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[2] ||  myFrame.keys[49] )
		{
			if (myFrame.green[2] ||  myFrame.green[49] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(114,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[3] ||  myFrame.keys[50] )
		{
			if (myFrame.green[3] ||  myFrame.green[50] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(170,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		
		if ( myFrame.keys[4] ||  myFrame.keys[51] )
		{
			if (myFrame.green[4] ||  myFrame.green[51] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(228,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		
		if ( myFrame.keys[5] ||  myFrame.keys[52] )
		{
			if (myFrame.green[5] ||  myFrame.green[52] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(284,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[6] ||  myFrame.keys[53] )
		{
			if (myFrame.green[6] ||  myFrame.green[53] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(339,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[7] ||  myFrame.keys[54] )
		{
			if (myFrame.green[7] ||  myFrame.green[54] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(394,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[8] ||  myFrame.keys[55] )
		{
			if (myFrame.green[8] ||  myFrame.green[55] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(450,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[9] ||  myFrame.keys[56] )
		{
			if (myFrame.green[9] ||  myFrame.green[56] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(506,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[10] ||  myFrame.keys[57] )
		{
			if (myFrame.green[10] ||  myFrame.green[57] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(562,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[12] ||  myFrame.keys[58] )
		{
			if (myFrame.green[12] ||  myFrame.green[58] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(618,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[13] ||  myFrame.keys[59] )
		{
			if (myFrame.green[13]||  myFrame.green[59] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(674,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[14]  ||  myFrame.keys[60] )
		{
			if (myFrame.green[14] || myFrame.green[60] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(730,10, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[15] ||  myFrame.keys[61]  )
		{
			if (myFrame.green[15] ||  myFrame.green[61]  )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(88,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[16] ||  myFrame.keys[62] )
		{
			if (myFrame.green[16]||  myFrame.green[62] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(144,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[17]  ||  myFrame.keys[63] )
		{
			if (myFrame.green[17]||  myFrame.green[63])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(200,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[18] ||  myFrame.keys[64] )
		{
			if (myFrame.green[18]||  myFrame.green[64] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(258,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[19] ||  myFrame.keys[65] )
		{
			if (myFrame.green[19]||  myFrame.green[65] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(313,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[20] ||  myFrame.keys[66] )
		{
			if (myFrame.green[20] ||  myFrame.green[66] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(370,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[21] ||  myFrame.keys[67] )
		{
			if (myFrame.green[21] ||  myFrame.green[67] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(424,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[22] ||  myFrame.keys[68] )
		{
			if (myFrame.green[22]||  myFrame.green[68] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(480,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[23] ||  myFrame.keys[69] )
		{
			if (myFrame.green[23] ||  myFrame.green[69] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(536,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[24] ||  myFrame.keys[70] )
		{
			if (myFrame.green[24] ||  myFrame.green[70])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(592,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[25] ||  myFrame.keys[71] )
		{
			if (myFrame.green[25] ||  myFrame.green[71] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(648,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[26] ||  myFrame.keys[72] )
		{
			if (myFrame.green[26] ||  myFrame.green[72] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(704,69, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[27] ||  myFrame.keys[73] )
		{
			if (myFrame.green[27] ||  myFrame.green[73] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(100,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[28] ||  myFrame.keys[74] )
		{
			if (myFrame.green[28] ||  myFrame.green[74] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(156,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[29] ||  myFrame.keys[75] )
		{
			if (myFrame.green[29] ||  myFrame.green[75])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(212,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[30] ||  myFrame.keys[76] )
		{
			if (myFrame.green[30] ||  myFrame.green[76] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(270,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[31] ||  myFrame.keys[77] )
		{
			if (myFrame.green[31] ||  myFrame.green[77])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(326,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[32] ||  myFrame.keys[78] )
		{
			if (myFrame.green[32] ||  myFrame.green[78] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(382,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[33] ||  myFrame.keys[79]  )
		{
			if (myFrame.green[33]||  myFrame.green[79]  )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(436,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[34] ||  myFrame.keys[80] )
		{
			if (myFrame.green[34] ||  myFrame.green[80])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(492,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[35] ||  myFrame.keys[81] )
		{
			if (myFrame.green[35] ||  myFrame.green[81])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(548,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[36] ||  myFrame.keys[82] )
		{
			if (myFrame.green[36] ||  myFrame.green[82])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(604,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[37] ||  myFrame.keys[83] )
		{
			if (myFrame.green[37] ||  myFrame.green[83])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(660,126, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[38] ||  myFrame.keys[84] )
		{
			if (myFrame.green[38] ||  myFrame.green[84])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(129,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[39] ||  myFrame.keys[85] )
		{
			if (myFrame.green[39] ||  myFrame.green[85])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(186,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[40] ||  myFrame.keys[86] )
		{
			if (myFrame.green[40] ||  myFrame.green[86])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(242,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[41] ||  myFrame.keys[87] )
		{
			if (myFrame.green[41] ||  myFrame.green[87])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(298,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[42] ||  myFrame.keys[88] )
		{
			if (myFrame.green[42] ||  myFrame.green[88])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(355,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[43] ||  myFrame.keys[89] )
		{
			if (myFrame.green[43] || myFrame.green[89] )
				g.setColor(new Color(0,255,0,185));
			g.fillOval(411,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[44] ||  myFrame.keys[90] )
		{
			if (myFrame.green[44] ||  myFrame.green[90])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(468,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[45] ||  myFrame.keys[91] )
		{
			if (myFrame.green[45] ||  myFrame.green[91])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(524,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[46] ||  myFrame.keys[92] )
		{
			if (myFrame.green[46] ||  myFrame.green[92])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(580,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		if ( myFrame.keys[47] ||  myFrame.keys[93] )
		{
			if (myFrame.green[47] ||  myFrame.green[93])
				g.setColor(new Color(0,255,0,185));
			g.fillOval(637,180, 50, 50);
			g.setColor(new Color(255,0,0,185));
		}
		
	}
}

class window extends JFrame
{
	public window(String name, int w, int h, String content)
	{
		setTitle(name);
		setSize(w,h);
		setLocation(200,300);
		setResizable(false);
		JTextArea tf = new JTextArea(content);
		
		tf.setFont(new Font("Arial",Font.BOLD,20));
		tf.setEditable(false);
		
		tf.setLineWrap(true);
		tf.setWrapStyleWord(true);
		tf.setOpaque(false);
		tf.setBorder(BorderFactory.createLineBorder(new Color(240,240,240), 20));
		JScrollPane scrollPane = new JScrollPane(tf);
		
		
		Container contentPane = getContentPane();
		contentPane.add(scrollPane);
	}
}

class IOwindow extends JFrame
{
	public JTextField field;
	public JButton btn;
	public IOwindow(String name)
	{
		setTitle(name);
		setSize(400,75);
		setLocation(300,300);
		setResizable(false);
		field = new JTextField(15);
		btn = new JButton("OK");

		JPanel pan = new JPanel();
		pan.add(new JLabel("Enter File Name:"));
		pan.add(field);
		pan.add(btn);
		
		Container contentPane = getContentPane();
		contentPane.add(pan);
	}
}

public class Main 
{
	public static Toolkit tk = Toolkit.getDefaultToolkit();
	public static void main(String [] args)
	{
		myFrame frame = new myFrame();
		frame.setVisible(true);
	}
}