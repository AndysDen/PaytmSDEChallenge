package com.paytmlabs.interview.average;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.xml.stream.events.StartDocument;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MovingAverageArrayListTest {
	
	
	private MovingAverage<BigDecimal> movingAverage;
	
	private static final long NVALUE_SIZE=6000000;
	private static final long ELEMENT_SIZE=9000000;
	
	
	@Before
	public void init() {
		
		movingAverage= new MovingAverageArrayListImpl(3l);
	}
	
	@Test
	  public void addElementTestMethod() {
		
		movingAverage.addElement(BigDecimal.valueOf(3));
		assertEquals(1, movingAverage.currentSize());
	}
	
	@Test 
	 public void testMovingAverageWhenSizeIsLessThenN() {
		movingAverage.addElement(BigDecimal.valueOf(3));
		movingAverage.addElement(BigDecimal.valueOf(2));
		assertEquals(BigDecimal.ZERO, movingAverage.getMovingAverage());
		
	}
	
	@Test 
	 public void testMovingAverageWhenSizeIsEqualToN() {
		movingAverage.addElement(BigDecimal.valueOf(3));
		movingAverage.addElement(BigDecimal.valueOf(2));
		movingAverage.addElement(BigDecimal.valueOf(1));
		assertEquals(BigDecimal.valueOf(2), movingAverage.getMovingAverage());
		
	}
	
	@Test 
	 public void testMovingAverageWhenSizeIsGreaterThanN() {
		movingAverage.addElement(BigDecimal.valueOf(10));
		movingAverage.addElement(BigDecimal.valueOf(3));
		movingAverage.addElement(BigDecimal.valueOf(2));
		movingAverage.addElement(BigDecimal.valueOf(1));
		assertEquals(BigDecimal.valueOf(2), movingAverage.getMovingAverage());
		
	}
	
	@Test 
	 public void testFetchingEntireListWhenSizeNotProvided() {
		movingAverage.addElement(BigDecimal.valueOf(10));
		movingAverage.addElement(BigDecimal.valueOf(3));
		movingAverage.addElement(BigDecimal.valueOf(2));
		movingAverage.addElement(BigDecimal.valueOf(1));
		assertEquals(movingAverage.currentSize(), movingAverage.getElements(Optional.<Integer>empty()).size());
		
	}
	
	@Test 
	 public void testFetchingPartialListWhenSizeisProvided() {
		movingAverage.addElement(BigDecimal.valueOf(10));
		movingAverage.addElement(BigDecimal.valueOf(3));
		movingAverage.addElement(BigDecimal.valueOf(2));
		movingAverage.addElement(BigDecimal.valueOf(1));
		assertEquals(2, movingAverage.getElements(Optional.of(2)).size());
		
	}

	@Test 
	 public void testFetchingElementMoreThantheSizeOfListProvided() {
		movingAverage.addElement(BigDecimal.valueOf(10));
		movingAverage.addElement(BigDecimal.valueOf(3));
		movingAverage.addElement(BigDecimal.valueOf(2));
		movingAverage.addElement(BigDecimal.valueOf(1));
		assertNull(movingAverage.getElement(6));
		
	}
	@Test 
	 public void testMovingAverageCalculationPerformance() {
		MovingAverage<BigDecimal> movAvg= new MovingAverageArrayListImpl(NVALUE_SIZE);
		long statTime=System.currentTimeMillis();
		
		IntStream.range(0,(int) ELEMENT_SIZE).boxed().forEach(i-> movAvg.addElement(BigDecimal.valueOf(i)));
      assertEquals(5999999.5, movAvg.getMovingAverage().doubleValue(),0.001);
      long endTime=System.currentTimeMillis();
      System.out.println("Total time is seconds is "+(endTime-statTime) /1000);
		
		
	}
	
	

}
