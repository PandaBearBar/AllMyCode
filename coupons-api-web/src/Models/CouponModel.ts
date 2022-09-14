export class CouponModel {
    public id?: number;
    public companyName?: string;
    public category?: string;
    public title?: string;
    public description?: string;
    public startDate?: Date;
    public endDate?: Date;
    public amount?: number;
    public price?: number;
    public image?: string;
 
    public constructor(id: number, companyName: string, category: string,title: string,description: string,startDate: Date,endDate: Date,amount: number,price: number,image: string){
        this.id = id;
        this.companyName = companyName;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

}

export class CouponPayloadModel {
    public companyName?: string;
    public category?: string;
    public title?: string;
    public description?: string;
    public startDate?: Date;
    public endDate?: Date;
    public amount?: number;
    public price?: number;
    public image?: string;
 

    public constructor(companyName: string, category: string,title: string,description: string,startDate: Date,endDate: Date,amount: number,price: number,image: string) {
        this.companyName = companyName;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }
}