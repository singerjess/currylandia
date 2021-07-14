import React from "react";
import currylandia from "../../currylandia.jpeg";
import {Columns} from "react-bulma-components"

export function RestaurantCatalogItem({onClick, restaurantName}) {
    return <Columns  onClick={onClick}>
            <Columns.Column className="is-3 is-8-mobile">
                <h1 className="is-size-3 title">{restaurantName}</h1>
                <h2 className="is-size-4 subtitle">resto porteño</h2>
                <p>asda</p>
            </Columns.Column>
            <Columns.Column className="is-5 is-8-mobile">
                <p> Balvanera 232</p>
            </Columns.Column>
            <Columns.Column className="is-4 is-8-mobile">
                <img style={{"maxHeight": "70px"}}  alt="site-logo" src={currylandia}/>
            </Columns.Column>
        </Columns>;
}