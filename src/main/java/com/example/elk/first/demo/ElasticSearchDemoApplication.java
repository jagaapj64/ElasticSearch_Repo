package com.example.elk.first.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.example.elk.first.demo.model.CustomerProduct;
import com.example.elk.first.demo.repo.CustomerProductRepository;

@SpringBootApplication
public class ElasticSearchDemoApplication {

	private static final String COMMA_DELIMITER = ",";

	@Autowired
	private ElasticsearchOperations esOps;

	@Autowired
	private CustomerProductRepository customerProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemoApplication.class, args);

	}

	@PreDestroy
	public void deleteIndex() {
		esOps.indexOps(CustomerProduct.class).delete();
	}

	@PostConstruct
	public void buildIndex() throws IOException, ClassNotFoundException {

		esOps.indexOps(CustomerProduct.class).refresh();
		customerProductRepository.deleteAll();
		Iterable<CustomerProduct> result = customerProductRepository.saveAll(prepareDataset());
		System.out.println("file saved successfully!............");
	}

	public List<CustomerProduct> prepareDataset() throws IOException, ClassNotFoundException {

		File resource = new File("./src/main/resources/Book.csv");
        InputStream targetStream = new FileInputStream(resource);

		List<CustomerProduct> productList = new ArrayList<CustomerProduct>();
       int count=1;
		try (

				Scanner scanner = new Scanner(targetStream);) {
			System.out.println("scanner :"+scanner);
			int lineNo = 0;

			while (scanner.hasNextLine()) {
				++lineNo;
				String line = scanner.nextLine();
				System.out.println("line :"+count+++" "+line);
				if (lineNo == 1)
					continue;
				Optional<CustomerProduct> product = csvRowToProductMapper(line);
				if (product.isPresent())
					productList.add(product.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	private Optional<CustomerProduct> csvRowToProductMapper(final String line) {
        System.out.println(line);
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
//				String name = rowScanner.next();
//				String description = rowScanner.next();
//				String manufacturer = rowScanner.next();
//				return Optional.of(CustomerProduct.builder().Name(name).Description(description)
//						.Manufacturer(manufacturer).build());
				
				Integer invoiceNo = rowScanner.nextInt();
				String StockCode = rowScanner.next();
				String description = rowScanner.next();
				Integer quantity = rowScanner.nextInt();
				String invoiceDate = rowScanner.next();
				
				Double unitPrice = rowScanner.nextDouble();
				Integer customerID = rowScanner.nextInt();
				String country = rowScanner.next();
				return Optional.of(CustomerProduct.builder().InvoiceNo(invoiceNo).StockCode(StockCode).Description(description).Quantity(quantity)
						.InvoiceDate(invoiceDate).UnitPrice(unitPrice).CustomerID(customerID).Country(country)
						.build());

			}
		}
		return Optional.of(null);
	}
}
