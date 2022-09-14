import { UserModel } from "../Models/Welcome";

export class AuthAppState {
    public user: UserModel = new UserModel();
    public constructor() {
        try {
            const storedUser = JSON.parse(localStorage.getItem('user') || '');
            if (storedUser) {
                this.user = storedUser;
            }
        }
        catch (err) {
            this.user = null as any;
        }
    }
}

export enum AuthActionType {
    Register = "Register",
    Login = "Login",
    Logout = "Logout"
}

export interface AuthAction {
    type: AuthActionType;
    payload?: any; // ? for logout
}

export function registerAction(): AuthAction {
    return { type: AuthActionType.Register };
}

export function loginAction(user: UserModel): AuthAction {
    return { type: AuthActionType.Login, payload: user };
}

export function logoutAction(): AuthAction {
    return { type: AuthActionType.Logout};
}

export function authReducer(currentState: AuthAppState = new AuthAppState(),
    action: AuthAction): AuthAppState {

    const newState = { ...currentState } 
    switch (action.type) {
        case AuthActionType.Register:
            break;
        case AuthActionType.Login:
            newState.user = action.payload;
            localStorage.setItem("user", JSON.stringify(newState.user));
            break;
        case AuthActionType.Logout:
            newState.user = null as any;
            localStorage.removeItem("user");
            
            break;

    }
    return newState;

}