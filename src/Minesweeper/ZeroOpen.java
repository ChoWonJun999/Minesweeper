package Minesweeper;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ZeroOpen {
	private JButton blank[][];
	private String number[][];
	ZeroOpen(JButton blank[][], String number[][], int x, int y) {
		this.blank = blank; this.number = number;
		ZeroOpen(x,y);
	}
	public void ZeroOpen(int x, int y) {
		if(blank[x][y].getText()==" ") {
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
			for(int k=a0; k<a1; k++) {
				for(int l=b0; l<b1; l++) {
					if(k!=0 || l!=0) if(blank[x+k][y+l].getText().equals(""))
					switch(number[x+k][y+l]) {
						case "0" : 
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText(" ");
							ZeroOpen(x+k, y+l);
							break;
						case "1" :
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("1");
							blank[x+k][y+l].setForeground(new Color(0,0,255));
							break;
						case "2" : 
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("2");
							blank[x+k][y+l].setForeground(new Color(0,128,0));
							break;
						case "3" : 
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("3");
							blank[x+k][y+l].setForeground(new Color(255,0,0));
							break;
						case "4" : 
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("4"); 
							blank[x+k][y+l].setForeground(new Color(0,0,128));
							break;
						case "5" : 
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("5"); 
							blank[x+k][y+l].setForeground(new Color(128,0,0));
							break;
						case "6" :
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("6");
							blank[x+k][y+l].setForeground(new Color(0,128,128));
							break;
						case "7" : 
							blank[x+k][y+l].setBackground(new Color(192,192,192));
							blank[x+k][y+l].setBorder(BorderFactory.createLineBorder(new Color(128,128,128)));
							blank[x+k][y+l].setFont(new Font("Arial",Font.BOLD,14));
							blank[x+k][y+l].setText("7");
							blank[x+k][y+l].setForeground(new Color(0,0,0));
							break;
					}
				}
			}
		}
	}
}
