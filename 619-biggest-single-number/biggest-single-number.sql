# Write your MySQL query statement below
select Max(num) as num from myNumbers
where num in(
    select num from myNumbers
    group by num
    having count(*) = 1
)