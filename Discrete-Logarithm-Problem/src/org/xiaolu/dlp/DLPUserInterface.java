package org.xiaolu.dlp;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DLPUserInterface extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final int windowWidth=250,windowsHeight=250;
	private Container container;
	private JLabel textOfPrimitiveElement,textOfCyclicGroup,textOfstar,textOfb,textOfDL,textOfResult;
	private JTextField primitiveElement,cyclicGroup,b,result;
	private JButton buttonOfBabyStepGiantStep,buttonOfPollardsPho;
	private JPanel primitiveElementPanel,cyclicGroupPanel,DLPanel,button1Panel,button2Panel,resultPanel;
	public DLPUserInterface() {
		this.setTitle("离散对数问题");
		this.setSize(windowWidth, windowsHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(6,1));
		container=getContentPane();
		this.initPanel();
		this.initTextField();
		this.initLabel();
		this.initButton();
		this.drawPanel();
	}
	private void initPanel() {
		primitiveElementPanel=new JPanel();
		cyclicGroupPanel=new JPanel();
		DLPanel=new JPanel();
		button1Panel=new JPanel();
		button2Panel=new JPanel();
		resultPanel=new JPanel();
	}
	private void initLabel() {
		textOfPrimitiveElement=new JLabel("生成元：a=");
		textOfCyclicGroup=new JLabel("循环群：G= Z");
		textOfstar=new JLabel("*");
		textOfb=new JLabel("求b=");
		textOfDL=new JLabel("的离散对数");
		textOfResult=new JLabel("结果为：");
		
	}
	private void initTextField() {
		primitiveElement=new JTextField(5);
		cyclicGroup=new JTextField(5);
		b=new JTextField(5);
		result=new JTextField(5);
	}
	private void initButton() {
		buttonOfBabyStepGiantStep=new JButton("用Baby-Step-Giant-Step计算");
		buttonOfPollardsPho=new JButton("用Pollard's Pho计算");
		buttonOfBabyStepGiantStep.addActionListener(this);
		buttonOfPollardsPho.addActionListener(this);
	}
	private void drawPanel() {
		primitiveElementPanel.add(textOfPrimitiveElement);
		primitiveElementPanel.add(primitiveElement);
		cyclicGroupPanel.add(textOfCyclicGroup);
		cyclicGroupPanel.add(cyclicGroup);
		cyclicGroupPanel.add(textOfstar);
		DLPanel.add(textOfb);
		DLPanel.add(b);
		DLPanel.add(textOfDL);
		button1Panel.add(buttonOfBabyStepGiantStep);
		button2Panel.add(buttonOfPollardsPho);
		resultPanel.add(textOfResult);
		resultPanel.add(result);
		container.add(primitiveElementPanel);
		container.add(cyclicGroupPanel);
		container.add(DLPanel);
		container.add(button1Panel);
		container.add(button2Panel);
		container.add(resultPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getActionCommand().equals("用Baby-Step-Giant-Step计算")) {
				DLPBabyStepGiantStep bsgs=new DLPBabyStepGiantStep();
				Integer resInt=bsgs.getDLPResult(new Integer(cyclicGroup.getText()),new Integer(primitiveElement.getText()),new Integer(b.getText()));
				result.setText(resInt.toString());
			}
			else if(e.getActionCommand().equals("用Pollard's Pho计算")) {
				DLPPollardsPho pol=new DLPPollardsPho();
				Integer resInt=pol.getDLPResult(new Integer(cyclicGroup.getText()),new Integer(primitiveElement.getText()),new Integer(b.getText()));
				result.setText(resInt.toString());
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(getParent(),exc.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
