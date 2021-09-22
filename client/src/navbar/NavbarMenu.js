import React from "react";
import {NavLink} from "react-router-dom";
import {Navbar} from "react-bulma-components";

export function NavbarMenu({isActive, handleLogout, user}) {
    return <Navbar.Menu className={"navbar-menu " + (isActive ? "is-active" : "")} id="nav-links">
        <div className="navbar-end">
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
            <NavLink
                className="navbar-item"
                activeClassName="is-active"
                to="/perfil" >
                Mi Perfil
            </NavLink>
            {user.logged ?
                <NavLink
                    className="navbar-item"
                    activeClassName="is-active"
                    onClick={handleLogout}
                    to="/restaurantes">
                    Cerrar sesión
                </NavLink>
                :
                <NavLink
                    className="navbar-item"
                    activeClassName="is-active"
                    to="/login">
                    Entrá o registrate
                </NavLink>
            }
        </div>
    </Navbar.Menu>;
}