package java_tasks.level_4;

import java.util.Arrays;

    /*
    Р РµР°Р»РёР·РѕРІР°С‚СЊ СЃС‚СЌРє СЃ РїРѕРјРѕС‰СЊСЋ РјР°СЃСЃРёРІР°.
    РќСѓР¶РЅРѕ СЂРµР°Р»РёР·РѕРІР°С‚СЊ РјРµС‚РѕРґС‹:
    size(), empty(), push(), peek(), pop().
     */
    public class MyStack {
        private int[] array;
        private int size;

        MyStack(int capacity){
            array = new int[capacity];
        }

        int size(){
            return size;
        }

        boolean empty(){
            return size == 0;
        }
        void push(int element){
            if (array.length <= size){
                int[] array2 = new int[array.length + 10];
                System.arraycopy(array, 0, array2, 0, array.length);
                array = array2;
            }
            array[size] = element;
            size++;
        }
        int peek(){
            return array[size-1];
        }
        int pop(){
            int val = array[size-1];
            size--;
            return val;
        }

        public String toString() {
            int[] arr = new int[size];
            System.arraycopy(array, 0, arr, 0, size);
            return Arrays.toString(arr);
        }
    }

