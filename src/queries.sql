SELECT id, description
FROM 	websystique.word as word
	JOIN
		(SELECT word_id as result_word_id
		FROM websystique.word_category
		WHERE 	difficulty_id = 	(
						SELECT id
						FROM websystique.difficulty
						WHERE description like 'difficulty'
						)
			AND
				category_id= 	(
						SELECT id
						FROM websystique.category
						WHERE description like 'category'
						)
		) as result
WHERE 	result_word_id = id
;


SELECT id, description FROM websystique.word as word 	JOIN 	(SELECT word_id as result_word_id 		FROM websystique.word_category 		WHERE 	difficulty_id = 	( SELECT id FROM websystique.difficulty	WHERE description like 'difficulty') AND category_id= 	(SELECT id 	FROM websystique.category WHERE description like 'category' ) ) as result WHERE 	result_word_id = id;