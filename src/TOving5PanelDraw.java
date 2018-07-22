package dat200;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

//----------------------------------------------------------------
// Tegnepanelet
//----------------------------------------------------------------
public class TOving5PanelDraw extends JPanel implements MouseListener,MouseMotionListener{
	
	TPointDouble ptMove; 	//Punktet som følger musen.
	TPolygon polygon;		//Polygonet som tegnes
		
	public TOving5PanelDraw(){
		setBackground(new Color(253,253,253));
		addMouseListener(this);
		addMouseMotionListener(this);
		ptMove=null;
		polygon=null;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(polygon!=null){
			polygon.DrawPolygon(g);
		}
	}
 
	public void mousePressed(MouseEvent e) {
		int iMouseButton = e.getButton();
		// Sjekker på musknappen.
		switch (iMouseButton){
			case MouseEvent.BUTTON1:	//Dette er venstere knapp
				
				//Hvis polygonet er lukket, kan man ikke legge til flere punkter.
				if(polygon!=null){
					if(polygon.getIsClosed()==true){
						return;
					}
				}else{
					polygon=new TPolygon();
					polygon.appendPoint(e.getPoint());
				}
				ptMove=polygon.appendPoint(e.getPoint());
				
			break;
			
			case MouseEvent.BUTTON2: //mus hjul
			break;
			
			case MouseEvent.BUTTON3: //høyre knapp
				polygon.setIsClosed(true);
				repaint();
			break;
		}				
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		//Hvis polygonet er lukket, kan man ikke flytte slutt punktet.
		if(polygon==null){
			return;
		}else if(polygon.getIsClosed()){
			return;
		}
		//flytter det siste punktet i listen, slik at det følger musen.
		ptMove.x=e.getPoint().x;
		ptMove.y=e.getPoint().y;
		repaint();
	}
	
	public void Clear(){
		polygon=null;
		repaint();
	}

	public void RotatePlus() {
		//Roter polygonet 50 grader mot klokken
		for(int f=0;f<50;f++){
			polygon.Rotate(1);
			paintImmediately(getBounds());
		}
		repaint();
	}

	public void RotateMinus() {
		//Roter polygonet 50 grader med klokken
		for(int f=0;f<50;f++){
			polygon.Rotate(-1);
			paintImmediately(getBounds());
		}
		repaint();
	}

	public void ScalePlus() {
		//Skaler polygonet 0.25 ganger større
		for(int f=0;f<50;f++){
			polygon.scale(1.005d);
			paintImmediately(getBounds());
		}
		repaint();
	}

	public void ScaleMinus() {
		//Skaler polygonet 0.25 ganger mindre.
		for(int f=0;f<50;f++){
			polygon.scale(0.995d);
			paintImmediately(getBounds());
		}
		repaint();
	}
	
	//Eventer som ikke brukes.
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	
	
}
