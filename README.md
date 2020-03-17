# PaytmSDEChallenge
# Problem 1 : 
# Design Consideration :
1. The solution has been created with the intension that ordering need to be preserved. 
2. We have selected baseline datastructure from Collection API to support new enchancement with minimal coding. 
# Time complexity of operation
 Solution has been implemented using ArrayList , hence 
 1. Complexity of Insertion is O(1).
 2. Complexity of element access is O(1). 
For the first problem we have defined Genric Interface which could calculate and return result with user provided DatType. 
For Examplery we have provided implementation using BiGDecmimal for the precsion of the results.
# Below are the mentioned Operation supported by the datastructure: 
   1. Adding new element into the list. 
   2. Accessing any element of the list. 
   3. Provide the size of the list. 
   4. Provide the Moving average of the last N elements of the list. 
  # Implementation  
  1. We have provided a list Implementation(ArrayList) to store the elements in the dataStructure. 
  2. With the Constructor of the dataStructure we are taking N size as input and set it in nValue.
  3.This implementation provides methods to fetch any element/fetch partial elements/get currentSize of the dataStructure.
  # Silent Contract
  1. If user tries to access the element which is outside the range of the List, it will return null. 
  2. Whenever we add a new element in the dataStructure the Indicator of Average calculator is reset. 
  3. Average is only re-calculated if a new element is added to the list. 
  4. If size of the list is less then N, then it Result zero is returned as result. 
  # Performance
  
  
