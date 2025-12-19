# Write your MySQL query statement below
with cte as(
select *, sum(weight) over (order by turn) as running_weight
from queue
order by turn
)
select person_name from cte
where running_weight <= 1000
order by running_weight desc
limit 1