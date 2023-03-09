package in.ashokit.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {

	@NotNull(message = "Id is required")
	private Integer pid;

	@NotNull(message = "Name is required")
	@Size(min = 3, max = 8)
	private String pname;

	@NotNull(message = "Price is required")
	private Double price;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}

}
