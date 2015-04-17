package com.sys.applet.main.min;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.applet.util.XYConstraints;
import com.sys.spring.min.domain.Message;
import com.sys.spring.min.service.MinService;

/** 
 * by dyong 2010-9-1
 */
public class AddMessagePanel extends CommonPanel{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public AddMessagePanel() {
    	this.add(new JLabel("数据录入"), new XYConstraints(200, 20, 100, 20));
    	//初始化表单
    	init() ;
    	
//        按钮      button
        JButton submitBut = new JButton();
        JButton cancleBut = new JButton();
        
        submitBut.setText("提交");
        submitBut.addActionListener(new SubmitButtonActionAdapter());
        
        cancleBut.setText("取消");
        cancleBut.addActionListener(new CancelButtonActionAdapter());
        buttonList.add(submitBut) ;
        buttonList.add(cancleBut) ;
        super.printFormModel() ;
        cardid.grabFocus() ;
    }

    private void cancelAction(ActionEvent e) {
    	clear() ;
    }
    private void submitAction(ActionEvent e) {
    	String message = "" ;
    	String title	= cardid.getText() ;
    	String cname	= name.getText() ;
//    	String caddress	= address.getText() ;
    	String ctel		= tel.getText() ;
    	
    	if(title==null || cname==null || ctel==null || 
      			title.length()==0 || cname.length()==0 || ctel.length()==0){
    		message = "信息不完整" ;
    	} else {
    		MinService minservice = ConstService.minService ;
    		
    		//获取表单数据
    		Message msg = getData() ;
			int re = minservice.addMessage(msg) ;
			if(re==1){
				message = "添加成功" ;
			} else {
				message = "添加失败" ;
			}
    		clear() ;
    	}
    	JOptionPane.showMessageDialog(this, message) ;
    }
    private void clear(){
    	for(JComponent item:fieldList){
    		((JTextField)item).setText("") ;
    	}
    	cardid.grabFocus() ;
    }

    class SubmitButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submitAction(e) ;
        }
    }

    class CancelButtonActionAdapter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cancelAction(e);
        }
    }
    
}
