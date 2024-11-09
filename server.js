const express = require('express');
const session = require('express-session');
const path = require('path');
const { keycloak, memoryStore } = require('./config/keycloak-config');
const authRoutes = require('./routes/auth');

const app = express();

// Middleware to parse JSON
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, 'public')));

app.use(session({
    secret: 'Secret123',
    resave: false,
    saveUninitialized: true,
    store: memoryStore
}));

// Keycloak middleware
app.use(keycloak.middleware());

// Routes
app.use('/api/auth', authRoutes);

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
});
