import React from "react";
import Restaurants from "./Restaurants";
import {Container, Section} from "react-bulma-components"

function RestaurantsCatalog() {
    return <Section>
        <Container>
            <h1 className="has-text-centered has-text-weight-semibold is-strong-color is-size-3">
                Restaurantes
            </h1>
            <Restaurants/>
        </Container>
    </Section>;
}
export default RestaurantsCatalog;