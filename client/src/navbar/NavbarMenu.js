import React from "react";
import { NavLink } from "react-router-dom";
import { Navbar } from "react-bulma-components";

export function NavbarMenu({isActive}) {
    return <Navbar.Menu className={"navbar-menu " + (isActive ? "is-active" : "")} id="nav-links">
        <div className="navbar-end">
            <NavLink
                className="navbar-item"
                activeClassName="is-active"
                to="/perfil" >
                Mi Perfil
            </NavLink>
            <NavLink
                className="navbar-item"
                activeClassName="is-active"
                to="/restaurantes" >
                Restaurantes
            </NavLink>
            <NavLink
                className="navbar-item"
                activeClassName="is-active"
                to="/crear" >
                Crear un restó
            </NavLink>
        </div>
    </Navbar.Menu>;
}