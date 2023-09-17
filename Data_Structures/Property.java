/**
 * 
 * @author Renzo Svartz
 *
 */

package Data_Structures;

/**
 * The Property class describes a piece of property that has a name, rent amount, city, owner, and has a plot class object
 * @param propertyName Name of the property
 * @param city Name of the city the property is in
 * @param rentAmount The amount of rent this property costs
 * @param owner The owner of this property
 * @param plot the Plot for this property
 */
public class Property 
{
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * No arg constructor used to create a new Property object
	 */
	public Property()
	{
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot(0, 0, 1, 1);
	}
	
	/**
	 * Copy Constructor used to create a deep copy instance of an object of the Property class.
	 * @param o2 The Property object we are copying
	 */
	public Property(Property o2)
	{
		this.city = new String(o2.city);
		this.owner = new String(o2.owner);
		this.propertyName = new String(o2.propertyName);
		this.rentAmount = o2.rentAmount;
		this.plot = new Plot(o2.plot);
	}
	
	/**
	 * Constructor used to build a Property object with default arguments for the plot field.
	 * @param propertyName Name of the property
	 * @param city Name of the city the property is in
	 * @param rentAmount The amount of rent this property costs
	 * @param owner The owner of this property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.city = new String(city);
		this.owner = new String(owner);
		this.propertyName = new String(propertyName);
		this.rentAmount = rentAmount;
		plot = new Plot();
	}
	
	/**
	 * Constructor used to build a Property object
	 * @param propertyName Name of the property
	 * @param city Name of the city the property is in
	 * @param rentAmount The amount of rent this property costs
	 * @param owner The owner of this property
	 * @param x The x coordinate of the property
	 * @param y The y coordinate of the property
	 * @param width The width of the property 
	 * @param depth The depth of the property
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.city = new String(city);
		this.owner = new String(owner);
		this.propertyName = new String(propertyName);
		this.rentAmount = rentAmount;
		plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * getter method used to get the city name
	 * @return A String; the name of the city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * getter method used to get the owner's name
	 * @return A String; the name of the owner
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/** 
	 * getter method used to get the property name
	 * @return A String; the property name
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/**
	 * getter method used to get the rent amount for the property
	 * @return A double; the rent amount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	/**
	 * getter method used to  get the plot for the property
	 * @return A Plot; the plot of the property
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * setter method used to set the Plot of the property
	 * @param x The x coordinate of the property
	 * @param y The y coordinate of the property
	 * @param width The width of the property 
	 * @param depth The depth of the property
	 * @return A deep copy of the new Plot
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		return this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * setter method used to set the city
	 * @param city The name of the city
	 */
	public void setCity(String city)
	{
		this.city = new String(city);
	}
	
	/**
	 * setter method used to set the owner
	 * @param owner The owner of the property
	 */
	public void setOwner(String owner)
	{
		this.owner = new String(owner);
	}
	
	/**
	 * setter method used to set the propertyName
	 * @param propertyName The name of the property
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = new String(propertyName);
	}
	
	/**
	 * setter method used to set the rent amount
	 * @param rentAmount The amount for rent
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * toString method used to print a formatted string containing information about the property object
	 * @return A String containing information about the property
	 */
	public String toString()
	{
		return String.format("Property Name: %s\nLocated in %s\nBelonging to: %s\nRent Amount: %.2f \n", propertyName, city, owner, rentAmount);
	}
}
