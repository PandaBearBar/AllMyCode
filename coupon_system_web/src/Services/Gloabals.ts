class Globals {
}

class DevelopmentGlobals extends Globals {
    public urls = {
        tasks: "http://localhost:8080/api/users/tasks/", 
        welcome: "http://localhost:8080/api/welcome/"
    }
}

class ProductionGlobals extends Globals {
    public urls = {
        tasks: "www.aws.com/MohseWebSite/tasks",
        welcome: "www.aws.com/MohseWebSite/welcome/"
    }
}

const globals = process.env.NODE_ENV === 'production' ? new ProductionGlobals() : new DevelopmentGlobals();

export default globals;