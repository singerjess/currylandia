import axios from 'axios';


export class UserApiClient {
    constructor(baseUrl) {
        this.httpClient = axios.create({
            baseURL: baseUrl,
            withCredentials: true
        });
    }
    handleLoginError(error) {

    }
    async login(userData) {
        return this.httpClient.post('/login', {
            "mail": userData.mail,
            "password": userData.password//TODO: encrypt
        })
            .then(response => response.data)
            .then({
            });
    }
}