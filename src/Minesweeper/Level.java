package Minesweeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

import java.awt.*;
import java.awt.event.*;

public class Level extends JPanel{
	private JButton blank [][];
	private String number [][];
	OpenListener ol;
	Level(int x, int y){
		blank = new JButton[x][y];
		number = new String[x][y];
		ol = new OpenListener(blank,number);
		setBackground(new Color(192,192,192));
		setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(4, 6, 5, 5),new CompoundBorder(BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(128,128,128)),BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE))));
		setLayout(new GridLayout(x,y));
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				blank[i][j]=new JButton("");
				number[i][j]="";
				blank[i][j].setBackground(new Color(192,192,192));
				blank[i][j].setBorder(new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE), BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(128,128,128))));
				blank[i][j].setFocusable(false);
				blank[i][j].addMouseListener(ol);
				add(blank[i][j]);
			}
		}
		int p=0;
		int q=0;
		switch(x*y) {
			case 16*30: q=99; break;
			case 16*16: q=40; break;
			case 9*9: q=10;
		}
		
		while(true) {
			int rX = (int)(Math.random()*x);
			int rY = (int)(Math.random()*y);
			if(number[rX][rY].equals("")) {
				number[rX][rY] = "*";
				p++;
			}
			if(p==q) break;
		}
		
		int index;
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				index=0;
				if(number[i][j]!="*") {
					int a0,a1,b0,b1;
					if(i==0) {
						if(j==0) {a0=0; a1=2; b0=0; b1=2;
						}else if(j==y-1) {a0=0; a1=2; b0=-1; b1=1;
						}else {a0=0; a1=2; b0=-1; b1=2;}
					}else if(i==x-1) {
						if(j==0) {a0=-1; a1=1; b0=0; b1=2;
						}else if(j==y-1) { a0=-1; a1=1; b0=-1; b1=1;
						}else {a0=-1; a1=1; b0=-1; b1=2;}
					}else {
						if(j==0) {a0=-1; a1=2; b0=0; b1=2;
						}else if(j==y-1) {a0=-1; a1=2; b0=-1; b1=1;
						}else {a0=-1; a1=2; b0=-1; b1=2;}
					}
					
					for(int k=a0; k<a1; k++) {
						for(int l=b0; l<b1; l++) {
							if(k!=0 || l!=0) if(number[i+k][j+l]=="*") index++;
						}
					}
					number[i][j] = Integer.toString(index);
				}
			}
		}
	}
}