package Minesweeper;

import javax.swing.*;
import javax.swing.border.CompoundBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;

public class OpenListener extends MouseAdapter{
	private JButton blank[][];
	private String number[][];
	OpenListener(JButton blank[][], String number[][]){
		this.blank = blank; this.number = number;
	}
	public void mouseReleased(MouseEvent e) {
		JButton open = (JButton)e.getSource();
		int x =  open.getY()/open.getHeight();
		int y =  open.getX()/open.getWidth();
		System.out.println(x+","+y);
		if(e.getButton()==MouseEvent.BUTTON1) {
			if(number[x][y].equals("*")) {
				for(int i=0; i<blank.length; i++) {
					for(int j=0; j<blank[0].length; j++) {
						if(number[i][j].equals("*")) {
							if(!blank[i][j].getText().equals("🚩")){
								blank[i][j].setBackground(new Color(192,192,192));
								blank[i][j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
								blank[i][j].setFont(new Font("Arial",Font.BOLD,14));
								blank[i][j].setForeground(Color.BLACK);
								blank[i][j].setText("*");
							}
						}
						blank[i][j].removeMouseListener(this);
					}
				}
				open.setBackground(Color.RED);
			}else if(number[x][y].equals("0")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setText(" ");
				new ZeroOpen(blank, number, x,y);
			}else if(number[x][y].equals("1")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(0,0,255));
				open.setText("1");
			}else if(number[x][y].equals("2")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(0,128,0));
				open.setText("2");
			}else if(number[x][y].equals("3")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(255,0,0));
				open.setText("3");
			}else if(number[x][y].equals("4")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(0,0,128));
				open.setText("4");
			}else if(number[x][y].equals("5")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(128,0,0));
				open.setText("5");
			}else if(number[x][y].equals("6")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(0,128,128));
				open.setText("6");
			}else if(number[x][y].equals("7")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(0,0,0));
				open.setText("7");
			}else if(number[x][y].equals("8")) {
				open.setBackground(new Color(192,192,192));
				open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
				open.setFont(new Font("Arial",Font.BOLD,14));
				open.setForeground(new Color(128,128,128));
				open.setText("8");
			}
		}else if(e.getButton()==4) {
			int a0,a1,b0,b1;
			if(x==0) {
				if(y==0) {a0=0; a1=2; b0=0; b1=2;
				}else if(y==blank[0].length-1) {a0=0; a1=2; b0=-1; b1=1;
				}else {a0=0; a1=2; b0=-1; b1=2;}
			}else if(x==blank.length-1) {
				if(y==0) {a0=-1; a1=1; b0=0; b1=2;
				}else if(y==blank[0].length-1) { a0=-1; a1=1; b0=-1; b1=1;
				}else {a0=-1; a1=1; b0=-1; b1=2;}
			}else {
				if(y==0) {a0=-1; a1=2; b0=0; b1=2;
				}else if(y==blank[0].length-1) {a0=-1; a1=2; b0=-1; b1=1;
				}else {a0=-1; a1=2; b0=-1; b1=2;}
			}
			int index=0;
			for(int k=a0; k<a1; k++) {
				for(int l=b0; l<b1; l++) {
					if(blank[x+k][y+l].getText().equals("🚩") && number[x+k][y+l].equals("*")) {
						index++;
					}
				}
			}
			
			if(number[x][y].equals(Integer.toString(index))) {
				if(index>0)
				for(int i=a0; i<a1; i++) {
					for(int j=b0; j<b1; j++) {
						if(number[x+i][y+j].equals("0")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setText(" ");
							new ZeroOpen(blank, number, x+i,y+j);
						}else if(number[x+i][y+j].equals("1")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(0,0,255));
							blank[x+i][y+j].setText("1");
						}else if(number[x+i][y+j].equals("2")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(0,128,0));
							blank[x+i][y+j].setText("2");
						}else if(number[x+i][y+j].equals("3")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(255,0,0));
							blank[x+i][y+j].setText("3");
						}else if(number[x+i][y+j].equals("4")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(0,0,128));
							blank[x+i][y+j].setText("4");
						}else if(number[x+i][y+j].equals("5")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(128,0,0));
							blank[x+i][y+j].setText("5");
						}else if(number[x+i][y+j].equals("6")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(0,128,128));
							blank[x+i][y+j].setText("6");
						}else if(number[x+i][y+j].equals("7")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(0,0,0));
							blank[x+i][y+j].setText("7");
						}else if(number[x+i][y+j].equals("8")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+i][y+j].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+i][y+j].setForeground(new Color(128,128,128));
							blank[x+i][y+j].setText("8");
						}
					}
				}
			}else {
				for(int i=a0; i<a1; i++) {
					for(int j=b0; j<b1; j++) {
						if(blank[x+i][y+j].getText().equals("")) {
							blank[x+i][y+j].setBackground(new Color(192,192,192));
							blank[x+i][y+j].setBorder(new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(128,128,128))));
						}
					}
				}
			}
		}
		
	}
	public void mousePressed(MouseEvent e) {
		JButton open = (JButton)e.getSource();
		int x =  open.getY()/open.getHeight();
		int y =  open.getX()/open.getWidth();
		if(e.getButton()==MouseEvent.BUTTON1) {
			open.setBackground(new Color(192,192,192));
			open.setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
		}else if(e.getButton()==MouseEvent.BUTTON3) {
			if(open.getText().equals("🚩")) {
				open.setText("?");
				open.setForeground(Color.BLACK);
				open.setBackground(new Color(192,192,192));
				open.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(128,128,128))));
			}else if(open.getText().equals("?")) {
				open.setText("");
				open.setForeground(null);
				open.setBackground(new Color(192,192,192));
				open.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(128,128,128))));
			}else if(open.getText().equals("")) {
				open.setFont(new Font(null,Font.BOLD,11));
				open.setText("🚩");
				open.setForeground(Color.RED);
				open.setBackground(new Color(192,192,192));
				open.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(128,128,128))));
			}
		}else if(e.getButton()==4) {
			int a0,a1,b0,b1;
			if(x==0) {
				if(y==0) {a0=0; a1=2; b0=0; b1=2;
				}else if(y==blank[0].length-1) {a0=0; a1=2; b0=-1; b1=1;
				}else {a0=0; a1=2; b0=-1; b1=2;}
			}else if(x==blank.length-1) {
				if(y==0) {a0=-1; a1=1; b0=0; b1=2;
				}else if(y==blank[0].length-1) { a0=-1; a1=1; b0=-1; b1=1;
				}else {a0=-1; a1=1; b0=-1; b1=2;}
			}else {
				if(y==0) {a0=-1; a1=2; b0=0; b1=2;
				}else if(y==blank[0].length-1) {a0=-1; a1=2; b0=-1; b1=1;
				}else {a0=-1; a1=2; b0=-1; b1=2;}
			}
			for(int i=a0; i<a1; i++) {
				for(int j=b0; j<b1; j++) {
					if(blank[x+i][y+j].getText().equals("")) {
						blank[x+i][y+j].setBackground(new Color(192,192,192));
						blank[x+i][y+j].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
					}
				}
			}
		}
	}
}
