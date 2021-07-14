import React from "react";

export function Breadcrumbs(props) {
    return <div className="section pt-4 pb-0">
        <nav className="breadcrumb has-arrow-separator">
            <ul className="container is-size-6">
                <li><a href="." className="has-text-grey">Mi resto</a></li>
                <li><a href="." className="has-text-grey">Mi resto</a></li>
                <li className="is-active"><a href="." className="has-text-grey">Mi resto</a></li>
            </ul>
        </nav>
    </div>
}