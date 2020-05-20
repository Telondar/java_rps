package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.HashMap;

public class HashWork extends AbstractHash {

    /** hashMap field **/
    public final HashMap<Integer, Object> hash;
    public Integer[] result_list;

    /**
        Constrictor - create new object
     **/
    public HashWork() {
        hash = new HashMap<>();
        out = System.out;
    }


    @Override
    public PrintStream getOutStream() {
        return this.out;
    }


    @Override
    public void setOutStream(PrintStream out) {
        this.out = out;
    }


    /**
     * Append element to Hash
     * @param key Input key Integer
     * @param value Input value Object
     */
    public void appendElement(Integer key, Object value) {
        if (isInitKey(key)){
           this.out.println("Key is init");
           updateElement(key, value);
        }else{
            hash.put(key, value);
        }
    }


    /**
     * is Init key in {@link HashWork#hash}
     * @param key hashmap key
     * @return if init then true else false
     */
    public boolean isInitKey(Integer key) {
        return this.hash.get(key) != null;
    }


    /**
     * Drop element by key
     * @param key Element key
     */
    public void dropElement(Integer key){
        if (isInitKey(key)) {
            hash.remove(key);
            this.out.println("Element is Dropped");
        }else{
            this.out.println("Element not Found");
        }
    }

    /**
     * Update value element for key
     * @param key Element key
     * @param value Element value
     */
    private void updateElement(Integer key, Object value) {
        hash.replace(key, value);
        this.out.println("Value updated");
    }


    /**
     * Show all Element
     */
    public void showHash() {
        if (!hash.isEmpty()) {
            for (Integer key: hash.keySet()) {
                this.out.println("Key: " + key + " Value: " + hash.get(key));
            }
        }else{
            this.out.println("Hash is Empty");
        }
    }

    /**
     * Valid input data
     * @param value Element value
     * @return is_valid
     */
    public boolean valid (Object value) {
        if (value.equals("")){
            this.out.println("invalid Data");
            return false;
        }
        return true;
    }

    /**
     * validate key
     * @param key not clean data
     * @return is input data valid
     */
    public boolean inputData(String key) {
        try {
            Integer.parseInt(key);
            return true;
        }catch (NumberFormatException e){
            this.out.println("Input value is not integer");
            return false;
        }
    }

    /**
     * Shell Sort
     */
    public void shellSort() {
        if (!hash.isEmpty()) {
            List<Integer> listKeys = new ArrayList<>(hash.keySet());
            Integer[] obj = listKeys.toArray(new Integer[0]);
            Integer[] result = sort(obj);
            result_list = obj;
            this.out.println("Result");
            for (Integer key : result) {
                this.out.println("Key: " + key + " Value: " + hash.get(key));
            }
        }else{
            this.out.println("Hash is Empty");
        }
    }

    /**
     * IntroSort
     */
    public void iterSort() {
        if (!hash.isEmpty()) {
            List<Integer> listKeys = new ArrayList<>(hash.keySet());
            Integer[] obj = listKeys.toArray(new Integer[0]);
            sorts(obj);
            result_list = obj;
            this.out.println(Arrays.toString(obj));
            for (Integer key : obj) {
                this.out.println("Key: " + key + " Value: " + hash.get(key));
            }
        }else {
            this.out.println("Hash is Empty");
        }
    }

    /**
     * Quick Sort
     */
    public void quicSort() {
        if (!hash.isEmpty()) {
            List<Integer> listKeys = new ArrayList<>(hash.keySet());
            Integer[] obj = listKeys.toArray(new Integer[0]);
            quickSort(obj, 0, obj.length-1);
            result_list = obj;
            this.out.println(Arrays.toString(obj));
            for (Integer key : obj) {
                this.out.println("Key: " + key + " Value: " + hash.get(key));
            }
        }else {
            this.out.println("Hash is Empty");
        }
    }

}
