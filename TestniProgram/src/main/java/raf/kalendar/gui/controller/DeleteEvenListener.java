package raf.kalendar.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

import raf.kalendar.calendar_componentrs.model.EventFactory;
import raf.kalendar.gui.view.ScheduleView;

public class DeleteEvenListener implements ActionListener {

	private ScheduleView scheduleView;
	private EventFactory eventFactory;

	public DeleteEvenListener(ScheduleView scheduleView) {
		this.scheduleView = scheduleView;
	}

	public void actionPerformed(ActionEvent arg0) {
		((DefaultTableModel) scheduleView.getTable().getModel()).removeRow(scheduleView.getTable().getSelectedRow());
	}

}
