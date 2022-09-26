package com.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.entity.Product;
import com.manage.model.Product_Supplier;
import com.manage.service.ProductService;
@RestController
@RequestMapping(value="/Product")

public class ProductController {

	@Autowired
	
	private ProductService service;
	@PostMapping(value="/saveProduct")
	public String saveProduct(@RequestBody Product product) {
		boolean flag=service.saveProduct(product);
		if(flag) {
			return "product saved";
		}else {
			return "product not saved";
		}

	}
	@GetMapping(value="/getProduct/{productId}")
	public Product getProductbyId(@PathVariable int productId) {
		return service.getProductbyId(productId);

	}
	@DeleteMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {

		boolean deleted=service.deleteProduct(productId);

		if(deleted) {
			return "Deleted";


		}
		else {
			return "not Deleted";
		}
	}
	@GetMapping (value="/getproductandSupplierbyProductId/{productId}")
	public Product_Supplier getproductandSupplierbyProductId(@PathVariable int productId){
		System.out.println(productId);
		return service.getproductandSupplierbyProductId(productId);
	}
	@PutMapping(value="/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		boolean isUpdate=service.updateProduct(product);
		if(isUpdate) {
			return "product update";

		}else
			return "failed to update";
	}
	@PatchMapping(value="/updateProduct/{productId}")
	public String updateProductbyId(@RequestBody Product product ,@PathVariable  int productId) {
		boolean isUpdate=service.updateProduct(product);
		if(isUpdate) {
			return "product update";

		}else
			return "failed to update";
	}
	
	
	@GetMapping(value="/getAllProducts")
	public List<Product> getAllProduct(){
		return service.listgetAllProduct();
	}
	

	@GetMapping(value="/getProductbyName/{productName}")
	public List<Product> getProductbyName(@PathVariable String productName)
	{
		return service.getProductByName(productName);
	}
	
	
	
	@GetMapping(value="/getProductbySellerId/{productSellerId}")
	public List<Product> getProductbysesslerId(@PathVariable String productSellerId)
	{
		return service.getProductbySellerId(productSellerId);
	}
	
	
	@GetMapping(value="/getProductbytype/{productType}")
	public List<Product> getProductbytype(@PathVariable String productType)
	{System.out.println(productType);
		return service.getProductbyType(productType);
	}
	
	
	@GetMapping(value="/getProductPriceGT/{productPrice}")
	public List<Product> getProductPriceGT(@PathVariable Double productPrice)
	{
		return service.getProductPriceGT(productPrice);
	}
	@GetMapping(value="/getProductPricelt/{productPrice}")
	public List<Product> getProductPricelt(@PathVariable Double productPrice)
	{
		return service.getProductPriceLt(productPrice);
	}
	
	
	@GetMapping(value="/getBTWPrice/{LPrice}/{Hprice}")
	public List<Product> getBTWPrice(@PathVariable Double LPrice,@PathVariable Double Hprice)
	{
		return service.getProductPriceBTW(LPrice, Hprice);
	}
	@GetMapping(value="getOrOperation/{ptype}/{pname}")
	public List<Product> getOrOperation(@PathVariable String ptype,@PathVariable String pname){
		System.out.println(ptype + pname);
		return service.getProductnameisPenOrtypeEdu(ptype, pname);
	}



	@GetMapping(value="/maxProductlist")
	public List<Product> getmaxProductlist()
	{
		return service.getMaxPriceProductlist();
	}
	
	@GetMapping(value="/minProductlist")
	public List<Product> getminProductlist()
	{
		return service.getMinPriceProduct();
	}
	@GetMapping(value="/ProductQty/{productId}")
	public Integer minProductQty(@PathVariable int productId)
	{System.out.println("in controller"+productId);
	System.out.println("in a controller "+service.getQuantity(productId));
		return service.getQuantity(productId);
	
}
	@PostMapping(value="/importExcel")
	public String importExcel() {
		String msg =service.importExcel();
		return msg;
	}
}
