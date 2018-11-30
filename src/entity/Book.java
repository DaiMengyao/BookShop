package entity;

public class Book {
	//书本编号
	private int id;
	//书名
	private String name;
	//书的标签种类
	private String category;
	//书的作者
	private String author;
	//书的图片地址
	private String ImageUrl;
	//书的库存
	private int count;
	//书的价格
	private double price;
	//书的详细描述
	private String descriptionImage;
	public String getDescriptionImage() {
		return descriptionImage;
	}
	public void setDescriptionImage(String descriptionImage) {
		this.descriptionImage = descriptionImage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String i) {
		this.category = i;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
}
