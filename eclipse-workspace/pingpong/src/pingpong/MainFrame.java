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


		frame = new JFrame("PEAK DETECTION"); // 프레임 객체 생성 및 이름 설정
		panel = new MainPanel(); // 패널 객체 생성
		panel.setLayout(null); // 패널 레이아웃 설정 없음
		panel.setBounds(0,0,50000,1000); // 패널의 크기 및 위치 설정

		// 리스  너2(리스너 병합과 생성을 동시에)
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

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기버튼 클릭 시 모든 창 꺼지게
		frame.setBounds(5, 5, 1500, 1000); // 프레임의 크기 및 위치 설정

		// 리스너(따로 클래스를 만들어서 추가)
		endbutton = new JButton("종료");
		endbutton.setBounds(frame.getWidth()/2-50,900,100,50);
		endbutton.addActionListener(new EndListener());
		
		panel.add(endbutton);

		frame.getContentPane().add(panel); // 프레임에 메인패널을 더하기 (창위에 방화벽하나 깔고 도화지깔기)
		frame.setVisible(true); // 프레임 보이게끔
		
		timer = new Timer(100,new timerListener());		// 100ms 주기로 timerListener 실행
	}
	public class EndListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			frame.dispose();		//창 없애기
		}		
	}
	
	public class timerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hello");			//일정 시간마다 행하고 싶은 작동 넣기
		}
		
	}
	// 패널부
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
			//패널의 크기, 위치, 색  선정

			g.drawOval(cir.x, cir.y, cir.width, cir.height);
			//원의 위치, 크기 설정

			//조건에 맞는 원 색 설정

			//원 색칠
			g.fillOval(cir.x, cir.y, cir.width, cir.height);

		}
	}

	public class Circle {

		int x = 0, y = 0;		//x,y 좌표

		int width = 50, height = 50;		//너비 높이

		int xDirec = 2, yDirec = 2;		//x,y방향으로 움직이는 속도

		int radious = 25;
	}
	
}
