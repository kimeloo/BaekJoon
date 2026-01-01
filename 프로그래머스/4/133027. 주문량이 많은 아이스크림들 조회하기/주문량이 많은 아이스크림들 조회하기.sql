SELECT f.flavor
FROM first_half f
INNER JOIN (
    SELECT flavor, SUM(total_order) AS total_order
    FROM july
    GROUP BY flavor
) j ON f.flavor = j.flavor
ORDER BY f.total_order + j.total_order DESC
LIMIT 3;