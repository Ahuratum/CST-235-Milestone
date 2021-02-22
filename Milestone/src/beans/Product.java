package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean
public class Product implements Serializable {
	
	/**
	 * Attributes of the Product class
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "productName")
	private int productID;
	@Column
	private String productName;
	@Column
	private String productDiscription;
	@Column
	private int productAmount;
	@Column
	private double productCost;
	@Column
	private double productPrice;
	@Column
	private String imageUrl;
	
	// Default constructor
	public Product() {}
	
	// Non-default constructor
	public Product(int productID, String productName, String productDiscription, int productAmount, double productCost, double productPrice, String imageUrl) {
		this.productID = productID;
		this.productName = productName;
		this.productDiscription = productDiscription;
		this.productAmount = productAmount;
		this.productCost = productCost;
		this.productPrice = productPrice;
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productDiscription="
				+ productDiscription + ", productAmount=" + productAmount + ", productCost=" + productCost
				+ ", imageUrl=" + imageUrl + "]";
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}


	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}


	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	/**
	 * @return the productDiscription
	 */
	public String getProductDiscription() {
		return productDiscription;
	}


	/**
	 * @param productDiscription the productDiscription to set
	 */
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}


	/**
	 * @return the productAmount
	 */
	public int getProductAmount() {
		return productAmount;
	}


	/**
	 * @param productAmount the productAmount to set
	 */
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}


	/**
	 * @return the productCost
	 */
	public double getProductCost() {
		return productCost;
	}


	/**
	 * @param productCost the productCost to set
	 */
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}


	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}


	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}


	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
