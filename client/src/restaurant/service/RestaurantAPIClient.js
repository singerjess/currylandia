import axios from 'axios';

export class RestaurantApiClient {
    constructor(baseUrl) {
        this.httpClient = axios.create({
            baseURL: baseUrl
        });
    }

    mapRestaurantResponse(restaurant) {
        restaurant["id"] = restaurant.id;
        restaurant["name"] = restaurant.name;
        restaurant["description"] = restaurant.description;
        restaurant["address"] = restaurant.address;
        return restaurant;
    }

    async getAll() {
        return this.httpClient.get('/restaurants', {})
            .then(response => response.data)
            .then(restaurantItems => {
                return restaurantItems.map(this.mapRestaurantResponse)
            });
    }

    async getById(id) {
        return this.httpClient.get('/restaurants/'+id, {})
            .then(response => response.data)
            .then(restaurant => {
                return this.mapRestaurantResponse(restaurant);
            });
    }

    async createRestaurant(restaurant) {
        return this.httpClient.post('/add',
            {
                name: restaurant.name,
                description: restaurant.description,
                address: restaurant.address
            }).then(response => response.data)
            .then(item => {
                return this.mapRestaurantResponse(item)
            });
    }


}