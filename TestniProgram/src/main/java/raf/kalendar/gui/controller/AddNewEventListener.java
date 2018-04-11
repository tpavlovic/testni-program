package raf.kalendar.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import raf.kalendar.calendar_componentrs.model.Event;
import raf.kalendar.calendar_componentrs.model.EventFactory;
import raf.kalendar.gui.view.ScheduleView;

public class AddNewEventListener implements ActionListener {

	private ScheduleView scheduleView;
	private EventFactory eventFactory;

	public AddNewEventListener(ScheduleView scheduleView) {
		this.scheduleView = scheduleView;
	}

	public void actionPerformed(ActionEvent arg0) {
		/*String title = scheduleView.getTitleField().getText();
		String description = scheduleView.getDescriptionField().getText();
		LocalDateTime startActivity = LocalDateTime.parse(scheduleView.getStartActivityField().getText());
		LocalDateTime endActivity = LocalDateTime.parse(scheduleView.getEndActivityField().getText());
		String type = scheduleView.getTypeField().getText();
		scheduleTableModel.addRow(new Object[] { title, description, startActivity, endActivity, type });*/
	}

}
