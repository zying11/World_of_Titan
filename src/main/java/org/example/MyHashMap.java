package org.example;

import java.util.ArrayList;

public class MyHashMap {
    ArrayList<Entry> map;

    public MyHashMap(){
        this.map = new ArrayList<>();
    }

    public void put (char key, char value){
        map.add(new Entry(key, value));
    }

    public char get (char key){
        for (Entry obj : map){
            if(obj.key == key){
                return obj.value;
            }
        }
        return 0;
    }




}

class Entry{
    public char key;
    public char value;

    public Entry(char key, char value){
        this.key = key;
        this.value = value;
    }
}
