package com.paytmlabs.interview.average;

import java.util.List;
import java.util.Optional;

/**
 * This Generic Interface declares the template of operation to be implemented by the implementing class
 * 
 * Following operation should be supported by the implementing class :
 *  a. Adding new element into the list. 
 *  b. Accessing any element of the list. 
 *  c. Provide the size of the list. 
 *  d. Provide the Moving average of the last N elements of the list.  
 * 
 *    
 * @author anandsoni
 *
 * @param <T>
 */

public interface MovingAverage<T> {
	

	/** 
	 * This function adds the element to the underlying dataStructure. 
	 * @param element
	 */
	public void addElement(T element) ;

	/**
	 * This returns the size of the underlying datastructure.
	 * @return
	 */
	public int currentSize();
	
	/** 
	 * This method allows the user to browse the elements in the underlying dataStructure. This method returns the List for convenient ordered browsing(Based on insertion order) of the elements
     * @param size : This methods takes optional 
	 */
	public List<T> getElements(Optional<Integer> size);
	
	/**
	 * @param index: Takes the index of which element to be returned.
	 * @return T : returns the element on that location. 
	 * @throws IndexOutofBoundsException , if the accessed index is out of range of the underlying datastructure. 
	 */
	public T getElement(int index);
	
	/**
	 * Calculate return moving average. 
	 * @return T : Returns the calculated moving average.
	 */
	
	public T getMovingAverage();
}
