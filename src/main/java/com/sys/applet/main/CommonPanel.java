package com.sys.applet.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sys.applet.util.XYConstraints;
import com.sys.applet.util.XYLayout;
import com.sys.spring.min.domain.Message;

/** 
 * by dyong 2010-9-21
 */
public class CommonPanel extends JPanel {

	private static final long serialVersionUID = 7110139687990358872L;
	
	XYLayout xYLayout1 = new XYLayout();
	 
	 public ArrayList<JLabel> labList = new ArrayList<JLabel>();
	 public ArrayList<JComponent> fieldList = new ArrayList<JComponent>();
	 
	 public ArrayList<JButton> buttonList = new ArrayList<JButton>();
	 
	 private JScrollPane jScrollPane1 = new JScrollPane();
	 public JTable table = new JTable();
	 public CommonPanel(){
	     xYLayout1.setWidth(800);
	     xYLayout1.setHeight(700);
		 this.setLayout(xYLayout1);
//	     this.setBackground(SystemColor.LIGHT_GRAY);
	     this.setBackground(SystemColor.controlLtHighlight);
	     
	 }
	 
	 /**
	  * 表单提交模板
	  * 单列，标签、文本框对应
	  * 最后一行以提交按钮结束
	  */
	 public void printFormModel(){
		 Font font = new Font("宋体", Font.PLAIN, 12) ;	//标签字体
		 int x_lab = 200 ;	//标签的X坐标
		 int x_text = 260 ;	//输入框的X坐标
		 int height_dif = 30 ;	//行间距
		 int y_start = 50 ;	//起始行Y坐标
		 
		 int y = 20 ;	//当前行Y坐标
		 for(int i=0;i<labList.size();i++){
			 y = y_start+height_dif*i ;
			 labList.get(i).setFont(font) ;
			 this.add(labList.get(i), new XYConstraints(x_lab, y, -1, -1));
		 }
		 for(int i=0;i<fieldList.size();i++){
			 int y_line = y_start+height_dif*i ;
//			 跳过空行
			 if(fieldList.get(i)!=null){
				 JComponent item = fieldList.get(i) ;
				 if(item instanceof JTextArea){
//					 item.setLineWrap(true) ;
					 item.setBackground(new Color(40,200,58)) ;
					 this.add(item, new XYConstraints(x_text, y_line, 300, 300));
					 y_line +=300 ;
				 } else {
					 this.add(item, new XYConstraints(x_text, y_line, 250, 20));
				 }
			 }
			 if(y < y_line){
				 y = y_line ;
			 }
		 }
		 
		 for(int i=0;i<buttonList.size();i++){
			 this.add(buttonList.get(i), new XYConstraints(x_lab+i*100, height_dif+y, -1, -1));
		 }
	 }
	 
	 /**
	  * 表格模板
	  * 查询表单 表格
	  */
	 public void printSearchTableModel(){
		 int y = 20 ;		//y坐标
		 int x_start = 80 ;	//X起始坐标
		 int y_hight = 30 ;	//行距间隔
		 
		 jScrollPane1.getViewport().setBackground(SystemColor.info);
		 jScrollPane1.getViewport().add(table);
		 
		 if(fieldList!=null && fieldList.size()>0){
			 int x_dif = 0 ;	//x坐标差值
			 for(int i=0;i<fieldList.size();i++){
				 JComponent item = fieldList.get(i) ;
				 if(item==null){
					 y=y+y_hight ;
					 x_dif = 0;
					 continue ;
				 }
				 if(item instanceof JLabel){
					 this.add(item, new XYConstraints(x_start+x_dif, y, -1, -1));
					 x_dif+=50 ;
				 } else if(item instanceof JButton){
					 this.add(item, new XYConstraints(x_start+x_dif, y, -1, -1));
					 x_dif+=80 ;
				 } else {
					 this.add(item, new XYConstraints(x_start+x_dif, y, 100, 20));
					 x_dif+=120 ;
				 }
			}
			y=y+y_hight ;
		}
		
		this.add(jScrollPane1, new XYConstraints(x_start, y, -1, -1));
	 }
	 
	 protected void showMessageDialog(String message){
		 JOptionPane.showMessageDialog(this, message) ;
	 }
	 
//   text
	public JTextField cardid = new JTextField();
	public JTextField name = new JTextField();
	public JTextField address = new JTextField();
	public JTextField person = new JTextField();
	public JTextField type = new JTextField();
	
	public JTextField ctime = new JTextField();
	public JTextField cmoney = new JTextField();
	public JTextField ctype = new JTextField();
	public JTextField cage = new JTextField();
	public JTextField used = new JTextField();
	
	public JTextField area = new JTextField();
	public JTextField web = new JTextField();
	public JTextField tel = new JTextField();
	public JTextField cz = new JTextField();
	public JTextField email = new JTextField();
	
	public JTextField weixin = new JTextField();
	public JTextField num = new JTextField();
	public JTextField others = new JTextField();

	protected void init(){
    	labList.add(new JLabel("卡号")) ;
    	labList.add(new JLabel("企业名称")) ;
    	labList.add(new JLabel("地址")) ;
    	labList.add(new JLabel("法人代表")) ;
    	labList.add(new JLabel("行业类别")) ;
    	
    	labList.add(new JLabel("注册时间")) ;
    	labList.add(new JLabel("注册资金")) ;
    	labList.add(new JLabel("企业性质")) ;
    	labList.add(new JLabel("经营年限")) ;
    	labList.add(new JLabel("业务范围")) ;
    	
    	labList.add(new JLabel("业务区域")) ;
    	labList.add(new JLabel("公司网站")) ;
    	labList.add(new JLabel("联系电话")) ;
    	labList.add(new JLabel("传真")) ;
    	labList.add(new JLabel("邮箱")) ;
    	
    	labList.add(new JLabel("微信")) ;
    	labList.add(new JLabel("员工人数")) ;
    	labList.add(new JLabel("其他信息")) ;
    	
        fieldList.add(cardid) ;
        fieldList.add(name) ;
        fieldList.add(address) ;
        fieldList.add(person) ;
        fieldList.add(type) ;

        fieldList.add(ctime) ;
        fieldList.add(cmoney) ;
        fieldList.add(ctype) ;
        fieldList.add(cage) ;
        fieldList.add(used) ;

        fieldList.add(area) ;
        fieldList.add(web) ;
        fieldList.add(tel) ;
        fieldList.add(cz) ;
        fieldList.add(email) ;

        fieldList.add(weixin) ;
        fieldList.add(num) ;
        fieldList.add(others) ;
	}

	protected Message getData(){
		Message msg = new Message() ;
		msg.setAddress(address.getText());
		msg.setArea(area.getText()) ;
		msg.setCage(cage.getText()) ;
    	msg.setCardid(cardid.getText());
    	msg.setCmoney(cmoney.getText());
    	msg.setCtime(ctime.getText());
    	msg.setCtype(ctype.getText());
    	msg.setCz(cz.getText());
    	msg.setEmail(email.getText());
    	msg.setName(name.getText());
    	msg.setNum(num.getText());
    	msg.setOthers(others.getText());
    	msg.setPerson(person.getText());
    	msg.setTel(tel.getText());
    	msg.setType(type.getText());
    	msg.setUsed(used.getText());
    	msg.setWeb(web.getText());
    	msg.setWeixin(weixin.getText());
    	
    	return msg ;
	}
}
