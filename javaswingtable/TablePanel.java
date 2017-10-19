import java.text.ParseException;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.swing.JPanel;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComponent;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.RowFilter;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
public class TablePanel extends JPanel{
	private JPanel filters;
	private JCheckBox sensitive[];
	private JTable table;
	private JTextField queryFields[];
	private JTextField secondDateFields[];
	private List<RowFilter<Object,Object>> sortList;
	private List<RowFilter<Object,Object>> sortDate;
	private String formatIfDate;
	public TablePanel(Object[][] rows, String columns[]){
		table = new FTable(rows,columns);
		table.getTableHeader().setReorderingAllowed(false);
		sortList = new ArrayList<RowFilter<Object,Object>>();
		sortDate = new ArrayList<RowFilter<Object,Object>>();
		formatIfDate = "dd/MM/yyyy";

	}

	public TablePanel(JTable table){
		formatIfDate = "dd/MM/yyyy";

		this.table = table;
		table.getTableHeader().setReorderingAllowed(false);
		sortList = new ArrayList<RowFilter<Object,Object>>();
				sortDate = new ArrayList<RowFilter<Object,Object>>();

		initUI();
	}

	public TablePanel(JTable table,String format){
		formatIfDate = format;

		this.table = table;
		table.getTableHeader().setReorderingAllowed(false);
		sortList = new ArrayList<RowFilter<Object,Object>>();
				sortDate = new ArrayList<RowFilter<Object,Object>>();

		initUI();
	}


	@SuppressWarnings("unchecked")
	public void queryChanged(int index){
		String text = queryFields[index].getText();
		if(table.getColumnClass(index).equals(Date.class)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatIfDate);
				String text2 = secondDateFields[index].getText();

				if(text2.equals("") && !text.equals("")){

					try{
					sortList.set(index,RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL,dateFormat.parse(text),index));
					}catch(ParseException e){
						System.out.println("Error");
					}
				}else if(text.equals("") && !text2.equals("")){
						try{

					sortList.set(index,RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL,dateFormat.parse(text2),index));

					}catch(ParseException e){

						System.out.println("Error");
					}				
				}else if(text.equals("") && text2.equals("")){

					sortList.set(index,RowFilter.regexFilter(text,index));
					
				}else{
						try{

						sortDate = new ArrayList<RowFilter<Object,Object>>();

						sortDate.add(RowFilter.dateFilter(RowFilter.ComparisonType.AFTER,dateFormat.parse(text),index));
						sortDate.add(RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE,dateFormat.parse(text2),index));
						sortList.set(index,RowFilter.andFilter(sortDate));

					}catch(ParseException e){

						System.out.println("Error");
						//sortList.set(index,RowFilter.regexFilter(text,index));
					}						
				}
			//}
		}else{

		if(sensitive[index].isSelected())
			sortList.set(index,RowFilter.regexFilter(text,index));
		else
			sortList.set(index,RowFilter.regexFilter("(?i)"+text,index));
	}
		((TableRowSorter<TableModel>)table.getRowSorter()).setRowFilter(RowFilter.andFilter(sortList));
	}


	public void initListeners(JComponent component,int index){
		if(component instanceof JTextField){
			((JTextField)component).getDocument().addDocumentListener(new DocumentListener(){
				final int i = index;
				public void changedUpdate(DocumentEvent e){
					queryChanged(i);
				}
				public void removeUpdate(DocumentEvent e){
					queryChanged(i);
				}
				public void insertUpdate(DocumentEvent e){
					queryChanged(i);
				}

			});
		}else if(component instanceof JCheckBox){
			((JCheckBox)component).addItemListener(new ItemListener(){
				final int i = index;
				public void itemStateChanged(ItemEvent e){
					//Trigger change on JTextField
					queryChanged(i);
				}
			});
		}
	}

	public void initUI(){
		queryFields = new JTextField[table.getColumnCount()];
		secondDateFields = new JTextField[table.getColumnCount()];
		sensitive = new JCheckBox[table.getColumnCount()];
		filters = new JPanel();
		filters.setLayout(new BoxLayout(filters,BoxLayout.X_AXIS));

		//filters = new JPanel(new BoxLayout(filters,BoxLayout.X_AXIS));
		for(int i = 0; i < table.getColumnCount();i++){
			queryFields[i] = new JTextField();
			//sensitive[i] = new JCheckBox();
			if(table.getColumnClass(i).equals(Date.class)){

			table.getColumnModel().getColumn(i).setCellRenderer(new AwesomeRender());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			secondDateFields[i] = new JTextField();
			initListeners(secondDateFields[i],i);
			initListeners(queryFields[i],i);
			initListeners(sensitive[i],i);
			JPanel aux = new JPanel();
			JPanel helper = new JPanel();
			helper.setLayout(new BoxLayout(helper,BoxLayout.Y_AXIS));
			helper.add(queryFields[i]);
			helper.add(secondDateFields[i]);
			filters.add(helper);

			try{
				sortDate.add(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL,dateFormat.parse(queryFields[i].getText()),i));
				sortDate.add(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL,dateFormat.parse(secondDateFields[i].getText()),i));
				//sortList.add(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL,dateFormat.parse(queryFields[i].getText()),i));
				sortList.add(RowFilter.andFilter(sortDate));
			}catch(ParseException e){
				System.out.println("sem parse");

				sortList.add(RowFilter.regexFilter(queryFields[i].getText(),i));
			}
			}else{
				sensitive[i] = new JCheckBox();
				initListeners(queryFields[i],i);
				initListeners(sensitive[i],i);
				filters.add(sensitive[i]);			
				filters.add(queryFields[i]);

				sortList.add(RowFilter.regexFilter(queryFields[i].getText(),i));
			}

		}

		setLayout(new BorderLayout());
		JScrollPane scrollpane = new JScrollPane(table);
		add(filters,BorderLayout.NORTH);
		add(scrollpane,BorderLayout.CENTER);

	}


	private class AwesomeRender extends DefaultTableCellRenderer{
		SimpleDateFormat f = new SimpleDateFormat(formatIfDate);
		
		public void setFormat(SimpleDateFormat f){
			this.f = f;
		}
		@Override
   	    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        	if( value instanceof Date) {
            	value = f.format(value);
        	}
        	return super.getTableCellRendererComponent(table, value, isSelected,
           	hasFocus, row, column);
    	}

	}



}