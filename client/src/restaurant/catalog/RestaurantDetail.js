import currylandia from "../../currylandia.jpeg";
import {useParams} from "react-router-dom";
import {Columns, Container, Section} from 'react-bulma-components';

function RestaurantDetail() {
    let {restaurantName } = useParams();
    return <Section>
        <Container>
            <Columns>
                <Columns.Column className="is-3">
                    <h1 className="is-size-3 title">{restaurantName}</h1>
                    <h2 className="is-size-4 subtitle">resto porteño</h2>
                    <p>asda</p>
                </Columns.Column>
                <Columns.Column  className=" is-5">
                    <p> Balvanera 232</p>
                </Columns.Column >
                <Columns.Column  className=" is-4">
                    <img style={{"maxHeight": "70px"}}  alt="site-logo" src={currylandia}/>
                </Columns.Column >
            </Columns>
        </Container>
    </Section>;
}
export default RestaurantDetail;