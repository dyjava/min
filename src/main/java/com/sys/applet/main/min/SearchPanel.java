package com.sys.applet.main.min;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.applet.util.XYConstraints;
import com.sys.spring.min.domain.Message;

/** 
 * by dyong 2010-9-1
 */
public class SearchPanel extends CommonPanel{
	private static final long serialVersionUID = 8094222460871915784L;
	
	private JTextField searchid = new JTextField();
        
    public SearchPanel() {
    	fieldList.add(new JLabel("查询卡号：")) ;
    	fieldList.add(searchid) ;

        JButton submitBut = new JButton();
        submitBut.setText("提交");
        submitBut.addActionListener(new SubmitActionAdapter());
        fieldList.add(submitBut) ;
        
        super.printSearchTableModel() ;
        searchid.grabFocus() ;
        
        this.add(new JLabel("查询结果："), new XYConstraints(200, 30, 100, 20));
        
        init() ;
        super.printFormModel() ;
   }

    /**
     * 查询 显示
     * @param e
     */
    private void submitAction(ActionEvent e) {
    	String id = searchid.getText() ;
    	if(id.trim().length()==0){
    		String message = "请填写查询卡号" ;
			JOptionPane.showMessageDialog(this, message) ;
    	} else {
	    	Message msg = new Message() ;
	    	msg.setCardid(id);
	    	List<Message> list = ConstService.minService.findMessageByMessage(msg) ;
	    	if(list.size()>0){
	    		msg = list.get(0) ;
	    		setData(msg) ;
	    	}
    	}
    }
    
    class SubmitActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e);
        }
    }
}
