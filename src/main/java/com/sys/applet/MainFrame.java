package com.sys.applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sys.applet.main.WellcomeFrame;
import com.sys.applet.main.account.AccountTree;
import com.sys.applet.main.diary.DiaryTree;
import com.sys.applet.main.income.IncomeTree;
import com.sys.applet.main.kind.KindTree;
import com.sys.applet.main.min.AddMessagePanel;
import com.sys.applet.main.min.SearchPanel;
import com.sys.applet.main.user.UserTree;

/** 
 * 登陆后主页面
 * @author dyong
 *
 */
public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 112547L;

	BorderLayout borderLayout1 = new BorderLayout();
    
	JLabel userOut = new JLabel("",JLabel.CENTER);
	
    JButton acc_button = new JButton();
    JButton in_button = new JButton();
    JButton kind_button = new JButton();
    JButton diary_button = new JButton();
//    JButton photo_button = new JButton();
    JButton user_button = new JButton();
    JButton out_button = new JButton();

    JPanel topF = new JPanel();
    JPanel mainF = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JOptionPane jop = new JOptionPane();
//    Icon icon=new ImageIcon(".\\src\\image\\1.gif");
//    Icon i=new ImageIcon(".\\src\\image\\user.ico");
//    JLabel lb = new JLabel(icon,JLabel.CENTER);
    
    public MainFrame(){
    	getContentPane().setLayout(borderLayout1);
    	topF.setBackground(new Color(204, 153, 102));//#4682B4

        mainF.setLayout(gridLayout1);
        this.setResizable(false);
        this.setTitle("会员卡号管理系统--"+ConstService.user.getName());
        
    	user_button.setBackground(Color.white);
    	user_button.setForeground(Color.blue);
    	user_button.setText("个人信息");
    	user_button.addMouseListener(new UserMouseAdapter());
    	
    	out_button.setBackground(Color.white);
    	out_button.setForeground(Color.blue);
    	out_button.setText("退出系统");
    	out_button.addMouseListener(new OutMouseAdapter());
    	
    	userOut.setText(" --"+ConstService.user.getName()) ;
    	
    	JButton input = new JButton();
    	input.setBackground(Color.white);
    	input.setForeground(Color.blue);
    	input.setText("录入");
    	input.addMouseListener(new CommonMouseAdapter(AddMessagePanel.class));
    	
    	JButton search = new JButton();
    	search.setBackground(Color.white);
    	search.setForeground(Color.blue);
    	search.setText("查询");
    	search.addMouseListener(new CommonMouseAdapter(SearchPanel.class));
//    	分隔符
    	String slip = "    |    " ;
    	
//    	部署按钮

    	topF.add(search);
		topF.add(new JLabel(slip)) ;
    	topF.add(input);
		topF.add(new JLabel(slip)) ;
//    	UserRank rank = ConstService.rank ;
//    	if(rank.accunt=='1'){
//    		topF.add(acc_button);
//    		topF.add(new JLabel(slip)) ;
//    	}
//    	if(rank.income=='1'){
//    		topF.add(in_button) ;
//    		topF.add(new JLabel(slip)) ;
//    	}
//    	if(rank.diary=='1'){
//        	topF.add(diary_button);
//    		topF.add(new JLabel(slip)) ;
//    	}
//    	if(rank.diary=='1'){
//        	topF.add(photo_button);
//    		topF.add(new JLabel(slip)) ;
//    	}
//    	if(rank.kind=='1'){
//    		topF.add(kind_button);
//    		topF.add(new JLabel(slip)) ;
//    	}
//    	topF.add(user_button);
//		topF.add(new JLabel(slip)) ;

//    	topF.add(userOut) ;
    	topF.add(out_button);
    	
    	this.getContentPane().add(mainF, java.awt.BorderLayout.CENTER);
    	this.getContentPane().add(topF, java.awt.BorderLayout.NORTH);
        
    	mainF.add(new WellcomeFrame());	//初次进入显示的欢迎信息	
    }

    private void commonMouseReleased(Class<?> clazz, MouseEvent e){
    	mainF.removeAll() ;
    	try {
			mainF.add((JPanel)clazz.newInstance()) ;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	mainF.validate() ;
    }
    private void accountMouseReleased(MouseEvent e){
    	mainF.removeAll() ;
    	mainF.add(new AccountTree()) ;
    	mainF.validate() ;
    }
    private void incomeMouseReleased(MouseEvent e){
    	mainF.removeAll() ;
    	mainF.add(new IncomeTree()) ;
    	mainF.validate() ;
    }
    private void kindMouseReleased(MouseEvent e){
    	mainF.removeAll() ;
    	mainF.add(new KindTree()) ;
    	mainF.validate() ;
    }
    private void diaryMouseReleased(MouseEvent e){
    	mainF.removeAll() ;
    	mainF.add(new DiaryTree()) ;
    	mainF.validate() ;
    }
    private void userMouseReleased(MouseEvent e){
    	mainF.removeAll() ;
    	mainF.add(new UserTree()) ;
    	mainF.validate() ;
    }
    @SuppressWarnings("static-access")
	private void outMouseReleased(MouseEvent e){
    	int rel=jop.showConfirmDialog(this,"你要退出系统吗？","退出",jop.YES_NO_OPTION ) ;
        if(rel==jop.YES_OPTION ){
            System.exit(0);
        }
    }

    class CommonMouseAdapter extends MouseAdapter{
    	private Class clazz ;
    	public CommonMouseAdapter(Class<?> class1) {
			this.clazz = class1 ;
		}

		public void mouseReleased(MouseEvent e) {
    		commonMouseReleased(clazz ,e);
        }
    }
    
    class AccountMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		accountMouseReleased(e);
        }
    }
    class IncomeMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		incomeMouseReleased(e);
        }
    }
    class KindMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		kindMouseReleased(e);
        }
    }
    class DiaryMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		diaryMouseReleased(e);
        }
    }
    class UserMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		userMouseReleased(e);
        }
    }
    class OutMouseAdapter extends MouseAdapter{
    	public void mouseReleased(MouseEvent e) {
    		outMouseReleased(e);
        }
    }
}
