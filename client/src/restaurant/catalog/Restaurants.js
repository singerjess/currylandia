import React, {useState} from "react";
import {RestaurantCatalogItem} from "./RestaurantCatalogItem";
import {useHistory} from 'react-router-dom';
import {Section} from 'react-bulma-components'

function Restaurants() {
    const history = useHistory();
    const handleOnClick = (resto) => {
        history.push('/restaurantes/' + resto);
    };
    const [getRestos, setRestos] = useState(["la panera rosa", "lo de jaime", "cacho de familia"]);
    return <Section className="is-multiline is-mobile has-text-centered-mobile" display="wrap" style={{"flexWrap": "wrap"}}>
        {getRestos.map(resto => <RestaurantCatalogItem onClick={() => handleOnClick(resto)} key={resto} restaurantName={resto}/>)}
    </Section>;
}

export default Restaurants;