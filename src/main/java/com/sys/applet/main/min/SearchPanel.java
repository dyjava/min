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
	
	JComboBox kindBox = new JComboBox();
    JTextField beginTimeText = new DateChooserJTextField();
    JTextField endTimeText = new DateChooserJTextField();
        
    public SearchPanel() {
    	super.init();
    	
    	super.printFormModel() ;
        cardid.grabFocus() ;
   }

    /**
     * 查询 显示
     * @param e
     */
    private void submitAction(ActionEvent e) {
    	String begin = beginTimeText.getText() ;
    	String end = endTimeText.getText() ;

    }
    
    class SubmitActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e);
        }
    }
}
