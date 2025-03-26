-- Insert Authors
INSERT INTO author (name) VALUES
('Mark Twain'),
('Albert Einstein'),
('Oscar Wilde'),
('Mahatma Gandhi'),
('Winston Churchill'),
('Nelson Mandela'),
('William Shakespeare'),
('Confucius'),
('Leo Tolstoy'),
('Marie Curie');

-- Insert Quotes
INSERT INTO quote (content, author_id, created_at) VALUES
('The secret of getting ahead is getting started.', 1, CURDATE()),
('Imagination is more important than knowledge.', 2, CURDATE()),
('Be yourself; everyone else is already taken.', 3, CURDATE()),
('Be the change that you wish to see in the world.', 4, CURDATE()),
('Success is not final, failure is not fatal.', 5, CURDATE()),
('Education is the most powerful weapon.', 6, CURDATE()),
('To be, or not to be, that is the question.', 7, CURDATE()),
('It does not matter how slowly you go as long as you do not stop.', 8, CURDATE()),
('Everyone thinks of changing the world, but no one thinks of changing himself.', 9, CURDATE()),
('One never notices what has been done; one can only see what remains to be done.', 10, CURDATE()),
('Do not wait to strike till the iron is hot; but make it hot by striking.', 1, CURDATE()),
('Logic will get you from A to B. Imagination will take you everywhere.', 2, CURDATE()),
('Experience is simply the name we give our mistakes.', 3, CURDATE()),
('The best way to find yourself is to lose yourself in the service of others.', 4, CURDATE()),
('Success is stumbling from failure to failure with no loss of enthusiasm.', 5, CURDATE()),
('A winner is a dreamer who never gives up.', 6, CURDATE()),
('Love all, trust a few, do wrong to none.', 7, CURDATE()),
('Wherever you go, go with all your heart.', 8, CURDATE()),
('If you want to be happy, be.', 9, CURDATE()),
('Have no fear of perfection; you''ll never reach it.', 10, CURDATE());