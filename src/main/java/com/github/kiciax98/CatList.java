package com.github.kiciax98;

import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CatList {

    private static List<Cat> catList = new LinkedList<>();

    public void addCatToList(Cat cat){
        catList.add(cat);
        System.out.println("Cat added");
    }

    static List<Cat> giveCatList(){
        return catList;
    }
}
