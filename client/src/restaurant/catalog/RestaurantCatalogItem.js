import React from "react";
import currylandia from "../../currylandia.png";
import {Columns, Card, Media, Content, Image} from "react-bulma-components"

export function RestaurantCatalogItem({onClick, restaurant}) {
    return <Columns.Column style={{"display" : "grid"}}className="is-3 is-8-mobile">
        <Card className="is-fullheight" onClick={onClick}>
            <Card.Content>
                <figure className="image is-1by1 is-centered"  >
                    <img className="is-rounded" alt="p el que l" src="https://www.tablefortwoblog.com/wp-content/uploads/2018/09/pan-fried-spicy-garlic-tofu-recipe-photos-tablefortwoblog-5.jpg"/>
                </figure>
            </Card.Content>
            <Card.Content>
                <Media>
                    <Media.Item className="media-left">
                            <Image className="is-48x48" style={{"maxHeight": "70px"}} alt="site-logo" src={currylandia}/>

                    </Media.Item>
                    <Media.Item className="media-content">
                        <p className="title is-4">{restaurant.name}</p>
                        <p className="subtitle is-6">{restaurant.address}</p>
                    </Media.Item>
                </Media>
                <Content>
                    {restaurant.description}
                </Content>
            </Card.Content>
        </Card>
    </Columns.Column>;
}