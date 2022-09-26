package com.manage.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manage.entity.Product;
 
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sf;
	Product product;
	ArrayList<Product> list;

	@Override
	public boolean saveProduct(Product product) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isSaved = false;
		try {
//			Supplier supplier=session.get(Supplier.class, product.getSupplier().getSupplierId());
//			if(supplier!=null) {
//			product.setSupplier(supplier);}
			
			session.save(product);
			transaction.commit();
			isSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

		return isSaved;
	}

	@Override
	public boolean deleteProduct(int productId) {
		Session session = sf.openSession();
		boolean isDelete = false;
		Transaction transaction = session.beginTransaction();

		try {
			Product product = session.load(Product.class, productId);			
			session.delete(product);
			transaction.commit();
			System.out.println(product);
			isDelete = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return isDelete;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isupdate = false;
		try {
//			Supplier supplier=session.get(Supplier.class, product.getSupplier().getSupplierId());
//			product.setSupplier(supplier);
			session.update(product);
			transaction.commit();
			isupdate = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return isupdate;
	}

	@Override
	public Product getProductbyId(int productId) {
		Session session = sf.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;

	}

	@Override
	public List<Product> listgetAllProduct() {
		Session session = sf.openSession();

		List<Product> list = null;
		try { 
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override // done
	public List<Product> getProductByName(String productName) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			// criteria.add(Restrictions.like("productName", "productName"+"%"));
			criteria.add(Restrictions.eq("productName", productName));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override // done
	public List<Product> getProductbySellerId(String productSellerId) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {

			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.eq("productSellerId", productSellerId));

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}

		}
		return list;
	}

	@Override // done
	public List<Product> getProductbyType(String productType) {
		Session session = sf.openSession();
		List<Product> list = null;

		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productType", productType));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override // done
	public List<Product> getProductPriceGT(Double productPrice) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", productPrice));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override // done
	public List<Product> getProductPriceBTW(Double LPrice, Double Hprice) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.between("productPrice", LPrice, Hprice));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override // done
	public List<Product> getMaxPriceProductlist() {
		Session session = sf.openSession();
		List<Product> list = null;
		Double max = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			Criteria criteria1 = session.createCriteria(Product.class);

			criteria.setProjection(Projections.max("productPrice"));

			max = (Double) criteria.list().get(0);
			criteria1.add(Restrictions.eq("productPrice", max));
			list = criteria1.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	@Override // done
	public List<Product> getMinPriceProduct() {
		Session session = sf.openSession();
		List<Product> list = null;
		Double min = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			Criteria criteria1 = session.createCriteria(Product.class);

			criteria.setProjection(Projections.min("productPrice"));

			min = (Double) criteria.list().get(0);
			criteria1.add(Restrictions.eq("productPrice", min));
			list = criteria1.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	@Override
	public List<Product> getProductnameisPenOrtypeEdu(String ptype, String pname) {
		// System.out.println(ptype +" "+ pname);
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			SimpleExpression Ptype = Restrictions.eq("productType", ptype);
			SimpleExpression Pname = Restrictions.eq("productName", pname);

			criteria.add(Restrictions.or(Ptype, Pname));
			list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Product> getProductPriceLt(Double productPrice) {
		Session session = sf.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.lt("productPrice", productPrice));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Integer getQuantity(int productId) {
		Session session = sf.openSession();
		Product product = null;
		try {
			product = session.get(Product.class, productId);
			
			//System.out.println(quantity);
			//System.out.println(product);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}			
		int quantity=product.getProductQty();

		return quantity;
	}

	@Override
	public boolean updateProductbyId(int productId ,Product product) {
Session session=sf.openSession();
Transaction transaction=session.beginTransaction();
Product product1=null;

		try {
			product1=session.get(Product.class, productId);
			product1.setProductName(product.getProductName());
			product1.setProductPrice(product.getProductPrice());
			product1.setProductQty(product.getProductQty());
			product1.setProductType(product.getProductType());
			product1.setSupplierId(product.getSupplierId());
			
			session.save(product1);
			transaction.commit();
		} catch (Exception e) {
e.printStackTrace();		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public String uploadSheet(List<Product> list) {
		Session session=null;
		
		int count=0;
		int count2=0;
		try {
			for (Product product : list) {
				session = sf.openSession();
				Transaction transaction = session.beginTransaction();

				Product product1=session.get(Product.class, product.getProductId());
				System.out.println(product1);
				if(product1==null) {
				session.save(product);
				transaction.commit();
				count=count+1;
				}else {
					count2=count2+1;
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally { 
			if(session!=null) {
				session.close();

			}
		}

			return "uploded " +count +"already "+count2;
	}


}
