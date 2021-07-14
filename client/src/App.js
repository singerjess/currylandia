import './App.css';
import NavbarElement from "./navbar/NavbarElement";
import {Breadcrumbs} from "./breadcrumbs/breadcrumbs";
import {Route, Switch} from "react-router-dom";
import RestaurantDetail from "./restaurant/catalog/RestaurantDetail";
import RestaurantsCatalog from "./restaurant/catalog/RestaurantsCatalog";
import CreateRestaurantForm from "./restaurant/CreateRestaurantForm";

export function App() {
  return (
    <div className="App">
      <NavbarElement />
      <Breadcrumbs />
      <main>
        <Switch>
          <Route path="/restaurantes/:restaurantName">
            <RestaurantDetail />
          </Route>
            <Route path="/restaurantes">
                <RestaurantsCatalog />
            </Route>
            <Route path="/crear">
                <CreateRestaurantForm />
            </Route>
          <Route path="/">
            <RestaurantsCatalog />
          </Route>
        </Switch>
      </main>
    </div>
  );
}