with valid_date as (
    select product_id,sale_date from sales
where sale_date between '2019-01-01' and '2019-03-31'
),
invalid_date as(
    select product_id ,sale_date from sales
    where sale_date not between '2019-01-01' and '2019-03-31'
)select distinct p.product_id,p.product_name from product p
join valid_date v
on v.product_id = p.product_id and v.product_id not in(select product_id from invalid_date)
