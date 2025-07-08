with mergedTable as 
(select p1.user_id,p1.product_id ,p2.category from ProductPurchases  p1
join productInfo p2
 on p1.product_id = p2.product_id)
 select m1.product_id product1_id,m2.product_id product2_id,m1.category product1_category,m2.category product2_category ,count(m1.user_id) customer_count
 from mergedTable m1
 join mergedTable m2
 on m1.user_id = m2.user_id and m1.product_id < m2.product_id
 group by m1.product_id,m2.product_id 
 having customer_count >= 3
 order by customer_count desc ,product1_id asc ,product2_id asc