package com.jbk.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.Model.Product;
@Repository
public interface ProductDao {
	public boolean saveProduct(Product product);
	public Product getProductById(String productId);
	public List<Product> getAllProducts();
	public boolean deleteProductById(String productId);
	public boolean updateProduct(Product product);
	
	public List<Product> getProductById_ASC();
	public List<Product> getProductByName_DSC();
	public Product getMaxPriceProducts();
	public double getSumOfProductPrice();
	public int getTotalCountOfProducts();

}
