module com.shop.delivery{
    requires transitive com.shop.billing;
    exports delivery.service;
}