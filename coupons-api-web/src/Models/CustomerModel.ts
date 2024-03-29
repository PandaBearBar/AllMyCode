export class CustomerModel {
    public id?: number;
    public firstName?: string;
    public lastName?: string;
    public email?: string;
    public password?: string;
 
    public constructor(id: number, firstName: string,lastName: string, email: string,password: string){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}

export class CustomerPayloadModel {
    public firstName?: string;
    public lastName?: string;
    public email?: string;
    public password?: string;
 

    public constructor(firstName: string,lastName: string, email: string,password: string){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

export class CustomerRegisterPayloadModel {
    public firstName?: string;
    public lastName?: string;
    public email?: string;
    public password?: string;
    public confirm?: string;
 

    public constructor(firstName: string,lastName: string, email: string,password: string,confirm: string){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }
}