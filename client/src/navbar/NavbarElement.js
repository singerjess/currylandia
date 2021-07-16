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
            <h1 className="navbar-item has-text-centered is-size-3 has-text-weight-bold">Currylandia</h1>
            <NavbarBurger onClick={() => setisActive(!isActive)} />
        </Navbar.Brand>
        <NavbarMenu isActive={isActive}/>
    </Navbar>;
}
export default NavbarElement;