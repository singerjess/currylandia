import React from "react";
import {Navbar} from "react-bulma-components"

export function NavbarBurger({onClick}) {
    return <Navbar.Burger onClick={onClick}>
        <span></span>
        <span></span>
        <span></span>
    </Navbar.Burger>;
}