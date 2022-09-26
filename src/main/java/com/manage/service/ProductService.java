package com.manage.service;

import java.util.List;

import com.manage.entity.Product;
import com.manage.model.Product_Supplier;

public interface ProductService {
public boolean saveProduct(Product  product);//done
public boolean deleteProduct(int productId);//done
public boolean updateProduct(Product product);//done
public Product getProductbyId(int productId);//done
public List<Product> getProductByName(String productName);//done
public List<Product> getProductbySellerId(String productSellerId);//done
public List<Product> getProductbyType(String productType);//done
public List<Product> listgetAllProduct();//done
public List<Product>  getMaxPriceProductlist();//done
public List<Product> getMinPriceProduct();//done
public List<Product> getProductPriceGT(Double productPrice);//done
public List<Product> getProductPriceLt(Double productPrice);//done
public List<Product> getProductPriceBTW(Double LPrice,Double Hprice);//done
public List<Product> getProductnameisPenOrtypeEdu(String ptype,String pname);//done
public Integer getQuantity(int productId);
//public  List<Product> getProdGTavgPrice();

public List<Product> getProdLTavgPrice();

public List<Product> getProductExceptTpye();

public List<Product> getProduct(Double LPrice,Double Hprice);//done

public List<Product> getProducteBTW(Double LPrice,Double Hprice);//done


public boolean updateProductbyId(int productId ,Product product);//done

public String importExcel();
public Product_Supplier getproductandSupplierbyProductId(int productId);





}
