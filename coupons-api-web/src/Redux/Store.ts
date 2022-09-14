import { combineReducers, createStore } from "redux";
import { CouponsReducer } from "./CouponsAppState";
import { authReducer } from "./UserAppState";

const reducers = combineReducers({couponsReducer: CouponsReducer,authReducer:authReducer});
const store = createStore(reducers)


export default store;