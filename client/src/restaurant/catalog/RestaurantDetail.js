import currylandia from "../../currylandia.png";
import {useParams} from "react-router-dom";
import {Columns, Container, Section, Content, omponent, Element} from 'react-bulma-components';
import {useEffect, useState} from "react";
import { RestaurantApiClient } from "../service/RestaurantAPIClient";

function RestaurantDetail() {
    let { restaurantId } = useParams();
    const [getRestaurant, setRestaurant] = useState();
    const restaurantApiClient = new RestaurantApiClient("http://localhost:8080");
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        restaurantApiClient.getById(restaurantId).then(response => {
            setRestaurant(response);
            setIsLoading(false);
        }).catch((error) => {
            setIsLoading(true);
            console.log(error);
        });
    }, [])
    if (!isLoading) {
        return <Section>
            <Container>
                <Columns>
                    <Columns.Column className="is-3">
                        <h1 className="is-size-3 title">{getRestaurant.name}</h1>
                        <h2 className="is-size-4 subtitle">{getRestaurant.description}</h2>
                    </Columns.Column>
                    <Columns.Column className=" is-5 is-8-mobile">
                        <p className="is-size-5 has-text-weight-semibold">{getRestaurant.address}</p>
                    </Columns.Column>
                    <Columns.Column className=" is-4">
                        <img style={{"maxHeight": "70px"}} alt="site-logo" src={currylandia}/>
                    </Columns.Column>
                </Columns>
            </Container>
        </Section>;
    }else {
        return <Section><Container>Carganding</Container></Section>;
    }
}
export default RestaurantDetail;