package org.xiaolu.doubleadd;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ECDoubleAndAddUserInterface extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private int windowWidth=300,windowsHeigth=275;
	private Container con;
	private JPanel ecPanel,pointPanel,mulPanel,resultPanel,buttonPanel;
	private JLabel ecpLabel,ecaLabel,ecbLabel,leftLabel,rightLabel,mulLabel,resLabel;
	private JTextField ecpText,ecaText,ecbText,pointTextx,pointTexty,mulText,resTextx,resTexty;
	private JButton calcButton,clearButton;
	public ECDoubleAndAddUserInterface(){
		this.setTitle("椭圆曲线 - 双重加算法");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(this.windowWidth,this.windowsHeigth);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(5,1));
		con=this.getContentPane();
		this.setPanel();
		this.setECAreaItem();
		this.setPointAreaItem();
		this.setMulAreaItem();
		this.setResultAreaItem();
		this.setButtonAreaItem();
		this.addPanelToFrame();
	}
	private void setPanel() {
		this.ecPanel=new JPanel();
		this.pointPanel=new JPanel();
		this.mulPanel=new JPanel();
		this.resultPanel=new JPanel();
		this.buttonPanel=new JPanel();
	}
	private void setECAreaItem() {
		this.ecpLabel=new JLabel("EC参数：p=");
		this.ecpText=new JTextField(3);
		this.ecaLabel=new JLabel("a=");
		this.ecaText=new JTextField(3);
		this.ecbLabel=new JLabel("b=");
		this.ecbText=new JTextField(3);
		this.ecPanel.add(ecpLabel);
		this.ecPanel.add(ecpText);
		this.ecPanel.add(ecaLabel);
		this.ecPanel.add(ecaText);
		this.ecPanel.add(ecbLabel);
		this.ecPanel.add(ecbText);
	}
	private void setPointAreaItem() {
		leftLabel=new JLabel("P点坐标：x=");
		pointTextx=new JTextField(3);
		rightLabel=new JLabel("y=");
		pointTexty=new JTextField(3);
		pointPanel.add(leftLabel);
		pointPanel.add(pointTextx);
		pointPanel.add(rightLabel);
		pointPanel.add(pointTexty);
	}
	private void setMulAreaItem() {
		mulLabel=new JLabel("倍数：");
		mulText=new JTextField(3);
		mulPanel.add(mulLabel);
		mulPanel.add(mulText);
	}
	private void setResultAreaItem() {
		this.resLabel=new JLabel("结果：");
		this.resTextx=new JTextField(3);
		this.resTexty=new JTextField(3);
		this.resultPanel.add(resLabel);
		this.resultPanel.add(resTextx);
		this.resultPanel.add(resTexty);
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
		con.add(ecPanel);
		con.add(pointPanel);
		con.add(mulPanel);
		con.add(resultPanel);
		con.add(buttonPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("清空")) {
			ecpText.setText("");
			ecaText.setText("");
			ecbText.setText("");
			pointTextx.setText("");
			pointTexty.setText("");
			mulText.setText("");
			resTextx.setText("");
			resTexty.setText("");
		}
		else if(e.getActionCommand().equals("计算")) {
			Integer p=new Integer(ecpText.getText());
			Integer a=new Integer(ecaText.getText());
			Integer b=new Integer(ecbText.getText());
			Integer pointX=new Integer(pointTextx.getText());
			Integer pointY=new Integer(pointTexty.getText());
			Integer mul=new Integer(mulText.getText());
			ECDoubleAndAddCalc calc=new ECDoubleAndAddCalc(p,a,b,pointX,pointY,mul);
			Integer[] result=calc.getECDoubleAndAddResult();
			resTextx.setText(result[0].toString());
			resTexty.setText(result[1].toString());
		}
	}
}
