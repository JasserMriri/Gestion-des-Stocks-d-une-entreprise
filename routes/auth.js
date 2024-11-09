const express = require('express');
const fetch = require('node-fetch');
const bcrypt = require('bcryptjs'); // Add bcrypt for password hashing
const pool = require('../config/db');
const router = express.Router();
require('dotenv').config();

router.post('/register', async (req, res) => {
    const { username, password, email, firstName, lastName } = req.body;

    if (!username || !password || !email) {
        return res.status(400).json({ message: 'Username, password, and email are required.' });
    }

    try {
        // Step 1: Get Keycloak admin token
        const adminTokenResponse = await fetch('http://localhost:8099/realms/master/protocol/openid-connect/token', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: new URLSearchParams({
                client_id: 'admin-cli',
                username: 'admin', // Replace with Keycloak admin username
                password: 'admin', // Replace with Keycloak admin password
                grant_type: 'password'
            })
        });

        const adminToken = await adminTokenResponse.json();

        // Step 2: Register the user in Keycloak
        const keycloakResponse = await fetch('http://localhost:8099/admin/realms/JobBoardKeycloack/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${adminToken.access_token}`
            },
            body: JSON.stringify({
                username,
                email,
                firstName,
                lastName,
                enabled: true,
                credentials: [{ type: 'password', value: password, temporary: false }]
            })
        });

        if (keycloakResponse.ok) {
            // Step 3: Hash the password for PostgreSQL storage
            const hashedPassword = await bcrypt.hash(password, 10);

            // Step 4: Save the user in PostgreSQL
            const query = `
                INSERT INTO users (username, password, email, first_name, last_name, created_at, updated_at)
                VALUES ($1, $2, $3, $4, $5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
                RETURNING id;
            `;
            const values = [username, hashedPassword, email, firstName, lastName];

            const result = await pool.query(query, values);

            return res.status(201).json({
                message: 'User registered successfully',
                userId: result.rows[0].id
            });
        } else {
            const error = await keycloakResponse.json();
            return res.status(keycloakResponse.status).json(error);
        }
    } catch (error) {
        console.error('Error:', error); // Log the error details
        return res.status(500).json({ message: 'Internal Server Error' });
    }
});

module.exports = router;
