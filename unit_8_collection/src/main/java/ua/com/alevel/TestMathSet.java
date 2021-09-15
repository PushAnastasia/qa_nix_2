package ua.com.alevel;

public class TestMathSet {

    public static void run() {
        //Default constructor
        MathSet setConstructorDef = new MathSet();
        System.out.println("MathSet default constructor " + setConstructorDef);
        //Constructor with capacity argument
        MathSet setConstrCapacity = new MathSet(15);
        System.out.println("MathSet constructor with capacity argument " + setConstrCapacity);
        //Constructor with array argument
        Number[] array1 = {10, -2, 5, 8, 0.7, 8, 5, 3};
        MathSet setConstrArray = new MathSet(array1);
        System.out.println("MathSet constructor with { 10, -2, 5, 8 , 0.7, 8, 5, 3 } array argument " + setConstrArray);
        System.out.println();
        //Constructor with array vararg
        Number[] array2 = {6, 2, 15, 8, -7, 8, 2, 13};
        Number[] array3 = {5, 10, 15, 20, 20};
        Number[] array4 = {-1, -3, -5, -7};
        MathSet setConstrArrays = new MathSet(array2, array3, array4);
        System.out.println("MathSet constructor with { 6, 2, 15, 8 , -7, 8, 2, 13 }, { 5, 10, 15, 20 , 20 } and " +
                "{ -1, -3, -5, -7 } array arguments:");
        System.out.println(setConstrArrays);
        System.out.println();
        //Constructor with MathSet argument
        MathSet setConstMathSet = new MathSet(setConstrArray);
        System.out.println("MathSet constructor with MathSet argument " + setConstMathSet);
        System.out.println();
        //Constructor with MathSet vararg
        MathSet setConstMathSets = new MathSet(setConstrArray, setConstrArrays);
        System.out.println("MathSet constructor with MathSet arguments: [10, -2, 5, 8, 0.7, 3, null, null] and " +
                "[6, 2, 15, 8, -7, 13, 5, 10, 20, -1, -3, -5, null, null, null, null, null]");
        System.out.println(setConstMathSets);
        System.out.println();

        //Methods
        //void add(Number n)
        Number[] array5 = {8, 5, 7, 4, 2};
        MathSet mathSet1 = new MathSet(array5);
        System.out.println("Add value 15 that is not present in MathSet " + mathSet1);
        mathSet1.add(15);
        System.out.println("After adding " + mathSet1);
        System.out.println("Add value 7 that is present in MathSet" + mathSet1);
        mathSet1.add(7);
        System.out.println("After adding " + mathSet1);
        //void add(Number ... n)
        System.out.println("Add 14, 12, 17 and 8 values to MathSet " + mathSet1);
        mathSet1.add(14, 12, 8);
        System.out.println("After adding " + mathSet1);
        System.out.println();

        //void join(MathSet ms)
        Number[] array6 = {4, 7, 8, 12};
        Number[] array7 = {12, 45, 15, 8};
        MathSet mathSet2 = new MathSet(array6);
        MathSet mathSet3 = new MathSet(array7);
        System.out.println("Join MathSet: " + mathSet3 + " to MathSet " + mathSet2);
        mathSet2.join(mathSet3);
        System.out.println("Joined Math Set: " + mathSet2);
        //void join(MathSet ... ms)
        Number[] array8 = {25, 35, 45};
        Number[] array9 = {45, 8, 17, 35};
        MathSet mathSet4 = new MathSet(array8);
        MathSet mathSet5 = new MathSet(array9);
        System.out.println("Join MathSets: " + mathSet4 + " and " + mathSet5 + " to MathSet " + mathSet3);
        mathSet3.join(mathSet4, mathSet5);
        System.out.println("Joined Math Set: " + mathSet3);
        System.out.println();

        //void intersection(MathSet ms)
        System.out.println("Intersection of " + mathSet4 + " and " + mathSet5);
        mathSet4.intersection(mathSet5);
        System.out.println("Result of intersection: " + mathSet4);
        //void intersection (MathSet ... ms)
        Number[] array10 = {26, 14, 17, 8};
        Number[] array11 = {102, 8, 19, 17};
        MathSet mathSet6 = new MathSet(array10);
        MathSet mathSet7 = new MathSet(array11);
        System.out.println("Intersection of " + mathSet5 + ", " + mathSet6 + " and " + mathSet7);
        mathSet5.intersection(mathSet6, mathSet7);
        System.out.println("Result of intersection " + mathSet5);
        System.out.println();

        //void sortDesc()
        System.out.println("Sort in Descending order MathSet: " + mathSet1);
        mathSet1.sortDesc();
        System.out.println("Sorted: " + mathSet1);
        //void sortDesc(int firstIndex, int lastIndex)
        Number[] array12 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MathSet mathSet8 = new MathSet(array12);
        System.out.println("Sort in Descending order from index 3 to index 7 MathSet: " + mathSet8);
        mathSet8.sortDesc(3, 7);
        System.out.println("Sorted: " + mathSet8);
        //void sortDesc(Number value)
        MathSet mathSet9 = new MathSet(array12);
        System.out.println("Sort in Descending order from value 4 MathSet: " + mathSet9);
        mathSet9.sortDesc(4);
        System.out.println("Sorted: " + mathSet9);
        System.out.println();

        //void sortAsc()
        Number[] array13 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        MathSet mathSet10 = new MathSet(array13);
        System.out.println("Sort in Ascending order MathSet: " + mathSet10);
        mathSet10.sortAsc();
        System.out.println("Sorted: " + mathSet10);
        //void sortAsc(int firstIndex, int lastIndex)
        MathSet mathSet11 = new MathSet(array13);
        System.out.println("Sort in Ascending order from index 4 to index 6 MathSet: " + mathSet11);
        mathSet11.sortAsc(4, 6);
        System.out.println("Sorted: " + mathSet11);
        //void sortAsc(Number value)
        MathSet mathSet12 = new MathSet(array13);
        System.out.println("Sort in Ascending order from value 7 MathSet: " + mathSet12);
        mathSet12.sortAsc(7);
        System.out.println("Sorted: " + mathSet12);
        System.out.println();

        //Number get(int index)
        Number[] array14 = {6, 2, 15, 8, -7, 13, 5, 10, 20, -1, -3, -5, 4};
        MathSet mathSet13 = new MathSet(array14);
        System.out.println("Get value by index 6 from MathSet: " + mathSet13);
        System.out.println("Value: " + mathSet13.get(6));
        //Number getMax()
        System.out.println("Get max value from MathSet: " + mathSet13);
        System.out.println("Max Value: " + mathSet13.getMax());
        //Number getMin()
        System.out.println("Get min value from MathSet: " + mathSet13);
        System.out.println("Min Value: " + mathSet13.getMin());
        //Number getAverage()
        System.out.println("Get average value from MathSet: " + mathSet13);
        System.out.println("Average Value: " + mathSet13.getAverage());
        //Number getMedian()
        System.out.println("Get median of MathSet: " + mathSet13);
        System.out.println("Median: " + mathSet13.getMedian());
        System.out.println();

        //Number[] toArray();
        System.out.println("Array representation of MathSet: " + mathSet13);
        for (Number num : mathSet13.toArray()) {
            System.out.print(num + " ");
        }
        System.out.println();
        //Number[] toArray(int firstIndex, int lastIndex);
        System.out.println("Array representation of MathSet taken from index 5 to index 8: " + mathSet13);
        for (Number num : mathSet13.toArray(5, 8)) {
            System.out.print(num + " ");
        }
        System.out.println();
        //MathSet cut(int firstIndex, int lastIndex)
        System.out.println("Cut of MathSet taken from index 3 to index 7: " + mathSet13);
        System.out.println("Cut: " + mathSet13.cut(3, 7));
        System.out.println();

        //void clear()
        System.out.println("Clear the MathSet: " + mathSet13);
        mathSet13.clear();
        System.out.println("After clearing: " + mathSet13);
        //void clear(Number[] numbers)
        MathSet mathSet14 = new MathSet(array14);
        Number[] array15 = {6, 8, 13, 15};
        System.out.println("Clear values 6, 8, 13, 15 from MathSet:" + mathSet14);
        mathSet14.clear(array15);
        System.out.println("After clearing: " + mathSet14);
    }
}
