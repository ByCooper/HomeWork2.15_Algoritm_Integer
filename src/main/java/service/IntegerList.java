package service;

import exception.NotFoundElementException;
import exception.NullValueFindException;
import exception.OutsideSelectException;
import object.Repository;

import java.util.Arrays;

public class IntegerList implements ServiceIntegerList {
    Repository repository = new Repository();

    @Override
    public Integer add(Integer item) {
        Integer[] rep = new Integer[repository.length() + 1];
        System.arraycopy(repository.getRepository(), 0, rep, 0, repository.length());
        rep[rep.length - 1] = item;
        repository.setRepository(rep);
        return repository.getRepository()[rep.length - 1];
    }

    @Override
    public Integer add(int index, Integer item) {
        Integer[] rep = new Integer[repository.length() + 1];
        if (index > rep.length - 1) {
//            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
            grow();
            add(index, item);
        } else if (index == 0) {
            System.arraycopy(repository.getRepository(), 0, rep, 1, repository.length());
            rep[index] = item;
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            rep[index] = item;
            System.arraycopy(repository.getRepository(), index, rep, index + 1, repository.length() - index);
            repository.setRepository(rep);
        }
        return repository.getRepository()[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        Integer[] rep = new Integer[repository.length()];
        if (index > rep.length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        } else if (index == 0) {
            System.arraycopy(repository.getRepository(), 1, rep, 1, repository.length() - (index + 1));
            rep[index] = item;
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            rep[index] = item;
            System.arraycopy(repository.getRepository(), index + 1, rep, index + 1, repository.length() - (index + 1));
            repository.setRepository(rep);
        }
        return repository.getRepository()[index];
    }

    @Override
    public Integer remove(Integer item) {
        int index = Integer.MIN_VALUE;
        Integer[] rep = new Integer[repository.length() - 1];
        for (int i = 0; i < repository.length(); i++) {
            if (item == repository.getRepository()[i]) {
                index = i;
            }
        }
        if (index < 0) {
            throw new NotFoundElementException("Элемент не найден");
        }
        else if (index == 0) {
            System.arraycopy(repository.getRepository(), 1, rep, 0, repository.length() - 1);
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            System.arraycopy(repository.getRepository(), index + 1, rep, index, repository.length() - (index + 1));
            repository.setRepository(rep);
        }
        return item;
    }

    @Override
    public Integer removeIndex(int index) {
        if (index > repository.getRepository().length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        }
        Integer[] rep = new Integer[repository.length() - 1];
        Integer remove = repository.getRepository()[index];
        if (index == 0) {
            System.arraycopy(repository.getRepository(), 1, rep, 0, repository.length() - 1);
            repository.setRepository(rep);
        } else {
            System.arraycopy(repository.getRepository(), 0, rep, 0, index);
            System.arraycopy(repository.getRepository(), index + 1, rep, index, repository.length() - (index + 1));

            repository.setRepository(rep);
        }
        return remove;
    }

    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < repository.length(); i++) {
            if (repository.getRepository()[i] == null) {
                throw new NullValueFindException("В списке недопустимое значение=null");
            }
        }
        quickSort(repository.getRepository());
        return binarySearch(repository.getRepository(), item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < repository.length(); i++) {
            if(repository.getRepository()[i].equals(item)){
                int index;
                return index = i;
            }
        }
        return - 1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = repository.length() - 1; i >= 0; i--) {
            if(repository.getRepository()[i].equals(item)){
                int index;
                return index = i;
            }
        }
        return - 1;
    }

    @Override
    public Integer get(int index) {
        if (index > repository.getRepository().length - 1) {
            throw new OutsideSelectException("Вы выбрали индекс, который находится за пределами массива");
        }
        return repository.getRepository()[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            if (otherList.get(i) == null) {
                throw new NullValueFindException("В списке недопустимое значение=null");
            }
        }
        Integer[] rep = new Integer[otherList.size()];
        for (int i = 0; i < otherList.size(); i++) {
            rep[i] = otherList.get(i);
        }
        if (Arrays.equals(repository.getRepository(), rep)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return repository.length();
    }

    @Override
    public boolean isEmpty() {
        if (repository.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        Integer[] rep = new Integer[0];
        repository.setRepository(rep);
    }

    @Override
    public Integer[] toArray() {
        Integer[] rep = new Integer[repository.length()];
        System.arraycopy(repository.getRepository(), 0, rep, 0, repository.length());
        return rep;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    @Override
    public Integer[] sortedBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    @Override
    public Integer[] sortedSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
        return arr;
    }

    @Override
    public Integer[] sortedInsert(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private boolean binarySearch(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


    private void grow() {
        Integer[] rep = new Integer[repository.length() + (repository.length() / 2)];
        System.arraycopy(repository.getRepository(), 0, rep, 0, repository.length());
        repository.setRepository(rep);
    }

    @Override
    public Integer[] quickSort(Integer[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[arr.length - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }
        quickSort(left);
        quickSort(right);
        merge(arr, left, right);
        return arr;
    }
    public void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}
