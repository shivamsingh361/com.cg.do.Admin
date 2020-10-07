package com.cg.go.admin.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.go.admin.dto.Order;
import com.cg.go.admin.dto.ResultSet;

@Repository
public interface OrderDao extends CrudRepository<Order, String> {
	/*
	 * collection data type ? 'from' and 'to' (Including). Date Format: YYYY-MM-DD.
	 * Returns: Integer
	 */

	// 1. revenueGenerated(from, to) Total amount of order placed between date.
	@Query(value = "select sum(amount) from order_table where order_date>=?1 and order_date<=?2 and status='Delivered'", nativeQuery = true)
	Double revenueGenerated(String from, String to);

	// 2. revenueGenerated(date) Total amount of order placed on specific 'date'.
	@Query(value = "select sum(amount) from order_table where order_date = ?1", nativeQuery = true)
	Double revenueGenerated(String data);

	// 3. Number of order placed on the given date.
	@Query(value = "select count(*) from order_table where order_date =?1", nativeQuery = true)
	Integer orderPlaced(String date);

	// 4. Number of order placed in the range of the to and from inclusive.
	@Query(value = "select count(*) from order_table where order_date >= ?1 and order_date <= ?2 and status='Delivered'", nativeQuery = true)
	Integer orderPlaced(String from, String to);

	// 5. Number of order cancelled on given date.
	@Query(value = "select count(*) from order_table where order_date =?1 and status='Cancelled'", nativeQuery = true)
	Integer orderCancelled(String date);

	// 6. Number of order cancelled in the range of the to and from inclusive.
	@Query(value = "select count(*) from order_table where order_date >= ?1 and order_date <= ?2 and status='Cancelled'", nativeQuery = true)
	Integer orderCancelled(String from, String to);

	// 7. Return Quantity sold(status=delivered) group by category between the
	// given dates.
	@Query(value = "select p.category as Category, sum(opm.quantity) Val from  (order_product_mapping opm inner join order_table ot using(order_id)) "
			+ "inner join product_table p using(product_id) where ot.order_date >= ?1 and ot.order_date <= ?2 and ot.status='Delivered'  group by p.category", nativeQuery = true)
	List<ResultSet> quantitySoldGroupByCategory(String from, String to);

	// 8. Return Quantity sold(status=delivered) group by category on given date.
	@Query(value = "select p.category as Category, sum(opm.quantity) Val from  (order_product_mapping opm inner join order_table ot using(order_id)) "
			+ "inner join product_table p using(product_id) where ot.order_date = ?1 and ot.status='Delivered' group by p.category", nativeQuery = true)
	List<ResultSet> quantitySoldGroupByCategory(String date);

	// 9. Return Quantity cancelled order group by category between the given date
	// (Inclusive).
	@Query(value = "select p.category as Category, sum(opm.quantity) Val from  (order_product_mapping opm inner join order_table ot using(order_id)) "
			+ "inner join product_table p using(product_id) where ot.order_date >= ?1 and ot.order_date <= ?2 and ot.status='Cancelled'  group by p.category", nativeQuery = true)
	List<ResultSet> quantityCancelledGroupByCategory(String from, String to);

	// 10. Return Quantity cancelled order group by category on the given date.
	@Query(value = "select p.category as Category, sum(opm.quantity) Val from  (order_product_mapping opm inner join order_table ot using(order_id)) "
			+ "inner join product_table p using(product_id) where ot.order_date = ?1 and ot.status='Cancelled' group by p.category", nativeQuery = true)
	List<ResultSet> quantityCancelledGroupByCategory(String date);
	
	 // 11. Return total cost of order sold on specific date
	 @Query(value =" select p.category as Category, sum(opm.quantity*p.price) as Val from order_table as ot inner join order_product_mapping opm using(order_id) "
			 + "inner join product_table as p using(product_id) where ot.order_date = ?1 and ot.status=?2 group by category", nativeQuery = true) 
	 List<ResultSet> getCostOfOrderForStatus(String date, String orderStatus);
	 
	 // 12. Return total cost of order sold on between given dates(including to and from)
	 @Query(value = " select p.category as Category, sum(opm.quantity*p.price) as Val from order_table as ot inner join order_product_mapping as opm using(order_id) "
			 + "inner join product_table as p using(product_id) where ot.order_date >= ?1 and ot.order_date <= ?2 and ot.status=?3 group by category", nativeQuery = true)
	 List<ResultSet> getCostOfOrderForStatus(String from, String to, String orderStatus); 
}
