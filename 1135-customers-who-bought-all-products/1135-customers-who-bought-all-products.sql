SELECT customer_id 
FROM customer
GROUP BY customer_id
HAVING count(distinct product_key) = (select count(product_key) from product);