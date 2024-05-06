-- 코드를 작성해주세요
WITH GRADE_DATA AS
(
    SELECT 
        EMP_NO,
        (
            CASE
                WHEN AVG(SCORE) >= 96 THEN 'S'
                WHEN AVG(SCORE) >= 90 THEN 'A'
                WHEN AVG(SCORE) >= 80 THEN 'B'
                ELSE 'C'
            END     
        ) AS GRADE,
        (
            CASE
                WHEN AVG(SCORE) >= 96 THEN 0.2
                WHEN AVG(SCORE) >= 90 THEN 0.15
                WHEN AVG(SCORE) >= 80 THEN 0.1
                ELSE 0
            END 
        ) AS PERCNET
    FROM HR_GRADE
    GROUP BY EMP_NO    
)

SELECT A.EMP_NO
    , A.EMP_NAME
    , B.GRADE
    , A.SAL * B.PERCNET AS BONUS
FROM HR_EMPLOYEES AS A
    JOIN GRADE_DATA AS B
        ON A.EMP_NO = B.EMP_NO
ORDER BY A.EMP_NO