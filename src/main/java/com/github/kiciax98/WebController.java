package com.github.kiciax98;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebController {

    private CatList catList;

    WebController(CatList catList){
        this.catList = catList;
    }

    @GetMapping("/catDatabase")
    List<Cat> showAllCats (){
        return catList.giveCatList();
    }

    @GetMapping("/catDatabase/{id}")
    Cat showCatById (@PathVariable int id){
        for(Cat cat : CatList.giveCatList()){
            if(cat.getId()== id){
                return cat;
            }
        }
        return catList.giveCatList().get(id);
    }

    @PostMapping("/addCat")
    Cat addCatToDatabase(@RequestBody Cat newCat){
        Cat cat = new Cat(newCat.getName(), newCat.getDate(), newCat.getWeight(), newCat.getKeeperName());
        catList.addCatToList(cat);
        return cat;
    }

    @PutMapping("/replaceCatData/{id}")
    Cat replaceCatDataById(@RequestBody Cat newCat, @PathVariable int id){
        for(Cat cat : CatList.giveCatList()){
            if(cat.getId()== id){
                cat.setName(newCat.getName());
                cat.setDate(newCat.getDate());
                cat.setWeight(newCat.getWeight());
                cat.setKeeperName(newCat.getKeeperName());
                return cat;
            }
        }
        return CatList.giveCatList().get(id);
    }

    @DeleteMapping("/removeCat/{id}")
    List<Cat> removeCatById(@PathVariable int id){
        int catPositionInList=0;
        for(Cat cat : CatList.giveCatList()){
            if(cat.getId() == id){
            break;
            }
            catPositionInList++;
        }
        CatList.giveCatList().remove(catPositionInList);
        return CatList.giveCatList();
    }

}
