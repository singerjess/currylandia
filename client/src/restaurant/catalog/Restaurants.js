import React, {useEffect, useState} from "react";
import {RestaurantCatalogItem} from "./RestaurantCatalogItem";
import {useHistory} from 'react-router-dom';
import {Section} from 'react-bulma-components'
import {RestaurantApiClient} from "../service/RestaurantAPIClient";

function Restaurants() {
    const restaurantApiClient = new RestaurantApiClient("http://localhost:8080");
    const [isLoading, setIsLoading] = useState(true);
    const [getRestaurants, setRestaurants] = useState([]);

    const history = useHistory();
    const handleOnClick = (resto) => {
        history.push('/restaurantes/' + resto.id);
    };

    useEffect(() => {
        restaurantApiClient.getAll().then(response => {
            setRestaurants(response);
            setIsLoading(false);
        }).catch((error) => {
            setIsLoading(true);
            console.log(error);
        });
    }, [])

    return <Section className="is-multiline is-mobile has-text-centered-mobile" display="wrap" style={{"flexWrap": "wrap"}}>
        {getRestaurants.map(restaurant => <RestaurantCatalogItem onClick={() => handleOnClick(restaurant)} key={restaurant.name} restaurant={restaurant}/>)}
    </Section>;
}

export default Restaurants;