import axios from 'axios';


export class UserApiClient {
    constructor(baseUrl) {
        this.httpClient = axios.create({
            baseURL: baseUrl,
            withCredentials: true
        });
    }

    mapUser(userData) {
        let user = {"username": "", "logged": true};
        user.username = userData["userDTO"]["username"];
        return user;
    }

    async login(userData) {
        return this.httpClient.post('/session', {
            "mail": userData.mail,
            "password": userData.password//TODO: encrypt
        })
            .then(response => response.data)
            .then(userData => {return this.mapUser(userData)});
    }
    async register(userData) {
        return this.httpClient.post('/user', {
            "mail": userData.mail,
            "username": userData.username,
            "password": userData.password//TODO: encrypt
        })
            .then(response => response.data);
    }
}