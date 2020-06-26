import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	JButton btnPlayAgain;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else {
				message = guess + 
						" is correct. You Win!!";
				btnPlayAgain.setVisible(true);
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();			
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		btnPlayAgain.setVisible(false);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("James' Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("James' Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 39, 414, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 92, 252, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(272, 88, 50, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBounds(173, 134, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblOutput.setBounds(10, 216, 414, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
				txtGuess.setText("");
			}
		});
		btnPlayAgain.setBounds(76, 168, 252, 39);
		getContentPane().add(btnPlayAgain);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
