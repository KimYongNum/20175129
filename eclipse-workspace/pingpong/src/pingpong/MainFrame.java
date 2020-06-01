package pingpong;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainFrame {

	JFrame frame;
	MainPanel panel;
	JButton endbutton;
	Timer timer;
	int tmppanelx;

	public static void main(String[] args) {
		new MainFrame();
	}
	public MainFrame() {


		frame = new JFrame("PEAK DETECTION"); // ������ ��ü ���� �� �̸� ����
		panel = new MainPanel(); // �г� ��ü ����
		panel.setLayout(null); // �г� ���̾ƿ� ���� ����
		panel.setBounds(0,0,50000,1000); // �г��� ũ�� �� ��ġ ����

		// ����  ��2(������ ���հ� ������ ���ÿ�)
		panel.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(arg0.getX() + " "+arg0.getY());
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				panel.setCursor(new Cursor(Cursor.HAND_CURSOR));				
			}
			public void mouseExited(MouseEvent arg0) 
			{
				panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent me) 
			{
				tmppanelx = me.getX();
			}
			public void mouseReleased(MouseEvent arg0)	{}					
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� �ݱ��ư Ŭ�� �� ��� â ������
		frame.setBounds(5, 5, 1500, 1000); // �������� ũ�� �� ��ġ ����

		// ������(���� Ŭ������ ���� �߰�)
		endbutton = new JButton("����");
		endbutton.setBounds(frame.getWidth()/2-50,900,100,50);
		endbutton.addActionListener(new EndListener());
		
		panel.add(endbutton);

		frame.getContentPane().add(panel); // �����ӿ� �����г��� ���ϱ� (â���� ��ȭ���ϳ� ��� ��ȭ�����)
		frame.setVisible(true); // ������ ���̰Բ�
		
		timer = new Timer(100,new timerListener());		// 100ms �ֱ�� timerListener ����
	}
	public class EndListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			frame.dispose();		//â ���ֱ�
		}		
	}
	
	public class timerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hello");			//���� �ð����� ���ϰ� ���� �۵� �ֱ�
		}
		
	}
	// �гκ�
	public class MainPanel extends JPanel
	{
		Circle cir;

		public MainPanel()
		{
			cir = new Circle();
		}

		public void paintComponent(Graphics g) {

			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(), this.getHeight()-80);
			//�г��� ũ��, ��ġ, ��  ����

			g.drawOval(cir.x, cir.y, cir.width, cir.height);
			//���� ��ġ, ũ�� ����

			//���ǿ� �´� �� �� ����

			//�� ��ĥ
			g.fillOval(cir.x, cir.y, cir.width, cir.height);

		}
	}

	public class Circle {

		int x = 0, y = 0;		//x,y ��ǥ

		int width = 50, height = 50;		//�ʺ� ����

		int xDirec = 2, yDirec = 2;		//x,y�������� �����̴� �ӵ�

		int radious = 25;
	}
	
}
