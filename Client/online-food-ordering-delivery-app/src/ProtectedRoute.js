import { Route } from "react-router-dom";
import Login from "./Components/Login";

function ProtectedRoute(props) {
    if (sessionStorage.getItem("isLoggedin") === 'true') 
        return <Route path={props.path} exact component={props.component}></Route>
    else
        return <Login />
}

export default ProtectedRoute;