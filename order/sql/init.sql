CREATE DATABASE IF NOT EXISTS dog DEFAULT CHARSET utf8mb4 COLLATE UTF8MB4_GENERAL_CI;
USE dog;
CREATE TABLE IF NOT EXISTS `t_order`
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    user_id      VARCHAR(32),
    product_id   VARCHAR(32),
    status       TINYINT,
    order_time   DATETIME,
    total_amount DECIMAL(10, 2)
);
INSERT INTO t_order (`user_id`, `product_id`, `status`, `order_time`, `total_amount`)
VALUES ('uHnJL2WVx9a7dY6R4XbQ0Zc5', 'pFtD2GhKl4sY6JwR8HnM0Qc5', 1, '2024-04-01', 99.99),
       ('eIbN3gR7oW4rS6lF9jHnJ8Kc2', 'vFcB1sR5tE7yU3iH8lO0Pn9M', 2, '2024-04-02', 49.99),
       ('lDmZ8jY2Xw9vQ6bR4aHcN1M3', 'nBmV7cS4xW1zA3eD5fRgH8Jl', 1, '2024-04-03', 29.99),
       ('wZcX7vN2bQ9rT4gF6hKlJ3M5', 'bQwErT3yU6iO2pA5sDfGhJ8K', 2, '2024-04-04', 79.99),
       ('oCmV3bX6zW8qR4eT2yHnJ5Ll', 'cNvB5xS2wQ6rT8yU3iOkP9M0', 1, '2024-04-05', 39.99),
       ('pGhJ5tE7uW4rY2iH8kLoP9N6', 'mBnV4cS2xW1zA3eD5fRgH8Jl', 2, '2024-04-06', 59.99),
       ('sQwErT3yU6iO2pA5fRgJ8Kl0', 'oXbZ7cV4xW1zA3eD5jHnM9P8', 1, '2024-04-07', 69.99),
       ('vBnM1sR4xWzA6eY3iKoP9N2c', 'mVnC5xS2wQ6rT8yU1zA3eD7f', 2, '2024-04-08', 89.99),
       ('qWwErT2yU6iO3pA5fRgJ8Kl4', 'bNvC7xS2wQ6rT8yU3iOkP9M0', 1, '2024-04-09', 99.99),
       ('nVcX5bQwErR7yU3iHnJ8Kl1', 'pFtD2GhKl4sY6JwR8HnM0Qc5', 2, '2024-04-10', 109.99),
       ('jHnM1sR4xWzA6eY3iKoP9N2c', 'mVnC5xS2wQ6rT8yU1zA3eD7f', 1, '2024-04-11', 119.99),
       ('iKoP9N2cX5bQwErR7yU3lM1s', 'nVnC7xS4xW1zA3eD5fRgH8Jl', 2, '2024-04-12', 129.99),
       ('rFgJ8Kl4sY6JwR8HnM0Qc5V', 'pFtD2GhKl4sY6JwR8HnM0Qc5', 1, '2024-04-13', 139.99),
       ('tY6iO3pA5sDfGhJ8KlM1sR4x', 'mVnC5xS2wQ6rT8yU1zA3eD7f', 2, '2024-04-14', 149.99),
       ('zA6rT8yU3iO2pS4xWzB5fGhJ', 'bNvC7xS2wQ6rT8yU3iOkP9M0', 1, '2024-04-15', 159.99),
       ('xWzA3eD5fRgH8Jl1sY6iO2pA', 'mVnC5xS2wQ6rT8yU1zA3eD7f', 2, '2024-04-16', 169.99),
       ('cV5bQwErT3yU6iO2pA4sY6Jw', 'nVnC7xS4xW1zA3eD5fRgH8Jl', 1, '2024-04-17', 179.99),
       ('vBnM1sR4xWzA6eY3iKoP9N2c', 'bNvC7xS2wQ6rT8yU3iOkP9M0', 2, '2024-04-18', 189.99),
       ('nVnC5xS2wQ6rT8yU1zA3eD7fM', 'mVnC5xS2wQ6rT8yU1zA3eD7f', 1, '2024-04-19', 199.99),
       ('iO2pA5sDfGhJ8Kl4sY6iO3pA', 'nVnC7xS4xW1zA3eD5fRgH8Jl', 2, '2024-04-20', 209.99),
       ('mVnC5xS2wQ6rT8yU1zA3eD7fR', 'mVnC5xS2wQ6rT8yU1zA3eD7f', 1, '2024-04-21', 219.99);