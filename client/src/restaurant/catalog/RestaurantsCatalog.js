import React, {useState} from "react";
import Restaurants from "./Restaurants";
import {Container, Section} from "react-bulma-components"

function RestaurantsCatalog() {
    const [getRestaurants, setRestaurants] = useState([]);
    const handleRestaurantsCallback = (restaurants) =>{
        setRestaurants(restaurants);
    };
    return <Section>
        <Container>
            <h1 className="has-text-centered has-text-weight-semibold is-strong-color is-size-3">
                Restaurantes
            </h1>
            <h3 className="has-text-left is-strong-color is-size-6 is-uppercase has-text-weight-bold">Total: {getRestaurants.length}</h3>
            <Restaurants setParentRestaurants={handleRestaurantsCallback}/>
        </Container>
    </Section>;
}
export default RestaurantsCatalog;