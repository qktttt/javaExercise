public class Sorting {
	private static int[] aux;

	private static void parition(Comparable[] a, int p, int r) {
		Comparable midValue = a[r];
		int lessPointer = p - 1;
		for (int i = p; i < r; i++) {
			if (lessOrEqual(a[i], midValue)) {
				lessPointer++;
				exch(a, lessPointer, i);
			}
		}
		exch(a, ++lessPointer, r);
		return lessPointer;
	}

	public static void quickSort(Comparable[] a, int p, int r) {
		if (p < r) {
			q = parition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	// in this method
	// the quickSort3 will need to
	// handle duplicate elelments 
	// in the array
	public static void quickSort3(Comparable[] a, int p, int r) {
		// this method is waiting to be finished
		// TODO
	}

	public static void shellSort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j-=h )
					exch(a, j. j-h);
			}
			h = h / 3;
		}
	}

	public static void mergeSort(Comparable[] a) {
		aux = new int[a.length];
		mergeSort(a, 0, a.length - 1);
	}

	private static void mergeSort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(a, lo, mid);
		mergeSort(a, mid + 1, hi);
		merge(a, lo, mid. hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i])) 
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0; 
	}

	public static boolean lessOrEqual(Comparable a, Comparable b) {
		return a.compareTo(b) <= 0;
	}

	public static boolean bigger(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}

	public static boolean biggerOrEqual(Comparable a, Comparable b) {
		return a.compareTo(b) >= 0;
	}

	public static boolean equal(Comparable a, Comparable b) {
		return a.compareTo(b) == 0;
	}

	public static void exch(Object[] collection, int a, int b) {
		Object tmp = collection[a];
		collection[a] = collection[b];
		collection[b] = tmp;
	}
}