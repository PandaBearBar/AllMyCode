export class CompanyModel {
    public id?: number;
    public companyName?: string;
    public email?: string;
    public password?: string;
    public confirm?: string;
 
    public constructor(id: number, companyName: string, email: string,password: string,confirm: string){
        this.id = id;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }

}

export class CompanyPayloadModel {
    public companyName?: string;
    public email?: string;
    public password?: string;
 

    public constructor(companyName: string, email: string,password: string){
        this.companyName = companyName;
        this.email = email;
        this.password = password;
    }
}

export class CompanyRegisterPayloadModel {
    public name?: string;
    public email?: string;
    public password?: string;
    public confirm?: string;
 

    public constructor(name: string, email: string,password: string,confirm: string){
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }
}