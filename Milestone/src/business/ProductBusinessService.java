package business;

import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import beans.Product;

@Stateless
@Local(ProductBusinessServiceInterface.class)
@Alternative
public class ProductBusinessService implements ProductBusinessServiceInterface {

	@Inject
	ProductDataBaseInterface dp;
	
	@Override
	public ArrayList<Product> getAllProducts() {
		return dp.getAllProducts();
	}

	@Override
	public void decreaseOne(Product pd) {
		dp.decreaseOne(pd);
		
	}

	@Override
	public boolean checkProduct(Product pd) {
		return dp.checkProduct(pd);
	}

	@Override
	public ArrayList<Product> readAllProducts() {
		return dp.readAllProducts();
	}

	@Override
	public void addProduct(Product pd) {
		dp.addProduct(pd);
		
	}

	@Override
	public void editProduct(Product pd) {
		dp.editProduct(pd);
		
	}

	@Override
	public void deleteProduct(Product pd) {
		dp.deleteProduct(pd);
		
	}

	@Override
	public Product findById(int id) {
		return dp.findById(id);
	}
	
	

}
