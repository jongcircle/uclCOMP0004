

import java.util.Scanner;


public class StringArray {

    private int size = 0;
    private int max_size = 100; // default = 100
    private String[] elementData = new String[max_size];

    public StringArray() {}

    public StringArray(StringArray a) {
        size = a.size();
        for (int i = 0; i < size; i++) {
            elementData[i] = a.get(i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String get(int index) {
        if (index > size || index < 0){
            return null;
        }
        return elementData[index];
    }

    public void set(int index, String s) {
        if (index <= size && index >= 0 && size != 0){
            elementData[index] = s;
        }
    }

    public void add(String s) {
        if (size == max_size){
            String[] newData = new String[max_size * 2];
            max_size *= 2;
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[i];
            }
            elementData = newData;
        }
        elementData[size] = s;
        size++;
    }

    public void insert(int index, String s) {
        if (size == max_size){
            String[] newData = new String[max_size * 2];
            max_size *= 2;
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[i];
            }
            elementData = newData;
        }
        if (index >= 0 && index <= size && size != 0){
            for (int i = size - 1; i >= index; i--) {
                elementData[i + 1] = elementData[i];
            }
            elementData[index] = s;
            size++;
        }
    }

    public void remove(int index) {
        if (size == max_size/2){
            String[] newData = new String[max_size / 2];
            max_size /= 2;
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[i];
            }
            elementData = newData;
        }
        if (index >= 0 && index <= size && size != 0) {
            for (int i = index + 1; i < size; i++) {
                elementData[i - 1] = elementData[i];
            }
            elementData[size - 1] = null;
            size--;
        }
    }

    public boolean contains(String s) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    public boolean containsMatchingCase(String s) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(String s) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equalsIgnoreCase(s)){
                return i;
            }
        }
        return -1;
    }

    public int indexOfMatchingCase(String s) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(s)){
                return i;
            }
        }
        return -1;
    }

    public void show(){
        for (int i = 0; i < 5; i++) {
            System.out.println(elementData[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringArray elementData = new StringArray();
        while (true) {
            System.out.println("번호입력 : ");
            int su = scanner.nextInt();
            if (su == 1) {
                System.out.println(elementData.size());
            } else if (su == 2) {
                System.out.println(elementData.isEmpty());
            } else if (su == 3) {
                System.out.println("index 입력 : ");
                int index = scanner.nextInt();
                System.out.println(elementData.get(index));
            } else if (su == 4) {
                System.out.println("index 입력 : ");
                int index = scanner.nextInt();
                System.out.println("string 입력 : ");
                String s = scanner.next();
                elementData.set(index, s);
            } else if (su == 5) {
                System.out.println("string 입력 : ");
                String s = scanner.next();
                elementData.add(s);
            } else if (su == 6) {
                System.out.println("index 입력 : ");
                int index = scanner.nextInt();
                System.out.println("string 입력 : ");
                String s = scanner.next();
                elementData.insert(index, s);
            } else if (su == 7) {
                System.out.println("index 입력 : ");
                int index = scanner.nextInt();
                elementData.remove(index);
            } else if (su == 8) {
                System.out.println("string 입력 : ");
                String s = scanner.next();
                System.out.println(elementData.contains(s));
            } else if (su == 9) {
                System.out.println("string 입력 : ");
                String s = scanner.next();
                System.out.println(elementData.containsMatchingCase(s));
            } else if (su == 10) {
                System.out.println("string 입력 : ");
                String s = scanner.next();
                System.out.println(elementData.indexOf(s));
            } else if (su == 11) {
                System.out.println("string 입력 : ");
                String s = scanner.next();
                System.out.println(elementData.indexOfMatchingCase(s));
            } else if (su == 12) {
                elementData.show();
            } else {
                break;
            }
        }
        StringArray elementData2 = new StringArray(elementData);
        System.out.println("elementData2 : ");
        elementData2.show();
    }


}
