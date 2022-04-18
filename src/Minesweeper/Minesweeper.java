package Minesweeper;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.*;

public class Minesweeper extends JFrame{
	public Level level;
	private int x,y;
	Container c = getContentPane();
	Minesweeper(int x, int y){
		this.x=x; this.y=y;
		setTitle("지뢰찾기");
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Menu();
		level = new Level(x,y);
		c.add(new CountResetTime1(), BorderLayout.NORTH);
		c.add(level, BorderLayout.CENTER);
		((JComponent) c).setBorder(BorderFactory.createMatteBorder(3, 3, 0, 0, Color.WHITE));
		
		if(x==16 && y==16) setSize(275,354);
		else if(x==9 && y==9) setSize(170,255);
		else setSize(515,370);
		
		setLocation(225, 172);
		setVisible(true);
		setResizable(false);
	}
	
	void Menu() {
		JMenuItem menuItem[] = new JMenuItem[14];
		String menuItemNames[] = {"새 게임(N)\tF2","초급(B)","중급(I)","고급(E)","사용자 지정(C)...","? 표시(M)","컬러로 표시(L)","소리(X)","최고기록(T)","끝내기(X)","목차(C)\tF1","도움말 검색(S)...","도움말 사용(H)","지뢰찾기 정보(A)"};
		int menuItemMenmonic[] = {'N','B','I','E','C','M','L','X','T','X','C','S','H','A'};
		JMenuBar menuBar = new JMenuBar();
		JMenu game = new JMenu("게임(G)");
		game.setMnemonic('G');
		JMenu help = new JMenu("도움말(H)");
		help.setMnemonic('H');
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(menuItemNames[i]);
			menuItem[i].setMnemonic(menuItemMenmonic[i]);
			menuItem[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			menuItem[i].setFocusPainted(false);
			menuItem[i].addActionListener(new MenuListener());
			if(i<10) {
				game.add(menuItem[i]);
				if(i==0 || i==4 || i==7 || i==8) game.addSeparator();
			}else {
				help.add(menuItem[i]);
				if(i==12) help.addSeparator();
			}
		}
		menuBar.add(game);
		menuBar.add(help);
		menuBar.setBackground(Color.WHITE);
		game.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		help.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		setJMenuBar(menuBar);
	}
	class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "새 게임(N)\tF2" :
				remove(level);
				level = new Level(x,y);
				c.add(level, BorderLayout.CENTER);
				revalidate();
				repaint();
				if(x==16 && y==16) setSize(275,354);
				else if(x==9 && y==9) setSize(170,255);
				else setSize(515,370);
				break;
			case "초급(B)" :
				remove(level);
				x=9;y=9;
				level = new Level(9,9);
				c.add(level, BorderLayout.CENTER);
				revalidate();
				repaint();
				setSize(170,255);
				break;
			case "중급(I)" :
				remove(level);
				x=16;y=16;
				level = new Level(16,16);
				c.add(level, BorderLayout.CENTER);
				revalidate();
				repaint();
				setSize(275,354);
				break;
			case "고급(E)" :
				remove(level);
				x=16;y=30;
				level = new Level(16,30);
				c.add(level, BorderLayout.CENTER);
				revalidate();
				repaint();
				setSize(515,370);
				break;
			}
		}
	}class CountResetTime1 extends JPanel{
		CountResetTime1(){
			setBackground(new Color(192,192,192));
			setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(6, 6, 5, 5),new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, new Color(128,128,128)),BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE))));
			JLabel count = new JLabel();
			JLabel time = new JLabel();
			
			JButton reset = new JButton("🙂");
			reset.setForeground(Color.YELLOW);
			reset.setFont(new Font(null,Font.BOLD,18));
			reset.setPreferredSize(new Dimension(25,25));
			reset.setBackground(new Color(192,192,192));
			reset.setBorder(new CompoundBorder(BorderFactory.createLineBorder(new Color(128,128,128)), new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE),BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(128,128,128)))));
			reset.setFocusable(false);
			reset.addActionListener(new ResetListener());
			count.setText("99");
			time.setText("00");
			
			add(count);
			add(reset);
			add(time);
		}
	}class ResetListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			remove(level);
			level = new Level(x,y);
			c.add(level, BorderLayout.CENTER);
			revalidate();
			repaint();
		}
	}
	public static void main(String[] args) {
		new Minesweeper(16,30);
	}
}
