package com.manage.dao;

import java.util.List;

import com.manage.entity.Product;

public interface ProductDao {
	
		public boolean saveProduct(Product  product);
		public boolean deleteProduct(int productId);
		public Product getProductbyId(int productId);
		public boolean updateProduct(Product product);
		public List<Product> listgetAllProduct();
		public List<Product> getProductByName(String productName);
		public boolean updateProductbyId(int productId ,Product product);//done
		public String uploadSheet(List<Product> list);
		

		public List<Product>  getMaxPriceProductlist();
		public List<Product> getMinPriceProduct();
		public List<Product> getProductbySellerId(String productSellerId);
		public List<Product> getProductbyType(String productType);
		public List<Product> getProductPriceGT(Double productPrice);
		public List<Product> getProductPriceBTW(Double LPrice,Double Hprice);
		public List<Product> getProductnameisPenOrtypeEdu(String pname,String ptype);
		public List<Product> getProductPriceLt(Double productPrice);
		public Integer getQuantity(int productId);




	}
