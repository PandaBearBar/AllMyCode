export class CompanyRegisterModel {
    public name?: string;
    public email?: string;
    public password?: string;
    public confirm?: string;

    public constructor(email?: string, password?: string,name? : string, confirm?: string) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }
}

export class CustomerRegisterModel {
    public firstName?: string;
    public lastName?: string;
    public email?: string;
    public password?: string;
    public confirm?: string;

    public constructor(email?: string, password?: string,firstName? : string,lastName? : string, confirm?: string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }
}

export class LoginModel {
    public email?: string;
    public password?: string;
    public userType?: string;

    public constructor(email?: string, password?: string, userType?: string) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}

export class CompanyCredentialsModel {
    public name?: string;
    public email?: string;
    public password?: string;

    public constructor(email?: string, password?: string, name?: string) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

export class CustomerCredentialsModel {
    public firstName?: string;
    public lastName?: string;
    public email?: string;
    public password?: string;

    public constructor(email?: string, password?: string, firstName?: string,lastName?: string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

export class UserModel {
    public token?: string;
    public email?: string;

    public constructor(token?: string,email?: string) {
        this.token = token;
        this.email = email;

    }
}