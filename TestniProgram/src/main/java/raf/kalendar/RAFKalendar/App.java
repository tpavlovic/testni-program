package raf.kalendar.RAFKalendar;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.json.simple.parser.ParseException;

import raf.kalendar.gui.controller.ImportDataActionListener;

public class App extends JFrame{
	
	
	private static App myInstance;
	JButton temp_imp;

    // the constructor
    private App() throws ParseException {
    	this.setTitle("ScheduleSync");
        this.setSize(1200, 1200);
        this.setLayout(new BorderLayout());
        
        temp_imp = new JButton("Import");
        temp_imp.addActionListener(new ImportDataActionListener());
        temp_imp.setSize(250, 90);
        this.add(temp_imp, BorderLayout.CENTER);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static App getInstance() throws ParseException {
        if (myInstance == null)
            myInstance = new App();

        return myInstance;
    }

	public static void main(String[] args) throws ParseException {
		App.getInstance();
	}
	
	public JButton getTemp_imp() {
		return temp_imp;
	}

}
