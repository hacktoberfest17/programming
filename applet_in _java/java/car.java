import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class car extends Applet implements Runnable,MouseListener


{
	int i=0,k=0,z=0;
	public void paint(Graphics g)
	{
          int x[]={200+i,300+i,400+i,500+i,500+i,0+i,0+i,100+i};
          int y[]={200,200,300,300,400,400,300,300};
          g.setColor(Color.RED);
          g.fillPolygon(x,y,8);
          g.setColor(Color.BLUE);
        g.drawPolygon(x,y,8);
        g.setColor(Color.WHITE);
        g.fillOval(80+i, 350, 80, 80);
        g.fillOval(320+i, 350, 80, 80);
        g.setColor(Color.GREEN);
        g.drawOval(80+i, 350, 80, 80);
        g.drawOval(320+i, 350, 80, 80);
        int x1[]={200+i,300+i,380+i,120+i};
        int y1[]={220,220,300,300};
        
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(x1,y1,4);
        g.setColor(Color.MAGENTA);
        g.drawPolygon(x1,y1,4);
        
	}
	void update()
	{
		
		if(z%2!=0)
		{
		 i=(i+1)%getWidth();
		}
		if(z%2==0)
		{

			if(i==0)
			{
				i=getWidth();
			}
			i=(i-1);
					
		}
		
	}
	
	Thread t;
	Thread t1;
	public void init()
	{
		 t=new Thread(this);
		//t.setDaemon(true); 
		t1=new Thread(this);
		//t1.setDaemon(true); 
		addMouseListener(this);
		
        			
	}
	public void run()
	{
		if(z%2==0)
		{
			while(true)
			{
		update();
			repaint();
			try
			{
			  Thread.sleep(10);
			}
			catch(Exception e )
			{
				
			}	
								
		}
		}
						
			 if(z%2!=0)
		{
		while(true)
		{
		update();
		repaint();
		try
		{
		  Thread.sleep(10);
		}
		catch(Exception e )
		{
			
		}
		}
		
	}
		
	}
		
		public void mouseClicked(MouseEvent e)
		{
	
			//if(k>0)
			//{
				//t.resume();
			
//			}
			System.out.println("kkk = "+e);
			int x=e.getX();
			int y=e.getY();
			
           z++;
			while(x>0&&x<getWidth())
			{
				
				if(z%2!=0)
				{		
					System.out.println(x);
				 t.start();
				}
				if(z%2==0)
				{
					System.out.println(x);
					t1.start();
				}
				
			}

		
	
		}



		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) 
		{
			
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) 
		{
			
		}

		
		
		
	
}
