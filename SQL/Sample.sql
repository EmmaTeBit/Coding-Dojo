SELECT * FROM sightings;

SELECT * FROM cookie_order;


-- SELECT users.first_name,recipes.user_id 
-- FROM recipes 
-- WHERE 
-- this query-is for one specific recipes without the WHERE cluase -we will get everydata
SELECT * FROM recipes
JOIN users
ON users.id = recipes.user_id
WHERE recipes.id = 3;



-- SELECT recipes.id, recipes.created_at, recipes.updated_at, instructions, description, name, date_made, under30,
-- users.id as user_id, first_name, last_name, email, users.created_at as uc, users.updated_at as uu
-- FROM recipes
-- JOIN users on users.id = recipes.user_id;

-- SELECT recipes.id, recipes.created_at, recipes.updated_at, instructions, description, name, date_made, under30,
-- users.id as user_id, first_name, last_name, email, users.created_at as uc, users.updated_at as uu
-- FROM recipes
-- JOIN users on users.id = recipes.user_id
-- WHERE recipes.id = ids;

-- SELECT users.first_name, users.last_name, users2.first_name AS friend_first_name, users2.last_name AS friend_last_name FROM users
-- JOIN friendships ON users.id = friendships.user_id
-- LEFT JOIN users AS users2 ON users2.id = friendships.friend_id;

-- INSERT INTO friendships (user_id,friend_id)
-- VALUES (1,2),(2,6);

-- SELECT * FROM users WHERE users.id NOT IN ( SELECT user_id FROM friendships WHERE user_id = 1);

-- INSERT INTO register (first_name,last_name,email)
-- VALUES ("Emma","Te","em.ect18@gmail.com");

-- INSERT INTO friendships (user_id,friend_id)
-- VALUES (1,2);
-- INSERT INTO cookie_order (name, cookie_type, num_of_boxes)
-- VALUES ("Derek","Sugared", 5);
-- SELECT users.first_name,friendships.user.id FROM users JOIN friendships ON users.id = friendships.user_id;
-- SELECT * FROM friendships
-- JOIN users ON users.id = user_id
-- JOIN users AS friend ON friend.id = friend_id;
-- we renamed users AS friend so = friend.it instead
-- SELECT * FROM books LEFT JOIN favorites ON books.id = f-- avorites.book_id LEFT JOIN authors ON authors.id = favorites.author_id WHERE books.id = id;
-- SELECT * from users;
-- SELECT * FROM friendships;
-- -- Query: Create 6 new users
-- INSERT INTO users (first_name, last_name)
-- VALUES 
-- ("Apple", "Red"),
-- ("Lime", "Green"),
-- ("Pineapple", "Yellow"),
-- ("BlueBerry", "Blue"),
-- ("Grape", "Purple"),
-- ("Corn", "Orange");
-- INSERT INTO friends(first_name, last_name, occupation)
-- VALUES("Derek","LaMarche","Cat");
-- -- Query: Have user 1 be friends with user 2, 4 and 6
-- INSERT INTO friendships (user_id, friend_id)
-- VALUES (1,2),(1,4),(1,6),(2,1),(2,3),(2,5),(3,2),(3,5),(4,3),(5,1),(5,6),(6,2),(6,3);

-- -- Query: Display the relationships created as shown in the table in the above image
-- SELECT users.first_name as first_name, users.last_name as last_name, users2.first_name as friend_first_name, users2.last_name as friend_last_name FROM users
-- JOIN friendships ON users.id = friendships.user_id
-- LEFT JOIN users as users2 ON users2.id = friendships.friend_id;
-- -- NINJA Query: Return all users who are friends with the first user, make sure their names are displayed in results.

-- SELECT users2.first_name as first_name, users2.last_name as last_name, users.first_name as friends_with FROM users
-- JOIN friendships ON users.id = friendships.user_id
-- LEFT JOIN users as users2 ON users2.id = friendships.friend_id
-- WHERE users.id = 1;
-- -- NINJA Query: Return the count of all friendships
-- SELECT COUNT(*) as num_of_friendships from friendships;

-- -- NINJA Query: Find out who has the most friends and return the count of their friends.
-- SELECT user_id, users.first_name, users.last_name, count(user_id) as num_of_friends from friendships
-- JOIN users ON users.id = friendships.user_id
-- GROUP BY user_id
-- ORDER BY num_of_friends DESC
-- LIMIT 1;
-- -- NINJA Query: Return the friends of the third user in alphabetical order
-- SELECT users2.first_name as first_name, users2.last_name as last_name, users.first_name as friends_with FROM users
-- JOIN friendships ON users.id = friendships.user_id
-- LEFT JOIN users as users2 ON users2.id = friendships.friend_id
-- WHERE users.id = 3
-- ORDER BY first_name;