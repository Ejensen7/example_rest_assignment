package com.erik;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.erik.models.Item;
import com.erik.repositories.ItemRepository;

@SpringBootApplication
public class MyRestTestApplication {

	
	@Value("${items.item1.name}")
	private String item1name;
	@Value("${items.item1.price}")
	private String item1price;
	@Value("${items.item1.type}")
	private String item1type;
	@Value("${items.item1.bin}")
	private String item1bin;
	@Value("${items.item2.name}")
	private String item2name;
	@Value("${items.item2.price}")
	private String item2price;
	@Value("${items.item2.type}")
	private String item2type;
	@Value("${items.item2.bin}")
	private String item2bin;
	@Value("${items.item3.name}")
	private String item3name;
	@Value("${items.item3.price}")
	private String item3price;
	@Value("${items.item3.type}")
	private String item3type;
	@Value("${items.item3.bin}")
	private String item3bin;
	@Value("${case_lifecycle_stage}")
	private String case_lifecycle_stage;
	@Value("${page_size}")
	private int page_size;
	
	public static void main(String[] args) {
		SpringApplication.run(MyRestTestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initializeDb(ItemRepository repo) {
		return (args) -> {
			System.out.println(case_lifecycle_stage);
			System.out.println(page_size);
			Date toDate = new Date();
			Date fromDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			String fromDateString= dateFormat.format(fromDate).replaceAll("%3A", ":");
			System.out.println(fromDateString);
			repo.deleteAll();
			// Insert some items
			ArrayList<Item> items = new ArrayList<Item>();
			items.add(new Item(item1name, item1price, item1type, item1bin));
			items.add(new Item(item2name, item2price, item2type, item2bin));
			items.add(new Item(item3name, item3price, item3type, item3bin));
			items.add(new Item("Violin", "90.11", "Instruments", "A004-IN"));
			items.add(new Item("Chocolate Bar", "1.00", "Candy", "A005-CA"));
			items.add(new Item("Wrench", "3.30", "Tools", "A006-TO"));
			items.add(new Item("House in the Andies", "500000000.01", "Housing", "A007-HO"));
			items.add(new Item("GTO", "898000.99", "Cars", "A008-CA"));
			items.add(new Item("Horse", "5673.20", "Animals", "A009-AN"));
			items.add(new Item("Razor", "10.00", "Health", "A010-HE"));
			repo.save(items);			
		};
	}
}
