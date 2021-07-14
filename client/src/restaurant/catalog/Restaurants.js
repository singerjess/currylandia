import React, {useEffect, useState} from "react";
import {RestaurantCatalogItem} from "./RestaurantCatalogItem";
import {useHistory} from 'react-router-dom';
import {Section} from 'react-bulma-components'
import {RestaurantApiClient} from "../service/RestaurantAPIClient";

function Restaurants() {
    const restaurantApiClient = new RestaurantApiClient("http://localhost:8080/");
    const [isLoading, setIsLoading] = useState(true);
    const [getRestos, setRestos] = useState([]);
    let fetchRestaurants;

    const history = useHistory();
    const handleOnClick = (resto) => {
        history.push('/restaurantes/' + resto);
    };

    useEffect(() => {
        restaurantApiClient.getAll().then(response => {
            setRestos(response);
            setIsLoading(false);
        }).catch((error) => {
            setIsLoading(true);
            console.log(error);
        });
    }, [])

    return <Section className="is-multiline is-mobile has-text-centered-mobile" display="wrap" style={{"flexWrap": "wrap"}}>
        {getRestos.map(resto => <RestaurantCatalogItem onClick={() => handleOnClick(resto)} key={resto} restaurant={resto}/>)}
    </Section>;
}

export default Restaurants;