package com.eg.sba1.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eg.sba1.model.Item;
@Repository
public class ItemRepository {
	
	

	    @Autowired
	    JdbcTemplate template;

	    /*Getting all Items from table*/
	    public List<Item> getAllItems(){
	        List<Item> items = template.query("select id, name,category from item",(result,rowNum)->new Item(result.getInt("id"),
	                result.getString("name"),result.getString("category")));
	        return items;
	    }
	    /*Getting a specific item by item id from table*/
	    public Item getItem(int itemId){
	        String query = "SELECT * FROM ITEM WHERE ID=?";
	        Item item = template.queryForObject(query,new Object[]{itemId},new BeanPropertyRowMapper<>(Item.class));

	        return item;
	    }
	    /*Adding an item into database table*/
	    public int addItem(Item item){
	    	int id = item.getId();
	    	String name = item.getName();
	    	String category = item.getCategory();
	        String query = "INSERT INTO ITEM VALUES(?,?,?)";
	        return template.update(query,id,name,category);
	    }
	    /*delete an item from database*/
	    public int deleteItem(int id){
	        String query = "DELETE FROM ITEM WHERE ID =?";
	        return template.update(query,id);
	    }

}
