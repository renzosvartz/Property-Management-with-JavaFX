/**
 * 
 * @author Renzo Svartz
 *
 */

package Data_Structures;

import java.util.ArrayList;

/**
 * The ManagementCompany class represents a company that manages up to 5 properties on a plot of land
 * @param MAX_PROPERTY The maximum properties the management company can have
 * @param mgmFeePer The percent amount fee the management company charges
 * @param name The name of the company
 * @param properties The arraylist of properties managed by the company
 * @param taxID The tax ID for the management company
 * @param MGMT_WIDTH the width of the management plot
 * @param MGMT_DEPTH the width of the management plot
 * @param plot The management company's plot
 */
public class ManagementCompany
{
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private ArrayList<Property> properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	/**
	 * No arg Constructor used to create a new ManagementCompany object
	 */
	public ManagementCompany()
	{
		name = "";
		taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new ArrayList<Property>();
	}
	
	/**
	 * Constructor used to build a ManagementCompany object
	 * @param name The name of the company
	 * @param taxID The tax ID for the management company
	 * @param mgmFee The percent amount fee the management company charges
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = new String(name);
		this.taxID = new String(taxID);
		mgmFeePer = mgmFee / 100;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new ArrayList<Property>();
	}
	
	/**
	 * Constructor used to build a ManagementCompany object
	 * @param name The name of the company
	 * @param taxID The tax ID for the management company
	 * @param mgmFee The percent amount fee the management company charges
	 * @param x The x coordinate of the company's plot
	 * @param y The y coordinate of the company's plot
	 * @param width The width of the company's plot
	 * @param depth The depth of the company's plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = new String(name);
		this.taxID = new String(taxID);
		mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new ArrayList<Property>();
	}
	
	/**
	 * Copy Constructor used to create a deep copy instance of an object of the ManagementCompany class.
	 * @param o2 The ManagementCompany object we are copying
	 */
	public ManagementCompany(ManagementCompany o2)
	{
		this.name = new String(o2.name);
		this.taxID = new String(o2.taxID);
		mgmFeePer = o2.mgmFeePer;
		plot = new Plot(o2.plot);
		properties = new ArrayList<Property>();
	}
	
	/**
	 * Method used to add a property to the Management Company's ArrayList
	 * @param property The property we are adding
	 * @return An integer representing the status of the addition
	 */
	public int addProperty(Property property)
	{
		boolean contains = false;
		if (plot.encompasses(property.getPlot()))
		{
			contains = true;
		}
		
		boolean overlap = false;
		for (int i = 0; i < properties.size(); i++)
		{
			if (properties.get(i).getPlot().overlaps(property.getPlot()))
			{
				overlap = true;
			}
		}
		
		if (properties.size() == MAX_PROPERTY)
		{
			return -1;
		}
		else if (properties == null)
		{
			return -2;
		}
		else if (!contains)
		{
			return -3;
		}
		else if (overlap)
		{
			return -4;
		}
		else
		{
			properties.add(new Property(property));
			return properties.size() - 1;
		}
	}
	
	/**
	 * Method used to add a property to the Management Company's ArrayList
	 * @param name Name of the property
	 * @param city Name of the city the property is in
	 * @param rent The amount of rent this property costs
	 * @param owner The owner of this property
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property property = new Property(name, city, rent, owner);
		
		boolean contains = false;
		if (plot.encompasses(property.getPlot()))
		{
			contains = true;
		}
		
		boolean overlap = false;
		for (int i = 0; i < properties.size(); i++)
		{
			if (properties.get(i).getPlot().overlaps(property.getPlot()))
			{
				overlap = true;
			}
		}
		
		if (properties.size() == 5)
		{
			return -1;
		}
		else if (properties == null)
		{
			return -2;
		}
		else if (!contains)
		{
			return -3;
		}
		else if (overlap)
		{
			return -4;
		}
		else
		{
			properties.add(new Property(property));
			return properties.size() - 1;
		}
	}
	
	/**
	 * Method used to add a property to the Management Company's ArrayList
	 * @param name Name of the property
	 * @param city Name of the city the property is in
	 * @param rent The amount of rent this property costs
	 * @param owner The owner of this property
	 * @param x The x coordinate of the property
	 * @param y The y coordinate of the property
	 * @param width The width of the property 
	 * @param depth The depth of the property
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		boolean contains = false;
		if (plot.encompasses(property.getPlot()))
		{
			contains = true;
		}
		
		boolean overlap = false;
		for (int i = 0; i < properties.size(); i++)
		{
			if (properties.get(i).getPlot().overlaps(property.getPlot()))
			{
				overlap = true;
			}
		}
		
		if (properties.size() == 5)
		{
			return -1;
		}
		else if (properties == null)
		{
			return -2;
		}
		else if (!contains)
		{
			return -3;
		}
		else if (overlap)
		{
			return -4;
		}
		else
		{
			properties.add(new Property(property));
			return properties.size() - 1;
		}
	}
	
	/**
	 * Method used to sum the total rent of all of the properties managed by the company
	 * @return The total sum of all property rents
	 */
	public double totalRent()
	{
		double sum = 0;
		
		for (int i = 0; i < properties.size(); i++)
		{
			sum += properties.get(i).getRentAmount();
		}
		
		return sum;
	}
	
	/**
	 * Method used to find and return the maximum rent among all of the properties managed by the company
	 * @return The max rent
	 */
	public double maxRentProp()
	{
		double max = 0;
		
		for (int i = 0; i < properties.size(); i++)
		{
			if (properties.get(i).getRentAmount() >= max)
			{
				max = properties.get(i).getRentAmount();
			}
		}
		
		return max;
	}
	
	/**
	 * Method used to find and return the index belonging to the property with the maximum rent among all of the properties managed by the company
	 * @return The index of the property with the max rent
	 */
	public double maxRentPropertyIndex()
	{
		double max = 0;
		double index = 0;
		
		for (int i = 0; i < properties.size(); i++)
		{
			if (properties.get(i).getRentAmount() >= max)
			{
				max = properties.get(i).getRentAmount();
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * Method used to display the information about a property at index i
	 * @param i The index of the property this method will return a String about
	 * @return A String containing information about a property
	 */
	private String displayPropertyAtIndex(int i)
	{
		return properties.get(i).toString();
	}
	
	/**
	 * toString method used to print a formatted string containing information about the ManagementCompany object
	 * @return A String containing information about the ManagementCompany
	 */
	public String toString()
	{	
		String allInfo = String.format("List of the properties for %s, taxID: %s\n", name, taxID);
		
		for (int i = 0; i < properties.size(); i++)
		{
			allInfo = allInfo.concat(properties.get(i).toString());
		}
		
		return allInfo.concat(String.format("Total management fee: %.2f", totalRent() * mgmFeePer));
	}
	
	/**
	 * getter method to get the name of the management company
	 * @return the name of the management company
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * getter method to get the plot of the management company
	 * @return the plot of the management company
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * getter method to get the maximum number of properties the management company can manage
	 * @return the maximum number of properties the management company can manage
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
}
