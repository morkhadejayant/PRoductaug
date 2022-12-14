package com.manage.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity 
public class Product {
	@Id
private Integer productId;
 private String productName;
private double productPrice;
private String productType;
private int productQty;

private int supplierId;
public Product(int productId, String productName, double productPrice, String productType, int productQty,
		int supplierId) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.productType = productType;
	this.productQty = productQty;
	
	this.supplierId = supplierId;
}
public Product() {
	super();
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public int getProductQty() {
	return productQty;
}
public void setProductQty(int productQty) {
	this.productQty = productQty;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int Supplier) {
	this.supplierId = Supplier;
	
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
			+ ", productType=" + productType + ", productQty=" + productQty + ", SupplierId=" + supplierId
			+ "]";
}
}

