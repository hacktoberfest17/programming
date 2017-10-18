


import javax.swing.event.TableColumnModelEvent;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.RowFilter;

//
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

//
public class FTable extends JTable{

	private TableRowSorter<TableModel> sorter;
	private List<RowFilter<Object,Object>> sortList;

	private class ModdedTable extends DefaultTableModel{
		public ModdedTable(Object[][] rows, String[] columns){
			super(rows,columns);
		}
		
		@Override
		public boolean isCellEditable(int row, int column){
			return false;
		}
	}


	public FTable(Object[][] rows, String columns[]){
			

		setModel(new ModdedTable(rows,columns));
		sorter = new TableRowSorter<>(getModel());
		setRowSorter(sorter);
		setBorder(new EtchedBorder(EtchedBorder.RAISED));
		setGridColor(Color.BLACK);
		setFillsViewportHeight(true);
		sortList = new ArrayList<RowFilter<Object,Object>>();
	}

	public FTable(TableModel model){
		
		setModel(model);
		sorter = new TableRowSorter<>(getModel());
		setRowSorter(sorter);
		setBorder(new EtchedBorder(EtchedBorder.RAISED));
		setGridColor(Color.BLACK);
		setFillsViewportHeight(true);
		sortList = new ArrayList<RowFilter<Object,Object>>();	

	}


	public void addToSortList(RowFilter<Object,Object> row){
		sortList.add(row);
	}

	public void setSortList(List<RowFilter<Object,Object>> sortList){
		this.sortList = sortList;
	}

	public List<RowFilter<Object,Object>> setSortList(){
		return sortList;
	}

	//OBS:
	//Postion and column must be the same
	
	public void updateSortList(int column, String text){
		sortList.set(column,RowFilter.regexFilter(text,column));

		sorter.setRowFilter(RowFilter.andFilter(sortList));
	}







}