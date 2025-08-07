with tablewithrank as (
select * , row_number() over (order by recordDate) rnk from weather
)select t1.id from tablewithrank t1
join tablewithrank t2
on datediff(t1.recordDate ,t2.recordDate) = 1
where t1.temperature > t2.temperature