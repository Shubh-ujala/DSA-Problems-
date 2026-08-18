# Write your MySQL query statement below
select MAX(salary) as SecondHighestSalary from Employee 
where salary < (
    Select MAX(salary) from employee 
) 