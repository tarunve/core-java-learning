import serviceloader.ServiceLoaderInpl;
import services.ServiceLoaderIntf;

module com.shop.serviceloader{
    requires com.shop.billing;
    provides ServiceLoaderIntf with ServiceLoaderInpl;
}