package com.manage.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.manage.dao.ProductDao;
import com.manage.entity.Product;
import com.manage.model.Product_Supplier;
import com.manage.model.Supplier;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	RestTemplate resttemp;
	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {

		return dao.saveProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {

		return dao.deleteProduct(productId);
	}

	@Override
	public Product getProductbyId(int productId) {

		return dao.getProductbyId(productId);
	}

	@Override
	public boolean updateProduct(Product product) {

		return dao.updateProduct(product);
	}

	@Override
	public List<Product> listgetAllProduct() {

		return dao.listgetAllProduct();
	}

	@Override
	public List<Product> getProductByName(String productName) {

		return dao.getProductByName(productName);
	}

	@Override
	public List<Product> getProductbySellerId(String productSellerId) {
		return dao.getProductbySellerId(productSellerId);
	}

	@Override
	public List<Product> getProductbyType(String productType) {
		return dao.getProductbyType(productType);
	}

	@Override
	public List<Product> getProductPriceGT(Double productPrice) {
		return dao.getProductPriceGT(productPrice);
	}

	@Override
	public List<Product> getProductPriceBTW(Double LPrice, Double Hprice) {
		// TODO Auto-generated method stub
		return dao.getProductPriceBTW(LPrice, Hprice);
	}

	@Override
	public List<Product> getMinPriceProduct() {

		return dao.getMinPriceProduct();
	}

	@Override
	public List<Product> getMaxPriceProductlist() {

		return dao.getMaxPriceProductlist();
	}

	@Override
	public List<Product> getProductnameisPenOrtypeEdu(String ptype, String pname) {
		return dao.getProductnameisPenOrtypeEdu(ptype, pname);
	}

	@Override
	public List<Product> getProductPriceLt(Double productPrice) {
		return dao.getProductPriceLt(productPrice);
	}

	@Override
	public Integer getQuantity(int productId) {
		return dao.getQuantity(productId);
	}

//	@Override
//	public List<Product> getProdGTavgPrice() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Product> getProdLTavgPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductExceptTpye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProduct(Double LPrice, Double Hprice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducteBTW(Double LPrice, Double Hprice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProductbyId(int productId, Product product) {
		// TODO Auto-generated method stub
		return dao.updateProductbyId(productId, product);
	}

	@Override
	public String importExcel() {
		String filepath = "D://product.xlsx";
		Product product = null;
		List<Product> list = new ArrayList<>();
		String count = null;
		Workbook workbook = null;
		try {
			FileInputStream file = new FileInputStream(new File(filepath));
			workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				product = new Product();
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					int coloum = cell.getColumnIndex();
					switch (coloum) {
					case 0: {
						product.setProductId((int) cell.getNumericCellValue());
						break;
					}
					case 1: {
						product.setProductName(cell.getStringCellValue());
						break;
					}
					case 2: {
						product.setProductPrice(cell.getNumericCellValue());
						break;
					}
					case 3: {
						product.setProductQty((int) cell.getNumericCellValue());
						;
						break;
					}
					case 4: {
						product.setProductType(cell.getStringCellValue());
						;
						break;
					}
					case 5: {
						product.setSupplierId((int) cell.getNumericCellValue());
						;
						break;
					}
					default:
						break;
					}

				}
				list.add(product);
			}
			count = dao.uploadSheet(list);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	@Override
	public Product_Supplier getproductandSupplierbyProductId(int productId) {

		Product_Supplier Product_supplier = new Product_Supplier();
		Supplier supplier = null;
		try {

			Product product = getProductbyId(productId);
			System.out.println(product);
			supplier = resttemp.getForObject("http://localhost:8085/Supplier/getSupplier/" + product.getSupplierId(),
					Supplier.class);
			// System.out.println(supplier);
			Product_supplier.setProduct(product);
			if (supplier != null) {
				Product_supplier.setSupplier(supplier);
			}
		} catch (ResourceAccessException e) {
			System.out.println("supplier is not running");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Product_supplier);
		return Product_supplier;
	}

}
