import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// This Table displays info of all users and allows admin to add or delete users to system

public class User {

	private String cardNumber;
	private String password;
	private double [] balance = new double[6];
	private double [] transactions = new double[6];
	private int transactionNumber = 0;

	
	
	public User()
	{
		this.cardNumber = "";
		this.password = "";
		balance[0] = 0;
		transactions[0] = 0;
		
	}
	
	
	// get current balance , balance is stored as first element in balance array
	
	public double getCurrentBalance()
	{
		return balance[0];
		
	}
	
	public double[] getBalanceHistory()
	{
		return balance;
		
	}
	
	public double[] getTransactionHistory()
	{
		return transactions;
		
	}
	
	public int gettransactionNumber()
	{
		return transactionNumber;
		
	}
	
	public void balanceInquire()
	{
		int x = 5;
		while(x>0)
		{
			balance[x] = balance[x-1];
			transactions[x] = transactions[x-1];
			x--;
		}
		balance[0] = balance[1];
		transactions[0] = 0;
		transactionNumber++;
	}
	public int deposit(double deposit)
	{
		if(deposit == 0)
			return 0;
		if(deposit < 0)
			deposit *= -1;
		int x = 5;
		while(x>0)
		{
			balance[x] = balance[x-1];
			transactions[x] = transactions[x-1];
			x--;
		}
		balance[0] = balance[1] + deposit;
		transactions[0] = deposit;
		transactionNumber ++;
		return 1;
	}
	
	public int withdraw(double withdraw)
	{
		if(withdraw < 0)
			withdraw *= -1;
		if(balance[0] < withdraw)
			return 0;
		if( withdraw == 0)
			return -1;
		int x = 5;
		while(x>0)
		{
			balance[x] = balance[x-1];
			transactions[x] = transactions[x-1];
			x--;
		}
		balance[0] = balance[1] - withdraw;
		transactions[0] = -withdraw;
		transactionNumber++;
		return 1;
	}	
	
	public User(String cardNumber , String password)
	{
		this.cardNumber = cardNumber;
		this.password = password;
		
		
	}
	
	public String getCardNumber()
	{
		return this.cardNumber;
	}
	
	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	

}
