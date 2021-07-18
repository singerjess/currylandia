import React from "react";
import {Logo} from "./Logo";
import {NavbarBurger} from "./NavbarBurger";
import {NavbarMenu} from "./NavbarMenu";
import {Navbar} from "react-bulma-components"

function NavbarElement(){
    const [isActive, setisActive] = React.useState(false);
    return <Navbar className="has-shadow is-light is-size-5 is-family-primary" style={{"backgroundColor" : "#eee2dc"}}>
        <Navbar.Brand>
            <Logo/>
            <h1 className="navbar-item is-title  is-light-grey is-size-4 has-text-weight-semibold">lechuga y tomate</h1>
            <NavbarBurger onClick={() => setisActive(!isActive)} />
        </Navbar.Brand>
        <NavbarMenu isActive={isActive}/>
    </Navbar>;
}
export default NavbarElement;