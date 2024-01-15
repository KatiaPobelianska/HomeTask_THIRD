package homeTask20231221.task1;
/* Дан массив строк на 10_000 элементов. Отсортируйте строки по длине, используя сортировку слиянием.
Сортировка должна быть выполнена в многопоточном режиме с применением ForkJoinPool.*/
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMergeSort {
    static class MergeSortTask extends RecursiveTask<String[]> {
        private final String[] array;

        public MergeSortTask(String[] array) {
            this.array = array;
        }

        @Override
        protected String[] compute() {
            if (array.length <= 1) {
                return array;
            }

            int mid = array.length / 2;

            MergeSortTask leftTask = new MergeSortTask(Arrays.copyOfRange(array, 0, mid));
            MergeSortTask rightTask = new MergeSortTask(Arrays.copyOfRange(array, mid, array.length));

            invokeAll(leftTask, rightTask);

            String[] leftResult = leftTask.join();
            String[] rightResult = rightTask.join();

            return merge(leftResult, rightResult);
        }

        private String[] merge(String[] left, String[] right) {
            String[] result = new String[left.length + right.length];
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i].length() <= right[j].length()) {
                    result[k++] = left[i++];
                } else {
                    result[k++] = right[j++];
                }
            }

            while (i < left.length) {
                result[k++] = left[i++];
            }

            while (j < right.length) {
                result[k++] = right[j++];
            }

            return result;
        }
    }

    public static void main(String[] args) {
        String[] array = generateRandomStrings(10_000, 5, 15);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String[] sortedArray = forkJoinPool.invoke(new MergeSortTask(array));

        System.out.println(Arrays.toString(sortedArray));
    }

    private static String[] generateRandomStrings(int count, int minLength, int maxLength) {
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            int length = minLength + (int) (Math.random() * (maxLength - minLength + 1));
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char randomChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
                sb.append(randomChar);
            }
            array[i] = sb.toString();
        }
        return array;
    }
}

