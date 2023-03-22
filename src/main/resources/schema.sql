DROP TABLE IF EXISTS REQUEST;

CREATE TABLE REQUEST(
    id INT AUTO_INCREMENT PRIMARY KEY,
    input_text TEXT NOT NULL,
    output_text TEXT NOT NULL,
    language_from VARCHAR(10) NOT NULL,
    language_to VARCHAR(10) NOT NULL,
    ip VARCHAR(15) NOT NULL,
    created TIMESTAMP DEFAULT now()
);