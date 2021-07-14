import React from "react";
import currylandia from "../../currylandia.jpeg";
import {Columns} from "react-bulma-components"

export function RestaurantCatalogItem({onClick, restaurant}) {
    return <Columns  onClick={onClick}>
            <Columns.Column className="is-3 is-8-mobile">
                <h1 className="is-size-3 title">{restaurant.name}</h1>
                <h2 className="is-size-4 subtitle">{restaurant.description}</h2>
                <p>asda</p>
            </Columns.Column>
            <Columns.Column className="is-5 is-8-mobile">
                <p>{restaurant.address}</p>
            </Columns.Column>
            <Columns.Column className="is-4 is-8-mobile">
                <img style={{"maxHeight": "70px"}}  alt="site-logo" src={currylandia}/>
            </Columns.Column>
        </Columns>;
}