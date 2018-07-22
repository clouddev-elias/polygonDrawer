package dat200;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


//----------------------------------------------------------------
// En klasse som holder på X og Y verdier som flyttall.
//----------------------------------------------------------------
class TPointDouble{
	double x,y;
	public TPointDouble(Point aPoint){
		x=aPoint.x;
		y=aPoint.y;
	}
	public TPointDouble(double aX, double aY) {
		x=aX;
		y=aY;
	}
	
	//----------------------------------------------------------------
	// Roterer et punkt om senter
	//----------------------------------------------------------------
	public void Rotate(TPointDouble aCenter,int aDegree){
		double dRad=Math.toRadians(aDegree);

		//Bergne sinus og cosinus av vinkel i radianer
		double dCos=Math.cos(dRad);
		double dSin=Math.sin(dRad);
		
		// Flytte punktet slik at det senter fallersammen med origo;
		double dMoveX = x-aCenter.x;
		double dMoveY = y-aCenter.y;
		
		// Rotere punktet rundt origo
		double dNewX = dMoveX*dCos - dMoveY*dSin;
		double dNewY = dMoveX*dSin + dMoveY*dCos;
		
		
		// Flytte punktet tilbake slik at det fallersammen med senter i gjenn.
		x = dNewX + aCenter.x;
		y = dNewY + aCenter.y;		
	}
	
	//----------------------------------------------------------------
	// Skallerer et punkt om senter
	//----------------------------------------------------------------
	public void Scale(TPointDouble aCenter,double aScale){
		// Flytte punktet slik at det senter fallersammen med origo;
		double dMoveX = x-aCenter.x;
		double dMoveY = y-aCenter.y;
		
		// Skalere punktet i forhold til origo
		double dNewX = dMoveX*aScale;
		double dNewY = dMoveY*aScale;
		
		
		// Flytte punktet tilbake slik at det fallersammen med senter i gjenn.
		x = dNewX + aCenter.x;
		y = dNewY + aCenter.y;				
	}
}

//----------------------------------------------------------------
// Plygon klasse 
//----------------------------------------------------------------
public class TPolygon
{
	//Liste over alle punktene i polygonet
	ArrayList<TPointDouble> plPolygon;
	
	//Brukes til å lukke polygonet
	private boolean bIsClosed;
	
	//Senter av polygonet
	TPointDouble ptCenter;
	
	//Konstruktør
	public TPolygon(){
		bIsClosed=false;
		
		plPolygon=new ArrayList<TPointDouble>();
		ptCenter=null;
	}
	
	//Legger til et punkt i listen over punkter
	public TPointDouble appendPoint(TPointDouble ptStart) {
		return this.appendPoint(new Point((int)ptStart.x , (int)ptStart.y));
	}

	//Legger til et punkt i listen over punkter
	public TPointDouble appendPoint(Point aPoint){
		TPointDouble ptNew = new TPointDouble(aPoint);
		plPolygon.add(ptNew);
		return ptNew;
	}
	
	//Lukker eller åpner polygonet.
	//Hvis polygonet er lukket, beregnes senteret av polygonet.
	public void setIsClosed(boolean aClosed){
		bIsClosed=aClosed;
		//sletter det siste punktet i listen
		if(bIsClosed=true){
			plPolygon.remove(plPolygon.size()-1);
			ptCenter=getCenter();
		}
	}
	
	//Returnerer om plygonet er lukket eller åpent.
	public boolean getIsClosed(){
		return bIsClosed;
	}
	
	//Tegner hele plygonet
	public void DrawPolygon(Graphics g){
		TPointDouble ptFrom;
		TPointDouble ptTo = null;
		for(int i=0; i<plPolygon.size()-1; i++){
			ptFrom=plPolygon.get(i);
			ptTo=plPolygon.get(i+1);
			g.drawLine((int)ptFrom.x, (int)ptFrom.y, (int)ptTo.x, (int)ptTo.y);
		}
		if(bIsClosed){
			ptFrom=ptTo;
			ptTo=plPolygon.get(0);
			g.drawLine((int)ptFrom.x, (int)ptFrom.y, (int)ptTo.x, (int)ptTo.y);

		}
	}
	
	//Bergner senter av polygonet ved å bergne gjennomsnitt av alle x og y verdier
	public TPointDouble getCenter(){
		double x=0.0d,y=0.0d;
		for(int i=0;i<plPolygon.size();i++){
			x+=plPolygon.get(i).x;	
			y+=plPolygon.get(i).y;	
		}
		x=x/plPolygon.size();
		y=y/plPolygon.size();
		
		return new TPointDouble(x,y);
	}
	
	//Roterer hele polygonet rundt senter.
	public void Rotate(int aRotation) {
		for(int i=0;i<plPolygon.size();i++){
			plPolygon.get(i).Rotate(ptCenter, aRotation);
		}
	}
	
	//Skalerer hele polygonet rundt senter.
	public void scale(double aScaled) {
		for(int i=0;i<plPolygon.size();i++){
			plPolygon.get(i).Scale(ptCenter, aScaled);
		}
	}

	
}
