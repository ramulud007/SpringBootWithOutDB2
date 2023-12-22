package com.jbk.DaoIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.Dao.ProductDao;
import com.jbk.Model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	List<Product> list = new ArrayList<>();

	public ProductDaoIMPL() {
		System.out.println("Product Added Successfully...");
		list.add(new Product("1", "aa", 101L, 202L, 303, 40000.0));
		list.add(new Product("2", "ab", 102L, 203L, 304, 50000.0));
		list.add(new Product("3", "ac", 103L, 204L, 305, 60000.0));
		list.add(new Product("4", "ad", 104L, 205L, 306, 70000.0));
	}

	@Override
	public boolean saveProduct(Product product) {
		boolean isExist = false;
		for (Product dbproduct : list) {
			if (dbproduct.getProductName().equalsIgnoreCase(product.getProductName())) {
				isExist = true;
				break;
			}
		}
		if (!isExist) {
			list.add(product);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Product> getAllProducts() {
		
		return list;
	}
	
	@Override
	public Product getProductById(String productId) {
		Product product = null;
		for (Product dbproductId : list) {
			if (dbproductId.getProductId().equals(productId)) {
				product = dbproductId;
				break;
			}
		}
		return product;

	}

	

	@Override
	public boolean deleteProductById(String productId) {
		boolean isDeleted=false;
		for (Product dbproduct : list) {
			if (dbproduct.getProductId().equals(productId)) {
			list.remove(dbproduct);
			isDeleted=true;
				break;
			}
			
			}
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated=false;
		for(Product dbProduct:list) {
		if(dbProduct.getProductId().equals(product.getProductId())) {
			list.set(list.indexOf(product), product);
			isUpdated=true;
			break;
		}
		}
		return isUpdated;
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
