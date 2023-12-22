package com.jbk.ServiceIMPL;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Dao.ProductDao;
import com.jbk.Model.Product;
import com.jbk.Service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;
	
	List<Product> list=new ArrayList<>();
	
	@Override
	public boolean saveProduct(Product product) {
		
		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(productId);
		return dao.saveProduct(product);
	
	}

	@Override
	public List<Product> getAllProducts() {
	List<Product> list = dao.getAllProducts();
		return list;
	}

	
	@Override
	public Product getProductById(String productId) {
		return dao.getProductById(productId);
		
	}

	@Override
	public boolean deleteProductById(String productId) {
		return dao.deleteProductById(productId);
		
	}

	@Override
	public boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	
	}

	@Override
	public List<Product> getProductById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByName_DSC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSumOfProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCountOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}


}
