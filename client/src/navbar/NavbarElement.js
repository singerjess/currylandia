import React from "react";
import {Logo} from "./Logo";
import {NavbarBurger} from "./NavbarBurger";
import {NavbarMenu} from "./NavbarMenu";
import {Navbar} from "react-bulma-components"

function NavbarElement(){
    const [isActive, setisActive] = React.useState(false);
    return <Navbar className="has-shadow is-light">
        <Navbar.Brand>
            <Logo/>
            <h1 className="navbar-item title">Currylandia</h1>
            <NavbarBurger onClick={() => setisActive(!isActive)} />
        </Navbar.Brand>
        <NavbarMenu isActive={isActive}/>
    </Navbar>;
}
export default NavbarElement;