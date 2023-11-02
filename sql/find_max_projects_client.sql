SELECT c."NAME" AS "NAME", COUNT(p.ID) AS "PROJECT_COUNT"
FROM client c
LEFT JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c."NAME"
HAVING COUNT(p.ID) = (
    SELECT MAX(project_count)
    FROM (
        SELECT CLIENT_ID, COUNT(ID) AS project_count
        FROM project
        GROUP BY CLIENT_ID
    ) AS project_counts
)
ORDER BY c."NAME";
