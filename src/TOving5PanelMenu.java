package dat200;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TOving5PanelMenu extends JPanel{
	JButton cmbClear;
	JButton cmbRotatePlus;
	JButton cmbRotateMinus;
	JButton cmbscalePlus;
	JButton cmbscaleMinus;
	
	public TOving5PanelDraw pnlDraw;
	
	public TOving5PanelMenu(){
		// Clear knapp......
		cmbClear=new JButton("Clear...");
		cmbClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDraw.Clear();
			}
		});
		add(cmbClear);
		
		// Rotere knapp +......
		cmbRotatePlus = new JButton("Rotate +");
		cmbRotatePlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDraw.RotatePlus();
			}
		});
		add(cmbRotatePlus);
		
		cmbRotateMinus = new JButton("Rotate -");
		cmbRotateMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDraw.RotateMinus();
			}
		});
		add(cmbRotateMinus);
		
		cmbscalePlus = new JButton("Scale +");
		cmbscalePlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDraw.ScalePlus();
			}
		});
		add(cmbscalePlus);

		cmbscaleMinus = new JButton("Scale -");
		cmbscaleMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pnlDraw.ScaleMinus();
			}
		});
		add(cmbscaleMinus);

	}

	public TOving5PanelMenu(TOving5PanelDraw aPanelDraw) {
		this();
		pnlDraw=aPanelDraw;
	}

	
}

