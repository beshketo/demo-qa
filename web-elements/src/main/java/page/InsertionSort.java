public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Зсуваємо елементи, які більші за key, вправо
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Вставляємо key у правильне місце
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        insertionSort(arr);

        // Виводимо відсортований масив
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
