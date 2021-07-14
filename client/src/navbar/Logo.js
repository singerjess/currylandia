import currylandia from "../currylandia.jpeg";
import React from "react";

export function Logo() {
    return <a href="/" className="navbar-item">
        <img style={{"maxHeight": "70px"}} className="py-2 px-2" alt="site-logo" src={currylandia}/>
    </a>;
}