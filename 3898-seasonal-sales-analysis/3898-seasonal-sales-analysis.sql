with filtered as (select (case when month(p1.sale_date) in (1,2,12) then "Winter"
                           when month(p1.sale_date) in (3,4,5) then "Spring"
                           when month(p1.sale_date) in (6,7,8) then "Summer"
                           when month(p1.sale_date) in (9,10,11) then "Fall"
                           end) season
,p2.category
,sum(p1.quantity) total_quantity
,sum(p1.quantity * p1.price) total_revenue
from sales p1
join products p2
on p1.product_id = p2.product_id
group by season,category
),ranked_data as (select *,row_number() over(partition by season order by total_quantity desc,total_revenue desc) rnk
from filtered)
select season,category,total_quantity,total_revenue 
from ranked_data 
where rnk = 1;