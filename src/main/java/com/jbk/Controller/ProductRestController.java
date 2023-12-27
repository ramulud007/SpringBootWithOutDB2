package com.jbk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Model.Product;
import com.jbk.ServiceIMPL.ProductServiceIMPL;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductServiceIMPL service;

	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product) {
		boolean isAdded = service.saveProduct(product);

		if (isAdded) {
			return "saved";
		}
		return "Product Already Exist..";
	}

	@GetMapping("/get-AllProductsList")
	public Object getAllProducts() {
System.out.println("This method is used to get all product list");
		List<Product> list = service.getAllProducts();

		if (list.isEmpty()) {
			return "no data available";
		} else {
			return list;
		}

	}

	@GetMapping("/get-productById/{Id}")
	public Object getProductById(@PathVariable("Id") String Id) {
		Product dbProduct = service.getProductById(Id);
		if (dbProduct != null) {
			return dbProduct;
		} else {
			return "Product not available...";
		}
	}

	@DeleteMapping("/delete-ProductById")
	public String deleteProductById(@RequestParam("id") String id) {
		boolean isDeleted = service.deleteProductById(id);
		if (isDeleted) {
			return "Product is Deleted..";
		} else {
			return "product not found=" + id;
		}
	}

	@PutMapping("/update-Product")
	public String updateProduct(@RequestBody Product product) {
		boolean isUpdate = service.updateProduct(product);
		if(isUpdate) {
			return "isUpdated";
		}else {
			return "Product not found to update Id= "+product.getProductId();
		}
	}
}
