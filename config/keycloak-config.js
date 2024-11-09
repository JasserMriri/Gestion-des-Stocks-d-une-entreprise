const session = require('express-session');
const Keycloak = require('keycloak-connect');

const memoryStore = new session.MemoryStore();

const keycloak = new Keycloak({ store: memoryStore }, {
    realm: 'JobBoardKeycloack', 
    clientId: 'auth-app-client', 
    serverUrl: 'http://localhost:8099', 
    bearerOnly: true,
});

module.exports = { keycloak, memoryStore };
