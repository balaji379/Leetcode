with filter as(
  select sales_id from orders o
  join company c  
  on c.name = "RED"  and c.com_id = o.com_id
)select distinct s.name from salesperson s
where s.sales_id not in (select * from filter)
