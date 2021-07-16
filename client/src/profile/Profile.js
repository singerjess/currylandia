import currylandia from "../currylandia.png";
import {Columns, Container, Section} from 'react-bulma-components';
import {useEffect, useState} from "react";

function Profile() {
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
            setIsLoading(false);
        }
        , [])
    if (!isLoading) {
        return <Section>
            <Container>
                <Columns>
                    <Columns.Column className="is-3">
                        <h1 className="is-size-3 title">Jessi</h1>
                        <h2 className="is-size-4 subtitle">Alguna descripcion</h2>
                    </Columns.Column>
                    <Columns.Column className=" is-4">
                        <p>otra cosa</p>
                    </Columns.Column>
                    <Columns.Column className=" is-4">
                        <img style={{"maxHeight": "70px"}} alt="site-logo" src={currylandia}/>
                    </Columns.Column>
                </Columns>
            </Container>
        </Section>;
    } else {
        return <Section><Container>Carganding</Container></Section>;
    }
}

export default Profile;