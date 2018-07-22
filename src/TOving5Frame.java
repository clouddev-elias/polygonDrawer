package dat200;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TOving5Frame extends JFrame
{
	
	TOving5PanelMenu pnlMenu;
	TOving5PanelDraw pnlDraw;
	
	public TOving5Frame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,720);
		
		pnlDraw=new TOving5PanelDraw();
		pnlMenu=new TOving5PanelMenu(pnlDraw);
		
		setLayout(new BorderLayout());
		
		getContentPane().add(pnlMenu,BorderLayout.NORTH);
		getContentPane().add(pnlDraw,BorderLayout.CENTER);
		
		setVisible(true);
	}
}
