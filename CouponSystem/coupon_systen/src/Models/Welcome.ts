export enum ClientType {
    Administrator,
    Customer,
    Company
}
export class RegisterModel{
    public email?:string;
    public password?:string;
    public confirm?:string;
    public clientType?:ClientType;

    public constructor (email?:string, password?:string, confirm?:string, clientType?:ClientType){
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.clientType = clientType;
    }
}
export class LoginModel {
    public email?:string;
    public password?:string;
    public clientType?:ClientType;

    public constructor (email?:string, password?:string, clientType?:ClientType){
        this.email = email;
        this.password = password;
        this.clientType = clientType;
    }
}
export class ClientModel{
    public token?:string;
    public email?:string;
    public clientType?:ClientType;

    public constructor (token?:string, email?:string, clientType?:ClientType){
        this.token = token;
        this.email = email;
        this.clientType = clientType;
    }
}