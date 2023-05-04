
package assignment01;
/**
 * @author Tan Hong Rui Freeman
 * @Version 1.0
 * 
 * Describes The Name,Coin and the Changes
 * category of coins : One Dollar, Fifty Cent, Twenty Cent, Ten Cent and Five Cent
 * 
 * Move away Print statement from the class
 * Try not to use scanner input in the class.
 * Do the input and output in the client program, i.e. the main method: public static void main(String[] args)
 */

public class Change 
{
    /**The amount of change/coins the person has for the change client and tempcoin to store temporary values
     * @param tempCoin temporary stores Coins values to calculate
    */
    private String name;
    private int coin;
    private int tempcoin;
    
    /**Default Constructor Change class
    *<p>
     *A blank constructor to intialise the call method from another class 
     * </p>
     */
    public Change()
    {
        this.name = " ";
        this.coin = 0;
    }
    
    /** Parameterised constructors
     * <p>
     * This method is used to represent the Name and Coins
     * </p>
     * post condition - A Change object created with the Name and Coins
     * @param Name Name of the person from Change object
     * @param Coins Coins is the value from Change object
     */
    public Change(String name, int coin)
    {
        this.name = name;
        this.coin = coin;
        this.tempcoin = coin;
    }
    
    /** This method is used get the name of the Change object   
     * <p>
     * Precondition: Name is initialised at the Constructor  
     * Postcondition: The name of the Change object is returned.
     * </p><br>
     *  To access private String name;
     * Allows attributes(instance variables) to be read and modified
     * Getter and Setter and mostly came in pair
     * @return Name Return the Change object Name 
     */
    
    public String getName()
    {
        return name;
    }
    
    /** This method is used get the coin of the Change object   
     * <p>
     * Precondition: Coin is initialised at the Constructor  
     * Postcondition: The coin of the Change object is returned.
     * </p><br>
     *  To access private integer coin;
     * Allows attributes(instance variables) to be read and modified
     * Getter and Setter and mostly came in pair
     * @return Coin Return the Change object Coin 
     */

    public int getCoin()
    {
        return coin;
    }
    
    /**This method is used set the name of the Change object    
     * <p>
     * Precondition: Name is initialised at the Constructor 
     * postcondition: A string to hold the Name input.
     * </p><br>
     * Getter and Setter and mostly came in pair
     * @param Name A String containing Change object Name 
     */
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**This method is used set the Coin of the Change object       
     * <p>
     * Precondition: Coin is initialised at the Constructor 
     * postcondition: A integer to hold the Coin input.
     * </p><br>
     * Getter and Setter and mostly came in pair
     * @param Coin A String containing Change object Coin 
     */
    
    public void setCoin(int coin)
    {
        this.coin = coin;
    }
    
    /** This method is use to calculate the coin from the input and the temporary coin that is store there
     * @param this coin plus equal to the integer coin
     * @param this tempcoin plus equal to the integer coin
     */
    
    public void totalCoin(int coin)
    {
        this.coin += coin;
        this.tempcoin += coin;
    }
    
    /** This method is use to calculate how many coins of one dollar.
     * @param oneDollar A integer contain the coins
     * @return it to the user
     */
    
     public int forOneDollar()
    {
        if(this.coin / 100 == 0)
        {
            return 0;
        }
        int oneDollar = this.coin / 100;
        this.coin = this.coin - ((this.coin / 100 )* 100);
        return oneDollar;
    }
    
     /** This method is use to calculate how many coins of fifty cents.
     * @param fifty A integer contain the coins
     * @return it to the user
     */
    public int forFifty()
    {
        if(this.coin / 50 == 0)
        {
            return 0;
        }
        int fifty = this.coin / 50;
        this.coin = this.coin - ((this.coin / 50 )* 50);
        return fifty;
    }
    
    /** This method is use to calculate how many coins of Twenty cents.
     * @param twenty A integer contain the coins
     * @return it to the user
     */
    public int forTwenty()
    {
        if(this.coin / 20 == 0)
        {
            return 0;
        }
        int twenty = this.coin / 20;
        this.coin = this.coin - ((this.coin / 20 )*20);
        return twenty;
    }
    
    /** This method is use to calculate how many coins of Ten cents.
     * @param ten A integer contain the coins
     * @return it to the user
     */
    public int forTen()
    {
        if(this.coin / 10 == 0)
        {
            return 0;
        }
        int ten = this.coin / 10;
        this.coin = this.coin - ((this.coin / 10 )*10);
        return ten;
    }
    
    /** This method is use to calculate how many coins of five cents.
     * @param five A integer contain the coins
     * @return it to the user
     */
    public int forFive()
    {
        if(this.coin / 5 == 0)
        {
            return 0;
        }
        int five = this.coin / 5;
        this.coin = this.coin - ((this.coin / 5 )*5);
        return five;
    }
    
    /** This method is to reset the coin and tempcoin 
     * @param coin contain tempcoin too
     */
    public void resetCoin()
    {
        this.coin = this.tempcoin;
    }
    
    /** This method is for the toString that find how many coins the customer have
     * @return it to the customer of their coin amount
     */
    public String toString()
    {
        resetCoin();
        String str = name + " has " + coin + " cents\nChanges ";
        
        int oneDollar = forOneDollar();
        if(oneDollar != 0)
        {
            str += ", 1 Dollars: " + oneDollar;
        }
        
        int fifty = forFifty();
        if(fifty != 0)
        {
            str += ", 50 cents: " + fifty;
        }
        
        int twenty = forTwenty();
        if(twenty != 0)
        {
            str += ", 20 cents: " + twenty;
        }
        
        int ten = forTen();
        if(ten != 0)
        {
            str += ", 10 cents: " + ten;
        }
        
        int five = forFive();
        if(five != 0)
        {
            str += ", 5 cents: " + five;
        }
        
        resetCoin();
        return str;
    }     
}



