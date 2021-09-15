package ua.com.alevel;

import java.util.Arrays;

public class MathSet {

    private int capacity;
    private Number[] numbers;

    public MathSet() {
        this.capacity = 10;
        this.numbers = new Number[capacity];
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        this.numbers = new Number[capacity];
    }

    public MathSet(Number[] numbers) {
        this.capacity = numbers.length;
        this.numbers = getUniqueValues(numbers);
    }

    public MathSet(Number[]... numbers) {
        Number[] allNumbers = joinArrays(numbers);
        this.numbers = getUniqueValues(allNumbers);
    }

    public MathSet(MathSet numbers) {
        this.numbers = numbers.getNumbers();
    }

    public MathSet(MathSet... numbers) {
        this.numbers = joinMathSet(numbers);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Number[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Number[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "MathSet{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public void add(Number n) {
        Number[] currentNumbers = this.numbers;
        int index = 0;
        if (!(isPresent(n, currentNumbers))) {
            if (currentNumbers[capacity - 1] != null) {
                index = capacity;
                increaseSet();
                this.numbers[index] = n;
            } else {
                for (int i = 0; i < capacity; i++) {
                    if (currentNumbers[i] != null) {
                        index++;
                    }
                }
                currentNumbers[index] = n;
            }
        }
    }

    public void add(Number... n) {
        for (Number current : n) {
            add(current);
        }
    }

    public void join(MathSet ms) {
        this.numbers = joinMathSet(this, ms);
    }

    public void join(MathSet... ms) {
        for (MathSet current : ms) {
            this.numbers = joinMathSet(this, current);
        }
    }

    public void intersection(MathSet ms) {
        if (this.getNumbers().length >= ms.getNumbers().length) {
            this.setNumbers(intersectMathSet(ms, this));
        } else {
            this.setNumbers(intersectMathSet(this, ms));
        }
    }

    public void intersection(MathSet... ms) {
        for (MathSet current : ms) {
            if (this.getNumbers().length >= current.getNumbers().length) {
                this.setNumbers(intersectMathSet(current, this));
            } else {
                this.setNumbers(intersectMathSet(this, current));
            }
        }
    }

    void sortDesc() {
        Number temp;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() > numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortDesc(int firstIndex, int lastIndex) {
        Number temp;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            for (int j = i; j > firstIndex; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() > numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortDesc(Number value) {
        int index = getIndex(value);
        sortDesc(index, numbers.length - 1);
    }

    void sortAsc() {
        Number temp;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() < numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortAsc(int firstIndex, int lastIndex) {
        Number temp;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            for (int j = i; j > firstIndex; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() < numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortAsc(Number value) {
        int index = getIndex(value);
        sortAsc(index, numbers.length - 1);
    }

    Number get(int index) {
        return this.getNumbers()[index];
    }

    Number getMax() {
        MathSet ms = new MathSet(this.getNumbers());
        ms.sortDesc();
        return ms.getNumbers()[0];
    }

    Number getMin() {
        MathSet ms = new MathSet(this.getNumbers());
        ms.sortAsc();
        return ms.getNumbers()[0];
    }

    Number getAverage() {
        Number sum = 0;
        int count = 0;
        Number result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != null) {
                sum = sum.doubleValue() + numbers[i].doubleValue();
                count++;
            }
        }
        if (count > 0) {
            result = sum.doubleValue() / count;
        }
        return result;
    }

    Number getMedian() {
        Number median = 0;
        MathSet ms = new MathSet(this.getNumbers());
        ms.sortAsc();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != null) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        } else if (count % 2 == 0) {
            median = (ms.getNumbers()[count / 2].doubleValue() + ms.getNumbers()[(count / 2) - 1].doubleValue()) / 2;

        } else {
            median = ms.getNumbers()[count / 2];
        }
        return median;
    }

    Number[] toArray() {
        return this.getNumbers();
    }

    Number[] toArray(int firstIndex, int lastIndex) {
        int size = lastIndex - firstIndex + 1;
        int index = 0;
        Number[] result = new Number[size];
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            result[index] = this.getNumbers()[i];
            index++;
        }
        return result;
    }

    MathSet cut(int firstIndex, int lastIndex) {
        Number[] array = this.toArray(firstIndex, lastIndex);
        MathSet ms = new MathSet();
        ms.setNumbers(array);
        return ms;
    }

    void clear() {
        for (int i = 0; i < getNumbers().length; i++) {
            numbers[i] = null;
        }
    }

    void clear(Number[] numbers) {
        int index;
        for (Number num : numbers) {
            index = getIndex(num);
            this.numbers[index] = null;
            for (int i = index; i < this.numbers.length; i++) {
                if (i == this.numbers.length - 1) {
                    this.numbers[i] = null;
                } else {
                    this.numbers[i] = this.numbers[i + 1];
                }
            }
        }
    }

    private int getIndex(Number number) {
        int index = 0;
        if (isPresent(number, this.getNumbers())) {
            while (this.getNumbers()[index] != number) {
                index++;
            }
        }
        return index;
    }

    private void increaseSet() {
        this.capacity = capacity * 3 / 2 + 1;
        Number[] temp = new Number[capacity];
        for (int i = 0; i < this.numbers.length; i++) {
            temp[i] = this.numbers[i];
        }
        this.numbers = temp;
    }

    private Number[] joinMathSet(MathSet... numbers) {
        int size = 0;
        int current = 0;
        for (MathSet num : numbers) {
            size += num.getNumbers().length;
        }
        Number[] allNumbers = new Number[size];
        for (MathSet num : numbers) {
            for (Number n : num.getNumbers()) {
                allNumbers[current] = n;
                current++;
            }
        }
        return getUniqueValues(allNumbers);
    }

    private Number[] joinArrays(Number[]... numbers) {
        int size = 0;
        int current = 0;
        for (Number[] num : numbers) {
            size += num.length;
        }
        Number[] allNumbers = new Number[size];
        for (Number[] num : numbers) {
            for (Number n : num) {
                allNumbers[current] = n;
                current++;
            }
        }
        return allNumbers;
    }

    private Number[] intersectMathSet(MathSet msShort, MathSet msLong) {
        int resultCount = 0;
        for (int i = 0; i < msShort.getNumbers().length; i++) {
            if (isPresent(msShort.getNumbers()[i], msLong.getNumbers())) {
                resultCount++;
            }
        }
        Number[] result = new Number[resultCount];
        resultCount = 0;
        for (int i = 0; i < msShort.getNumbers().length; i++) {
            if (isPresent(msShort.getNumbers()[i], msLong.getNumbers())) {
                result[resultCount] = msShort.getNumbers()[i];
                resultCount++;
            }
        }
        return result;
    }

    private Number[] getUniqueValues(Number[] numbers) {
        Number[] result = new Number[numbers.length];
        int resultCount = 0;
        boolean isPresent;
        for (int i = 0; i < numbers.length; i++) {
            isPresent = false;
            for (int j = 0; j < i; j++) {
                isPresent = isPresent(numbers[i], result);
            }
            if (!(numbers[i] == null) && isPresent == false) {
                result[resultCount] = numbers[i];
                resultCount++;
            }
        }
        return result;
    }

    private boolean isPresent(Number item, Number[] numbers) {
        boolean isPresent = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == item) {
                isPresent = true;
            }
        }
        return isPresent;
    }
}
