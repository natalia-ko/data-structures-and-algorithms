import sorting.InsertionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        InsertionSort<MyClass> is = new InsertionSort<>();
        int[] toSort = {-10, 12, 13, 666, 32, -156};

        MyClass[] myC = {new MyClass("A", 500), new MyClass("C", -123), new MyClass("Q", 4), new MyClass("F", 468)};
        is.insertionSort(myC);

        is.insertionSort(toSort);
        System.out.println(Arrays.toString(toSort));
        System.out.println(Arrays.toString(myC));



    }

    private static class MyClass implements Comparable<MyClass> {

        private String name;
        private int number;

        public MyClass(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(MyClass o) {
            return this.name.compareTo(o.getName()) ;
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
