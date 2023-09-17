/**
 * 
 * @author Renzo Svartz
 *
 */

package Data_Structures;

/**
 * The Plot class represents a piece of land (a plot) for a property, that has a corner located at point (x, y)
 * and extends by it's width and depth amount
 * @param x The x coordinate of the top left corner of the plot
 * @param y The y coordinate of the top left corner of the plot
 * @param width The width the x-axis of the plot extends
 * @param depth The depth the y-axis of the plot extends
 */
public class Plot 
{
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * No arg Constructor used to create a new Plot object
	 */
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Copy Constructor used to create a deep copy instance of an object of the Plot class.
	 * @param o2 The Plot object we are copying
	 */
	public Plot(Plot o2)
	{
		this.x = o2.x;
		this.y = o2.y;
		this.width = o2.width;
		this.depth = o2.depth;
	}
	
	/**
	 * Constructor used to build a Plot object
	 * @param x The x coordinate of the property
	 * @param y The y coordinate of the property
	 * @param width The width of the property 
	 * @param depth The depth of the property
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Method used to check if the argument plot overlaps the instance plot
	 * @param o2 The plot that we check if overlapping
	 * @return True or False, whether the plots overlap
	 */
	public boolean overlaps(Plot o2)
	{
		boolean status = false;
		
		if ((o2.x > x && o2.x < x + width) && (o2.y > y && o2.y < y + depth))
			status = true;
		else if ((o2.x > x && o2.x < x + width) && (o2.y + o2.depth > y && o2.y + o2.depth < y + depth))
			status = true;
		else if ((o2.x + o2.width > x && o2.x < x + width) && (o2.y + o2.depth > y && o2.y + o2.depth < y + depth))
			status = true;
		else if ((o2.x + o2.width > x && o2.x < x + width) && (o2.y > y && o2.y < y + depth))
			status = true;
		else if ((o2.x <= x && o2.x + o2.width >= x + width) && ((o2.y >= y && o2.y < y + depth) || (o2.y + o2.depth > y && o2.y + o2.depth <= y + depth)))
			status = true;
		else if ((o2.y <= y && o2.y + o2.depth >= y + depth) && ((o2.x + o2.width > x && o2.x + o2.width <= x + width) || (o2.x >= x && o2.x < x + width)))
			status = true;
		else if ((x <= o2.x && x + width >= o2.x + o2.width) && (o2.y <= y && o2.y + o2.depth >= y + depth))
			status = true;
		else if ((o2.x <= x && o2.x + o2.width >= x + width) && (y <= o2.y && y + depth >= o2.y + o2.depth))
			status = true;
		
		return status;
	}
	
	/**
	 * Method used to check if the argument plot is encompassed by the instance plot
	 * @param o2 The plot that we check if encompassed
	 * @return True or False, whether the plot is encompassed
	 */
	public boolean encompasses(Plot o2)
	{
		boolean status = false;
		
		if (x <= o2.x && x + width >= o2.x + o2.width && y <= o2.y && y + depth >= o2.y + o2.depth)
			status = true;
		
		return status;
	}
	
	/**
	 * setter method to set x
	 * @param x the x coordinate of the top left point of the plot
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * getter method to get x
	 * @return the x coordinate of the top left point of the plot
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * setter method to set y
	 * @param y the y coordinate of the top left point of the plot
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * getter method to get y
	 * @return the y coordinate of the top left point of the plot
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * setter method to set width
	 * @param width the width of the plot along the x-axis
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * getter method to get the width
	 * @return the width of the plot
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * setter method to set depth
	 * @param depth the depth of the plot along the y-axis
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	 * getter method to get the depth
	 * @return the depth of the plot
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * toString method used to print a formatted string containing information about the plot object
	 * @return A String containing information about the plot
	 */
	public String toString()
	{
		return String.format("Upper left: (%d,%d); Width: %d Depth: %d\n", x, y, width, depth);
	}
}
