//Anani Assoutovi

//I am using these three system libraries because I hate importing large libraries that won't be used
import static java.lang.System.out;
import static java.lang.System.err;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTT extends JFrame implements ActionListener
{
	private JButton[][] gameIndex;
	private JLabel gameMessage;
	private JPanel gamePanel;
	private boolean oTurn;
	private char[][] leaveADot;
	
	//Bulding the constructor
	public TTT()
	{
		//Setting the GUI Title
		super("Tic Tac Toe");
		
		//This is where we declare the Board Layout for the GUI
		this.setLayout(new BorderLayout());
		//Now Set the size of the Layout
		//like this
		this.setSize(500, 500);
		
		//Now let us set the message for the player's turn
		gameMessage = new JLabel("It is now Player O's Turn");
		//Let us make that message visible
		gameMessage.setVisible(true);
		//Let us define where we want this message to be outputted 
		this.add(gameMessage, BorderLayout.NORTH);
		
		gamePanel = new JPanel(new GridLayout(5, 5));
		gamePanel.setVisible(true);
		
		gameIndex = new JButton[5][5];
		leaveADot = new char[5][5];
		
		for(int a=0; a<5; a++)
		{
			for(int b=0; b<5; b++)
			{
				gameIndex[a][b] = new JButton("");
				gameIndex[a][b].setEnabled(true);
				gameIndex[a][b].addActionListener(this);
				gameIndex[a][b].setActionCommand(a+" "+b);
				gameIndex[a][b].setVisible(true);
				gameIndex[a][b].add(gameIndex[a][b]);
				leaveADot[a][b] ='*';
			}
		}
		
		this.add(gamePanel, BorderLayout.CENTER);
		oTurn = true;
	}
	
	private boolean Winner(char selectedSpot, char[][] gamePanel)
	{
		//First Let us check the board for Vertical Score
		for(int y=0; y<5; y++)
		{
			//Let us keep the count of each scores
			int keepCount =0;
			for(int x=0; x<5; x++)
			{
				if(gamePanel[x][y] == selectedSpot)
					keepCount++;
				else
					keepCount =0;
			}
			if(keepCount ==4)
				return true;
		}
		
		// Second let us check for Horizontal Score
		for(int x =0; x<5; x++)
		{
			int keepCount =0;
			for(int y=0; y<5; y++)
			{
				if(gamePanel[x][y] == selectedSpot)
					keepCount++;
				else
					keepCount =0;
			}
			if(keepCount ==4)
				return true;
		}
		
		//Now let us check for diagonal top-left to bottom-right
		if(gamePanel[0][0] ==selectedSpot && gamePanel[1][1] ==selectedSpot && gamePanel[2][2] ==selectedSpot && gamePanel[3][3] ==selectedSpot)
			return true;
		if(gamePanel[1][1] ==selectedSpot && gamePanel[2][2] ==selectedSpot && gamePanel[3][3] ==selectedSpot && gamePanel[4][4] ==selectedSpot)
			return true;
		if(gamePanel[0][1] ==selectedSpot && gamePanel[1][2] ==selectedSpot && gamePanel[2][3] ==selectedSpot && gamePanel[3][4] ==selectedSpot)
			return true;
		if(gamePanel[1][0] ==selectedSpot && gamePanel[2][1] ==selectedSpot && gamePanel[3][2] ==selectedSpot && gamePanel[4][3] ==selectedSpot)
			return true;
		
		//Now finally, let us check for diagonal top-right to bottom-left
		if(gamePanel[4][0] ==selectedSpot && gamePanel[3][1] ==selectedSpot && gamePanel[2][2] ==selectedSpot && gamePanel[1][3] ==selectedSpot)
			return true;
		if(gamePanel[3][1] ==selectedSpot && gamePanel[2][2] ==selectedSpot && gamePanel[1][3] ==selectedSpot && gamePanel[0][4] ==selectedSpot)
			return true;
		if(gamePanel[3][0] ==selectedSpot && gamePanel[2][1] ==selectedSpot && gamePanel[1][2] ==selectedSpot && gamePanel[0][3] ==selectedSpot)
			return true;
		if(gamePanel[4][1] ==selectedSpot && gamePanel[3][2] ==selectedSpot && gamePanel[2][3] ==selectedSpot && gamePanel[1][4] ==selectedSpot)
			return true;
	}
	
	//Now let us create a method to keep tie record
	private boolean gameTie(char[][] gamePanel)
	{
		for(int a=0; a<5; a++)
		{
			for(int b=0; b<5; b++)
			{
				if(gamePanel[a][b] =='*')
					return false;
			}
		}
		return true;
	}
	
	//Let us set the actionPerformed method (keep in mind this method does not return value
	public void actionPerformed(ActionEvent y)		//import java.awt.event.ActionEvent;
	{
		
	}

}
