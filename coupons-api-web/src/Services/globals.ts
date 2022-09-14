class Globals {
}

class DevelopmentGlobals extends Globals {
    public urls = {
        couponsApi: "http://localhost:8080/api/companies/",
        couponsPurchaseApi: "http://localhost:8080/api/customers/purchase/",
        coupons: "http://localhost:8080/api/customers/coupons", 
        welcome: "http://localhost:8080/api/welcome/"
    }
}

class ProductionGlobals extends Globals {
    public urls = {
        couponsApi: "http://localhost:8080/api/companies",
        couponsPurchaseApi: "http://localhost:8080/api/customers/purchase/",
        coupons: "http://localhost:8080/api/customers/coupons", 
        welcome: "www.aws.com/MohseWebSite/welcome/"
    }
}

const globals = process.env.NODE_ENV === 'production' ? new ProductionGlobals() : new DevelopmentGlobals();

export default globals;