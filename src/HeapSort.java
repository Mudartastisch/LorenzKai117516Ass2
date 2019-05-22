import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HeapSort {

	public static void swap(int[] arr, int i, int j) { // utility
		arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
	}

	public static void sort(int heapArray[]) {
		// create Heap
		for (int i = heapArray.length / 2 - 1; i >= 0; i--)
			heapify(heapArray, heapArray.length, i);

		// remove last element after each run (should be largest)
		for (int i = heapArray.length - 1; i >= 0; i--) {
			swap(heapArray, i, 0);

			heapify(heapArray, i, 0); // repair Heap
		}
	}

	public static void  heapify(int heapArray[], int n, int i) {
		int largest = i; // starting with root as largest
		int left = 2 * i + 1; // left leaf
		int right = 2 * i + 2; // right leaf

		if (left < n && heapArray[left] > heapArray[largest]) {
			largest = left; // if left child is larger than root
		}

		if (right < n && heapArray[right] > heapArray[largest]) {
			largest = right; // if right child is larger then root
		}

		if (largest != i) { // if largest is not root
			swap(heapArray, largest, i);

			heapify(heapArray, n, largest); // heapify sub trees
		}
	}

	public static void print(int printArray[]) { //utility function to print
		for (int i = 0; i < printArray.length; ++i)
			System.out.print(printArray[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) throws IOException {
		String stringArray;
		int[] result;
		
		Scanner scanner = new Scanner(new File("examples.txt"));
		while(scanner.hasNextLine()){
			stringArray = scanner.nextLine();
			String[] items = stringArray.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

			 result = new int[items.length];

			for (int i = 0; i < items.length; i++) {
			    try {
			        result[i] = Integer.parseInt(items[i]);
			    } catch (NumberFormatException nfe) {
			        System.err.println("Something is wrong in your example.txt");
			    };
			}
			System.out.println("From:");
			print(result);
			sort(result);
			System.out.println("to:");
			print(result);
			System.out.println("\n");

		}
		System.out.println("You can edit example.txt to add your own arrays, please mind the structure");
		scanner.close();
	}
}
