import React from "react";
import {Logo} from "./Logo";
import {NavbarBurger} from "./NavbarBurger";
import {NavbarMenu} from "./NavbarMenu";
import {Navbar} from "react-bulma-components"

function NavbarElement({handleLogout, user}){
    const [isActive, setisActive] = React.useState(false);
    return <Navbar className="has-shadow is-strong-background-color is-size-5 is-family-primary">
        <Navbar.Brand>
            <Logo/>
            <h1 className="navbar-item is-title  is-light-grey is-size-4 has-text-weight-semibold">Currylandia</h1>
            <NavbarBurger onClick={() => setisActive(!isActive)} />
        </Navbar.Brand>
        <NavbarMenu handleLogout={handleLogout} user={user} isActive={isActive}/>
    </Navbar>;
}
export default NavbarElement;