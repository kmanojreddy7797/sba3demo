package com.eg.sba1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.sba1.model.Item;
import com.eg.sba1.repo.ItemRepository;

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    @RequestMapping("/getAllItems")
    @ResponseBody
    public List<Item> getAllItems(){
        return itemRepo.getAllItems();
    }

    @RequestMapping("/getItem")
    @ResponseBody
    public Item getItem(@RequestParam("itemId") int itemId){
        return itemRepo.getItem(itemId);
    }

//    @RequestMapping("/addItem")
//    @ResponseBody
//    public String addItem(@RequestParam(value = "id") int id,@RequestParam("name") String name,
//                              @RequestParam("category") String category){
//    	System.out.println("Reached method"); 
//        if(itemRepo.addItem(id,name,category) >= 1){
//            return "Item Added Successfully";
//        }else{
//            return "Something went wrong !";
//        }
//    }
    @RequestMapping(value="/addItem",method=RequestMethod.POST)
    public String addItem(@RequestBody Item item){
    	System.out.println("Reached method"); 
        if(itemRepo.addItem(item) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deteteItem")
    @ResponseBody
    public String deteteItem(@RequestParam("itemId") int itemId){
        if(itemRepo.deleteItem(itemId) >= 1){
            return "Item Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
