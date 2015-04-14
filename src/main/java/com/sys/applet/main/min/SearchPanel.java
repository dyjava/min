package com.sys.applet.main.min;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.applet.util.DateChooserJTextField;
import com.sys.applet.util.DoubleUtil;
import com.sys.applet.util.TableFactory;
import com.sys.spring.account.domain.Account;
import com.sys.spring.account.domain.Kind;

/** 
 * by dyong 2010-9-1
 */
public class SearchPanel extends CommonPanel{
	private static final long serialVersionUID = 8094222460871915784L;
	
	JTextField titleText = new JTextField() ;
	JTextField moneyText = new JTextField() ;
	JComboBox kindBox = new JComboBox();
    JTextField beginTimeText = new DateChooserJTextField();
    JTextField endTimeText = new DateChooserJTextField();
    private List<Kind> kindList ;
    
//	table
    List<List<Object>> data = new ArrayList<List<Object>>() ;
    
    public SearchPanel() {
//    	button
        JButton submitButton = new JButton();
        submitButton.setText("确定");
        submitButton.addActionListener(new SubmitActionAdapter());
        
    	fieldList.add(new JLabel("名称")) ;
    	fieldList.add(titleText) ;
    	fieldList.add(new JLabel("价格")) ;
    	fieldList.add(moneyText) ;
    	fieldList.add(submitButton) ;
    	
//        table
    	List<String> title = new ArrayList<String>() ;
    	title.add("ID") ;
    	title.add("名称") ;
    	title.add("价格(元)") ;
    	title.add("类别") ;
    	title.add("日期") ;
        table = TableFactory.createtable(title, data);
        table.addMouseListener(new TableMouseListener()) ;
        
        super.printSearchTableModel() ;
        
    }

    /**
     * 查询 显示
     * @param e
     */
    private void submitAction(ActionEvent e) {
    	String begin = beginTimeText.getText() ;
    	String end = endTimeText.getText() ;

    	Account acc = new Account() ;
    	String title = titleText.getText() ;
    	if(title!=null && title.length()>0){
    		acc.setTitle(title) ;
    	}
    	String money = moneyText.getText() ;
    	if(money!=null && money.trim().length()>0){
    		acc.setMoney(Double.parseDouble(money)) ;
    	}
    	int index = kindBox.getSelectedIndex() ;
    	if(index>0){
        	Kind kind = kindList.get(index-1) ;
    		acc.setKindid(kind.getUid()) ;
    		acc.setKid(kind.getId());
    	}
    	
    	data = getData(begin, end, acc) ;
        TableFactory.freshTableData(table, data) ;
    }
    
//    查询结果输出到表格
    private List<List<Object>> getData(String begin, String end,Account account){
    	List<List<Object>> data = new ArrayList<List<Object>>() ;
    	
    	List<Account> accList = ConstService.accService.findAccountList(begin, end, account) ;
    	
    	double allMoney = 0 ;
    	int count = 0 ;
        if(accList!=null)
        for(int i=0;i<accList.size();i++){
        	List<Object> l = new ArrayList<Object>() ;
        	Account acc = accList.get(i) ;
        	l.add(acc.getId()) ;
        	l.add(acc.getTitle()) ;
        	l.add(DoubleUtil.money(acc.getMoney())) ;
        	l.add(acc.getKindtitle()) ;
        	l.add(acc.getDatetime()) ;
        	data.add(l) ;
        	count ++ ;
        	allMoney+=acc.getMoney() ;
        }
        List<Object> l = new ArrayList<Object>() ;
        l.add("总计") ;
        l.add(count+"笔") ;
        l.add(DoubleUtil.money(allMoney)) ;
        l.add("") ;
        l.add("") ;
        data.add(l) ;
        return data ;
    }

    class SubmitActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e);
        }
    }
    class TableMouseListener extends MouseAdapter  {
    	public void mouseClicked(MouseEvent e){
    		int clickTimes = e.getClickCount();
    		if (clickTimes >= 1){
    			JTable table = (JTable)e.getSource() ;
    			int allRow = table.getRowCount() ;
    			int row = table.getSelectedRow() ;
//    			int col = table.getSelectedColumn() ;
    			int id = Integer.parseInt(data.get(row).get(0).toString()) ;
//    			System.out.println("Doublc Clicked!"+row+"/"+uid);
    			
//    			进入详细页面
    			if(row<allRow-1){
    			}
    		}
    	}
	}
}
