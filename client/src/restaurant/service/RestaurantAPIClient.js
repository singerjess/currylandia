import axios from 'axios';

export class RestaurantApiClient {
    constructor(baseUrl) {
        this.httpClient = axios.create({
            baseURL: baseUrl
        });
    }

    mapRestaurantResponse(restaurant) {
        restaurant.name = restaurant.name;
        restaurant.description = restaurant.description;
        restaurant.address = restaurant.address;
        return restaurant;
    }

    async getAll() {
        return this.httpClient.get('/restaurants', {})
            .then(response => response.data.items)
            .then(restaurantItems => {
                return restaurantItems.map(this.mapRestaurantResponse)
            });
    }

}