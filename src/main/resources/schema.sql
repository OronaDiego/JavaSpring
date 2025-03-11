DROP TABLE ALUMNO IF EXISTS;

CREATE TABLE ALUMNO(
    nombre VARCHAR(150) NOT NULL,
    apellido VARCHAR(150) NOT NULL,
    dni INT NOT NULL,
    legajo INT NOT NULL
);
            CREATE TABLE IF NOT EXISTS clients (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(75),
                lastname VARCHAR(75),
                doc_number VARCHAR(11)
            );

            CREATE TABLE IF NOT EXISTS products (
                id INT AUTO_INCREMENT PRIMARY KEY,
                description VARCHAR(150),
                code VARCHAR(50),
                stock INT,
                price DOUBLE
            );

            CREATE TABLE IF NOT EXISTS invoice (
                id INT AUTO_INCREMENT PRIMARY KEY,
                client_id INT,
                created_at DATETIME,
                total DOUBLE,
                FOREIGN KEY (client_id) REFERENCES clients(id)
            );

            CREATE TABLE IF NOT EXISTS invoice_details (
                invoice_detail_id INT AUTO_INCREMENT PRIMARY KEY,
                invoice_id INT,
                product_id INT,
                amount INT,
                price DOUBLE,
                FOREIGN KEY (invoice_id) REFERENCES invoice(id),
                FOREIGN KEY (product_id) REFERENCES products(id)
            );