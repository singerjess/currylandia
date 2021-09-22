import './App.css';
import NavbarElement from "./navbar/NavbarElement";
import {Breadcrumbs} from "./breadcrumbs/breadcrumbs";
import {Redirect, Route, Switch} from "react-router-dom";
import RestaurantDetail from "./restaurant/catalog/RestaurantDetail";
import RestaurantsCatalog from "./restaurant/catalog/RestaurantsCatalog";
import CreateRestaurantForm from "./restaurant/CreateRestaurantForm";
import Profile from "./profile/Profile";
import Register from "./login/Register";
import Login from "./login/Login";
import {useEffect, useState} from "react";
import { useHistory } from 'react-router-dom';


export function App() {
    const [user, setUser] = useState(localStorage.getItem('user.logged') === 'true' ?
        {
            username: localStorage.getItem('user.username'),
            logged: true
        } : {logged: false});
    const handleLogin = (user) => {
        setUser(user);
    };
    const handleRegistration = (user) => {
        setUser(user);
        history.push("/restaurants");
    };
    const history = useHistory(); //TODO: hacer esto
    const handleLoginError = (error) => {
        setUser({logged: false});
    }
    const handleRegistrationError = (error) => {
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
            localStorage.setItem('user.id', user.id);
        } else {
            localStorage.setItem('user.logged', false);
            localStorage.removeItem('user.username')
            localStorage.removeItem('user.id');
        }
    }, [user]);
    return (
        <div className="App">
            <NavbarElement handleLogout={handleLogout} user={user}/>
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
                        {user.logged ?<CreateRestaurantForm/> : <Redirect to="/login" /> }
                    </Route>
                    <Route path="/perfil">
                        <Profile/>
                    </Route>
                    <Route path="/login">
                        <Login handleLogin={handleLogin} handleLoginError={handleLoginError} />
                    </Route>
                    <Route path="/register">
                        <Register handleRegistration={handleRegistration} handleRegistrationError={handleRegistrationError}/>
                    </Route>
                    <Route path="/">
                        <RestaurantsCatalog/>
                    </Route>
                </Switch>
            </main>
        </div>
    );
}
