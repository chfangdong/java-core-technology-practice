package src;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
//
//public class InnerClassTest {
//	public static void main(String[] args)
//	{
//		TalkingClock talkingClock = new TalkingClock(1000, true);
//		talkingClock.start();
//		JOptionPane.showMessageDialog(null, "Quit progra?");
//		System.exit(0);
//	}
//}

class TalkingClock
{
	private int interval;
	private boolean been;
	public TalkingClock(int interval, boolean been) 
	{
		this.been = been;
		this.interval = interval;
		
	}
	public void start() 
	{
		ActionListener actionListener = new TimePrinter();
		Timer timer = new Timer(interval, actionListener);
		timer.start();
	}
	class TimePrinter implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			Date now = new Date();
			System.out.println("At the tone, the timer is " + now);
			if(been) Toolkit.getDefaultToolkit().beep();
			
		}
	}
}