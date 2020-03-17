package com.paytmlabs.interview.average;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


/**
 * This class is using ArrayList as underlying data structure to store the
 * elements, For highest precision we have considered the storage type to be of
 * BigDecimal. 
 * 
 * ASSUMPTION : 
 * a. Whenever a new element gets added moving average calculation will lazily initialized. 
 * b. DataStructure will not allow any null values , if any null values is passed to addElement method it will silently reject the insertion.
 * 
 * @author anandsoni
 *
 */

public class MovingAverageArrayListImpl implements MovingAverage<BigDecimal> {

	private Long nValue;
	private List<BigDecimal> list;
	private BigDecimal movAvg;

	public MovingAverageArrayListImpl(Long nValue) {
		this.nValue = nValue;
		this.list = new ArrayList<BigDecimal>();
		this.movAvg = BigDecimal.ZERO;
	}

	public void addElement(BigDecimal element) {

		list.add(element);
		this.movAvg = BigDecimal.ZERO;

	}

	public int currentSize() {
		return list.size();
	}

	/**
	 * this methods fetches the portion of the stored elements. 
	 * if size is null then it will return the entire dataStructure. else it will return the first size elements from the list.
	 * 
	 */
	public List<BigDecimal> getElements(Optional<Integer> size) {
		int askSize = size.isPresent() ? size.get() : list.size();

		List<BigDecimal> listOfElements = new ArrayList<>();

		IntStream.range(0, askSize).boxed().forEach(i -> listOfElements.add(list.get(i)));
		return listOfElements;

	}

	/**
	 * This method will check if index is within the range of the list, incase it is not it will silently return null. 
	 */
	public BigDecimal getElement(int index) {
		return index < list.size() ? list.get(index) : null;
	}

	
	/** 
	 * @return average of the last n elements stored in the List. 
	 * if number of elements in < nValue then it will simply return zero. 
	 * else will calculate the average of the last n elements.  
	 */
	
	
	public BigDecimal getMovingAverage() {
		  if(!this.movAvg.equals(BigDecimal.ZERO)) {
			  return movAvg;
		  }
		  
		  int index=list.size() >= nValue?(int)( list.size()-nValue):Integer.MAX_VALUE; 
		  BigDecimal addedValue=BigDecimal.ZERO;
		  int counter=1;
			 while(index< list.size() && counter<=nValue) {
				addedValue=addedValue.add(list.get(index));
				counter++;
				index++;
		  }
		BigDecimal result = addedValue.divide(BigDecimal.valueOf(nValue));
		return result;
	}

}
