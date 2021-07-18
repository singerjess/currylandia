import './App.css';
import NavbarElement from "./navbar/NavbarElement";
import {Breadcrumbs} from "./breadcrumbs/breadcrumbs";
import {Redirect, Route, Switch} from "react-router-dom";
import RestaurantDetail from "./restaurant/catalog/RestaurantDetail";
import RestaurantsCatalog from "./restaurant/catalog/RestaurantsCatalog";
import CreateRestaurantForm from "./restaurant/CreateRestaurantForm";
import Profile from "./profile/Profile";
import Login from "./login/Login";
import {useEffect, useState} from "react";

export function App() {
    const [user, setUser] = useState(localStorage.getItem('user.logged') === 'true' ?
        {
            username: localStorage.getItem('user.username'),
            id: localStorage.getItem('user.id'),
            logged: true
        } : {logged: false});
    const handleLogin = (user) => {
        setUser(user);
    };
    const handleLoginError = (error) => {
        setUser({logged: false});
    }
    const handleLogout = (user) => {
        user.logged = false;
        setUser(user);
    }
    useEffect(() => {
        if (user.logged === true) {
            localStorage.setItem('user.logged', user.logged);
            localStorage.setItem('user.username', user.username);
            localStorage.setItem('user.role', user.role);
            localStorage.setItem('user.id', user.id);
        } else {
            localStorage.setItem('user.logged', false);
            localStorage.removeItem('user.username')
            localStorage.removeItem('user.role')
            localStorage.removeItem('user.id');
        }
    }, [user]);
    return (
        <div className="App">
            <NavbarElement/>
            <Breadcrumbs/>
            <main>
                <Switch>
                    <Route path="/restaurantes/:restaurantId">
                        <RestaurantDetail/>
                    </Route>
                    <Route path="/restaurantes">
                        <RestaurantsCatalog/>
                    </Route>
                    <Route path="/crear">
                        <CreateRestaurantForm/>
                    </Route>
                    <Route path="/perfil">
                        <Profile/>
                    </Route>
                    <Route path="/login">
                        {user.logged ? <Redirect to="/restaurantes" /> : <Login handleLogin={handleLogin} handleLoginError={handleLoginError} />}
                    </Route>
                    <Route path="/registracion">
                        <Profile/>
                    </Route>
                    <Route path="/">
                        <RestaurantsCatalog/>
                    </Route>
                </Switch>
            </main>
        </div>
    );
}
