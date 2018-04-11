package raf.kalendar.gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.json.simple.parser.ParseException;

import raf.kalendar.gui.controller.AddNewEventListener;
import raf.kalendar.gui.controller.DeleteEvenListener;
import raf.kalendar.gui.controller.ImportDataActionListener;
import raf.kalendar.calendar_componentrs.import_export_impl.SheduleImportExportJsonImplementation;
import raf.kalendar.calendar_componentrs.model.JsonHandler;
import raf.kalendar.calendar_componentrs.model.Schedule;

public class ScheduleView extends JPanel {

	private DefaultTableModel dtm;
	private JPanel editingPanel;
	private JButton addButton;
	private JButton deleteButton;
	private JButton importButton;
	private JButton exportButton;
	private JTable table;
	private JsonHandler jhandle;
	private String[] col_names;
	private Object[][] data;
	
	JTextField[] fields = new JTextField[100];

	public ScheduleView(String path) throws ParseException {
		super();
		this.setSize(400, 400);

		jhandle = new JsonHandler();
		col_names = jhandle.getObjectFromFile(path).toArray(new String[0]);
		data = jhandle.getDataFromFile(path);
		dtm = new DefaultTableModel(data, col_names);
		table = new JTable(dtm);
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane, BorderLayout.NORTH);

		this._initEditPanel();

	}

	private void _initEditPanel() {
		this.editingPanel = new JPanel();
		this.editingPanel.setLayout(new BorderLayout());

		this.addButton = new JButton("ADD");
		this.deleteButton = new JButton("DELETE");
		this.importButton = new JButton("IMPORT");
		this.exportButton = new JButton("EXPORT");

		addButton.addActionListener(new AddNewEventListener(this));
		deleteButton.addActionListener(new DeleteEvenListener(this));
		importButton.addActionListener(new ImportDataActionListener());

		// Add panel for buttons
		JPanel buttonsPanel = new JPanel();

		buttonsPanel.add(addButton);
		buttonsPanel.add(deleteButton);
		buttonsPanel.add(importButton);
		buttonsPanel.add(exportButton);

		JPanel fieldsPanel = new JPanel();
		for (int i = 0; i < col_names.length ; i++) {
			   fields[i] = new JTextField(col_names[i], 10);
			   fieldsPanel.add(fields[i]);
		}

		this.editingPanel.add(buttonsPanel, BorderLayout.CENTER);
		this.editingPanel.add(fieldsPanel, BorderLayout.SOUTH);
		this.add(editingPanel, BorderLayout.CENTER);
	}

	public JPanel getEditingPanel() {
		return editingPanel;
	}

	public void setEditingPanel(JPanel editingPanel) {
		this.editingPanel = editingPanel;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

	public JButton getImportButton() {
		return importButton;
	}

	public void setImportButton(JButton importButton) {
		this.importButton = importButton;
	}

	public JButton getExportButton() {
		return exportButton;
	}

	public void setExportButton(JButton exportButton) {
		this.exportButton = exportButton;
	}
	
	public JTable getTable() {
		return table;
	}
	
	public DefaultTableModel getDtm() {
		return dtm;
	}

}
