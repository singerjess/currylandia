import axios from 'axios';


export class UserApiClient {
    constructor(baseUrl) {
        this.httpClient = axios.create({
            baseURL: baseUrl
        });
    }
    handleLoginError(error) {

    }
    async login(userData) {
        return this.httpClient.post('/login', {
            "user": userData.username,
            "password": userData.password //TODO: encrypt
        })
            .then(response => response.data)
            .then({
            });
    }
}