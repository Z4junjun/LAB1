package lab1_2;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Javagui {

	public static void main(String[] args) {
		Javagui ja=new Javagui();
		ja.face();
	}
	public void face() {
		JFrame frame = new JFrame("LAB1_2");
        frame.setSize(400,350);
        frame.setLayout(null);
        Point p = new Point(500,200);
        frame.setLocation(p);
        
        JPanel pn1 = new JPanel();
        pn1.setBounds(0,0,385,60);
        pn1.setBorder(BorderFactory.createTitledBorder("Please input the file path:"));
        JTextField setpath = new JTextField("e.g. C:\\Users\\Apple\\Desktop\\c_testfile.txt",30);
        pn1.add(setpath);
        
        JPanel pn2 = new JPanel();
        pn2.setBounds(0,60,385,60);
        pn2.setBorder(BorderFactory.createTitledBorder("Please choose the level you want:"));
        pn2.setLayout(new GridLayout(2,2));
        JRadioButton bn1 = new JRadioButton("level 1");
    	JRadioButton bn2 = new JRadioButton("level 2");
    	JRadioButton bn3 = new JRadioButton("level 3");
    	JRadioButton bn4 = new JRadioButton("level 4");
    	pn2.add(bn1);
    	pn2.add(bn2);
    	pn2.add(bn3);
    	pn2.add(bn4);
    	ButtonGroup bn = new ButtonGroup();
		bn.add(bn1);
		bn.add(bn2);
		bn.add(bn3);
		bn.add(bn4);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0,120,385,60);
		pn3.setBorder(BorderFactory.createTitledBorder("Click here to begin"));
		JButton begin = new JButton("Check");
		pn3.add(begin);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0,180,385,130);
		pn4.setBorder(BorderFactory.createTitledBorder("The answer will be show here"));
		JTextArea out = new JTextArea(5,30);
		pn4.add(out);

		frame.add(pn1);
		frame.add(pn2);
		frame.add(pn3);
		frame.add(pn4);
        frame.setVisible(true);

		begin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Extract ex = new Extract();
				String path;
				int level = 0;
				if (e.getSource() == begin)
				{
					path = setpath.getText();
					if(bn1.isSelected()) {
						level = 1;
					}else if(bn2.isSelected()) {
						level = 2;
					}else if(bn3.isSelected()) {
						level = 3;
					}else if(bn4.isSelected()) {
						level = 4;
					}
					out.setText(ex.answer(path,level));
				}
			}
		});
	}
}
