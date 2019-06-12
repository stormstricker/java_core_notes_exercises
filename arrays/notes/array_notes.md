# Arrays

## Variable-Length Argument Lists

* A variable number of arguments of the same type can be passed to a method and treated as an array
* **FORMAT** - `typeName... parameterName`
* Only one allowed in a method header
* Must be the last parameter; any regular parameters must precede it
* *Remember*, vararg are treated as *arrays* in method
* **EXAMPLE**:

```java

// Prints the max number out of a variable-sized array of double values
public static void printMax(double... numbers){
    if(numbers.length == 0){
        System.out.println("No arguments passed");
        return;
    }

    // numbers is an array
    double result = numbers[0];

    // find the max value in numbers and set the value to result
    for(int i=1; i<numbers.length; i++){
        if(numbers[i]>result){
            result = numbers[i];
        }
    }
    System.out.println("The max value is " + result);
}

// Use example:
public static void main(String[] args){
    printMax(34, 3, 3, 2, 56.5);
    printMax(new double[]{1,2,3});
}
/* Output:
The max value is 56.5
The max value is 3.0
*/

```

## Searching Arrays

### The *linear search approach*

* compares the value you are searching for (*key*), with every single element in an array
  
* Don't do this. Its slow and inefficient

### *Binary search Approach*

* elements in the array must be ordered/ presorted for this to work
* How it works/ Process (assuming it array is in ascending order):
  1. Compare key with middle element; if key less than middle, search the first half of array, otherwise search second half of array
  2. Repeat this process until key is found or only one element is left

* **EXAMPLE**:
  
  ```java
  public static int binarySearch(int[] list, int key){
      // set min and max index values
      int low = 0;
      int high = list.length-1;

      while(high>= low{
          // find the middle index value
          int mid = (low+high)/2;

          // first half of array
          if(key<list[mid]){
              // set new max index value
              high = mid-1;
          }
          else if(key == list[mid]){
              // we found our "key"!
              return mid;
          }
          else{
              // set new min index value, for the second half of array
              low = mid + 1;
          }

          // when high<low, key is not found, return value that makes it obvious that key was not found
          return -low-1;
      }
  }
  ```

## Sorting Arrays

### Selection Sort

* This sorting finds the smallest number in the list and swaps it with the first element; then it finds the next smallest number and swaps it the second element, and so on until only a single number remains

* **Example:**

```java
public class SelectionSort{
    public static void selectionSort(double[] list){
        // list.length-1 because the last element will be the max, and won't need to be checked/ sorted
        for(int i=0; i<list.length-1; i++){
            // set the current minimum value and minimum index; minimum index will be used to switch the two elements
            double currentMin = list[i];
            int currentMinIndex = i;
            // j=i+1 because we want to compare currentMin (list[i]) with list[i+1]
            for(int j = i+1; j<list.length; j++){
                // if list[i] is higher than list[i+1](aka list[j]), then set currentMin equal to list[j]
                if(currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // this is to switch the lower element and higher element in the array, to get them sorted in ascending order
            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
```

### Insertion Sort

* The insertion-sort algorithm sorts a list of values by repeatedly inserting a new element into a sorted sublist until the whole list is sorted

* **EXAMPLE:**

```java
public class InsertionSort{
    public static void insertionSort(double[] list){
        for(int i=1; i<list.length; i++){
            // Insert list[i] into a sorted sublist list[0...i-1] so that list[0...i] is sorted
            double currentElement = list[i];
            int k;
            // inner loop is going to count down from list[i-1] to list[0]
            for(k=i-1; k>=0 && list[k] > currentElement; k--){
                // swap values
                list[k+1] = list[k];
            }
            list[k+1] = currentElement;
        }
    }
}
```

* *note to me: I still can't really wrap my head around this algoritms, need to use them more and understand them better later*

## The `Arrays` class

* `java.util.Arrays` class contains various static methods for sorting and searching arrays, comparing arrays, filling array elements, and returning a string representation of the array
* look up javadocs for all the methods and their uses

## Two-Dimensional Array Basics

* **Syntax:** 
  * `elementType[][] arrayReferenceVariableName;`
  * `int[][] matrix = new int[5][5];`
  * Array initialization example: `int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};`
  * Accessing element in 2D array example: `array[2][1] == 7;`
  * Remember, each subscript must be enclosed in brackets; *ex* this would not be valid: `array[2,1]`

* first bracket (will be referred to as subscript), denotes number of rows; second subscript denotes number of columns
* Think of each row in a 2D array, as individual arrays; the columns make up the values in those individual arrays

### Lengths of 2D array

* Since 2D arrays are essentially, an array of arrays (each row in 2D array is itself an array)....lengths are found separately for each subscript 
* Example, assume `int[][] array = {{1,2,3}, {4,5,6}, {7,8,9}};`...`array.length` is 3 since `array` holds 3 rows (aka individual arrays)
  * `array[0].length` is 3, since the first row has only 3 elements...and so on (`array[1].length, array[2].length)`
* also rows can have different lengths

### Ragged Arrays

* ragged arrays are arrays where the rows have different lengths

## Processing Two-Dimensional Arrays

* Nested `for` loops are often used to process a 2D array
* Examples:

  ```java
  // Initializing arrays with values
  Scanner scanner = new Scanner(System.in);
  System.out.println("Enter " + matrix.length + " rows and " + matrix[0].length + " columns: ");
  // for each row
  for(int row=0; row<matrix.length; row++){
      // for each column (row values)
      for(int column=0; column<matrix[row].length; column++){
          matrix[row][column]=input.nextInt();
          // can also use Math.random() for random values
      }
  }
  ```

  ```java
  // printing arrays
  for(int row=0; row<matrix.length; row++){
      for(int column=0; column<matrix[row].length; column++){
          System.out.print(matrix[row][column]);
      }
      System.out.println();
  }
  ```

  ```java
  // summing all elements
  int total=0;
  for(int row=0; row<matrix.length; row++){
      for(int column=0; column<matrix[row].length; column++){
          total += matrix[row][column];
      }
  }
  ```

  ```java
  // summing elements by column
  for(int column=0; columm<matrix[row].length;column++){
      int total=0;
      for(int row=0; row<matrix[0].length; row++){
          total += matrix[row][column];
          System.out.println("Sum for column " + column + " is " + total);
      }
  }
  ```

  ```java

  // finding which row had the largest sum 
  // (my version, diff. from book version...need to confirm if it is valid)
  int sum = 0;
  int maxSum =0;
  int rowHolder =0;
  for(int row=0; row<matrix.length; row++){
      for(int column = 0; column<matrix[row].length; column++){
          sum += matrix[row][column];
      }
      if(sum > maxSum){
          maxSum = sum;
          rowHolder = row;
      }
  }
  System.out.println("The " + rowHolder + " row had the biggest sum of " + maxSum);
  ```

  ```java
  // Random shuffling of all the elements in a 2D array
  for (int i=0; i<matrix.length; i++){
      for(int j=0; j<matrix[i].length; j++){
          int i1 = (int)(Math.random() * matrix.length);
          int j1 = (int)(Math.random() * matrix[i].length);

          // swap matrix[i][j] with matrix[i1][j1]
          int temp = matrix[i][j];
          matrix[i1][j1] = temp;
      }
  }
  ```

## Passing 2D arrays to methods

* same as passing normal arrays to methods except you use two pairs of squares of brackets instead of one (to denote it is 2D)
  * Ex: `public static int[][] getArray()`

## Multidimensional arrays

* A 2D array consists of an array of 1D arrays....a 3D array would then consists of an array of 2D arrays...and so on
* for each "dimension", add one pair of square brackets to array definition/ declaration
  * Ex: (for 3D array) `double[][][] scores = new double[6][5][2];`

### NOTE TO SELF: I skipped a whole bunch of case studies and exercises in this chapter...should go back in look over them in depth
