import { combineReducers, createStore } from "redux";
import { tasksReducer } from "./TaskAppState";
import { authReducer } from "./UserAppState";

const reducers = combineReducers({tasksReducer: tasksReducer,authReducer:authReducer});
const store = createStore(reducers)


export default store;