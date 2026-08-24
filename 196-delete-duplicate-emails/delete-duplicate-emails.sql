# Write your MySQL query statement below
delete from Person
where id not in(
    select id from (
        select min(id) as id from person
        group by email
    ) as temp
);


-- DELETE FROM Person
-- WHERE id NOT IN (
--     SELECT id
--     FROM (
--         SELECT MIN(id) AS id
--         FROM Person
--         GROUP BY email
--     ) AS temp
-- );