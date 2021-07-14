import React from "react";
import Restaurants from "./Restaurants";
import {Container, Section} from "react-bulma-components"

function RestaurantsCatalog() {
    return <Section>
        <Container>
            <h1 className="has-text-left has-text-primary-dark">
                Restaurantes
            </h1>
            <Restaurants/>
        </Container>
    </Section>;
}
export default RestaurantsCatalog;