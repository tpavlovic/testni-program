package raf.kalendar.gui.controller;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import org.json.simple.parser.ParseException;

import raf.kalendar.RAFKalendar.App;
import raf.kalendar.calendar_componentrs.model.Schedule;
import raf.kalendar.gui.view.ScheduleView;

public class ImportDataActionListener implements ActionListener {


	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		String path = "";
		ScheduleView shScheduleView;
		
		int returnVal = 0;
		try {
			returnVal = chooser.showOpenDialog(App.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Schedule schedule = null;
			try {
				path = chooser.getSelectedFile().getAbsolutePath();
				App.getInstance().getTemp_imp().setVisible(false);
				shScheduleView = new ScheduleView(path);
				App.getInstance().add(shScheduleView, BorderLayout.NORTH);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}

}
