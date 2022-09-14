export enum Category {
    Food,
    Electricity,
    Restaurant,
    Vacation
}


export class CouponModel {
    public id?:number;
    public notAmount?:number;
    public notPrice?:number;
    public notCategory?:Category;
    public notImg?:string;
    public notTitle?:string;
    public notDesc?:string;
    public notStartDate?:Date;
    public notEndDate?:Date;

    public constructor(id:number, notAmount:number, notPrice:number, notCategory:Category ,notImg:string, notTitle:string, notDesc:string, notStartDate:Date, notEndDate:Date){
        this.id = id;
        this.notAmount = notAmount;
        this.notPrice = notPrice;
        this.notCategory = notCategory;
        this.notImg = notImg;
        this.notDesc = notDesc;
        this.notTitle = notTitle;
        this.notStartDate = notStartDate;
        this.notEndDate = notEndDate;
    }
}
export class CouponPayloadModel {
    public notAmount?:number;
    public notPrice?:number;
    public notCategory?:Category;
    public notImg?:string;
    public notTitle?:string;
    public notDesc?:string;
    public notStartDate?:Date;
    public notEndDate?:Date; 

    public constructor(notAmount:number, notPrice:number, notCategory:Category, notImg:string, notTitle:string, notDesc:string, notStartDate:Date, notEndDate:Date){
        this.notAmount = notAmount;
        this.notPrice = notPrice;
        this.notCategory = notCategory;
        this.notImg = notImg;
        this.notDesc = notDesc;
        this.notTitle = notTitle;
        this.notStartDate = notStartDate;
        this.notEndDate = notEndDate;
    }
}