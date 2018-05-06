package org.xiaolu.squaremultiply;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SquareAndMultiplyUserInterface extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int windowWidth=300,windowsHeigth=150;
	private Container con;
	private JPanel calcPanel,resultPanel,buttonPanel;
	private JLabel calcLabel,multiLabel,modLabel,resLabel;
	private JTextField baseText,expText,modText,resText;
	private JButton calcButton,clearButton;
	public SquareAndMultiplyUserInterface(){
		this.setTitle("平方乘算法");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(this.windowWidth,this.windowsHeigth);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3,1));
		con=this.getContentPane();
		this.setPanel();
		this.setCalcAreaItem();
		this.setResultAreaItem();
		this.setButtonAreaItem();
		this.addPanelToFrame();
	}
	private void setPanel() {
		this.calcPanel=new JPanel();
		this.resultPanel=new JPanel();
		this.buttonPanel=new JPanel();
	}
	private void setCalcAreaItem() {
		this.calcLabel=new JLabel("计算：");
		this.baseText=new JTextField(3);
		this.multiLabel=new JLabel("^");
		this.expText=new JTextField(5);
		this.modLabel=new JLabel("mod");
		this.modText=new JTextField(5);
		this.calcPanel.add(calcLabel);
		this.calcPanel.add(baseText);
		this.calcPanel.add(multiLabel);
		this.calcPanel.add(expText);
		this.calcPanel.add(modLabel);
		this.calcPanel.add(modText);
	}
	private void setResultAreaItem() {
		this.resLabel=new JLabel("结果：");
		this.resText=new JTextField(5);
		this.resultPanel.add(resLabel);
		this.resultPanel.add(resText);
	}
	private void setButtonAreaItem() {
		this.calcButton=new JButton("计算");
		this.clearButton=new JButton("清空");
		this.calcButton.addActionListener(this);
		this.clearButton.addActionListener(this);
		this.buttonPanel.add(calcButton);
		this.buttonPanel.add(clearButton);
	}
	private void addPanelToFrame() {
		con.add(calcPanel);
		con.add(resultPanel);
		con.add(buttonPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("清空")) {
			this.baseText.setText("");
			this.expText.setText("");
			this.modText.setText("");
			this.resText.setText("");
		}
		else if(e.getActionCommand().equals("计算")) {
			int baseElement,exponent,modulus;
			baseElement=new Integer(this.baseText.getText());
			exponent=new Integer(this.expText.getText());
			modulus=new Integer(this.modText.getText());
			SquareAndMultiplyCalc calc=new SquareAndMultiplyCalc(baseElement,exponent,modulus);
			this.resText.setText(calc.getSquareAndMultipyResult().toString());
		}
	}
}