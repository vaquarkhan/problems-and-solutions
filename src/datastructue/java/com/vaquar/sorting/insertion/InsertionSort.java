package datastructue.java.com.vaquar.sorting.insertion;

import static datastructue.java.com.vaquar.sorting.utils.SortUtils.exchange;
import static datastructue.java.com.vaquar.sorting.utils.SortUtils.less;

public class InsertionSort {

	public Comparable[] sort(Comparable[] items) {

		for (int i = 0; i < items.length; i++) {

			for (int j = i; j > 0; j--) {
				if (less(items[j], items[j - 1])) {
					exchange(items, j, j - 1);
				} else {
					break;
				}
			}

		}

		return items;

	}

}
