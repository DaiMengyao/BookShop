package entity;

import java.sql.Date;
import java.util.List;

public class Order {
	//订单id
	private String order_id;
	//支付价格
	private Double payment;
	//状态
	private int status;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//支付时间
	private Date payTime;
	//发货时间
	private Date consignTime;
	//订单完整时间
	private Date endTime;
	//快递名字
	private String shippingName;
	//快递单号
	private String shipping_code;
	//下单用户
	private int userid;
	//下单的书
	private String bookid;
	//下单书本数量 
	private int BookCount;
	//收货地址
	private String Address;
	//
	private String books;
	
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getConsignTime() {
		return consignTime;
	}
	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getShippingName() {
		return shippingName;
	}
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	public String getShipping_code() {
		return shipping_code;
	}
	public void setShipping_code(String shipping_code) {
		this.shipping_code = shipping_code;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public int getBookCount() {
		return BookCount;
	}
	public void setBookCount(int bookCount) {
		BookCount = bookCount;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	

}
