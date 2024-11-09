const { Pool } = require('pg');
const dotenv = require('dotenv');

dotenv.config();

const pool = new Pool({
    host: process.env.DB_HOST || '127.0.0.1',
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME,
    port: process.env.DB_PORT || 5432, 
});

pool.connect(err => {
    if (err) {
        console.error('Database connection failed:', err.message);
        process.exit(1); 
    }
    console.log('Connected to the PostgreSQL database.');
});

module.exports = pool;
